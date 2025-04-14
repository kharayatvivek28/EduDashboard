package com.mycompany.managementdashboard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "student_details")
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentDetailsId")
    private int studentDetailsId;

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

    @NotBlank(message = "Class Name is required")
    @Column(name = "class_name")
    private String className;

    @NotBlank(message = "Course Name is required")
    @Column(name = "course")
    private String course;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;

    // Getters and Setters

    public int getStudentDetailsId() {
        return studentDetailsId;
    }

    public void setStudentDetailsId(int studentDetailsId) {
        this.studentDetailsId = studentDetailsId;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
