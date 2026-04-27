# Library Management System

## Overview

This project is a Library Management System implemented in Java. It manages books, patrons, and lending operations using in-memory data structures. The focus of this implementation is on demonstrating Object-Oriented Programming (OOP), SOLID principles, and the use of design patterns.

No external database or APIs are used.

---

## Features

### Book Management

* Add, remove, and update books
* Search books by title, author, and ISBN
* Track availability of books

### Patron Management

* Add and update patron details
* Maintain patron records

### Lending Process

* Checkout books
* Return books
* Track borrowing transactions

### Inventory Management

* Maintain current state of available and borrowed books

### Reservation System

* Patrons can reserve books that are currently borrowed
* Patrons are notified when the book becomes available

---

## System Design

### Core Classes

* `Book`: Represents a book in the library
* `Patron`: Represents a library member
* `Transaction`: Represents a borrowing record
* `BookRepository`: Interface for managing books
* `PatronRepository`: Interface for managing patrons
* `BookService`: Handles book-related business logic
* `PatronService`: Handles patron-related operations
* `LendingService`: Handles checkout, return, and reservation logic

---

## Design Patterns

### Observer Pattern

Used for the reservation system.

* `Book` acts as the subject
* `Patron` acts as the observer
* When a book is returned, all registered patrons are notified

### Factory Pattern

Used for creating book objects.

* `BookFactory` centralizes object creation
* Helps encapsulate validation and creation logic

---

## SOLID Principles

* Single Responsibility Principle: Each class has a clearly defined responsibility
* Open/Closed Principle: System can be extended without modifying existing code
* Liskov Substitution Principle: Repository implementations can be replaced without affecting behavior
* Interface Segregation Principle: Separate interfaces for different entities
* Dependency Inversion Principle: Services depend on abstractions, not concrete implementations

---

## Class Diagram (Textual Representation)

```
Book
 - title
 - author
 - isbn
 - publicationYear
 - isAvailable
 - observers

Patron implements Observer
 - id
 - name

Transaction
 - patronId
 - isbn
 - issueDate
 - returnDate

BookRepository (interface)
PatronRepository (interface)

BookService
PatronService
LendingService
```

---

## How to Run

1. Clone the repository
2. Open the project in an IDE (IntelliJ, Eclipse, etc.)
3. Run the `Main` class

---

## Assumptions

* Data is stored in memory
* ISBN uniquely identifies a book
* A book can be borrowed by only one patron at a time
* Notifications are printed to the console

---

## Future Improvements

* Add persistent storage (database)
* Implement logging framework
* Add multi-branch support
* Add recommendation system

---

## Author

Sreeparna
