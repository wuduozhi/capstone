package com.model;

import javax.ws.rs.FormParam;
import  java.sql.Date;

public class Repair implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    @FormParam("id")
    Integer id;
    @FormParam("number")
    String number;
    @FormParam("good")
    String good;
    @FormParam("operation")
    String operation;
    @FormParam("remark")
    String remark;
    @FormParam("status")
    Integer status;
    @FormParam("do_time")
    Date do_time;
    @FormParam("time")
    Date time;
    @FormParam("user")
    User user;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDo_time() {
        return do_time;
    }

    public void setDo_time(Date do_time) {
        this.do_time = do_time;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
