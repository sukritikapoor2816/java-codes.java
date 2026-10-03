package assignment21;

import java.sql.Connection;
import java.sql.DriverManager;

public class ques1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "MySQL@12345";
        try {
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully!");
            System.out.println("Connection Status: Connected");

            con.close();
        } catch (Exception e) {
            System.out.println("Connection failed!");
            System.out.println(e.getMessage());
        }
    }
}