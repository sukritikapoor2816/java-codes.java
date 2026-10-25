<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Record Management</title>
</head>
<body>
    <h1>Patient Record Management System</h1>
    <h2>Patient Records</h2>
    <p><a href="AddPatient.jsp">Add New Patient</a></p>
    <table border="1" cellpadding="10">
        <tr>
            <th>Patient ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
            <th>Actions</th>
        </tr>
        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db",
                "root",
                "MySQL@12345"
            );
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM patients ORDER BY patient_id"
            );
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
            <td>
                <a href="EditPatient.jsp?id=<%= rs.getInt("patient_id") %>">Edit</a>
                |
                <a href="DeletePatient.jsp?id=<%= rs.getInt("patient_id") %>"onclick="return confirm('Are you sure you want to delete this patient?')">Delete
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
            <td colspan="6">
                Error loading patients: <%= e.getMessage() %>
            </td>
        </tr>
        <%
        }
        %>
    </table>
</body>
</html>
