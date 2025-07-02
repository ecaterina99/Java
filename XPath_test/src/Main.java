import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {

        XPathFactory factory = XPathFactory.newInstance();

        XPath xPath = factory.newXPath();

        XPathExpression xPathExpression = xPath.compile("//book[pages>200]/title");
        //XPathExpression xPathExpression = xPath.compile("//book[position()<=2]/author | //book[last()]/author");

        File xmlDocument = new File(".idea/books.xml");
        InputSource inputSource = new InputSource(new FileInputStream(xmlDocument));

        Object result = xPathExpression.evaluate(inputSource, XPathConstants.NODESET);

        NodeList nodes = (NodeList) result;

        for(int i = 0; i < nodes.getLength(); i++) {
            System.out.println("node name: "+nodes.item(i).getNodeName());
            System.out.println("node value: "+nodes.item(i).getFirstChild().getNodeValue());
        }

    }
}