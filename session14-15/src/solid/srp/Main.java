package solid.srp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book theLordOfTheRings = new Book("The Lord of the Rings",
                "J.R.R. Tolkien",
                "978-0544003415");

        Book theHobbit = new Book("The Hobbit",
                "J.R.R. Tolkien",
                "978-0547928229");

        List<Book> books = List.of(theLordOfTheRings, theHobbit);
        BookPrinter bookPrinter = new BookPrinter();

        for (Book book : books) {
            bookPrinter.printBookDetails(book);
        }
    }
}
