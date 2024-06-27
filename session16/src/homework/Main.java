package homework;

public class Main {

    public static void main(String[] args) {
        System.out.println(performOperation(Operation.ADD, 5, 3));
        System.out.println(performOperation(Operation.SUBTRACT, 5, 3));
        System.out.println(performOperation(Operation.MULTIPLY, 5, 3));
        System.out.println(performOperation(Operation.DIVIDE, 5, 3));

        System.out.println(Operation.ADD.performOperation(5, 3));
        System.out.println(Operation.SUBTRACT.performOperation(5, 3));
        System.out.println(Operation.MULTIPLY.performOperation(5, 3));
        System.out.println(Operation.DIVIDE.performOperation(5, 3));

        System.out.println(Operation.performOperation(Operation.ADD, 5, 3));
        System.out.println(Operation.performOperation(Operation.SUBTRACT, 5, 3));
        System.out.println(Operation.performOperation(Operation.MULTIPLY, 5, 3));
        System.out.println(Operation.performOperation(Operation.DIVIDE, 5, 3));

    }

    // First way
    public static double performOperation(Operation operation, double a, double b) {
        return switch (operation) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> a / b;
        };
    }
}
