package standard;

import java.util.Random;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> {
            if (s != null && !s.isEmpty()) {
                System.out.println(s);
            } else {
                System.out.println("String is empty or null");
            }
        };
        consumer.accept("Hello world!");
        consumer.accept("");

        Random random = new Random();
        Supplier<Integer[]> supplier = () -> {
            Integer[] integers = new Integer[10];
            for (int i = 0; i < integers.length; i++) {
                integers[i] = random.nextInt(100);
            }
            return integers;
        };
        Integer[] integers = supplier.get();
        System.out.println("Random integers: " + java.util.Arrays.toString(integers));

        Function<String, Integer> function = s -> {
            if (s != null && !s.isEmpty()) {
                return s.length();
            } else {
                return 0;
            }
        };
        System.out.println(function.apply("Hello world!"));
        System.out.println(function.apply(""));

        ToIntFunction<String> toIntFunction = s -> {
            if (s != null && !s.isEmpty()) {
                return s.length();
            } else {
                return 0;
            }
        };
        System.out.println(toIntFunction.applyAsInt("Hello world!"));
        System.out.println(toIntFunction.applyAsInt(""));

        BiFunction<String, Double, Integer> biFunction = (s, d) -> s.length() + d.intValue();
        System.out.println("bifunction = " + biFunction.apply("Hello world!", 3.14));

        Predicate<String> predicate = s -> s != null
                && !s.isEmpty()
                && s.length() % 2 == 0;

        System.out.println(predicate.test("Hello world!"));
        System.out.println(predicate.test("Hello world"));

        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        System.out.println(binaryOperator.apply(1, 2));

        UnaryOperator<Integer> unaryOperator = a -> a * 2;
        System.out.println(unaryOperator.apply(3));
    }
}
