import java.util.Scanner;
class MyException extends Exception {
    MyException(String m) {
        super(m);
    }
}
public class License {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        try {
            if (age < 18) {
                throw new MyException("Age is below 18");
            }

            System.out.println("You are eligible for driving license");
        }
        catch (MyException e) {
            System.out.println("You are not eligible for driving license");
        }
        sc.close();
    }
}