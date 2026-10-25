<%@ page import="java.sql.*" %>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String department = request.getParameter("department");
String salaryText = request.getParameter("salary");
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employee_db",
        "root",
        "MySQL@12345"
    );
    String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, name);
    ps.setString(2, department);
    ps.setDouble(3, Double.parseDouble(salaryText));
    int result = ps.executeUpdate();
    ps.close();
    con.close();
    if (result > 0) {
        response.sendRedirect("index.jsp");
    } else {
        out.println("Employee could not be added.");
    }
} catch (Exception e) {
    out.println("Error adding employee: " + e.getMessage());
}
%>