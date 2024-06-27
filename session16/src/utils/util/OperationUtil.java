package utils.util;

import homework.Operation;

// This class is a utility class that provides a method to compute the result of an operation.
public final class OperationUtil {

    public static double computeOperation(Operation operation,
                                          double a,
                                          double b) {
        return switch (operation) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> a / b;
        };
    }
}
