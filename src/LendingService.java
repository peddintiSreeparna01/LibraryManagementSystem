import java.util.ArrayList;
import java.util.List;

public class LendingService {

    private BookRepository repo;
    private PatronRepository patronRepo;
    private List<Transaction> records = new ArrayList<>();

    public LendingService(BookRepository repo, PatronRepository patronRepo){
        this.repo = repo;
        this.patronRepo = patronRepo;
    }

    public void checkOut(String isbn, String patronId){

        Book book = repo.getBook(isbn);
        if(book == null){
            throw new RuntimeException("Book not found");
        }

        Patron patron = patronRepo.getPatron(patronId);
        if(patron == null){
            throw new RuntimeException("Patron not found.");
        }

        if(!book.isAvailable()){
            throw new RuntimeException("Book is already borrowed");
        }

        book.markAsBorrowed();

        Transaction record = new Transaction(patronId,isbn);
        records.add(record);
    }

    public void returnBook(String isbn, String patronId){

        Book book = repo.getBook(isbn);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }

        Patron patron = patronRepo.getPatron(patronId);
        if (patron == null) {
            throw new RuntimeException("Patron not found");
        }

        Transaction activeRecord = null;

        for (Transaction record : records) {
            if (record.getIsbn().equals(isbn)
                    && record.getPatronId().equals(patronId)
                    && record.getReturnDate() == null) {

                activeRecord = record;
                break;
            }
        }

        if (activeRecord == null) {
            throw new RuntimeException("No active borrow record found");
        }

        activeRecord.markAsReturned();
        book.markAsReturned();
    }

    public void reserveBook(String isbn, String patronId) {

        Book book = repo.getBook(isbn);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }

        Patron patron = patronRepo.getPatron(patronId);
        if (patron == null) {
            throw new RuntimeException("Patron not found");
        }

        if (book.isAvailable()) {
            throw new RuntimeException("Book is available, no need to reserve");
        }

        book.addObserver(patron);
    }
}