package main;

import connection.HibernateConnection;
import connection.HibernateUtil;
import org.hibernate.Session;
import ui.UserInterface;

public class Main {

    public static void main(String[] args) {
        try {
            runApp();
            System.out.println("Application terminated successfully");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            HibernateConnection.getInstance().shutdown();
        }
    }

    private static void runApp() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            UserInterface.run(session);
            if (session.getTransaction().isActive()) {
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.err.println("Error in application: " + e.getMessage());
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}