# 🎓 EduDashboard – Admin Dashboard for Educational Institutions

EduDashboard is a web-based admin dashboard designed for educational institutions to manage Admin, Teacher, and Student data. It features a responsive and minimal UI, backed by powerful Java-based backend technologies and follows a well-structured MVC and three-layered architecture.

---

## 🚀 Features

- Admin login and authentication
- Add, view, update, and delete Teachers and Students
- View detailed biodata of each user
- Clean and responsive UI with Pico CSS
- Modular, scalable, and maintainable codebase

---

## 🛠️ Technologies Used

### 🔹 Frontend Technologies

- **HTML5** – Structuring content and pages
- **CSS3** – Styling and layout
- **Pico CSS** – Lightweight CSS framework for responsive UI
- **JSP (JavaServer Pages)** – Dynamic web content rendering

### 🔸 Backend Technologies

- **Java (JDK 17)** – Core server-side programming language
- **Jakarta EE (Servlets & JSP)** – Handles HTTP requests/responses
- **Hibernate ORM** – Object-Relational Mapping for efficient DB access
- **Maven** – Dependency and build management

### 🗃️ Database

- **MySQL** – Relational database for storing Admin, Teacher, and Student data
- **JDBC + Hibernate** – Seamless data connectivity and manipulation

### 🧰 Tools & IDEs

- **Apache Tomcat** – Servlet container for running the application
- **NetBeans / IntelliJ IDEA** – Development and debugging
- **phpMyAdmin** – MySQL database management

---

## 📐 Project Architecture

### ✅ MVC Pattern (Model-View-Controller)

- **Model:** Java entity classes – `Admin`, `Teacher`, `Student`, `TeacherDetails`, `StudentDetails`
- **View:** JSP files for UI rendering
- **Controller:** Servlets managing HTTP requests and responses

### ✅ Three-Layered Architecture

1. **DAO Layer:** Handles all database operations
2. **Service Layer:** Contains business logic
3. **Servlet Layer:** Processes HTTP requests and manages navigation
