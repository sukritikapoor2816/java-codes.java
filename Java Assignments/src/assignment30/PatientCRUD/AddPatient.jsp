<%@ page import="java.sql.*" %>
<%
if ("POST".equalsIgnoreCase(request.getMethod())) {
    String idText = request.getParameter("patient_id");
    String name = request.getParameter("name");
    String ageText = request.getParameter("age");
    String disease = request.getParameter("disease");
    String status = request.getParameter("treatment_status");
    try {
        int patientId = Integer.parseInt(idText);
        int age = Integer.parseInt(ageText);
        if (patientId <= 0 || age < 0 || age > 150) {
            out.println("Please enter a valid patient ID and age.");
        } else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db",
                "root",
                "MySQL@12345"
            );
            PreparedStatement ps = con.prepareStatement("INSERT INTO patients (patient_id, name, age, disease, treatment_status) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setInt(1, patientId);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, disease);
            ps.setString(5, status);
            ps.executeUpdate();
            ps.close();
            con.close();
            response.sendRedirect("index.jsp");
            return;
        }
    } catch (SQLIntegrityConstraintViolationException e) {
        out.println("This patient ID already exists. Please use a different ID.");
    } catch (Exception e) {
        out.println("Error adding patient: " + e.getMessage());
    }
}
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Patient</title>
</head>
<body>
    <h1>Add New Patient</h1>
    <form action="AddPatient.jsp" method="post">
        <label>Patient ID:</label>
        <input type="number" name="patient_id" min="1" required>
        <br><br>
        <label>Name:</label>
        <input type="text" name="name" maxlength="100" required>
        <br><br>
        <label>Age:</label>
        <input type="number" name="age" min="0" max="150" required>
        <br><br>
        <label>Disease:</label>
        <input type="text" name="disease" maxlength="150" required>
        <br><br>
        <label>Treatment Status:</label>
        <select name="treatment_status" required>
            <option value="">-- Select Status --</option>
            <option value="Ongoing">Ongoing</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select>
        <br><br>
        <input type="submit" value="Save Patient">
    </form>
    <p><a href="index.jsp">Back to Patient Records</a></p>
</body>
</html>
