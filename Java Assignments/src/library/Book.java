package library;
public class Book {

    public int bookId;
    public String title;
    public String author;
    public double price;

    public void displayBook() {
        System.out.println("Book Details");
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}