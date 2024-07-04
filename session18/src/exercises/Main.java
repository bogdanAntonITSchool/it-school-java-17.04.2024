package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        // 1. Create a Consumer that prints each element of a list of integers.
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        Consumer<List<Integer>> intConsumer = integersList -> {
            for (Integer integer : integersList) {
                System.out.println(integer);
            }
        };

        intConsumer.accept(integers);

        // 2. Create a Supplier that returns a random number.
        Random random = new Random();
        Supplier<Integer> randomInt = random::nextInt;

        Integer randomIntValue = randomInt.get();
        System.out.println(randomIntValue);

        MyFunctionalInterface myFunctionalInterface = System.out::println;
        myFunctionalInterface.sayHello("Hello");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired type (INTEGER, DOUBLE, FLOAT, LONG): ");
        String type = scanner.nextLine();

        NumberTypes numberType = NumberTypes.valueOf(type);
        Supplier<Number> numberSupplier = () -> switch (numberType) {
            case INTEGER -> random.nextInt();
            case DOUBLE -> random.nextDouble();
            case FLOAT -> random.nextFloat();
            case LONG -> random.nextLong();
        };

        Number number = numberSupplier.get();
        System.out.println("Random number: " + number);

        // 3. Create a Predicate that checks if a string is empty.
        String string = scanner.nextLine();
        Predicate<String> stringPredicate = s -> s != null && s.isEmpty();

        System.out.println("Is the string empty? " + stringPredicate.test(string));

        // 4. Create a Function that converts a string to its length.
        String str = scanner.nextLine();
        Function<String, Integer> stringLengthFunction = s -> s == null || s.isEmpty() ? 0 : s.length();

        System.out.println("The length of the string is: " + stringLengthFunction.apply (str));
        System.out.println("The length of the string is: " + stringLengthFunction.apply(null));

        // 5. Create a functional interface that takes two integers and prints their sum.
        BiConsumer<Integer, Integer> sumConsumer = (a, b) ->
                System.out.println("The sum of " + a + " and " + b + " is " + (a + b));

        sumConsumer.accept(random.nextInt(10), random.nextInt(10));

        BiConsumer<Integer, String> integerStringBiConsumer =
                (i, s) -> System.out.println(i + stringLengthFunction.apply(s));

        integerStringBiConsumer.accept(random.nextInt(10), "Hello world!");
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        void sayHello(String hello);
    }

    enum NumberTypes {
        INTEGER, DOUBLE, FLOAT, LONG;
    }
}
