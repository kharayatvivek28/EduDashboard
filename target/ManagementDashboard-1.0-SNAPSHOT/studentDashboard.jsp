<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mycompany.managementdashboard.model.*" %>
<%@ page import="com.mycompany.managementdashboard.service.*" %>

<%
    HttpSession currentSession = request.getSession(false);
    Student loggedInStudent = (Student) currentSession.getAttribute("student");

    StudentService studentService = new StudentService();
    Student fullStudentData = studentService.getStudentWithDetailsById(loggedInStudent.getStudentId());
    StudentDetails details = fullStudentData.getStudentDetails();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1.6.1/css/pico.min.css">
    <style>
        body {
            display: flex;
            min-height: 100vh;
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: #e9f5f3;
        }

        .sidebar {
            width: 250px;
            background-color: #156c6f;
            color: #fff;
            padding: 2rem 1rem;
            box-shadow: 2px 0 8px rgba(0, 0, 0, 0.1);
        }

        .sidebar h4 {
            font-size: 1.5rem;
            text-align: center;
            margin-bottom: 2rem;
        }

        .sidebar ul {
            list-style-type: none;
            padding-left: 0;
        }

        .sidebar ul li {
            margin-bottom: 1.2rem;
        }

        .sidebar ul li a {
            color: #a8e6df;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s;
        }

        .sidebar ul li a:hover {
            color: #fff;
        }

        .content {
            flex: 1;
            padding: 3rem 2rem;
            background-color: #ffffff;
        }

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 2rem;
        }

        header h2 {
            font-size: 2rem;
            color: #156c6f;
        }

        .logout-link {
            text-decoration: none;
            font-weight: bold;
            color: #156c6f;
            transition: color 0.3s;
        }

        .logout-link:hover {
            color: #0a3d3e;
        }

        .card {
            background: #f7fffd;
            border-left: 6px solid #156c6f;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.08);
            transition: transform 0.3s;
        }

        .card:hover {
            transform: translateY(-4px);
        }

        .card h3 {
            margin-bottom: 1rem;
            color: #156c6f;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1rem;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ccc;
        }

        th {
            background-color: #e0f7f5;
            color: #156c6f;
        }

        td {
            background-color: #ffffff;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<nav class="sidebar" style="padding-top: 100px;">
    <h4>Navigation</h4>
    <ul>
        <li><a href="#">📄 My Attendance</a></li>
        <li><a href="#">📊 My Marks</a></li>
    </ul>
</nav>

<!-- Content -->
<div class="content">

    <header>
        <h2>📘 Student Dashboard</h2>
        <p><strong>Welcome, <%= loggedInStudent.getFname() %>!</strong></p>
        <p><a href="logout.jsp" class="logout-link">🚪 Logout</a></p>
    </header>

    <!-- Profile Block -->
    <div class="card">
        <h3>👤 My Profile</h3>
        <table>
            <tr>
                <th>Full Name</th>
                <td><%= loggedInStudent.getFname() %> <%= loggedInStudent.getLname() %></td>
            </tr>
            <tr>
                <th>Email</th>
                <td><%= loggedInStudent.getEmail() %></td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><%= details != null ? details.getPhone() : "N/A" %></td>
            </tr>
            <tr>
                <th>Address</th>
                <td><%= details != null ? details.getAddress() : "N/A" %></td>
            </tr>
            <tr>
                <th>Age</th>
                <td><%= details != null ? details.getAge() : "N/A" %></td>
            </tr>
            <tr>
                <th>Class</th>
                <td><%= details != null ? details.getClassName() : "N/A" %></td>
            </tr>
            <tr>
                <th>Course</th>
                <td><%= details != null ? details.getCourse() : "N/A" %></td>
            </tr>
        </table>
    </div>

</div>
</body>
</html>
