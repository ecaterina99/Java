//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2025.07.03 at 05:01:12 PM EEST 
//


package country;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the country package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: country
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link country.Root }
     * 
     */
    public country.Root createRoot() {
        return new Root();
    }

    /**
     * Create an instance of {@link country.Country }
     * 
     */
    public country.Country createCountry() {
        return new Country();
    }

    /**
     * Create an instance of {@link Ruler }
     * 
     */
    public Ruler createRuler() {
        return new Ruler();
    }

}
