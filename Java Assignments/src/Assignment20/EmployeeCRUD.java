package Assignment20;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class EmployeeCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Assignment19DB";
        String username = "root";
        String password = "MySQL@12345";
        try {
            // Establish database connection
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            // Create Statement object
            Statement stmt = con.createStatement();
            // INSERT operation
            String insertQuery =
                "INSERT INTO employees VALUES " +
                "(101, 'Rahul', 'IT', 50000)";
            stmt.executeUpdate(insertQuery);
            System.out.println("After INSERT:");
            displayEmployees(stmt);
            // UPDATE operation
            String updateQuery =
                "UPDATE employees SET salary = 55000 " +
                "WHERE employee_id = 101";
            stmt.executeUpdate(updateQuery);
            System.out.println("\nAfter UPDATE:");
            displayEmployees(stmt);
            // DELETE operation
            String deleteQuery =
                "DELETE FROM employees " +
                "WHERE employee_id = 101";
            stmt.executeUpdate(deleteQuery);
            System.out.println("\nAfter DELETE:");
            displayEmployees(stmt);
            // Close statement and connection
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // Method to display employee records
    public static void displayEmployees(Statement stmt) throws Exception {
        String query = "SELECT * FROM employees";
        ResultSet rs = stmt.executeQuery(query);
        System.out.println(" ");
        while (rs.next()) {
            int id = rs.getInt("employee_id");
            String name = rs.getString("employee_name");
            String department = rs.getString("department");
            double salary = rs.getDouble("salary");
            System.out.println(
                id + "  " + name + "  " +
                department + "  " + salary
            );
        }
        rs.close();
    }
}
