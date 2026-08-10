import java.util.Scanner;
public class pattern {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of rows for the pattern: ");
            int rows = sc.nextInt();

            for (int i = 1; i <= rows; i++) {
                // Print leading spaces
                for (int j = rows; j > i; j--) {
                    System.out.print(" ");
                }
                // Print stars
                for (int k = 1; k <= (2 * i - 1); k++) {
                    System.out.print("*");
                }
                System.out.println(); // Move to the next line after each row
            }
        }
    }
    
}
