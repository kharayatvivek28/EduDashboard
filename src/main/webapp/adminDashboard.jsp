<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.managementdashboard.model.*" %>
<%@ page import="com.mycompany.managementdashboard.service.*" %>

<%
  HttpSession currentSession = request.getSession(false);
  Admin loggedInAdmin = (Admin) currentSession.getAttribute("admin");

  AdminService adminService = new AdminService();
  TeacherService teacherService = new TeacherService();
  StudentService studentService = new StudentService();

  List<Admin> adminList = adminService.getAllAdmins();
  List<Teacher> teacherList = teacherService.getAllTeachers();
  List<Student> studentList = studentService.getAllStudents();
%>

<!DOCTYPE html>
<html>
<head>
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1.6.1/css/pico.min.css">
  <style>
    body {
      display: flex;
      min-height: 100vh;
      margin: 0;
      font-family: 'Arial', sans-serif;
      background: #f4f7f6;
    }

    .sidebar {
      width: 250px;
      background-color: #1f3c5b;
      color: #fff;
      padding: 2rem 1rem;
      border-right: 3px solid #ccc;
      box-shadow: 2px 0 10px rgba(0, 0, 0, 0.1);
    }

    .sidebar h4 {
      font-size: 1.5rem;
      margin-bottom: 2rem;
      text-align: center;
      font-weight: bold;
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
      color: #00c2c7;
      font-weight: bold;
      transition: color 0.3s ease;
    }

    .sidebar ul li a:hover {
      color: #fff;
    }

    .content {
      flex: 1;
      padding: 3rem 2rem;
      background: #fff;
      box-shadow: -2px 0 10px rgba(0, 0, 0, 0.1);
    }

    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 2rem;
    }

    header h2 {
      font-size: 2rem;
      color: #1f3c5b;
      margin: 0;
    }

    header p {
      font-size: 1.1rem;
    }

    .card {
      border-radius: 8px;
      padding: 1.5rem;
      margin-bottom: 2rem;
      background-color: #ffffff;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      border-left: 5px solid #00c2c7;
      transition: transform 0.3s ease;
    }

    .card:hover {
      transform: translateY(-5px);
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 1rem;
    }

    table, th, td {
      border: 1px solid #ddd;
    }

    th, td {
      padding: 12px;
      text-align: left;
    }

    th {
      background-color: #f4f7f6;
      color: #1f3c5b;
    }

    td {
      background-color: #ffffff;
    }

    td a {
      text-decoration: none;
      color: #00c2c7;
      font-weight: bold;
      transition: color 0.3s ease;
    }

    td a:hover {
      color: #1f3c5b;
    }

    .logout-link {
      text-decoration: none;
      font-weight: bold;
      color: #00c2c7;
      transition: color 0.3s ease;
    }

    .logout-link:hover {
      color: #1f3c5b;
    }
  </style>
</head>
<body>

<!-- Sidebar Navigation -->
<nav class="sidebar" style="padding-top: 100px;">
  <h4>Navigation</h4>
  <ul>
    <li><a href="adminDashboard.jsp">🏠 Dashboard</a></li>
    <li><a href="adminRegister.jsp">🧑‍💼 Register Admin</a></li>
    <li><a href="teacherRegister.jsp">👨‍🏫 Register Teacher</a></li>
    <li><a href="studentRegister.jsp">🎓 Register Student</a></li>
  </ul>
</nav>

<!-- Main Content -->
<div class="content">

  <!-- Header -->
  <header>
    <h2>📋 Admin Dashboard</h2>
    <p><strong>Welcome, <%= loggedInAdmin != null ? loggedInAdmin.getFname() : "Admin" %>!</strong></p>
    <p><a href="logout.jsp" class="logout-link">🚪 Logout</a></p>
  </header>

  <!-- Admins Block -->
  <div class="card">
    <h3>🧑‍💼 All Admins</h3>
    <table>
      <thead>
      <tr>
        <th style="width: 15%">ID</th>
        <th style="width: 20%">Name</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <% for (Admin admin : adminList) { %>
      <tr>
        <td><%= admin.getAdminId() %></td>
        <td><%= admin.getFname() %> <%= admin.getLname() %></td>
        <td><%= admin.getEmail() %></td>
        <td>
          <a href="editAdmin.jsp?id=<%= admin.getAdminId() %>">✏️ Edit</a> |
          <a href="AdminServlet?action=delete&id=<%= admin.getAdminId() %>">🗑️ Delete</a>
        </td>
      </tr>
      <% } %>
      </tbody>
    </table>
  </div>

  <!-- Teachers Block -->
  <div class="card">
    <h3>👨‍🏫 All Teachers</h3>
    <table>
      <thead>
      <tr>
        <th style="width: 15%">ID</th>
        <th style="width: 20%">Name</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <% for (Teacher teacher : teacherList) { %>
      <tr>
        <td><%= teacher.getTeacherId() %></td>
        <td><%= teacher.getFname() %> <%= teacher.getLname() %></td>
        <td><%= teacher.getEmail() %></td>
        <td>
          <a href="editTeacher.jsp?id=<%= teacher.getTeacherId() %>">✏️ Edit</a> |
          <a href="TeacherServlet?action=delete&id=<%= teacher.getTeacherId() %>">🗑️ Delete</a> |
          <a href="addTeacherDetails.jsp?teacherId=<%= teacher.getTeacherId() %>">➕ Add Details</a> |
          <a href="viewTeacherDetails.jsp?teacherId=<%= teacher.getTeacherId() %>">🔍 View</a>
        </td>
      </tr>
      <% } %>
      </tbody>
    </table>
  </div>

  <!-- Students Block -->
  <div class="card">
    <h3>🎓 All Students</h3>
    <table>
      <thead>
      <tr>
        <th style="width: 15%">ID</th>
        <th style="width: 20%">Name</th>
        <th>Email</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <% for (Student student : studentList) { %>
      <tr>
        <td><%= student.getStudentId() %></td>
        <td><%= student.getFname() %> <%= student.getLname() %></td>
        <td><%= student.getEmail() %></td>
        <td>
          <a href="editStudent.jsp?id=<%= student.getStudentId() %>">✏️ Edit</a> |
          <a href="StudentServlet?action=delete&id=<%= student.getStudentId() %>">🗑️ Delete</a> |
          <a href="addStudentDetails.jsp?studentId=<%= student.getStudentId() %>">➕ Add Details</a> |
          <a href="viewStudentDetails.jsp?studentId=<%= student.getStudentId() %>">🔍 View</a>
        </td>
      </tr>
      <% } %>
      </tbody>
    </table>
  </div>

</div>
</body>
</html>
