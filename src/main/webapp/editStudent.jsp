<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mycompany.managementdashboard.model.Student" %>
<%@ page import="com.mycompany.managementdashboard.service.StudentService" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    StudentService studentService = new StudentService();
    Student student = studentService.getStudentById(id);

    if (student == null) {
%>
<p>Student not found.</p>
<%
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1.5.10/css/pico.min.css" />
    <style>
        body {
            margin: 0;
            padding: 2rem;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff;
        }

        main.container {
            width: 100%;
            max-width: 500px;
            background-color: #fff;
            color: #000;
            padding: 2rem;
            border-radius: 1rem;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            color: #0066cc;
            margin-bottom: 2rem;
        }

        .form-buttons {
            display: flex;
            justify-content: space-between;
            gap: 1rem;
            margin-top: 1.5rem;
        }

        .btn-primary {
            background-color: #0066cc;
            color: #fff;
        }

        .btn-primary:hover {
            background-color: #004999;
        }

        .back-link {
            margin-top: 1.5rem;
            text-align: center;
        }

        .back-link a {
            color: #0066cc;
            font-weight: bold;
            text-decoration: none;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<main class="container">
    <h2>Edit Student</h2>

    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">

        <label for="username">Username</label>
        <input type="text" id="username" name="username" value="<%= student.getUsername() %>" required>

        <label for="fname">First Name</label>
        <input type="text" id="fname" name="fname" value="<%= student.getFname() %>" required>

        <label for="lname">Last Name</label>
        <input type="text" id="lname" name="lname" value="<%= student.getLname() %>" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="<%= student.getEmail() %>" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" value="<%= student.getPassword() %>" required>

        <div class="form-buttons">
            <button type="submit" class="btn-primary">Update Student</button>
            <button type="reset" class="secondary">Reset</button>
        </div>
    </form>

    <div class="back-link">
        <a href="adminDashboard.jsp">← Back to Dashboard</a>
    </div>
</main>

</body>
</html>
