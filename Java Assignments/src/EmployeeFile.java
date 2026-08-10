import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeFile {

    static File file = new File("employee.txt");

    public static void main(String[] args) {

        writeEmployeeDetails();
        readEmployeeDetails();
    }

    static void writeEmployeeDetails() {

        try {

            Scanner sc = new Scanner(System.in);
            FileWriter writer = new FileWriter(file);

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            writer.write("Employee ID: " + id + "\n");
            writer.write("Employee Name: " + name + "\n");
            writer.write("Department: " + department + "\n");
            writer.write("Salary: " + salary + "\n");

            writer.close();
            sc.close();

            System.out.println("Employee details written successfully.");

        } catch (IOException e) {

            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    static void readEmployeeDetails() {

        try {

            Scanner reader = new Scanner(file);

            System.out.println("\nEmployee Details:");

            while (reader.hasNextLine()) {

                String data = reader.nextLine();
                System.out.println(data);
            }

            reader.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}