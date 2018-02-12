package com.dao;
/*



 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    //定义常量是为了实现单例，不让随便new
    //ThreadLocal<Session>不是集合，是线程锁，为了单线程安全
    private static final ThreadLocal<Session> lock = new ThreadLocal<Session>();

    private static final SessionFactory factory = buildFactory();
    private static SessionFactory buildFactory() {
        Configuration cfg = new Configuration().configure();//读取 hibernate.cfg.xml 的配置信息
        return cfg.buildSessionFactory();
    }

    public static Session getSession() {
        //先获取线程锁中的session
        Session session = lock.get();

        if (session == null) {//如果没有session就新建一个session赋值给lock
            session = factory.openSession();
            lock.set(session);
        }

        return session;
    }
    public static void closeSession() {
        Session session = lock.get();//先获取线程锁中的session

        if (session != null) {//如果session有值，那么关闭session
            session.close();
            lock.set(null);    //将session关闭之后再给lock赋值null，方便其他线程使用
        }
    }
}
