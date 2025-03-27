package com.example.RegisterLogin.Dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserDTO {

    private int userid;
    private String username;
    private String email;
    private String password;
    private String course;



    public UserDTO(int userid, String username, String email, String password ,String course) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.course =course;
    }


    public UserDTO() {
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
        return "UserDTO{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
