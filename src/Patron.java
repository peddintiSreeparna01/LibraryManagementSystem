import java.util.ArrayList;
import java.util.List;

public class Patron implements Observer{
    private final String patronId;
    private String name;
    private List<Book> bookList = new ArrayList<>();


    public Patron(String patronId, String name) {
        this.patronId = patronId;
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return patronId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}
