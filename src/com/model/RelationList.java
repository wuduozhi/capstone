package com.model;

import javax.ws.rs.FormParam;

public class RelationList {
    @FormParam("id")
    Integer id;
    @FormParam("repair_id")
    Repair repair_id;
    @FormParam("report_id")
    Report report_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Repair getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Repair repair_id) {
        this.repair_id = repair_id;
    }

    public Report getReport_id() {
        return report_id;
    }

    public void setReport_id(Report report_id) {
        this.report_id = report_id;
    }
}
