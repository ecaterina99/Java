import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            URL wsdlLocation = new URL("http://localhost:8080/soap_services/temp_converter_service?wsdl");
            QName serviceName = new QName("http://link.com/", "TempConverterServiceService");

            Service service = Service.create(wsdlLocation, serviceName);

            QName portName = new QName("http://link.com/", "TempConverterServicePort");

            TempConverter tempConverterService = service.getPort(portName, TempConverter.class);

            System.out.println("0C = " + tempConverterService.c2f(0) + "F");
            System.out.println("218.0F = " + tempConverterService.f2c(218.0) + "C");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}