import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add sample books
        library.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));

        // Add sample users
        library.addUser(new User(101, "Alice"));
        library.addUser(new User(102, "Bob"));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Show Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    library.borrowBook(bId, uId);
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    int rbId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int ruId = sc.nextInt();
                    library.returnBook(rbId, ruId);
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
