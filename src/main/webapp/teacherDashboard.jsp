<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mycompany.managementdashboard.model.*" %>
<%@ page import="com.mycompany.managementdashboard.service.*" %>

<%
    HttpSession currentSession = request.getSession(false);
    Teacher loggedInTeacher = (Teacher) currentSession.getAttribute("teacher");

    TeacherService teacherService = new TeacherService();
    Teacher fullTeacherData = teacherService.getTeacherWithDetailsById(loggedInTeacher.getTeacherId());
    TeacherDetails details = fullTeacherData.getTeacherDetails();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Teacher Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1.6.1/css/pico.min.css">
    <style>
        body {
            display: flex;
            min-height: 100vh;
            margin: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f8f9fa;
        }

        .sidebar {
            width: 250px;
            background-color: #4b3c77;
            color: #fff;
            padding: 2rem 1rem;
            border-right: 3px solid #ccc;
            box-shadow: 2px 0 12px rgba(0, 0, 0, 0.1);
        }

        .sidebar h4 {
            font-size: 1.6rem;
            text-align: center;
            margin-bottom: 2rem;
        }

        .sidebar ul {
            list-style-type: none;
            padding-left: 0;
        }

        .sidebar ul li {
            margin-bottom: 1.5rem;
        }

        .sidebar ul li a {
            text-decoration: none;
            color: #ffd54f;
            font-weight: bold;
        }

        .sidebar ul li a:hover {
            color: #fff;
        }

        .content {
            flex: 1;
            padding: 2rem 2.5rem;
            background: #fff;
        }

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 2rem;
        }

        header h2 {
            color: #4b3c77;
            margin: 0;
            font-size: 2rem;
        }

        header p {
            margin: 0;
            font-size: 1.1rem;
        }

        .logout-link {
            text-decoration: none;
            color: #4b3c77;
            font-weight: bold;
        }

        .logout-link:hover {
            color: #000;
        }

        .card {
            border-left: 6px solid #9575cd;
            border-radius: 10px;
            background: #fdfdfd;
            box-shadow: 0 4px 14px rgba(0, 0, 0, 0.08);
            padding: 2rem;
            margin-bottom: 2rem;
        }

        .card h3 {
            margin-top: 0;
            color: #4b3c77;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1rem;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            color: #4b3c77;
        }

        td a {
            color: #9575cd;
            text-decoration: none;
            font-weight: bold;
        }

        td a:hover {
            color: #4b3c77;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<nav class="sidebar" style="padding-top: 80px;">
    <h4>📚 Teacher Panel</h4>
    <ul>
        <li><a href="">📝 Mark Attendance</a></li> <!--markAttendance.jsp-->
        <li><a href="">📊 Upload Marks</a></li>  <!--uploadMarks.jsp-->
    </ul>
</nav>

<!-- Content -->
<div class="content">
    <header>
        <h2>👨‍🏫 Teacher Dashboard</h2>
        <div>
            <p><strong>Welcome, <%= loggedInTeacher.getFname() %>!</strong></p>
            <p><a href="logout.jsp" class="logout-link">🚪 Logout</a></p>
        </div>
    </header>

    <!-- Teacher Info Block -->
    <div class="card">
        <h3>👤 My Profile</h3>
        <table>
            <tr><th>ID</th><td><%= fullTeacherData.getTeacherId() %></td></tr>
            <tr><th>Name</th><td><%= fullTeacherData.getFname() %> <%= fullTeacherData.getLname() %></td></tr>
            <tr><th>Username</th><td><%= fullTeacherData.getUsername() %></td></tr>
            <tr><th>Email</th><td><%= fullTeacherData.getEmail() %></td></tr>
            <tr><th>Phone</th><td><%= details != null ? details.getPhone() : "N/A" %></td></tr>
            <tr><th>Address</th><td><%= details != null ? details.getAddress() : "N/A" %></td></tr>
            <tr><th>Age</th><td><%= details != null ? details.getAge() : "N/A" %></td></tr>
            <tr><th>Role</th><td><%= details != null ? details.getRole() : "N/A" %></td></tr>
            <tr><th>Salary</th><td><%= details != null ? details.getSalary() : "N/A" %></td></tr>
            <tr><th>Subjects</th><td><%= details != null ? details.getExpertisedSubjects() : "N/A" %></td></tr>
        </table>
    </div>
</div>
</body>
</html>
