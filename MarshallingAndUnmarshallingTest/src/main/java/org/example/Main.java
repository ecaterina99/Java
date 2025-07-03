package org.example;
import country.Country;
import country.ObjectFactory;
import country.Root;
import country.Ruler;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, DatatypeConfigurationException, SAXException {

        ObjectFactory factory = new ObjectFactory();

/*
        Ruler ruler = factory.createRuler();
        ruler.setRulerName("Angela Merkel");
        DatatypeFactory df = DatatypeFactory.newInstance();
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(1954, 07, 17);
        XMLGregorianCalendar xmlGregorianCalendar = df.newXMLGregorianCalendar(gc);
        ruler.setDateOfBirth(xmlGregorianCalendar);
        Country country = factory.createCountry();
        country.setName("Germany");
        country.setCapital("Berlin");
        country.setCountryCode("De");
        country.setDescription("Germany is...");
        country.setRuler(ruler);
        country.setPopulation("83020000");
 */

        //marshalling -crearea xml-ului din Java object
        JAXBContext jc = JAXBContext.newInstance("country");
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("src/main/xsd/country.xsd"));

       /* Marshaller m = jc.createMarshaller();
        m.setSchema(schema);
        m.setEventHandler(new MyVEH());
        m.marshal(country, new File("out.xml"));
        // m.marshal(country, System.out);

        */

       //unmarshalling -crearea objectului Java din XML
        Unmarshaller um = jc.createUnmarshaller();

        um.setSchema(schema);
        um.setEventHandler(new MyVEH());

        Root root = (Root) um.unmarshal(new File("country.xml"));
        List<Country> countries = root.getCountry();

        for (Country c : countries) {
            System.out.println("Name: " + c.getName());
            System.out.println("Capital: " + c.getCapital());
            System.out.println("Code: " + c.getCountryCode());
            System.out.println("Desc: " + c.getDescription());
            System.out.println("Population: " + c.getPopulation());
            System.out.println("Ruler: " + c.getRuler().getRulerName());
            System.out.println("Ruler date of birth: " + c.getRuler().getDateOfBirth());
        }
    }
}