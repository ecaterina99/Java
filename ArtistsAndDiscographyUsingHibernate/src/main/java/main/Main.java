package main;
import connection.HibernateUtil;
import ui.UserInterface;

public class Main {

    public static void main(String[] args) {
        //  Entry point of the application. Starts the main execution flow.
        try {
            HibernateUtil.getSessionFactory();
            UserInterface.run();
            System.out.println("Application terminated successfully");
        } catch (Exception e) {
            System.err.println("Application error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            HibernateUtil.close();
        }
    }
}
