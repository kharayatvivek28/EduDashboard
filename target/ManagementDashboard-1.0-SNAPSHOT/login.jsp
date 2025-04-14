<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>EduDashboard - Login</title>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <!-- Pico CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1.5.10/css/pico.min.css" />
  <style>
    body {
      background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
      margin: 0;
      padding: 2rem;
      color: #fff;
    }

    main.container {
      width: 100%;
      max-width: 450px;
      background-color: #ffffff;
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

    label {
      font-weight: bold;
    }

    select,
    input {
      margin-bottom: 1rem;
    }

    .form-buttons {
      display: flex;
      justify-content: space-between;
      gap: 1rem;
      margin-top: 1.5rem;
    }

    .btn-login {
      background-color: #4b0082;
      color: #fff;
    }

    .btn-login:hover {
      background-color: #3a006f;
    }

    .login-footer {
      text-align: center;
      margin-top: 1.5rem;
      font-size: 0.9rem;
      color: #333;
    }

    .login-footer a {
      color: #4b0082;
      font-weight: bold;
      text-decoration: none;
    }

    .login-footer a:hover {
      text-decoration: underline;
    }

    .back-link {
      margin-top: 1.5rem;
      text-align: center;
    }

    .back-link a {
      color: #4b0082;
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
  <h2>Login to EduDashboard</h2>

  <form action="LoginServlet" method="post">
    <label for="role">Select Role</label>
    <select name="role" id="role" required>
      <option value="" disabled selected>-- Choose Role --</option>
      <option value="admin">Admin</option>
      <option value="teacher">Teacher</option>
      <option value="student">Student</option>
    </select>

    <label for="username">Username or Email</label>
    <input type="text" name="username" id="username" placeholder="Enter your username" required>

    <label for="password">Password</label>
    <input type="password" name="password" id="password" placeholder="Enter your password" required>

    <div class="form-buttons">
      <button type="submit" class="btn-login">Login</button>
      <button type="reset" class="secondary">Reset</button>
    </div>
  </form>
<%--  <div class="login-footer">--%>
<%--    <p>Don't have an account? <a href="index.jsp">Register here</a></p>--%>
<%--  </div>--%>
  <div class="back-link">
    <a href="index.jsp">← Back to Role Selection</a>
  </div>
</main>

</body>
</html>
