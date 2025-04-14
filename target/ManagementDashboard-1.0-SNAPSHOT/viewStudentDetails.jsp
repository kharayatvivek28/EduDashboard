<%@ page import="com.mycompany.managementdashboard.model.Student" %>
<%@ page import="com.mycompany.managementdashboard.model.StudentDetails" %>
<%@ page import="com.mycompany.managementdashboard.service.StudentService" %>
<%@ page import="com.mycompany.managementdashboard.service.StudentDetailsService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  int studentId = Integer.parseInt(request.getParameter("studentId"));
  StudentService studentService = new StudentService();
  StudentDetailsService studentDetailsService = new StudentDetailsService();
  Student student = studentService.getStudentById(studentId);
  StudentDetails details = student.getStudentDetails();
%>

<!DOCTYPE html>
<html>
<head>
  <title>Student Details</title>
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
      color: #222;
    }

    main.container {
      width: 100%;
      max-width: 700px;
      background-color: #fff;
      color: #222;
      padding: 2rem;
      border-radius: 1rem;
      box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
    }

    h2 {
      text-align: center;
      color: #0066cc;
      margin-bottom: 2rem;
    }

    h3 {
      --color: #f4b936;
    }

    section {
      margin-bottom: 2rem;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th, td {
      text-align: left;
      padding: 0.75rem;
      border-bottom: 1px solid #ccc;
    }

    th {
      color: hsl(129.05deg 44.42% 54.1%);
      width: 40%;
      background-color: #f2f2f2;
    }

    td {
      color: hsl(193.29deg 86.95% 21.99%);
      background-color: #fafafa;
    }

    .back-link {
      text-align: center;
      margin-top: 2rem;
    }

    .back-link a {
      color: #0066cc;
      text-decoration: none;
      font-weight: bold;
    }

    .back-link a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<main class="container">
  <h2>🎓 Student Full Details</h2>

  <section>
    <h3>Basic Info</h3>
    <table>
      <tr><th>Full Name</th><td><%= student.getFname() %> <%= student.getLname() %></td></tr>
      <tr><th>Username</th><td><%= student.getUsername() %></td></tr>
      <tr><th>Email</th><td><%= student.getEmail() %></td></tr>
    </table>
  </section>

  <% if (details != null) { %>
  <section>
    <h3>Additional Info</h3>
    <table>
      <tr><th>Address</th><td><%= details.getAddress() %></td></tr>
      <tr><th>Phone</th><td><%= details.getPhone() %></td></tr>
      <tr><th>Age</th><td><%= details.getAge() %></td></tr>
      <tr><th>Class</th><td><%= details.getClassName() %></td></tr>
      <tr><th>Course</th><td><%= details.getCourse() %></td></tr>
    </table>
  </section>
  <% } else { %>
  <p>No additional details found for this student.</p>
  <% } %>

  <div class="back-link">
    <a href="adminDashboard.jsp">← Back to Dashboard</a>
  </div>
</main>
</body>
</html>
