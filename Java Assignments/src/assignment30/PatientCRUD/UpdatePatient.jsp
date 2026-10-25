<%@ page import="java.sql.*" %>
<%
if (!"POST".equalsIgnoreCase(request.getMethod())) {
    response.sendRedirect("index.jsp");
    return;
}
request.setCharacterEncoding("UTF-8");
String idText = request.getParameter("patient_id");
String name = request.getParameter("name");
String ageText = request.getParameter("age");
String disease = request.getParameter("disease");
String status = request.getParameter("treatment_status");
try {
    int patientId = Integer.parseInt(idText);
    int age = Integer.parseInt(ageText);
    if (patientId <= 0 || age < 0 || age > 150 ||
        name == null || name.trim().isEmpty() ||
        disease == null || disease.trim().isEmpty() ||
        status == null ||
        !("Ongoing".equals(status) ||"Recovered".equals(status) ||"Discharged".equals(status))) {
        out.println("Invalid patient details. Please go back and check your entries.");
    } else {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/employee_db",
            "root",
            "MySQL@12345"
        );
        PreparedStatement ps = con.prepareStatement(
            "UPDATE patients SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?"
        );
        ps.setString(1, name.trim());
        ps.setInt(2, age);
        ps.setString(3, disease.trim());
        ps.setString(4, status);
        ps.setInt(5, patientId);
        int rows = ps.executeUpdate();
        ps.close();
        con.close();
        if (rows > 0) {
            response.sendRedirect("index.jsp");
            return;
        } else {
            out.println("Patient not found. No record was updated.");
        }
    }
} catch (Exception e) {
    out.println("Error updating patient: " + e.getMessage());
}
%>
<br>
<a href="index.jsp">Back to Patient Records</a>