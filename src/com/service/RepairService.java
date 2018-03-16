package com.service;

import com.dao.RelationListDaoImp;
import com.dao.RepairDaoImp;
import com.dao.ReportDaoImp;
import com.model.RelationList;
import com.model.Repair;
import com.model.Report;

import java.util.List;

public class RepairService {
    RelationListDaoImp listDao = new RelationListDaoImp();
    ReportDaoImp reportDao = new ReportDaoImp();
    RepairDaoImp repairDao = new RepairDaoImp();
    public Repair getRepair(Integer id){
        Repair repair = repairDao.get(id);
        if(repair == null){
            return  null;
        }

        RelationList relationList = listDao.get(repair.getId(),2);
        if(relationList == null){
            return repair;
        }
        Report report = relationList.getReport_id();
        report.setRepair(null);
        report.setStaff(null);
        repair.setReport(report);
        return repair;
    }

    public List getRepairs(Integer page, Integer size, Integer user_id){
        List<Repair> repairs = repairDao.findAll(page,size,user_id);
        for(int i=0;i<repairs.size();i++){
            Repair repair = repairs.get(i);
            RelationList relationList = listDao.get(repair.getId(),2);
            if(relationList!=null){
                Report report = relationList.getReport_id();
                report.setRepair(null);
                report.setStaff(null);
                repair.setReport(report);
            }
        }

        return repairs;
    }

    public List getRepairs(Integer page, Integer size){
        List<Repair> repairs = repairDao.findAll(page,size);
        for(int i=0;i<repairs.size();i++){
            Repair repair = repairs.get(i);
            RelationList relationList = listDao.get(repair.getId(),2);
            if(relationList!=null){
                Report report = relationList.getReport_id();
                report.setRepair(null);
                report.setStaff(null);
                repair.setReport(report);
            }
        }

        return repairs;
    }
}
