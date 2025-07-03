import main.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessFirstLesson {
    public static void main(String[] args)  {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonPU");
        EntityManager em = emf.createEntityManager();
        Person person = new Person("Nick Black",55);
       // em.persist(person);
        em.getTransaction().begin();
        Person person1 = em.find(Person.class,6);
        if(person1 != null) {
            person.setName("Jeniffer Douglass");
        }

        if(person != null) {
            em.remove(person);
        }

        em.getTransaction().commit();

/*Person person = new Person("Bob", 65);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123123");
        ) {
            System.out.println("Connected to database ");


         //  insertPerson(conn, person);
             updatePerson(conn, person);
            //deletePerson(conn, 5);
            readPersons(conn);


        } catch (SQLException e) {
            System.out.println("Error in database connection " + e.getMessage());
        }
    }

    public static void insertPerson(Connection conn, Person person) throws SQLException {

       /* Statement st = conn.createStatement();
        String query = "insert into persons values(null,'" + person.getName() + "', " + person.getAge() + ")";
        st.execute(query);
        */

        /*
        String query = "insert into persons (name, age) values(?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, person.getName());
        ps.setInt(2, person.getAge());
        ps.execute();


         */
    }

    public static void readPersons(Connection conn) throws SQLException {
        List<Person> personList = new ArrayList<>();
        Statement st = conn.createStatement();
        st.executeQuery("select * from persons");

        ResultSet rs = st.getResultSet();
        while (rs.next()) {
            Person p = new Person(rs.getString("name"), rs.getInt("age"));
            personList.add(p);
        }

        for (Person p : personList) {
            System.out.println(p);
        }
    }

    public static void updatePerson(Connection conn, Person person) throws SQLException {
       /*
        String query = "update persons set name='Jennifer Douglass' where id=3";
        Statement st = conn.createStatement();
        st.execute(query);
        */

        String query = "update persons set name=?, age=? where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, person.getName());
        ps.setInt(2, person.getAge());
        ps.setInt(3, person.getId(4));
        ps.execute();
    }

    public static void deletePerson(Connection conn, int id) throws SQLException {
        String query = "delete from persons where id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        //ps.execute();
        System.out.println(ps.executeUpdate());
    }

}


            /*
            // Use interface statement
            Statement st = conn.createStatement();
            String query = "insert into persons values(null,'" + person.getName() + "', " + person.getAge() + ")";
            st.execute(query);

            // Use interface prepared statement
            String query =  "insert into persons (name, age) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.execute();
           */

        /*main.Person person = new main.Person("John Deen", 55, "313/AB");
        FileWriter fw = new FileWriter("myFile.txt");
        fw.write(person.toString() + "\n");
        fw.close();
    }
        main.Person person = null;
        FileReader fr = new FileReader("myFile.txt");
        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = fr.read()) != -1) {
            stringBuilder.append((char) ch);
        }
        String userData = stringBuilder.toString();
        String[] userProps = userData.split("\n");
        if (userProps.length == 3) {
            person = new main.Person(userProps[0], Integer.valueOf(userProps[1]), userProps[2]);
        }
        System.out.println(person);
         */


// main.Person person = new main.Person("Maria D.", 25);
//main.Person person = new main.Person("James Bond", 45,1);