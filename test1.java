import java.util.Scanner;

public class test1 {

    double balance = 0.0;

    // Check Balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount Deposited Successfully.");
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal Successful.");
            System.out.println("Updated Balance: " + balance);
        }
    }

    // Menu
    public void displayMenu() {
        System.out.println("\nWelcome to Union Bank of India\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        test1 bank = new test1();

        System.out.print("Enter CustomerID: ");
        String customerId = sc.nextLine();
        System.out.println("\nCustomer ID : " + customerId + "\n");


        int choice;

        do {

            bank.displayMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bank.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    bank.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    bank.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you, " + customerId + "!");
                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
