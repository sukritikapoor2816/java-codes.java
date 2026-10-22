<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h1>Submitted Student Information</h1>
    <%
        String studentName = request.getParameter("studentName");
        String prn = request.getParameter("prn");
        String course = request.getParameter("course");
        String semester = request.getParameter("semester");
    %>
    <p><b>Student Name:</b> <%= studentName %></p>
    <p><b>PRN:</b> <%= prn %></p>
    <p><b>Course:</b> <%= course %></p>
    <p><b>Semester:</b> <%= semester %></p>

    <br>
    <a href="student.jsp">Back to Student Form</a>
</body>
</html>