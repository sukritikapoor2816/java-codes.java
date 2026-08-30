import java.util.Scanner;
class MyException extends Exception {
    MyException(String msg) {
        super(msg);
    }
}
public class Voting {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        try {
            if (age < 18) {
                throw new MyException("Not eligible for voting");
                
            }
            System.out.println("Eligible for voting");
        }
        catch (MyException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
