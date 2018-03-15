package com.dao;

import com.model.RelationList;
import com.model.Repair;
import com.model.Report;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RelationListDaoImp {
    public Integer save(RelationList list){
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(list);
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            tx.commit();
            session.flush();
            HibernateUtil.closeSession();
            return list.getId();
        }
    }

    public  static void main(String args[]){
        Report report = new Report();
        report.setId(1);
        Repair repair  = new Repair();
        repair.setId(1);
        RelationList list = new RelationList();
        list.setRepair_id(repair);
        list.setReport_id(report);
        RelationListDaoImp dao = new RelationListDaoImp();
        Integer id = dao.save(list);
    }
}
