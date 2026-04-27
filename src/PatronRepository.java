import java.util.Collection;

public interface PatronRepository {
    void addPatron(Patron patron);
    void removePatron(String patronId);
    Patron getPatron(String patronId);

}