<%@ page import="com.mycompany.managementdashboard.model.Admin" %>
<%@ page import="com.mycompany.managementdashboard.service.AdminService" %>
<%
  int adminId = Integer.parseInt(request.getParameter("id"));
  AdminService adminService = new AdminService();
  Admin admin = adminService.getAdminById(adminId);
%>

<!DOCTYPE html>
<html>
<head>
  <title>Edit Admin</title>
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
      color: #4b0082;
      margin-bottom: 2rem;
    }

    .form-buttons {
      display: flex;
      justify-content: space-between;
      gap: 1rem;
      margin-top: 1.5rem;
    }

    .btn-primary {
      background-color: #4b0082;
      color: #fff;
    }

    .btn-primary:hover {
      background-color: #3a006f;
    }


    .back-to-dashboard {
      display: block;
      text-align: center;
      margin-top: 1.5rem;
    }

    .back-to-dashboard a {
      color: #4b0082;
      font-weight: bold;
      text-decoration: none;
    }

    .back-to-dashboard a:hover {
      text-decoration: underline;
    }

  </style>
</head>
<body>
<main class="container">
  <h2>Edit Admin</h2>

  <form action="AdminServlet" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="adminId" value="<%= admin.getAdminId() %>">

    <label for="username">Username</label>
    <input type="text" id="username" name="username" value="<%= admin.getUsername() %>" placeholder="Username" required>

    <label for="fname">First Name</label>
    <input type="text" id="fname" name="fname" value="<%= admin.getFname() %>" placeholder="First Name" required>

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lname" value="<%= admin.getLname() %>" placeholder="Last Name" required>

    <label for="email">Email</label>
    <input type="email" id="email" name="email" value="<%= admin.getEmail() %>" placeholder="Email" required>

    <label for="password">Password</label>
    <input type="password" id="password" name="password" value="<%= admin.getPassword() %>" placeholder="Password" required>

    <div class="form-buttons">
      <button type="submit" class="btn-primary">Update Admin</button>
      <button type="reset" class="secondary">Reset</button>
    </div>
  </form>

  <div class="back-to-dashboard">
    <a href="adminDashboard.jsp"> Back to Dashboard</a>
  </div>
</main>
</body>
</html>
