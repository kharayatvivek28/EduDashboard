<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add Teacher Biodata</title>
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
      background-color: #004f99;
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
  <h2>Add Teacher Biodata</h2>

  <form action="teacherDetails" method="post">
    <input type="hidden" name="action" value="addDetails">
    <input type="hidden" name="teacherId" value="${param.teacherId}">

    <label for="address">Address:</label>
    <input type="text" name="address" id="address" required>

    <label for="phone">Phone Number:</label>
    <input type="text" name="phone" id="phone" required>

    <label for="age">Age:</label>
    <input type="number" name="age" id="age" required>

    <label for="salary">Salary:</label>
    <input type="number" step="0.01" name="salary" id="salary" required>

    <label for="role">Role:</label>
    <input type="text" name="role" id="role" required>

    <label for="expertisedSubjects">Expertised Subjects:</label>
    <input type="text" name="expertisedSubjects" id="expertisedSubjects" required>

    <div class="form-buttons">
      <button type="submit" class="btn-primary">Save Details</button>
      <button type="reset" class="secondary">Reset</button>
    </div>
  </form>

  <div class="back-link">
    <a href="adminDashboard.jsp">← Back to Dashboard</a>
  </div>
</main>

</body>
</html>
