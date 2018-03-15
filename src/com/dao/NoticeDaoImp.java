package com.dao;

import com.model.Notice;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NoticeDaoImp implements NoticeDao {
    public void save(Notice notice) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSession();
            tx = session.beginTransaction();
            session.save(notice);
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            tx.commit();
            session.flush();
            HibernateUtil.closeSession();
        }
    }

    public Notice get(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Notice where id=?";
        Notice notice = null;
        try {
            Query query = session.createQuery(hql);
            notice =(Notice) query.setParameter(0,id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tx.commit();
        session.flush();
        HibernateUtil.closeSession();
        return notice;
    }
    public void delete(Notice notice) {
        if(notice.getId() == null){
            return;
        }else{
            Session session = HibernateUtil.getSession();
            Transaction tx= session.beginTransaction();
            tx.commit();
            notice.setStatus(0);
            try{
                session.update(notice);
            }catch (Exception e){
                session.getTransaction().rollback();
                tx.commit();
            }finally {
                session.flush();
                HibernateUtil.closeSession();
            }
        }
    }

    public void update(Notice notice) {
        if(notice.getId()==null){
            return;
        }else{
            Session session = HibernateUtil.getSession();
            Transaction tx= session.beginTransaction();
            try{
                session.update(notice);
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
        String hql="From Notice where status!=0";
        int start = page*size;
        int end = start + size;
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        //6.分页查询
        List<Notice> list=query.list();
        tx.commit();
        session.flush();
        HibernateUtil.closeSession();
        return list;
    }

    public List findAll(Integer page, Integer size, Integer user_id) {
        return null;
    }
}
