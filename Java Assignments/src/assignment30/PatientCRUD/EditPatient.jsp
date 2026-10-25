<%@ page import="java.sql.*" %>
<%
String idText = request.getParameter("id");
if (idText == null || idText.trim().isEmpty()) {
    out.println("Patient ID is missing.");
    return;
}
try {
    int patientId = Integer.parseInt(idText);
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/employee_db",
        "root",
        "MySQL@12345"
    );
    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM patients WHERE patient_id = ?"
    );
    ps.setInt(1, patientId);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Patient</title>
</head>
<body>
    <h1>Edit Patient Details</h1>
    <form action="UpdatePatient.jsp" method="post">
        <input type="hidden" name="patient_id"value="<%= rs.getInt("patient_id") %>">
        <label>Name:</label>
        <input type="text" name="name"value="<%= rs.getString("name") %>" maxlength="100" required>
        <br><br>
        <label>Age:</label>
        <input type="number" name="age" value="<%= rs.getInt("age") %>" min="0" max="150" required>
        <br><br>
        <label>Disease:</label>
        <input type="text" name="disease"value="<%= rs.getString("disease") %>" maxlength="150" required>
        <br><br>
        <label>Treatment Status:</label>
        <select name="treatment_status" required>
            <option value="Ongoing"<%= "Ongoing".equals(rs.getString("treatment_status")) ? "selected" : "" %>>Ongoing
            </option>
            <option value="Recovered"<%= "Recovered".equals(rs.getString("treatment_status")) ? "selected" : "" %>>Recovered
            </option>
            <option value="Discharged"<%= "Discharged".equals(rs.getString("treatment_status")) ? "selected" : "" %>>Discharged
            </option>
        </select>
        <br><br>
        <input type="submit" value="Update Patient">
    </form>
    <p><a href="index.jsp">Back to Patient Records</a></p>
</body>
</html>
<%
    } else {
        out.println("Patient not found.");
    }
    rs.close();
    ps.close();
    con.close();
} catch (Exception e) {
    out.println("Error fetching patient: " + e.getMessage());
}
%>