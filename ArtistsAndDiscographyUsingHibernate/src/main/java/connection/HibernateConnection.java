package connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class HibernateConnection {
    /**
     * Manages database connectivity using Hibernate.
     * It ensures a single instance of the connection manager is used throughout
     * the application, following the Singleton design pattern. This helps maintain
     * consistent database access logic and promotes resource efficiency.
     */
    private static HibernateConnection instance;
    private static final Object lock = new Object();

    private HibernateConnection() {
    }

    public static HibernateConnection getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new HibernateConnection();
                }
            }
        }
        return instance;
    }

    public static Session getSession() throws HibernateException {
        try {
            return HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            System.err.println("Initial session creation failed." + e);
            throw new HibernateException("Failed to create session", e);
        }
    }

    public static void commitTransaction(Session session) throws HibernateException {
        if (session != null && session.getTransaction() != null && session.getTransaction().isActive()) {
            session.getTransaction().commit();
        }
    }

    public static void rollbackTransaction(Session session) {
        if (session != null && session.getTransaction() != null && session.getTransaction().isActive()) {
            try {
                session.getTransaction().rollback();
            } catch (Exception e) {
                System.err.println("Error during rollback: " + e.getMessage());
            }
        }
    }

    public void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}


