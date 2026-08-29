import java.util.Scanner;
public class Shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("HOW MANY PRODUCTS DO YOU WANT TO ADD? ");
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                throw new Exception("Invalid quantity");
            }
            for (int i = 0; i < quantity; i++) {
                System.out.print("Enter product name: ");
                String productName = sc.next();
            }
            System.out.println("\nProduct(s) added.");
        }
        catch (Exception e) {
            System.out.println("Error: Quantity should be greater than 0");
        }
        sc.close();
    }
}
