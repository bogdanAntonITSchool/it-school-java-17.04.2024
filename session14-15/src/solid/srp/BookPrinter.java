package solid.srp;

public class BookPrinter {
    public void printBookDetails(Book book) {
        System.out.println("Book details:");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("----------------------");
    }
}
