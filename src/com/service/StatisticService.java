package com.service;

import com.dao.RelationListDaoImp;
import com.dao.ReportDaoImp;
import com.model.RelationList;
import com.model.Report;
import com.model.Statistic;

import java.util.List;

public class StatisticService {

    ReportDaoImp reportDao = new ReportDaoImp();
    RelationListDaoImp listDao = new RelationListDaoImp();
    public List getStatistics(Statistic statistic){
        List list = reportDao.getReports(statistic);
        for(int i=0;i<list.size();i++){
            Report report = (Report)list.get(i);
            RelationList relationList = listDao.get(report.getId(),1);
            if(relationList!=null){
                report.setRepair(relationList.getRepair_id());
            }
        }

        return list;
    }
}
