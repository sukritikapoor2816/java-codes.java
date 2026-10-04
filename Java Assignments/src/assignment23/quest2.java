package assignment23;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class quest2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Assignment23DB";
        String username = "root";
        String password = "MySQL@12345";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM Employee";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Employee Records:");
            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                System.out.println("Employee ID: " + employeeId);
                System.out.println("Name: " + name);
                System.out.println("Department: " + department);
                System.out.println("Salary: " + salary);
                System.out.println("----------------------------");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}