import java.util.Scanner;

class EmployeePayroll
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        try
        {
            // Taking employee details as String
            System.out.print("Enter Employee ID: ");
            String idInput = sc.nextLine();

            System.out.print("Enter Salary: ");
            String salaryInput = sc.nextLine();

            System.out.print("Enter Bonus: ");
            String bonusInput = sc.nextLine();

            System.out.print("Enter Working Days: ");
            String daysInput = sc.nextLine();

            // Converting String values into wrapper objects
            Integer employeeId = Integer.valueOf(idInput);
            Double salary = Double.valueOf(salaryInput);
            Double bonus = Double.valueOf(bonusInput);
            Integer workingDays = Integer.valueOf(daysInput);

            // Calculating gross salary
            Double grossSalary = salary + bonus;

            // Calculating annual salary
            Double annualSalary = grossSalary * 12;

            // Displaying employee details
            System.out.println("\n--- Employee Payroll Details ---");
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Salary: " + salary);
            System.out.println("Bonus: " + bonus);
            System.out.println("Working Days: " + workingDays);
            System.out.println("Gross Salary: " + grossSalary);
            System.out.println("Annual Salary: " + annualSalary);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid input! Please enter numeric values only.");
        }

        sc.close();
    }
}