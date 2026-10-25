<%@ page import="java.sql.*" %>
<%
String idText = request.getParameter("id");
if (idText == null || idText.trim().isEmpty()) {
    response.sendRedirect("index.jsp");
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
        "DELETE FROM patients WHERE patient_id = ?"
    );
    ps.setInt(1, patientId);
    int rows = ps.executeUpdate();
    ps.close();
    con.close();
    if (rows > 0) {
        response.sendRedirect("index.jsp");
        return;
    } else {
        out.println("Patient record not found.");
    }
} catch (Exception e) {
    out.println("Error deleting patient: " + e.getMessage());
}
%>
<br>
<a href="index.jsp">Back to Patient Records</a>