import javax.xml.stream.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {
        //first step
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        //second step
        Reader reader = new FileReader(".idea/books.xml");
        //cursor
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);

        while (xmlStreamReader.hasNext()) {

            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT: {

                    String elementName = xmlStreamReader.getName().toString();
                    switch (elementName) {
                        case "book":
                            for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                                String attributeName = xmlStreamReader.getAttributeLocalName(i);
                                String attributeValue = xmlStreamReader.getAttributeValue(i);
                                System.out.println("  Attribute value for " + attributeName + " = " + attributeValue);
                            }
                            break;
                        case "title":
                            System.out.println("  Title: " + xmlStreamReader.getElementText());
                            break;
                        case "author":
                            System.out.println("  Author: " + xmlStreamReader.getElementText());
                            break;
                    }
                }
            }
        }

//writing
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("output.xml"));

        writer.writeStartDocument();
        writer.writeStartElement("books");

        writer.writeStartElement("book");
        writer.writeAttribute("id", "01");
        writer.writeAttribute("isbn", "12345");

        writer.writeStartElement("title");
        writer.writeCharacters("Childhood's End");
        writer.writeEndElement();

        writer.writeStartElement("author");
        writer.writeCharacters("John Doe");
        writer.writeEndElement();

        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();

    }
}

/*
        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {
                case XMLStreamReader.START_ELEMENT:
                    System.out.println("START_ELEMENT");
                    System.out.println(" Start element = " + xmlStreamReader.getName());
                    break;
                case XMLStreamReader.END_ELEMENT:
                    System.out.println("END_ELEMENT");
                    System.out.println(" End element = " + xmlStreamReader.getName());
                    break;
            }
        }
 */