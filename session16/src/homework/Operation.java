package homework;

// Second way
public enum Operation {
    ADD {
        @Override
        public double performOperation(double a, double b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public double performOperation(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public double performOperation(double a, double b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public double performOperation(double a, double b) {
            return a / b;
        }
    };

    public abstract double performOperation(double a, double b);

    // Third way
    public static double performOperation(Operation operation, double a, double b) {
        return switch (operation) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> a / b;
        };
    }
}
