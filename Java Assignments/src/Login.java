import java.util.Scanner;

class Login {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter password: ");
            String pass = sc.nextLine();
            if (!pass.equals("1234")) {
                throw new Exception();
            }
            System.out.println("Login successful");
        }
        catch (Exception e) {
            System.out.println("Invalid password");
        }
        finally {
            System.out.println("Thank you for using the login system");
            sc.close();
        }
    }
}
