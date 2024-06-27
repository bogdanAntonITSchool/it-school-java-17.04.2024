package utils.helper;

import homework.Operation;

// This class is a helper class for the Operation enum
public class OperationHelper {

    private double a;
    private double b;

    private Operation operation;

    public OperationHelper(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public OperationHelper(double a, double b, Operation operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    // This method is used to calculate the result of the operation,
    // the result will always be the same for a specific instance of OperationHelper
    public double calculate() {
        return switch (operation) {
            case ADD -> add();
            case SUBTRACT -> subtract();
            case MULTIPLY -> multiply();
            case DIVIDE -> divide();
        };
    }

    public double add() {
        return a + b;
    }

    public double subtract() {
        return a - b;
    }

    public double multiply() {
        return a * b;
    }

    public double divide() {
        return a / b;
    }
}
