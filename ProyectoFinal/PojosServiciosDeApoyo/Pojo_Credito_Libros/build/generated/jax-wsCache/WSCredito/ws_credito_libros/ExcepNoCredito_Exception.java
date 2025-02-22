
package ws_credito_libros;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ExcepNoCredito", targetNamespace = "http://wscredito/")
public class ExcepNoCredito_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ExcepNoCredito faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ExcepNoCredito_Exception(String message, ExcepNoCredito faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ExcepNoCredito_Exception(String message, ExcepNoCredito faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: ws_credito_libros.ExcepNoCredito
     */
    public ExcepNoCredito getFaultInfo() {
        return faultInfo;
    }

}
