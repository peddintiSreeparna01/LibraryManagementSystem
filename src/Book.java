import java.util.ArrayList;
import java.util.List;

public class Book {

    private String title;
    private String author;
    private final String isbn;
    private int publicationYear;
    private boolean isAvailable;

    // Observers
    private List<Observer> observers = new ArrayList<>();

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.isAvailable = true; // default
    }

    // ================== Getters ==================
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublicationYear() { return publicationYear; }
    public boolean isAvailable() { return isAvailable; }

    // ================== Allowed Updates ==================
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // ================== Business Methods ==================
    public void markAsBorrowed() {
        this.isAvailable = false;
    }

    public void markAsReturned() {
        this.isAvailable = true;
        notifyObservers();     // notify all waiting patrons
        observers.clear();     // clear reservations after notification
    }

    // ================== Observer Methods ==================
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Book '" + title + "' is now available!");
        }
    }
}