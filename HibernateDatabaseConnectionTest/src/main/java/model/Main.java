package model;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.*;

public class Main {
    static Session session;

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.buildSession();
        session = sessionFactory.openSession();
        if (!employeeExists("Florin", "Gavrilut")) {
            addEmployee("Florin", "Gavrilut", 1);
        }

        Employee Dorin = getEmployee(6);
        if (Dorin != null) {
            Job jobDorin = getJob(Dorin.getIdJob());
            if (jobDorin != null) {
                System.out.println("Before : employee: " + Dorin + jobDorin);

                Dorin.setLastName("Mr. " + Dorin.getLastName());
                jobDorin.setMinSalary(jobDorin.getMinSalary() + 500);

                System.out.println("After : employee: " + Dorin + jobDorin);

                Transaction transaction = session.beginTransaction();
                session.update(jobDorin);
                session.update(Dorin);
                transaction.commit();
            } else {
                System.out.println("Job not found for employee with id: " + Dorin.getId());
            }
        } else {
            System.out.println("Employee with id=6 not found.");
        }

        Map<String, String> conditions = new HashMap<>();
        conditions.put("   idJob", "              < 3   ");
        conditions.put("id   ", ">                    1");
        conditions.put("firstName\n", "        LIKE '%i'");
        customEmployeesSelect(conditions);


        //getDeliveryPersons();

    }

    //TODO query custom
    static void getDeliveryPersons() {
        String hqlQuery = "select e from Employee as e where e.idJob = 1";
        Query query = session.createQuery(hqlQuery, Employee.class);
        List<Employee> employees = query.getResultList();
        for (int i = 0; i < employees.size(); i++) {
            Employee angajat = employees.get(i);
            System.out.println("Employee" + angajat);
        }

        System.out.println("Iterator method: ");

        Iterator<Employee> empIterator = employees.iterator();
        while (empIterator.hasNext()) {
            Employee emp = empIterator.next();
            System.out.println("Employee" + emp);

        }
    }


    // TODO: select multiple
    static void customEmployeesSelect(Map<String, String> whereConditions) {
        Set<String> whereKeys = whereConditions.keySet();
        StringBuilder sb = new StringBuilder("select e from Employee as e where true ");
        for (String whereKey : whereKeys) {
            System.out.println("Am gasit cheia {" + whereKey + "}");
            String whereValue = whereConditions.get(whereKey);
            sb.append(" and ").append(whereKey).append(" ").append( whereValue);
        }
        String hqlQuery = sb.toString().replaceAll("\\s+", " ");
        System.out.println("Query-ul construit: " + hqlQuery);

        Query query = session.createQuery(hqlQuery, Employee.class);

        List<Employee> employees = query.getResultList();

        Iterator<Employee> empIterator = employees.iterator();
        while (empIterator.hasNext()) {
            Employee employee = empIterator.next();
            System.out.println("Angajat: " + employee);
        }

    }


    static boolean employeeExists(String firstName, String lastName) {
        String hql = "FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName";
        List<Employee> result = session.createQuery(hql, Employee.class)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .getResultList();
        return !result.isEmpty();
    }

    static void addEmployee(String firstName, String lastName, int idJob) {
        Employee employee = new Employee(firstName, lastName, idJob);
        Transaction tr = session.beginTransaction();
        session.save(employee);
        tr.commit();
        System.out.println("Employee added: " + employee);
    }

    static Job getJob(int id) {
        return session.get(Job.class, id);
    }

    static Employee getEmployee(int id) {
        //Select * FROM employees WHERE id = 6
        return session.get(Employee.class, id);
    }


}
