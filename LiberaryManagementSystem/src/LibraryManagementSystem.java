import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Update Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Add Member");
            System.out.println("7. Display Members");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();

                        Book book = new Book(bookId, title, author);

                        library.addBook(book);

                        break;

                    case 2:

                        System.out.print("Enter book title to search: ");
                        String searchTitle = sc.nextLine();

                        library.searchBook(searchTitle);

                        break;

                    case 3:

                        System.out.print("Enter Book ID: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new title: ");
                        String newTitle = sc.nextLine();

                        System.out.print("Enter new author: ");
                        String newAuthor = sc.nextLine();

                        library.updateBook(
                            updateId,
                            newTitle,
                            newAuthor
                        );

                        break;

                    case 4:

                        System.out.print("Enter Book ID to remove: ");
                        int removeId = sc.nextInt();

                        library.removeBook(removeId);

                        break;

                    case 5:

                        library.displayBooks();

                        break;

                    case 6:

                        System.out.print("Enter Member ID: ");
                        int memberId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Member Name: ");
                        String memberName = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        Member member =
                            new Member(memberId, memberName, email);

                        library.addMember(member);

                        break;

                    case 7:

                        library.displayMembers();

                        break;

                    case 8:

                        System.out.print("Enter Book ID: ");
                        int issueBookId = sc.nextInt();

                        System.out.print("Enter Member ID: ");
                        int issueMemberId = sc.nextInt();

                        library.issueBook(
                            issueBookId,
                            issueMemberId
                        );

                        break;

                    case 9:

                        System.out.print("Enter Book ID: ");
                        int returnBookId = sc.nextInt();

                        library.returnBook(returnBookId);

                        break;

                    case 10:

                        System.out.println(
                            "Thank you for using Library Management System!"
                        );

                        break;

                    default:

                        System.out.println(
                            "Invalid choice! Please enter 1-10."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                    "Invalid input! Please enter valid data."
                );

                sc.nextLine();
                choice = 0;
            }

        } while (choice != 10);

        sc.close();
    }
}