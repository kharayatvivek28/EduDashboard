# 🎓 EduDashboard – Admin Dashboard for Educational Institutions

EduDashboard is a web-based admin dashboard designed for educational institutions to manage Admin, Teacher, and Student data. It features a responsive and minimal UI, backed by powerful Java-based backend technologies and follows a well-structured MVC and three-layered architecture.

---
## 📑 Setup Guidelines

Follow these steps to set up and run **EduDashboard** on your local machine:

### 1. Clone the repository:
```bash
git clone
```

### 2. Import the project into your IDE
### 3. Database Setup:
- Open phpMyAdmin (or your MySQL client).
- Create a new database called EduDashboard.
- Execute the EduDashboardSQL text file Queries provided in the project to set up the necessary tables. The file contains the SQL queries for creating the required tables.

### 4. Insert an Admin for First-Time Login:
- If you're running the dashboard for the first time, you need to insert an admin record into the admins table (or equivalent) to be able to log in.
- Use the following SQL query to insert an initial admin:

```bash 
INSERT INTO admins (username, password, role)
VALUES ('admin', 'password123', 'Admin');
```
- Replace password123 with a secure password of your choice.

### 5. Configure MySQL Connection:
- Ensure that the connection details (like username, password, and URL) are correct in the Hibernate configuration or JDBC connection settings.
- These in the hibernate.cfg.xml file 
```bash
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/managementdashboard</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password"></property>
```
### 6. Run the Application:
- Build the project using Maven.
- Run the application on Apache Tomcat (Setup Tomcat on your device first). 
- Open your browser and visit:
```bash
http://localhost:8080/EduDashboard
```

## 🚀 Features

- Admin login and authentication
- Add, view, update, and delete Teachers and Students
- View detailed biodata of each user
- Clean and responsive UI with Pico CSS
- Modular, scalable, and maintainable codebase

---

##  🛠️ Technologies Used

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

## 📊 Flow Diagram
![Flow Diagram](/outputImages/FlowDiagram.png)

## 📷 Screenshots

###  EduDashboard Home Screen
![Home Screen](/outputImages/mainPage.png)

### Admin Dashboard Page
![Admin Dashboard Screen](/outputImages/adminDashboard.png)

### View Page
![BioData View Screen](/outputImages/viewDetailsPage.png)

### Teacher Dashboard Page
![Admin Dashboard Screen](/outputImages/teacherDashboard.png)

### Student Dashboard Page
![Admin Dashboard Screen](/outputImages/studentDashboard.png)
