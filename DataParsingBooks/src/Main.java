import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();

        Reader reader = new FileReader(".idea/books.xml");

        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(reader);

        String author = null, title = null, genre = null, description = null, publishDate = null;
        double price = 0.0;
        String currentElement = null;


        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {

                case XMLStreamReader.START_ELEMENT:
                    currentElement = xmlStreamReader.getName().toString();
                    if ("book".equals(currentElement)) {
                        author = title = genre = description = publishDate = null;
                        price = 0.0;
                    }
                    break;

                case XMLStreamReader.CHARACTERS:
                    if (currentElement != null) {

                        String text = xmlStreamReader.getText().trim();
                        if (!text.isEmpty()) {
                            switch (currentElement) {
                                case "author":
                                    author = text;
                                    break;
                                case "title":
                                    title = text;
                                    break;
                                case "genre":
                                    genre = text;
                                    break;
                                case "price":
                                    try {
                                        price = Double.parseDouble(text);
                                    } catch (NumberFormatException e) {
                                        price = 0.0;
                                    }
                                    break;
                                case "publish_date":
                                    publishDate = text;
                                    break;
                                case "description":
                                    description = text;
                                    break;
                            }
                        }
                    }
                    break;

                case XMLStreamReader.END_ELEMENT:
                    String endElementName = xmlStreamReader.getLocalName();

                    if ("book".equals(endElementName)) {
                        if (price > 10 && publishDate != null && publishDate.compareTo("2005-01-01") > 0) {
                            System.out.println("=== BOOK ===");
                            System.out.println("  Author: " + (author != null ? author : "Not available"));
                            System.out.println("  Title: " + (title != null ? title : "Not available"));
                            System.out.println("  Genre: " + (genre != null ? genre : "Not available"));
                            System.out.println("  Price: " + price);
                            System.out.println("  Publish date: " + (publishDate != null ? publishDate : "Not available"));
                            System.out.println("  Description: " + (description != null ? description : "Not available"));
                            System.out.println();
                        }
                    }
                    currentElement = null;
                    break;
            }
        }
        xmlStreamReader.close();
        reader.close();
    }
}

