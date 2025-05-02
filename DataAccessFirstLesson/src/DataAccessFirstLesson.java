import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

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


        Person person = new Person("Bob Ross", 33);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123123");
        ) {
            System.out.println("Connected to database ");

            // Use interface statement
            /*
            Statement st = conn.createStatement();
            String query = "insert into persons values(null,'" + person.getName() + "', " + person.getAge() + ")";
            st.execute(query);
             */

            String query =  "insert into persons (name, age) values(?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.execute();


        } catch (SQLException e) {
            System.out.println("Error in database connection" + e.getMessage());
        }

    }

}