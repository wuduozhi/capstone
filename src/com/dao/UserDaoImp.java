package com.dao;

import com.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImp implements UserDao {
    public void save(User user){
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(user);
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.getTransaction().commit();
            session.flush();
            HibernateUtil.closeSession();
        }
    }

    public User get(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM User where id=?";
        User user = null;
        try {
            Query query = session.createQuery(hql);
            user =(User)query.setParameter(0,id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tx.commit();
        session.flush();
        HibernateUtil.closeSession();
        return user;
    }

    public void delete(User user) {
        if(user.getId()==null){
            return;
        }else{
            Session session = HibernateUtil.getSession();
            Transaction tx= session.beginTransaction();
            user.setStatus(0);
            try{
                session.update(user);
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

    public void update(User user) {
        if(user.getId()==null){
            return;
        }else{
            Session session = HibernateUtil.getSession();
            Transaction tx= session.beginTransaction();
            try{
                session.update(user);
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

    public List findAll(Integer page,Integer size) {
        //1.获取session
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //2.定义查询最大记录数的hql
        String hql="From User where status!=0";
        int start = page*size;
        int end = start + size;
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        //6.分页查询
        List<User> list=query.list();
        tx.commit();
        session.flush();
        HibernateUtil.closeSession();
        return list;
    }

    public User login(User user){
        //1.获取session
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "From User  where name=? and password=? and status!=0";
        User u = null;
        try {
            Query query = session.createQuery(hql);
            query.setString(0,user.getName());
            query.setString(1,user.getPassword());
            List<User> list = query.list();
            u = list.get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            tx.commit();
            session.flush();
            HibernateUtil.closeSession();
        }
        return u;
    }

    public List getStaff(Integer page,Integer size) {
        //1.获取session
        Session session=HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        //2.定义查询最大记录数的hql
        String hql="From User where status!=0 and level="+User.STAFF;
        int start = page*size;
        int end = start + size;
        Query query = session.createQuery(hql);
        query.setFirstResult(start);
        query.setMaxResults(end);
        //6.分页查询
        List<User> list=query.list();
        tx.commit();
        session.flush();
        HibernateUtil.closeSession();
        return list;
    }

    public Integer getCount(){
        String hql = "From User where status=1";
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

    public static void main(java.lang.String args[]){
        UserDao dao = new UserDaoImp();
        User u = new User();
//        u.setId(3);
        u.setPhone("13098921645");
        u.setName("吴多智e");
        u.setPassword("wuduozhi");
        u.setLevel(3);
        dao.save(u);
    }

}
