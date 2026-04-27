import java.util.Collection;

public interface BookRepository {
    void addBook(Book book);
    void removeBook(String isbn);
    Book getBook(String isbn);
    Collection<Book> getAll();

}

//update to be done
