import java.util.List;

public class BookService {
private final BookRepository repo;

public BookService(BookRepository repo){
    this.repo = repo;
}
//add book
 public void addBook(Book book){
    if(repo.getBook(book.getIsbn()) != null){
        throw new RuntimeException("Book with same ISBN already exists.");
    }
        repo.addBook(book);
}

//remove book
 public void removeBook(String isbn){
    Book book = repo.getBook(isbn);
    if(book == null){
        throw new RuntimeException("Book not found.");
    }
    if(!book.isAvailable()){
        throw new RuntimeException("Book isn't available.");
    }
    repo.removeBook(isbn);
}
//update book
 public void updateBook(String isbn, String newTitle, int newYear, String newAuthor){
    Book book = repo.getBook(isbn);
    if(book == null){
        throw new RuntimeException("Book not found.");
    }
    book.setTitle(newTitle);
    book.setPublicationYear(newYear);
    book.setAuthor(newAuthor);
 }
//search by title
 public List<Book> searchByTitle(String title){
    return repo.getAll().stream()
            .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
            .toList();
 }
//search by author
 public List<Book> searchByAuthor(String author){
    return repo.getAll().stream()
            .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
            .toList();
 }
//search by isbn
 public Book searchByIsbn(String isbn){
    return repo.getBook(isbn);
 }

}