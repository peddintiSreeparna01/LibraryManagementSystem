public class Main {
    public static void main(String[] args) {

        BookRepository bookRepo = new BookRepoImpl();
        PatronRepository patronRepo = new PatronRepoImpl();

        BookService bookService = new BookService(bookRepo);
        PatronService patronService = new PatronService(patronRepo);
        LendingService lendingService = new LendingService(bookRepo, patronRepo);

        Book book = BookFactory.createBook("Java", "James", "101", 2020);
        bookService.addBook(book);

        Patron p1 = new Patron("P1", "Sreeparna");
        patronService.addPatron(p1);

        lendingService.checkOut("101", "P1");

        Patron p2 = new Patron("P2", "Alex");
        patronService.addPatron(p2);

        lendingService.reserveBook("101", "P2");

        lendingService.returnBook("101", "P1");
    }
}