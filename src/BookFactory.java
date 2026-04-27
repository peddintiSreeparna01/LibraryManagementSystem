public class BookFactory {

    public static Book createBook(String title, String author, String isbn, int year) {
        if (isbn == null || isbn.isEmpty()) {
            throw new RuntimeException("Invalid ISBN");
        }
        return new Book(title, author, isbn, year);
    }
}