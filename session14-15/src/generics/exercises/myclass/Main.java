package generics.exercises.myclass;

public class Main {

    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<>("Hello, ", "world!", "third");
        myClass.printSumOfValues();

        MyClass<Integer> myClassIntegers = new MyClass<>(10, 50, "100");
        myClassIntegers.printSumOfValues();

        MyClass<Double> myClassDifferentTypes = new MyClass<>(10.0d, 50.0d, "100.0d");
        myClassDifferentTypes.printSumOfValues();
    }

    static class MyClass<T> {
        private final T value;
        private final T secondValue;
        private final String thirdValue;

        public MyClass(T value, T secondValue, String thirdValue) {
            this.value = value;
            this.secondValue = secondValue;
            this.thirdValue = thirdValue;
        }

        public void printSumOfValues() {
            if (value instanceof Integer && secondValue instanceof Integer) {
                System.out.println((Integer) value / (Integer) secondValue);
            } else if (value instanceof String && secondValue instanceof String) {
                System.out.println(value + (String) secondValue);
            } else {
                System.out.println("Cannot sum values");
            }
        }
    }
}
