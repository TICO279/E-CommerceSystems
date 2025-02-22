
package wsenvios;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WS_Envios", targetNamespace = "http://wsenvios/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSEnvios {


    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "remove", targetNamespace = "http://wsenvios/", className = "wsenvios.Remove")
    @Action(input = "http://wsenvios/WS_Envios/remove")
    public void remove(
        @WebParam(name = "entity", targetNamespace = "")
        Envios entity);

    /**
     * 
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "count", targetNamespace = "http://wsenvios/", className = "wsenvios.Count")
    @ResponseWrapper(localName = "countResponse", targetNamespace = "http://wsenvios/", className = "wsenvios.CountResponse")
    @Action(input = "http://wsenvios/WS_Envios/countRequest", output = "http://wsenvios/WS_Envios/countResponse")
    public int count();

    /**
     * 
     * @param id
     * @return
     *     returns wsenvios.Envios
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "find", targetNamespace = "http://wsenvios/", className = "wsenvios.Find")
    @ResponseWrapper(localName = "findResponse", targetNamespace = "http://wsenvios/", className = "wsenvios.FindResponse")
    @Action(input = "http://wsenvios/WS_Envios/findRequest", output = "http://wsenvios/WS_Envios/findResponse")
    public Envios find(
        @WebParam(name = "id", targetNamespace = "")
        Object id);

    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "create", targetNamespace = "http://wsenvios/", className = "wsenvios.Create")
    @Action(input = "http://wsenvios/WS_Envios/create")
    public void create(
        @WebParam(name = "entity", targetNamespace = "")
        Envios entity);

    /**
     * 
     * @param entity
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "edit", targetNamespace = "http://wsenvios/", className = "wsenvios.Edit")
    @Action(input = "http://wsenvios/WS_Envios/edit")
    public void edit(
        @WebParam(name = "entity", targetNamespace = "")
        Envios entity);

    /**
     * 
     * @param range
     * @return
     *     returns java.util.List<wsenvios.Envios>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findRange", targetNamespace = "http://wsenvios/", className = "wsenvios.FindRange")
    @ResponseWrapper(localName = "findRangeResponse", targetNamespace = "http://wsenvios/", className = "wsenvios.FindRangeResponse")
    @Action(input = "http://wsenvios/WS_Envios/findRangeRequest", output = "http://wsenvios/WS_Envios/findRangeResponse")
    public List<Envios> findRange(
        @WebParam(name = "range", targetNamespace = "")
        List<Integer> range);

    /**
     * 
     * @return
     *     returns java.util.List<wsenvios.Envios>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://wsenvios/", className = "wsenvios.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://wsenvios/", className = "wsenvios.FindAllResponse")
    @Action(input = "http://wsenvios/WS_Envios/findAllRequest", output = "http://wsenvios/WS_Envios/findAllResponse")
    public List<Envios> findAll();

    /**
     * 
     * @param idTda
     * @param cityRegion
     * @param address
     * @param phone
     * @param name
     * @param idPedido
     * @param email
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "solicitudEnvio", targetNamespace = "http://wsenvios/", className = "wsenvios.SolicitudEnvio")
    @ResponseWrapper(localName = "solicitudEnvioResponse", targetNamespace = "http://wsenvios/", className = "wsenvios.SolicitudEnvioResponse")
    @Action(input = "http://wsenvios/WS_Envios/solicitudEnvioRequest", output = "http://wsenvios/WS_Envios/solicitudEnvioResponse")
    public boolean solicitudEnvio(
        @WebParam(name = "id_Tda", targetNamespace = "")
        int idTda,
        @WebParam(name = "id_pedido", targetNamespace = "")
        int idPedido,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "email", targetNamespace = "")
        String email,
        @WebParam(name = "phone", targetNamespace = "")
        String phone,
        @WebParam(name = "address", targetNamespace = "")
        String address,
        @WebParam(name = "city_region", targetNamespace = "")
        String cityRegion);

}
