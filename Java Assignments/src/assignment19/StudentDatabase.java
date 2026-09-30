package assignment19;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class StudentDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Assignment19DB";
        String username = "root";
        String password = "MySQL@12345";
        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Student Records");
            System.out.println(" ");
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                System.out.println(
                    id + "  " + name + "  " + age + "  " + course
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
