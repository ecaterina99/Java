package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSession() {
        Configuration cfg = new Configuration().configure();
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Job.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
    }

}
