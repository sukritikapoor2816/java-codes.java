import java.util.Scanner;
class ATMMachine {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int pin = s.nextInt();

            if (pin != 1234) {
                throw new Exception();
            }

            System.out.println("Correct PIN");
        }

        catch (Exception e) {
            System.out.println("Wrong PIN");
        }

        finally {
            System.out.println("Verification completed");
        }
        s.close();
    }
}
