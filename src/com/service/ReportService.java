package com.service;

import com.dao.RelationListDaoImp;
import com.dao.RepairDaoImp;
import com.dao.ReportDaoImp;
import com.model.RelationList;
import com.model.Repair;
import com.model.Report;

import java.util.List;

public class ReportService {
    RelationListDaoImp listDao = new RelationListDaoImp();
    ReportDaoImp   reportDao = new ReportDaoImp();
    RepairDaoImp   repairDao = new RepairDaoImp();

    public Report getReport(Integer id){
        Report report = reportDao.get(id);
        if(report == null){
            return null;
        }
        RelationList relationList = listDao.get(report.getId(),1);
        if(relationList != null)
           report.setRepair(relationList.getRepair_id());

        return report;
    }

    public List getReports(Integer page, Integer size, Integer user_id){
        List<Report> list = reportDao.findAll(page,size,user_id);
        for(int i=0;i<list.size();i++){
            Report report = list.get(i);
            RelationList relationList = listDao.get(report.getId(),1);
            if(relationList!=null){
                report.setRepair(relationList.getRepair_id());
            }
        }

        return list;
    }

    public List getReports(Integer page, Integer size){
        List<Report> list = reportDao.findAll(page,size);
        for(int i=0;i<list.size();i++){
            Report report = list.get(i);
            RelationList relationList = listDao.get(report.getId(),1);
            if(relationList!=null){
                report.setRepair(relationList.getRepair_id());
            }
        }

        return list;
    }






}
