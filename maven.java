import java.util.*;

class Book {
    String title;
    String author;
    int id;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public String toString() {
        return id + " - " + title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

class Library {
    private Map<Integer, Book> books = new HashMap<>();

    public void addBook(int id, String title, String author) {
        Book book = new Book(id, title, author);
        books.put(id, book);
    }

    public void issueBook(int id) {
        Book book = books.get(id);
        if (book != null && !book.isIssued) {
            book.issueBook();
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is either not available or already issued.");
        }
    }

    public void returnBook(int id) {
        Book book = books.get(id);
        if (book != null && book.isIssued) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid return operation.");
        }
    }

    public void displayBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(1, "The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook(2, "1984", "George Orwell");
        library.addBook(3, "To Kill a Mockingbird", "Harper Lee");

        while (true) {
            System.out.println("\n1. Display Books\n2. Issue Book\n3. Return Book\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = scanner.nextInt();
                    library.issueBook(issueId);
                    break;
                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
