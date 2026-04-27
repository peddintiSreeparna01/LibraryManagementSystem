import java.util.Collection;
import java.util.HashMap;

public class BookRepoImpl implements BookRepository{

    HashMap<String,Book> books = new HashMap<>();
    public void addBook(Book book){
        books.put(book.getIsbn(),book);
    }
    public void removeBook(String isbn){
        books.remove(isbn);
    }
    public Book getBook(String isbn){
        return books.get(isbn);
    }
    public Collection<Book> getAll(){
        return books.values();
    }


}
