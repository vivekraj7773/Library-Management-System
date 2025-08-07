import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
         return title;
    }

    public String getAuthor() {
         return author; 
    }

    public boolean isIssued() { 
        return isIssued;
    }

    public void issue() {
         isIssued = true; 
    }

    public void returnBook() { 
        isIssued = false; 
    }
}


class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { 
        return name;
    }

    public int getId() {
         return id; 
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to the library.");
    }

    public void issueBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (!b.isIssued()) {
                    b.issue();
                    System.out.println(title + " has been issued.");
                    return;
                } else {
                    System.out.println(title + " is already issued.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println(title + " has been returned.");
                    return;
                } else {
                    System.out.println(title + " was not issued.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void showBooks() {
        System.out.println("\nLibrary Books:");
        for (Book b : books) {
            System.out.println(b.getTitle() + " by " + b.getAuthor() + " - " + (b.isIssued() ? "Issued" : "Available"));
        }
        System.out.println();
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Effective Java", "Joshua Bloch"));
        library.addBook(new Book("Clean Code", "Robert C. Martin"));

         User user = new User("Vivek", 101);

        while (true) {
            System.out.println("----- Library Menu -----");
            System.out.println("1. Show all books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = scanner.nextLine();
                    library.issueBook(issueTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
