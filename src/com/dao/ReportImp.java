package com.dao;

import com.model.Report;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReportImp implements ReportDao {
    public void save(Report report) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(report);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            HibernateUtil.closeSession();
        }
    }

    public Report get(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Report where id=?";
        Report report = null;
        try {
            Query query = session.createQuery(hql);
            report =(Report) query.setParameter(0,id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tx.commit();
        HibernateUtil.closeSession();
        return report;
    }

    public void delete(Report report) {
        if(report.getId()==null){
            return;
        }else{
            Session session = HibernateUtil.getSession();
            Transaction tx= session.beginTransaction();
            tx.commit();
            report.setStatus(0);
            try{
                session.update(report);
            }catch (Exception e){
                session.getTransaction().rollback();
                tx.commit();
            }finally {
                HibernateUtil.closeSession();
            }
        }
    }

    public void update(Report report) {
        if(report.getId()==null){
            return;
        }else{
            Session session = HibernateUtil.getSession();
            Transaction tx= session.beginTransaction();
            try{
                session.update(report);
                tx.commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                tx.commit();
            }finally {
                HibernateUtil.closeSession();
            }
        }
    }

    public List findAll(Integer page, Integer size) {
        //1.获取session
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //2.定义查询最大记录数的hql
        String hql="From Report";
        int start = page*size;
        int end = start + size;
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        //6.分页查询
        List<Report> list=query.list();
        tx.commit();
        HibernateUtil.closeSession();
        return list;
    }
    public static void main(java.lang.String args[]){
        ReportDao dao = new ReportImp();
        Report re = new Report();
        re.setAddress("海南省海口市");
        re.setArea("湖南省");
        re.setCompany("湖南大学");
        re.setDepartment("信息科学与工程学院");
        re.setDescription("装系统配环境");
        re.setKind("计算机");
        re.setName("吴多智");
        re.setPhone("13098921645");
        re.setStaff("张三");
        dao.save(re);
    }
}
