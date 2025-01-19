
package wsproy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsproy package. 
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

    private final static QName _EltoRespuestaGestiona_QNAME = new QName("http://xml.netbeans.org/schema/ProyectoSCHEMA", "eltoRespuestaGestiona");
    private final static QName _EltoExcepcionGenerica_QNAME = new QName("http://xml.netbeans.org/schema/ProyectoSCHEMA", "eltoExcepcionGenerica");
    private final static QName _EltoGestionaPedido_QNAME = new QName("http://xml.netbeans.org/schema/ProyectoSCHEMA", "eltoGestionaPedido");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsproy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RespuestaGestionaPedido }
     * 
     */
    public RespuestaGestionaPedido createRespuestaGestionaPedido() {
        return new RespuestaGestionaPedido();
    }

    /**
     * Create an instance of {@link ExcepcionGenerica }
     * 
     */
    public ExcepcionGenerica createExcepcionGenerica() {
        return new ExcepcionGenerica();
    }

    /**
     * Create an instance of {@link GestionaPedido }
     * 
     */
    public GestionaPedido createGestionaPedido() {
        return new GestionaPedido();
    }

    /**
     * Create an instance of {@link ClsItem }
     * 
     */
    public ClsItem createClsItem() {
        return new ClsItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaGestionaPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/ProyectoSCHEMA", name = "eltoRespuestaGestiona")
    public JAXBElement<RespuestaGestionaPedido> createEltoRespuestaGestiona(RespuestaGestionaPedido value) {
        return new JAXBElement<RespuestaGestionaPedido>(_EltoRespuestaGestiona_QNAME, RespuestaGestionaPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepcionGenerica }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/ProyectoSCHEMA", name = "eltoExcepcionGenerica")
    public JAXBElement<ExcepcionGenerica> createEltoExcepcionGenerica(ExcepcionGenerica value) {
        return new JAXBElement<ExcepcionGenerica>(_EltoExcepcionGenerica_QNAME, ExcepcionGenerica.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GestionaPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/ProyectoSCHEMA", name = "eltoGestionaPedido")
    public JAXBElement<GestionaPedido> createEltoGestionaPedido(GestionaPedido value) {
        return new JAXBElement<GestionaPedido>(_EltoGestionaPedido_QNAME, GestionaPedido.class, null, value);
    }

}
