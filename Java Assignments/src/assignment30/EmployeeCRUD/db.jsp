<%@ page import="java.sql.*" %>
<%
String url = "jdbc:mysql://localhost:3306/employee_db";
String username = "root";
String password = "MySQL@12345";
Connection con = null;
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(url, username, password);
} catch (Exception e) {
    out.println("Database connection failed: " + e.getMessage());
}
%>