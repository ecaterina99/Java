/*
În această clasă, trebuie create metode suplimentare.
Prima ar trebui să efectueze serializarea XML a obiectelor,
iar a doua, pe baza XML, ar trebui să creeze obiectele din clasa User.
 */


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class User {
    private int id;
    private String email;
    private String password;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return this.id + " " + this.email + " " + this.password;
    }

    public void serializeXml (String xmlFile) {
        try(FileOutputStream fos = new FileOutputStream(xmlFile);
            XMLEncoder xmlEncoder = new XMLEncoder(fos)){
                xmlEncoder.writeObject(this);
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
    }

    public static User deserializeXml (String xmlFile) {
        User user = new User();
        try(FileInputStream fis = new FileInputStream(xmlFile);
            XMLDecoder xmlDecoder = new XMLDecoder(fis)){
            user = (User) xmlDecoder.readObject();

        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}

