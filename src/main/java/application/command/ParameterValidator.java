package application.command;

import com.google.common.base.Preconditions;

public class ParameterValidator {

    public static void below20(int value) {
        Preconditions.checkArgument(value >= 20, "Value is below 20cm");
    }

    public static void below1(int value) {
        Preconditions.checkArgument(value >= 1, "Value is below 1 degree");
    }

    public static void above500(int value) {
        Preconditions.checkArgument(value <= 500, "Value is above 500cm");
    }

    public static void above360(int value) {
        Preconditions.checkArgument(value >= 360, "Value is above 360 degrees");
    }


}
