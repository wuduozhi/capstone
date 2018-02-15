package com.model;

import javax.ws.rs.FormParam;
import java.sql.Date;

public class Notice implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    @FormParam("id")
    Integer id;
    @FormParam("repair_id")
    Integer repair_id;
    @FormParam("user_id")
    Integer user_id;
    @FormParam("message")
    String message;
    @FormParam("status")
    Integer status;
    @FormParam("time")
    Date time;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Integer repair_id) {
        this.repair_id = repair_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
