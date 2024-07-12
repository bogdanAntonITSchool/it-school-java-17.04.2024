package streams;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        List<String> bookNames =
                List.of("Java", "C++", "Python", "JavaScript", "RubyOnRail", "Kotlin", "Swift", "Go", "Rust", "Scala");

        boolean b = bookNames.stream()
                .anyMatch(s -> s.length() > 8);

//        boolean b = bookNames.stream()
//                .map(String::length)
//                .anyMatch(s -> s > 8);

        if (b) {
            System.out.println("At least one book name has more than 8 characters");
        } else {
            System.out.println("No book name has more than 8 characters");
        }

        boolean b1 = bookNames.stream()
                .allMatch(s -> s.length() >= 2);

        if (b1) {
            System.out.println("All book names have more than 2 characters");
        } else {
            System.out.println("Not all book names have more than 2 characters");
        }

        boolean b2 = bookNames.stream()
                .noneMatch(s -> s.length() > 10);

        if (b2) {
            System.out.println("No book name has more than 10 characters");
        } else {
            System.out.println("At least one book name has more than 10 characters");
        }

        Optional<String> first = bookNames.stream()
                .filter(s -> s.length() > 8)
                .filter(s -> s.length() % 2 == 0)
                .findFirst();

        System.out.println(first);

        Set<String> setOfBookNames =
                Set.of("Java", "C++", "Python", "JavaScript", "RubyOnRail", "Kotlin", "Swift", "Go", "Rust", "Scala");

        Optional<String> any = setOfBookNames.stream()
                .filter(s -> s.length() > 8)
                .filter(s -> s.length() % 2 == 0)
                .findAny();

        System.out.println(any);


        List<Integer> elements = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);


        int x = 1;
//        x = 5;
        elements.stream()
                .peek(e -> {
                    System.out.println(x + e);
                })
                .forEach(System.out::println);

        for (Integer element : elements) {
            elements.remove(element);
        }

        System.out.println(elements);
    }
}
