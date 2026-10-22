<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
    <h1>Student Information Form</h1>

    <form action="StudentResult.jsp" method="post">
        <label>Student Name:</label>
        <input type="text" name="studentName" required>
        <br><br>

        <label>PRN:</label>
        <input type="text" name="prn" required>
        <br><br>

        <label>Course:</label>
        <input type="text" name="course" required>
        <br><br>

        <label>Semester:</label>
        <input type="number" name="semester" required>
        <br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>