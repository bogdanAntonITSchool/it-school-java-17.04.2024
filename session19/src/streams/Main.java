package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        Predicate<Integer> evenPredicate = i -> {
            System.out.println("Salut i = " + i);
            return i % 2 == 0;
        };

        Stream<Integer> integerStream = integerList.stream()
                .filter(evenPredicate)
                .filter(i -> {
                    System.out.println("Salut from > 2 i = " + i);
                    return i > 2;
                });

        List<Integer> list = integerStream.toList();
        System.out.println(list);

        Book book = new Book("Author1", "Title1", 2020);
        Book book2 = new Book("Author2", "Title2", 2021);
        Book book3 = new Book("Author3", "Title3", 2022);
        Book book4 = new Book("Author4", "Title4", 2023);
        Book book5 = new Book("Author5", "Title5", 2024);
        Book book6 = new Book("Author5", "Title1", 2024);

        List<Book> books = List.of(book, book2, book3, book4, book5, book6);
        List<String> bookTitles = books.stream()
                .filter(b -> b.getYear() > 2022)
                .map(Book::getTitle)
                .toList();

        System.out.println(bookTitles);

        List<String> bookTitles2 = new ArrayList<>();
        for (Book currentBook : books) {
            if (currentBook.getYear() > 2022) {
                bookTitles2.add(currentBook.getTitle());
            }
        }

        List<String> uniqueTitles = books.stream()
                .map(Book::getTitle)
                .distinct()
                .toList();
        System.out.println(uniqueTitles);

        // don't use peek in production code
        List<String> sortedBooksByYear = books.stream()
                .peek(System.out::println)
//                .sorted((s1, s2) -> s1.getYear() - s2.getYear())
                .sorted(Comparator.comparingInt(Book::getYear))
                .map(Book::getTitle)
                .peek(System.out::println)
                .toList();
        System.out.println(sortedBooksByYear);

        List<Integer> list1 = books.stream()
                .filter(b -> b.getYear() == 2022)
                .flatMap(b -> b.getTitle().chars().boxed())
                .toList();
        System.out.println(list1);


        Stream<Book> stream = books.stream();

        // will throw IllegalStateException
        List<Book> list2 = stream.toList();
//        List<Book> list3 = stream.toList();

//        List<Book> collect = stream.toList();
//        System.out.println(collect);

        Integer maxYear = books.stream()
                .reduce(Integer.MIN_VALUE, (Integer currentMax, Book book1) -> {
                    if (book1.getYear() > currentMax) {
                        return book1.getYear();
                    } else {
                        return currentMax;
                    }
                }, (a, b) -> a);

        System.out.println(maxYear);

        Optional<Book> min = books.stream()
                .min(Comparator.comparingInt(Book::getYear));

        Optional<Integer> min1 = books.stream()
                .map(Book::getYear)
//                .min(Comparator.comparingInt(year -> year))
                .min(Comparator.naturalOrder());

        long count = books.stream()
                .filter(b -> b.getYear() > 2022)
                .count();

        System.out.println(count);
    }

    static class Book {
        private final String author;
        private final String title;
        private final int year;

        public Book(String author, String title, int year) {
            this.author = author;
            this.title = title;
            this.year = year;
        }

        public String getAuthor() {
            return author;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", year=" + year +
                    '}';
        }
    }
}
