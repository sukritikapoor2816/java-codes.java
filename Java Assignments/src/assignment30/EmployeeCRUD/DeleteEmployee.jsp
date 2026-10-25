<%@ page import="java.sql.*" %>
<%
String id = request.getParameter("id");
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employee_db",
        "root",
        "MySQL@12345"
    );
    String sql = "DELETE FROM employees WHERE id = ?";
    PreparedStatement ps = con.prepareStatement(sql);
    ps.setInt(1, Integer.parseInt(id));
    int result = ps.executeUpdate();
    ps.close();
    con.close();
    if (result > 0) {
        response.sendRedirect("index.jsp");
    } else {
        out.println("Employee not found.");
    }
} catch (Exception e) {
    out.println("Error deleting employee: " + e.getMessage());
}
%>