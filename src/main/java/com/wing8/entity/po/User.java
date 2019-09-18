package com.wing8.entity.po;
public class User {
    private String username;
    private String password;
    private String realName;
    private String email;
    private String code;

    public User(String username, String password, String realName, String email, String code) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.email = email;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}