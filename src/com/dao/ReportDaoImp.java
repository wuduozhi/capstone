package com.dao;

import com.model.Report;
import com.model.Statistic;
import com.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReportDaoImp implements ReportDao {
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
            session.flush();
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
        session.flush();
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
                session.flush();
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
                session.flush();
                HibernateUtil.closeSession();
            }
        }
    }

    public List findAll(Integer page, Integer size) {
        //1.获取session
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //2.定义查询最大记录数的hql
        String hql="From Report where status!=0";
        int start = page*size;
        int end = start + size;
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        //6.分页查询
        List<Report> list=query.list();
        tx.commit();
        session.flush();
        HibernateUtil.closeSession();
        return list;
    }

    public List findAll(Integer page, Integer size, Integer user_id) {
        //1.获取session
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //2.定义查询最大记录数的hql
        String hql="From Report where status!=0 and user="+user_id;
        int start = page*size;
        int end = start + size;
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        //6.分页查询
        List<Report> list=query.list();
        tx.commit();
        session.flush();
        HibernateUtil.closeSession();
        return list;
    }

    public List findAllNotDeal(Integer page, Integer size, Integer staff_id){
        //1.获取session
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //2.定义查询最大记录数的hql
        String hql="From Report where status!=0 and staff="+staff_id+" order by status ";
        int start = page*size;
        int end = start + size;
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        //6.分页查询
        List<Report> list=query.list();
        tx.commit();
        session.flush();
        HibernateUtil.closeSession();
        return list;
    }

    public Integer getCount(User user){
        String str = "";
        if(user!=null){  //不同人员过去的count不同
            if(user.getLevel().equals(User.COMMOM)){
                str = "status!=0 and user="+user.getId();
            }else if(user.getLevel().equals(User.STAFF)){
                str = " staff="+user.getId()+" and status =1";
            }else{
                return null;
            }
        }else{
            str = "status!=0";
        }
        String hql = "From Report where "+str;
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Integer count = 0;
        try{
            Query query = session.createQuery(hql);
            List list = query.list();
            count = list.size();
        }catch (Exception e){

        }finally {
            tx.commit();
            session.flush();
            HibernateUtil.closeSession();
            return count;
        }

    }

    public List getReports(Statistic statistic) {
        String str = "";
        if (statistic.getArea() != null) {
            str += "and area like '%" + statistic.getArea() + "%' ";
        } else if (statistic.getKind() != null) {
            str += "and kind like '%" + statistic.getKind() + "%' ";
        }else{
            str +="";
        }

        String hql = "From Report where 1=1 " + str;
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        List list = new ArrayList();
        try {
            Query query = session.createQuery(hql);
            list = query.list();
        } catch (Exception e) {

        } finally {
            tx.commit();
            session.flush();
            HibernateUtil.closeSession();
            return list;
        }
    }

    public static void main(java.lang.String args[]){
        ReportDao dao = new ReportDaoImp();
        Report re = new Report();
        re.setAddress("海南省海口市");
        re.setArea("湖南省");
        re.setCompany("湖南大学");
        re.setDepartment("信息科学与工程学院");
        re.setDescription("装系统配环境");
        re.setKind("计算机");
        re.setName("吴多智");
        re.setPhone("13098921645");
        User u = new User();
        u.setStatus(1);
        u.setId(1);
        u.setLevel(2);
        u.setName("吴多智");
        u.setPassword("asdfg1234");
        re.setUser(u);
        dao.save(re);
    }
}
