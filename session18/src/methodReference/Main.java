package methodReference;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        // Method reference on a static method
        Consumer<String> printString = System.out::println;
        Consumer<String> printStringWithoutReference = (s) -> System.out.println(s);

        System.out.println("Hello world!");

        // Method reference on a constructor
        Supplier<MyClass> createInstance = MyClass::new;
        System.out.println(createInstance.get());

        Random random = new Random();
        Supplier<Integer> randomInt = () -> random.nextInt();

        // Method reference on an instance method of an existing object
        Supplier<Integer> randomIntWithReference = random::nextInt;
    }

    static class MyClass {
        @Override
        public String toString() {
            return "MyClass{}";
        }
    }
}
