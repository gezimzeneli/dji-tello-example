package application.command;

public class TelloCommands {

    private static final TelloCommands instance = new TelloCommands();
    private static CommandSender commandSender;

    private TelloCommands() {
        commandSender = new CommandSender();
    }

    public static TelloCommands getInstance(){
        return instance;
    }

    public void exit() {
        commandSender.exit();
    }

    public void takeoff() {
        commandSender.send(CommandValues.TAKE_OFF);
    }

    public void land() {
        commandSender.send(CommandValues.LAND);
    }

    public void up(int value) {
        ParameterValidator.above500(value);
        ParameterValidator.below20(value);

        commandSender.send(CommandValues.UP, String.valueOf(value));
    }

    public void down(int value) {
        ParameterValidator.above500(value);
        ParameterValidator.below20(value);

        commandSender.send(CommandValues.DOWN, String.valueOf(value));
    }

    public void left(int value) {
        ParameterValidator.above500(value);
        ParameterValidator.below20(value);

        commandSender.send(CommandValues.LEFT, String.valueOf(value));
    }

    public void right(int value) {
        ParameterValidator.above500(value);
        ParameterValidator.below20(value);

        commandSender.send(CommandValues.RIGHT, String.valueOf(value));
    }

    public void back(int value) {
        ParameterValidator.above500(value);
        ParameterValidator.below20(value);

        commandSender.send(CommandValues.BACK, String.valueOf(value));
    }

    public void forward(int value) {
        ParameterValidator.above500(value);
        ParameterValidator.below20(value);

        commandSender.send(CommandValues.FORWARD, String.valueOf(value));
    }

    public void rotateLeft(int value) {
        ParameterValidator.below1(value);
        ParameterValidator.above360(value);

        commandSender.send(CommandValues.CCW, String.valueOf(value));
    }

    public void rotateRight(int value) {
        ParameterValidator.below1(value);
        ParameterValidator.above360(value);

        commandSender.send(CommandValues.CW, String.valueOf(value));
    }

}
