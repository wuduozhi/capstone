package com.dao;

import com.model.RelationList;
import com.model.Repair;
import com.model.Report;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

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

    public RelationList get(Integer id,int type){
        //1.获取session
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        List<RelationList> relationList = new ArrayList<RelationList>();
        if(type == 1){
            String hql="From RelationList where report_id = "+id;
            Query query = session.createQuery(hql);
            relationList = query.list();
            tx.commit();
            session.flush();
            HibernateUtil.closeSession();
        }else{
            String hql="From RelationList where repair_id = "+id;
            Query query = session.createQuery(hql);
            relationList = query.list();
            tx.commit();
            session.flush();
            HibernateUtil.closeSession();
        }
        if(relationList.size() == 0)
            return null;

        return relationList.get(0);
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
