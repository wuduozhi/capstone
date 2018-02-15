package com.dao;

import com.model.Repair;
import java.sql.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RepairDapImp implements RepairDao {

    public void save(Repair repair) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(repair);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            HibernateUtil.closeSession();
        }
    }

    public Repair get(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Repair where id=?";
        Repair repair = null;
        try {
            Query query = session.createQuery(hql);
            repair =(Repair) query.setParameter(0,id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tx.commit();
        HibernateUtil.closeSession();
        return repair;
    }

    public void delete(Repair repair) {
        if(repair.getId()==null){
            return;
        }else{
            Session session = HibernateUtil.getSession();
            Transaction tx= session.beginTransaction();
            tx.commit();
            repair.setStatus(0);
            try{
                session.update(repair);
            }catch (Exception e){
                session.getTransaction().rollback();
                tx.commit();
            }finally {
                HibernateUtil.closeSession();
            }
        }
    }

    public void update(Repair repair) {
        if(repair.getId()==null){
            return;
        }else{
            Session session = HibernateUtil.getSession();
            Transaction tx= session.beginTransaction();
            try{
                session.update(repair);
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
        String hql="From Repair";
        int start = page*size;
        int end = start + size;
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        //6.分页查询
        List<Repair> list=query.list();
        tx.commit();
        HibernateUtil.closeSession();
        return list;
    }

    public static void main(java.lang.String args[]){
        RepairDao dao = new RepairDapImp();
        Repair repair = new Repair();
        Date date = new Date(123456789);
        repair.setDo_time(date);
        repair.setGood("计算机");
        repair.setDo_time(date);
        repair.setNumber("123456789");
        repair.setOperation("装系统、配环境");
        dao.save(repair);
    }
}
