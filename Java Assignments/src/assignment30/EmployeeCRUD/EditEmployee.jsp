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
    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM employees WHERE id = ?"
    );
    ps.setInt(1, Integer.parseInt(id));
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <h1>Edit Employee Details</h1>
    <form action="updateEmployee.jsp" method="post">
        <input type="hidden" name="id"value="<%= rs.getInt("id") %>">

        <label>Name:</label>
        <input type="text" name="name"value="<%= rs.getString("name") %>" required>
        <br><br>

        <label>Department:</label>
        <input type="text" name="department"value="<%= rs.getString("department") %>" required>
        <br><br>

        <label>Salary:</label>
        <input type="number" name="salary" step="0.01" min="0"value="<%= rs.getDouble("salary") %>" required>
        <br><br>
        <input type="submit" value="Update Employee">
    </form>
    <p><a href="index.jsp">Back to Employee List</a></p>
</body>
</html>
<%
    } else {
        out.println("Employee not found.");
    }
    rs.close();
    ps.close();
    con.close();
} catch (Exception e) {
    out.println("Error fetching employee: " + e.getMessage());
}
%>