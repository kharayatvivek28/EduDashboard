<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>EduDashboard</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- Pico CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1.5.10/css/pico.min.css" />
    <style>
        body {
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: #fff;
        }

        main.container {
            width: 100%;
            max-width: 1200px;
            padding: 2rem;
        }

        h2 {
            text-align: center;
            color: #ffffff;
            margin-bottom: 0.5rem;
        }

        p.subtitle {
            text-align: center;
            color: #dddddd;
            margin-bottom: 3rem;
        }

        .role-grid {
            display: flex;
            justify-content: center;
            gap: 2rem;
            flex-wrap: wrap;
        }

        .role-card {
            background-color: #ffffff;
            color: #000;
            border-radius: 1rem;
            padding: 2rem;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease;
            min-width: 250px;
            max-width: 357px;
            text-align: center;
        }

        .role-card:hover {
            transform: translateY(-8px);
        }

        .admin-title {
            color: #4b0082;
        }

        .teacher-title {
            color: #228B22;
        }

        .student-title {
            color: #008080;
        }

        .role-card p {
            color: #555;
        }

        .btn-admin {
            background-color: #4b0082;
            color: #fff;
        }

        .btn-admin:hover {
            background-color: #3b006b;
        }

        .btn-teacher {
            background-color: #228B22;
            color: #fff;
        }

        .btn-teacher:hover {
            background-color: #1e7a1e;
        }

        .btn-student {
            background-color: #008080;
            color: #fff;
        }

        .btn-student:hover {
            background-color: #006666;
        }

        .btn-student-secondary {
            background-color: #20b2aa;
            color: #fff;
        }

        .btn-student-secondary:hover {
            background-color: #1e9e98;
        }

        .full-width {
            display: block;
            width: 100%;
            margin-top: 0.75rem;
            text-align: center;
        }
    </style>
</head>
<body>

<main class="container">
    <h2>Welcome to EduDashboard</h2>

    <p class="subtitle">Please choose your role to access your personalized dashboard</p>
    
    <div class="role-grid">
        <!-- Admin Card -->
        <section class="role-card">
            <h3 class="admin-title">Admin</h3>
            <p>Manage students and teachers.</p>
            <a href="login.jsp" role="button" class="btn-admin full-width">Login as Admin</a>
        </section>

        <!-- Teacher Card -->
        <section class="role-card">
            <h3 class="teacher-title">Teacher</h3>
            <p>Upload marks and take attendance.</p>
            <a href="login.jsp" role="button" class="btn-teacher full-width">Login as Teacher</a>
        </section>

        <!-- Student Card -->
        <section class="role-card">
            <h3 class="student-title">Student</h3>
            <p>View marks and attendance.</p>
            <a href="login.jsp" role="button" class="btn-student full-width">Login as Student</a>
            <a href="studentRegister.jsp" role="button" class="btn-student-secondary full-width">Register as Student</a>
        </section>
    </div>
</main>

</body>
</html>
