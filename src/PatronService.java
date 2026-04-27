public class PatronService {
    private PatronRepository patronRepo;

    public PatronService(PatronRepository patronRepo){
        this.patronRepo = patronRepo;
    }

    public void addPatron(Patron patron){
        if(patronRepo.getPatron(patron.getId()) != null){
            throw new RuntimeException("Patron already exists.");
        }
        patronRepo.addPatron(patron);
    }

    public void removePatron(String id){
        Patron patron = patronRepo.getPatron(id);
        if(patron == null){
            throw new RuntimeException("Patron not found.");
        }
        patronRepo.removePatron(id);
    }

    public void updatePatron(String id, String newName){
        Patron patron = patronRepo.getPatron(id);
        if(patron == null){
            throw new RuntimeException("Patron not found.");
        }
        patron.setName(newName);

    }

}
