<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Register as Student - EduDashboard</title>
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
      color: #008080;
      margin-bottom: 2rem;
    }

    .form-buttons {
      display: flex;
      justify-content: space-between;
      gap: 1rem;
      margin-top: 1.5rem;
    }

    .btn-primary {
      background-color: #008080;
      color: #fff;
    }

    .btn-primary:hover {
      background-color: #006666;
    }

    .login-link {
      margin-top: 1.5rem;
      text-align: center;
    }

    .login-link a {
      color: #008080;
      font-weight: bold;
      text-decoration: none;
    }

    .login-link a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<main class="container">
  <h2>Student Registration</h2>
  <form action="StudentServlet" method="post" onsubmit="return validatePasswords()">
    <input type="hidden" name="action" value="register" />

    <label for="firstName">First Name</label>
    <input type="text" id="firstName" name="fname" placeholder="Enter first name" required />

    <label for="lastName">Last Name</label>
    <input type="text" id="lastName" name="lname" placeholder="Enter last name" required />

    <label for="username">Username</label>
    <input type="text" id="username" name="username" placeholder="Choose a username" required />

    <label for="email">Email Address</label>
    <input type="email" id="email" name="email" placeholder="Enter email" required />

    <label for="password">Password</label>
    <input type="password" id="password" name="password" placeholder="Create password" required />

    <label for="confirmPassword">Confirm Password</label>
    <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm password" required />

    <div class="form-buttons">
      <button type="submit" class="btn-primary">Register</button>
      <button type="reset" class="secondary">Reset</button>
    </div>
  </form>

  <div class="login-link">
    Already registered? <a href="login.jsp">Login</a>
  </div>
</main>
<script>
  function validatePasswords() {
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword) {
      alert("Passwords do not match!");
      return false;
    }
    return true;
  }
</script>

</body>
</html>
