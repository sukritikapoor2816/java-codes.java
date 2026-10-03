package assignment22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class question2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "MySQL@12345";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Staff ID: ");
        String staffId = sc.nextLine();
        System.out.print("Enter Password: ");
        String staffPassword = sc.nextLine();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM hospital_staff WHERE staff_id = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, staffId);
            ps.setString(2, staffPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                System.out.println("Login successful!");
                System.out.println("Welcome, " + name);
                System.out.println("Role: " + role);
                System.out.println("Access granted.");
            } else {
                System.out.println("Invalid Staff ID or Password!");
                System.out.println("Access denied.");
            }
            rs.close();
            ps.close();
            con.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
        }
    }
}