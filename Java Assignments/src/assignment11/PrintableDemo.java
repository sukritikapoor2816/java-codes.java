package assignment11;

interface Printable {

    void printDetails();
}

class Student implements Printable {

    String name = "Rahul";
    int rollNo = 101;

    public void printDetails() {
        System.out.println("Student Details");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

class Employee implements Printable {

    String name = "Amit";
    int employeeId = 501;

    public void printDetails() {
        System.out.println("Employee Details");
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

public class PrintableDemo {

    public static void main(String[] args) {

        Student s = new Student();
        Employee e = new Employee();

        s.printDetails();

        System.out.println();

        e.printDetails();
    }
}
