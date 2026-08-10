package faculty;
import java.util.Scanner;
public class Faculty {
    
    String name;
    String department;
    int experience;

    public void displayFaculty() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Faculty Name: ");
        name = scanner.nextLine();

        System.out.println("Enter Department: ");
        department = scanner.nextLine();

        System.out.println("Enter Experience in years: ");
        experience = scanner.nextInt();

        System.out.println("Faculty Details");
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Experience: " + experience + " years");
    }
}
