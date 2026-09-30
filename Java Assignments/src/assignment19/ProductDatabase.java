package assignment19;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ProductDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Assignment19DB";
        String username = "root";
        String password = "MySQL@12345";
        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Product Details");
            System.out.println(" ");
            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                System.out.println(
                    id + "  " + name + "  " + quantity + "  " + price
                );
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
