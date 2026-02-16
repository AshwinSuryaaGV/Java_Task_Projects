import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Issued: " + (isIssued ? "Yes" : "No"));
        System.out.println("----------------------------");
    }
}

// User Class
class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    void displayUser() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("----------------------------");
    }
}

// Library Class
class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully.");
    }

    void issueBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).bookId == bookId) {

                if (!books.get(i).isIssued) {
                    books.get(i).isIssued = true;
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).bookId == bookId) {

                if (books.get(i).isIssued) {
                    books.get(i).isIssued = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void displayBooks() {
        if (books.size() == 0) {
            System.out.println("No books available.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            books.get(i).displayBook();
        }
    }

    void displayUsers() {
        if (users.size() == 0) {
            System.out.println("No users available.");
            return;
        }

        for (int i = 0; i < users.size(); i++) {
            users.get(i).displayUser();
        }
    }
}

// Main Class
public class LibraryBooks {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Users");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Author: ");
                String author = sc.nextLine();

                Book book = new Book(id, title, author);
                library.addBook(book);
            }

            else if (choice == 2) {

                System.out.print("Enter User ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                User user = new User(id, name);
                library.addUser(user);
            }

            else if (choice == 3) {

                System.out.print("Enter Book ID to issue: ");
                int id = sc.nextInt();
                library.issueBook(id);
            }

            else if (choice == 4) {

                System.out.print("Enter Book ID to return: ");
                int id = sc.nextInt();
                library.returnBook(id);
            }

            else if (choice == 5) {

                library.displayBooks();
            }

            else if (choice == 6) {

                library.displayUsers();
            }

            else if (choice == 7) {

                System.out.println("Exiting system...");
                break;
            }

            else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
