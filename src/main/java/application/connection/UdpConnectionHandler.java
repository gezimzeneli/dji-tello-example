package application.connection;

import application.configuration.ConnectionInformation;
import application.exception.ConnectionException;

import java.io.IOException;
import java.net.*;

public class UdpConnectionHandler {

    private static final UdpConnectionHandler instance = new UdpConnectionHandler();

    private DatagramSocket socket;
    private InetAddress address;

    private UdpConnectionHandler() { }

    public static UdpConnectionHandler getInstance(){
        return instance;
    }

    public void connect() throws ConnectionException {
        try {
            socket = new DatagramSocket();
        }
        catch (SocketException ex) {
            throw new ConnectionException("Connection cannot be established");
        }

        try {
            address = InetAddress.getByName(ConnectionInformation.droneIp);
        }
        catch (UnknownHostException e) {
            throw new ConnectionException("Host cannot be found.");
        }
    }

    public String send(String message) throws IOException {
        byte[] bufferedMessage = message.getBytes();
        DatagramPacket packet = new DatagramPacket(bufferedMessage,
                bufferedMessage.length,
                address,
                ConnectionInformation.dronePort);
        socket.send(packet);
        packet = new DatagramPacket(bufferedMessage, bufferedMessage.length);
        socket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
    }

    public void disconnect() {
        socket.close();
    }
}
