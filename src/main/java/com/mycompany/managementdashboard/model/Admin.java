package com.mycompany.managementdashboard.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "admintable")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @NotBlank(message = "Username is required")
    @Size(min = 4 , max = 25 ,message = "Username must be between 4 to 25 characters")
    @Column(name = "username", nullable = false, unique = true)
    private String username;


    @NotBlank(message = "First Name is required")
    @Size(min = 4, max = 25, message = "First Name must be between 4 to 25 characters")
    @Column(name = "fname" , nullable = false)
    private String fname;

    @NotBlank(message = "Last Name is required")
    @Size(min = 4, max = 25, message = "Last Name must be between 4 to 25 characters")
    @Column(name = "lname",nullable = false)
    private String lname;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email format")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 4, max = 25, message = "Password must be between 4 to 25 characters")
    @Column(name = "password", nullable = false)
    private String password;

    public Admin() {}
    public Admin(String username, String fname, String lname, String email, String password) {
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }
    public int getAdminId() {
        return adminId;
    }
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
