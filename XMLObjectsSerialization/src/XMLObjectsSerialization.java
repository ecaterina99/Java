public class XMLObjectsSerialization {
    public static void main(String[] args) {
/*
        User u = new User();
        u.setId(5);
        u.setEmail("mail@mail.ml");
        u.setPassword("123");
        u.serializeXml("src/my_xml.xml");

*/
        User u = User.deserializeXml("src/my_xml.xml");
        System.out.println(u);


    }

}