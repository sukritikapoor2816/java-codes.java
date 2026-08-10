package student;
import java.util.Scanner;
public class Student {
    String name;
    String course;
    int rollNo;
    

    public void displayStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Student Name: ");
        name = scanner.nextLine();

        System.out.println("Enter Course: ");
        course = scanner.nextLine();

        System.out.println("Enter Roll No: ");
        rollNo = scanner.nextInt();

        System.out.println("Student Details");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Course: " + course);
    }
}
