package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="user")

public class User {
    @Id
    @Column (name="user_id", length= 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;

    @Column (name="user_name", length = 255)
    private String username;

    @Column(name="email", length = 255)
    private String email;

    @Column( name="password", length = 255)
    private String password;

    @Column( name="course", length = 255)
    private String course;



    public User(int userid, String username, String email, String password,String course) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.course = course;
    }

    public User() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
