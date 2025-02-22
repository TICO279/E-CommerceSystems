
package wsproy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WS_SolicitaPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/BPELProyecto/src/WS_Solicita")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSSolicitaPortType {


    /**
     * 
     * @param datosEntrada
     * @return
     *     returns wsproy.RespuestaGestionaPedido
     * @throws WSSolicitaOperationFault
     */
    @WebMethod(operationName = "WS_SolicitaOperation")
    @WebResult(name = "eltoRespuestaGestiona", targetNamespace = "http://xml.netbeans.org/schema/ProyectoSCHEMA", partName = "datosRespuesta")
    public RespuestaGestionaPedido wsSolicitaOperation(
        @WebParam(name = "eltoGestionaPedido", targetNamespace = "http://xml.netbeans.org/schema/ProyectoSCHEMA", partName = "datosEntrada")
        GestionaPedido datosEntrada)
        throws WSSolicitaOperationFault
    ;

}
