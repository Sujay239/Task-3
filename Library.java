import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void showBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void borrowBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && book.isAvailable() && user != null) {
            book.borrowBook();
            user.borrowBook(book);
            System.out.println(user.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book not available or User not found.");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && !book.isAvailable() && user != null) {
            book.returnBook();
            user.returnBook(book);
            System.out.println(user.getName() + " returned: " + book.getTitle());
        } else {
            System.out.println("Invalid return attempt.");
        }
    }

    private Book findBook(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) return b;
        }
        return null;
    }

    private User findUser(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) return u;
        }
        return null;
    }
}
