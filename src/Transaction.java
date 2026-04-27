import java.time.LocalDate;

public class Transaction {
    private String patronId;
    private String isbn;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public Transaction(String patronId, String isbn) {
        this.patronId = patronId;
        this.isbn = isbn;
        this.issueDate = LocalDate.now();
    }

    public String getPatronId() {
        return patronId;
    }
    public String getIsbn() {
        return isbn;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void markAsReturned() {
        this.returnDate = LocalDate.now();
    }
}