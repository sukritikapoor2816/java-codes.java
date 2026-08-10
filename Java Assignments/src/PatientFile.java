import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PatientFile {

    static File file = new File("patient.txt");

    public static void main(String[] args) {

        writePatientDetails();
        readPatientDetails();
    }

    static void writePatientDetails() {

        try {

            Scanner sc = new Scanner(System.in);
            FileWriter writer = new FileWriter(file);

            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Patient Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Diagnosis: ");
            String diagnosis = sc.nextLine();

            writer.write("Patient ID: " + id + "\n");
            writer.write("Patient Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Diagnosis: " + diagnosis + "\n");

            writer.close();
            sc.close();

            System.out.println("Patient details written successfully.");

        } catch (IOException e) {

            System.out.println("An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    static void readPatientDetails() {

        try {

            Scanner reader = new Scanner(file);

            System.out.println("\nPatient Details:");

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
