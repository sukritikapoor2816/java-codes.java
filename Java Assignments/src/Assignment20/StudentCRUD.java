package Assignment20;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class StudentCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Assignment19DB";
        String username = "root";
        String password = "MySQL@12345";
        try {
            // Establish connection with database
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            // Create Statement object
            Statement stmt = con.createStatement();
            // CREATE - Insert student record
            String insertQuery =
                "INSERT INTO student_crud VALUES " +
                "(1, 'Sakshi', 'Computer Science', 85)";
            stmt.executeUpdate(insertQuery);
            System.out.println("After INSERT:");
            displayStudents(stmt);
            // UPDATE - Change student marks
            String updateQuery =
                "UPDATE student_crud SET marks = 90 " +
                "WHERE roll_no = 1";
            stmt.executeUpdate(updateQuery);
            System.out.println("\nAfter UPDATE:");
            displayStudents(stmt);
            // DELETE - Delete student record
            String deleteQuery =
                "DELETE FROM student_crud " +
                "WHERE roll_no = 1";
            stmt.executeUpdate(deleteQuery);
            System.out.println("\nAfter DELETE:");
            displayStudents(stmt);
            // Close resources
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // Method to display student records
    public static void displayStudents(Statement stmt) throws Exception {
        String query = "SELECT * FROM student_crud";
        ResultSet rs = stmt.executeQuery(query);
        System.out.println(" ");
        boolean found = false;
        while (rs.next()) {
            found = true;
            int rollNo = rs.getInt("roll_no");
            String name = rs.getString("name");
            String course = rs.getString("course");
            double marks = rs.getDouble("marks");
            System.out.println(
                rollNo + "  " + name + "  " +
                course + "  " + marks
            );
        }
        if (!found) {
            System.out.println("No student records found.");
        }
        rs.close();
    }
}
