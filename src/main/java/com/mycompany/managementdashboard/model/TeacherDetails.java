package com.mycompany.managementdashboard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "teacher_details")
public class TeacherDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherDetailsId")
    private int teacherDetailsId;

    @NotBlank(message = "Address is required")
    @Size(min = 4, max = 255, message = "Address must be between 4 and 255 characters")
    @Column(name = "address", length = 255)
    private String address;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    @Column(name = "phone", length = 15)
    private String phone;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than or equal to 100")
    @Column(name = "age", length = 15)
    private int age;

    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @Column(name = "salary", length = 15)
    private double salary;

    @NotBlank(message = "Role is required")
    @Size(min = 4, max = 50, message = "Role must be between 4 and 50 characters")
    @Column(name = "role", length = 50)
    private String role;

    @NotBlank(message = "Expertised subjects are required")
    @Size(min = 4, max = 255, message = "Expertised subjects must be between 4 and 255 characters")
    @Column(name = "expertized_subjects", length = 255)
    private String expertisedSubjects;

    // One-to-one relationship with Teacher
    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId", nullable = false)
    private Teacher teacher;

    // Constructors

    public TeacherDetails() {}

    public TeacherDetails(String address, String phone, int age, double salary, String role, String expertisedSubjects, Teacher teacher) {
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
        this.role = role;
        this.expertisedSubjects = expertisedSubjects;
        this.teacher = teacher;
    }

    // Getters and setters

    public int getTeacherDetailsId() {
        return teacherDetailsId;
    }

    public void setTeacherDetailsId(int teacherDetailsId) {
        this.teacherDetailsId = teacherDetailsId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getExpertisedSubjects() {
        return expertisedSubjects;
    }

    public void setExpertisedSubjects(String expertisedSubjects) {
        this.expertisedSubjects = expertisedSubjects;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
