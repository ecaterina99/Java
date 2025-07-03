package org.example;
import country.Country;
import country.ObjectFactory;
import country.Root;
import javax.xml.bind.*;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {

        ObjectFactory factory = new ObjectFactory();
        Country country = factory.createCountry();

        country.setName("Germany");
        country.setCapital("Berlin");
        country.setCountryCode("De");
        country.setDescription("Germany is...");


        //marshalling -crearea xml-ului din Java object
        JAXBContext jc = JAXBContext.newInstance("country");
        Marshaller m = jc.createMarshaller();
        //  m.marshal(country, System.out);
        //  m.marshal(country, new File("out.xml"));

        //unmarshalling -crearea objectului Java din XML

        Unmarshaller um = jc.createUnmarshaller();
        Root root = (Root) um.unmarshal(new File("country.xml"));
        List<Country> countries = root.getCountry();

        for (Country c : countries) {
            System.out.println("Name: " + c.getName());
            System.out.println("Capital: " + c.getCapital());
            System.out.println("Code: " + c.getCountryCode());
            System.out.println("Desc: " + c.getDescription() + "\n");
        }
    }
}