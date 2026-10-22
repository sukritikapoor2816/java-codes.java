<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <h1>Registration Successful!</h1>
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
    %>
    <h2>Submitted Registration Details</h2>
    <p><b>Name:</b> <%= name %></p>
    <p><b>Email:</b> <%= email %></p>
    <p><b>Phone Number:</b> <%= phone %></p>
    <p><b>Password:</b> Not displayed for security reasons.</p>
    <br>
    <a href="Registration.jsp">Back to Registration Form</a>
</body>
</html>
