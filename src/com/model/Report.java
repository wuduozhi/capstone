package com.model;

import javax.ws.rs.FormParam;

public class Report implements java.io.Serializable{
    public static Integer NOT_DEALL = 1;
    public static Integer DEALL = 2;

    @FormParam("id")
    Integer id;
    @FormParam("kind")
    String kind;
    @FormParam("area")
    String area;
    @FormParam("name")
    String name;
    @FormParam("company")
    String company;
    @FormParam("department")
    String department;
    @FormParam("phone")
    String phone;
    @FormParam("address")
    String address;
    @FormParam("description")
    String description;
    @FormParam("judge")
    String judge;
    @FormParam("status")
    Integer status;
    @FormParam("user")
    User user;
    @FormParam("staff")
    User staff;

    Repair repair;

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
