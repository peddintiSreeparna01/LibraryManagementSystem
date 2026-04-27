import java.util.HashMap;
import java.util.Map;

public class PatronRepoImpl implements PatronRepository{
    Map<String,Patron> patrons = new HashMap<>();
    public void addPatron(Patron patron){
        patrons.put(patron.getId(), patron);
    }
    public void removePatron(String patronId){
        patrons.remove(patronId);
    }
    public Patron getPatron(String patronId){
        return patrons.get(patronId);
    }
}
