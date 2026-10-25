<%@ page import="java.sql.*" %>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
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
    String sql = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, name);
    ps.setString(2, department);
    ps.setDouble(3, Double.parseDouble(salaryText));
    ps.setInt(4, Integer.parseInt(id));
    int result = ps.executeUpdate();
    ps.close();
    con.close();
    if (result > 0) {
        response.sendRedirect("index.jsp");
    } else {
        out.println("No employee was updated. Check the employee ID.");
    }
} catch (Exception e) {
    out.println("Error updating employee: " + e.getMessage());
}
%>