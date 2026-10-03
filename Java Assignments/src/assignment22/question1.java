package assignment22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class question1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "MySQL@12345";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful!");
                System.out.println("Welcome, " + user);
            } else {
                System.out.println("Invalid username or password!");
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