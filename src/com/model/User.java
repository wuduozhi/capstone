package com.model;

import javax.ws.rs.FormParam;

public class User implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    public static Integer COMMOM = 3;
    public static Integer STAFF = 2;
    public static Integer ADMIN = 1;
    @FormParam("id")
    Integer id;
    @FormParam("name")
    String name;
    @FormParam("password")
    String password;
    @FormParam("phone")
    String phone;
    @FormParam("level")
    Integer level;
    @FormParam("status")
    Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
