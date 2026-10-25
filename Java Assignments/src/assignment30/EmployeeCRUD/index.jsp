<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
</head>
<body>
    <h1>Employee Management System</h1>
    <h2>Add Employee</h2>
    <form action="addEmployee.jsp" method="post">
        <label>Employee Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>Department:</label>
        <input type="text" name="department" required>
        <br><br>

        <label>Salary:</label>
        <input type="number" name="salary" step="0.01" min="0" required>
        <br><br>
        <input type="submit" value="Add Employee">
    </form>
    <hr>
    <h2>Employee Records</h2>
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Actions</th>
        </tr>
        <%
        try {
            Class<?> driver = Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("<p>MySQL Driver Loaded: " + driver.getName() + "</p>");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db",
                "root",
                "MySQL@12345"
            );
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM employees"
            );
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("department") %></td>
            <td><%= rs.getDouble("salary") %></td>
            <td>
                <a href="editEmployee.jsp?id=<%= rs.getInt("id") %>">
                    Edit
                </a>
                |
                <a href="deleteEmployee.jsp?id=<%= rs.getInt("id") %>" onclick="return confirm('Are you sure you want to delete this employee?')">
                    Delete
                </a>
            </td>
        </tr>
        <%
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
        %>
        <tr>
            <td colspan="5">
                <strong>Error type:</strong>
                <%= e.getClass().getName() %>
                <br>
                <strong>Details:</strong>
                <%= e.getMessage() %>
            </td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>