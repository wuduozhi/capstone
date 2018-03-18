package com.model;

import javax.ws.rs.QueryParam;
import java.sql.Date;

public class Statistic {
    @QueryParam("start_time")
    Date start_time;
    @QueryParam("end_time")
    Date end_time;
    @QueryParam("kind")
    String kind;
    @QueryParam("area")
    String area;

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
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
}
