package assignment25;
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
            System.out.println("Withdrawn: " + amount + " | Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
public class questiontwo extends Thread {
    BankAccount account;
    boolean isDeposit;
    questiontwo(BankAccount account, boolean isDeposit) {
        this.account = account;
        this.isDeposit = isDeposit;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            if (isDeposit) {
                account.deposit(500);
            } else {
                account.withdraw(300);
            }
        }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        questiontwo t1 = new questiontwo(account, true);
        questiontwo t2 = new questiontwo(account, false);
        t1.start();
        t2.start();
    }
}
