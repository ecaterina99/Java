package connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class HibernateConnection {

    private static final HibernateConnection INSTANCE = new HibernateConnection();

    private HibernateConnection() {
    }

    public static HibernateConnection getInstance() {
        return INSTANCE;
    }

    public Session getSession() throws HibernateException {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public Session beginTransaction() throws HibernateException {
        Session session = getSession();
        session.beginTransaction();
        return session;
    }

    public void commitTransaction(Session session) throws HibernateException {
        if (session != null) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().commit();
            }
            session.close();
        }
    }

    public void rollbackTransaction(Session session) {
        if (session != null) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            session.close();
        }
    }

    public void shutdown() {
        HibernateUtil.close();
    }

}

