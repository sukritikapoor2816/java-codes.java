package assignment26;
class BankAccount {
    int balance = 1000;
    synchronized void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount
                + " | Balance: " + balance);
    }
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount
                    + " | Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
public class ques2 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Runnable depositTask = () -> {
            for (int i = 0; i < 3; i++) {
                account.deposit(500);
            }
        };
        Runnable withdrawTask = () -> {
            for (int i = 0; i < 3; i++) {
                account.withdraw(300);
            }
        };
        Thread t1 = new Thread(depositTask);
        Thread t2 = new Thread(withdrawTask);
        t1.start();
        t2.start();
    }
}
