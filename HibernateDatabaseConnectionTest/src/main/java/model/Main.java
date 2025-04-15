package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    static Session session;

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.buildSession();
        session = sessionFactory.openSession();

        Employee Dorin = getEmployee(6);
        Job jobDorin = getJob(Dorin.getIdJob());

        System.out.println("Before : employee: " + Dorin + jobDorin);

        Dorin.setLastName("Mr. " + Dorin.getLastName());
        jobDorin.setMinSalary(jobDorin.getMinSalary() + 500);

        System.out.println("After : employee: " + Dorin + jobDorin);

        Transaction transaction = session.beginTransaction();
        session.update(jobDorin);
        session.update(Dorin);
        transaction.commit();

        addEmployee("Florin", "Gavrilut", 1);

    }

    static void addEmployee(String firstName, String lastName, int idJob) {
        Employee employee = new Employee(firstName, lastName, idJob );
        Transaction tr = session.beginTransaction();
        session.save(employee);
        tr.commit();
        System.out.println("Employee added: " + employee);
//        System.out.println("Job: " + jo);
    }

    static Job getJob(int id) {
        return session.get(Job.class, id);
    }

    static Employee getEmployee(int id) {
        //Select * FROM employees WHERE id = 6
        return session.get(Employee.class, id);
    }


}
