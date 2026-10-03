package assignment21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ques2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "MySQL@12345";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection successful!");
            System.out.println("Connection Status: Connected");
            Statement stmt = con.createStatement();
            System.out.println("Student database connected successfully.");
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
        }
    }
}