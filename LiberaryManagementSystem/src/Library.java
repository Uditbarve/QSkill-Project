import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Search Book
    public void searchBook(String title) {

        boolean found = false;

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Update Book
    public void updateBook(int bookId, String title, String author) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                book.setTitle(title);
                book.setAuthor(author);

                System.out.println("Book updated successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Remove Book
    public void removeBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                books.remove(book);

                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Display all books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n----- BOOK LIST -----");

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Add Member
    public void addMember(Member member) {

        members.add(member);

        System.out.println("Member added successfully!");
    }

    // Display members
    public void displayMembers() {

        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        System.out.println("\n----- MEMBER LIST -----");

        for (Member member : members) {
            member.displayMember();
        }
    }

    // Issue Book
    public void issueBook(int bookId, int memberId) {

        Book selectedBook = null;

        for (Book book : books) {

            if (book.getBookId() == bookId) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Book not found.");
            return;
        }

        boolean memberExists = false;

        for (Member member : members) {

            if (member.getMemberId() == memberId) {
                memberExists = true;
                break;
            }
        }

        if (!memberExists) {
            System.out.println("Member not found.");
            return;
        }

        if (!selectedBook.isAvailable()) {
            System.out.println("Book is already issued.");
            return;
        }

        selectedBook.setAvailable(false);

        System.out.println("Book issued successfully!");
    }

    // Return Book
    public void returnBook(int bookId) {

        for (Book book : books) {

            if (book.getBookId() == bookId) {

                if (book.isAvailable()) {
                    System.out.println("Book is already available.");
                } else {
                    book.setAvailable(true);
                    System.out.println("Book returned successfully!");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }
}