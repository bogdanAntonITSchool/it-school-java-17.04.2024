package optional;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {


        Optional<Integer> optionalInt = halfOf(10);
        System.out.println(optionalInt.orElse(0).doubleValue());

        List<String> names = List.of("John", "Jane", "James", "Alice", "Bob", "Charlie", "David", "Eve");
        Optional<String> first = names.stream()
                .filter(s -> s.startsWith("A"))
                .findFirst();

        System.out.println(first.orElse("No name found"));

        Optional<Integer> hello = Optional.ofNullable(getSomeValue("Hello"));
        // will throw an exception if the value is not present
        // hello.get().doubleValue();
        hello.ifPresentOrElse(
                v -> System.out.println("Value is " + v),
                () -> System.out.println("Value not found")
        );

        if (hello.isPresent()) {
            System.out.println("Value is " + hello.get());
        } else {
            System.out.println("Value not found");
        }

        List<Book> books = List.of(
                new Book("Author1", "Title1"),
                new Book("Author2", "Title2"),
                new Book("Author3", "Title3"),
                new Book("Author4", "Title4"),
                new Book("Author5", "Title5")
        );

        Optional<Book> book = getBookMatchingTitle(books, "Title4");
        book.map(Book::getAuthor)
                .ifPresentOrElse(
                        author -> System.out.println("Author is " + author),
                        () -> System.out.println("Book not found")
                );
    }

    private static Optional<Integer> halfOf(Integer value) {
        return value != null && value > 0
                ? Optional.of(value / 2)
                : Optional.empty();
    }

    private static Integer getSomeValue(String param) {
        return param != null && param.length() % 2 == 0
                ? param.length()
                : null;
    }

    private static Optional<Book> getBookMatchingTitle(List<Book> books, String title) {
        return books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst();
    }

    static class Book {
        private final String author;
        private final String title;

        public Book(String author, String title) {
            this.author = author;
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }
    }
}
