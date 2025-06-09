package main;

import connection.HibernateUtil;
import lib.DependencyContainer;
import ui.UserInterface;

import static lib.DependencyContainer.configureDependencies;

public class Main {
    public static DependencyContainer container = configureDependencies();

    public static void main(String[] args) {

        //  Entry point of the application. Starts the main execution flow.
        try {
            HibernateUtil.getSessionFactory();
            UserInterface ui = new UserInterface();
            ui.run();

        } catch (Exception e) {
            System.err.println("Application error: " + e.getMessage());
        } finally {
            HibernateUtil.close();
        }
    }
}
