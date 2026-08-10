package assignment9;

class BankAccount {

    final long accountNumber = 1234567890;
    String accountHolder = "Rahul";
    double balance = 50000;

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class BankAccountDemo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.displayDetails();
    }
}