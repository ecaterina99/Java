import jakarta.jws.WebService;

@WebService(targetNamespace = "http://link.com/")
public interface TempConverter {

    double c2f(double degrees);
    double f2c(double degrees);

}