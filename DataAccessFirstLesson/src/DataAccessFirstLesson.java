import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessFirstLesson {
    public static void main(String[] args) throws IOException {
        /*Person person = new Person("John Deen", 55, "313/AB");
        FileWriter fw = new FileWriter("myFile.txt");
        fw.write(person.toString() + "\n");
        fw.close();
    }
        Person person = null;
        FileReader fr = new FileReader("myFile.txt");
        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        while ((ch = fr.read()) != -1) {
            stringBuilder.append((char) ch);
        }
        String userData = stringBuilder.toString();
        String[] userProps = userData.split("\n");
        if (userProps.length == 3) {
            person = new Person(userProps[0], Integer.valueOf(userProps[1]), userProps[2]);
        }
        System.out.println(person);
         */


        // Person person = new Person("Maria D.", 25);
        //Person person = new Person("James Bond", 45,1);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123123");
        ) {
            System.out.println("Connected to database ");

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



            // insertPerson(conn, person);
            // updatePerson(conn, person);
            deletePerson(conn, 5);
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
        String query = "insert into persons (name, age) values(?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, person.getName());
        ps.setInt(2, person.getAge());
        ps.execute();
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