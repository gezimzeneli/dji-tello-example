package application.command;

import application.connection.UdpConnectionHandler;

import java.io.IOException;

class CommandSender {

    private static final UdpConnectionHandler udpConnectionHandler = UdpConnectionHandler.getInstance();
    private boolean isConnected = false;
    private boolean isInitialCommandSent = false;


    public void send(String command, String... parameters) {
        connect();

        try {
            sendInitialCommand();

            String finalCommand = concatParams(command, parameters);
            System.err.println("Run: " + finalCommand);
            udpConnectionHandler.send(finalCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String concatParams(String command, String[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            command = command + " " + parameters[i];
        }

        return command;
    }

    private void connect() {
        if (!isConnected) {
            udpConnectionHandler.connect();
            isConnected = true;
        }
    }

    private void sendInitialCommand() throws IOException {
        if (!isInitialCommandSent) {
            udpConnectionHandler.send(CommandValues.COMMAND_MODE);
        }
    }

    public void exit() {
        connect();
        udpConnectionHandler.disconnect();
        isConnected = false;
        isInitialCommandSent = false;
    }

}
