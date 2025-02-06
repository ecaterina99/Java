import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.IOException;

public class SerializationXML {

    public static void main(String[] args) {
        Car c = new Car();
        c.setId(10);
        c.setModel("Audi A8");
        c.setMaximumSpeed(270.00);

        try (FileInputStream fis = new FileInputStream("my_car.xml");
             XMLDecoder XMLDecoder = new XMLDecoder(fis)) {

            Car car = (Car) XMLDecoder.readObject();
            System.out.println(car);

        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}