package assignment8;

class Employee {

    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee Details");
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {

    String name;

    Manager(String name) {
        super("Rahul", 40000);
        this.name = name;
    }

    void display() {
        System.out.println("Parent Name: " + super.name);
        System.out.println("Manager Name: " + name);
        System.out.println("Parent Salary: " + super.salary);
        super.display();
    }
}

public class EmployeeManager {

    public static void main(String[] args) {

        Manager m = new Manager("Amit");

        m.display();
    }
}