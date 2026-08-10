import java.util.Scanner;
import library.Book;

public class LibraryDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Book book = new Book();

        System.out.print("Enter Book ID: ");
        book.bookId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book Title: ");
        book.title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        book.author = scanner.nextLine();

        System.out.print("Enter Price: ");
        book.price = scanner.nextDouble();

        System.out.println();

        book.displayBook();

        scanner.close();
    }
}