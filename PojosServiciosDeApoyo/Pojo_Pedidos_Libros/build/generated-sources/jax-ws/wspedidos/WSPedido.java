
package wspedidos;

import java.math.BigDecimal;
import java.util.List;
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
@WebService(name = "WSPedido", targetNamespace = "http://wspedido/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSPedido {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://wspedido/", className = "wspedidos.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://wspedido/", className = "wspedidos.HelloResponse")
    @Action(input = "http://wspedido/WSPedido/helloRequest", output = "http://wspedido/WSPedido/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param listaIt
     * @param idClte
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "altaPedido", targetNamespace = "http://wspedido/", className = "wspedidos.AltaPedido")
    @ResponseWrapper(localName = "altaPedidoResponse", targetNamespace = "http://wspedido/", className = "wspedidos.AltaPedidoResponse")
    @Action(input = "http://wspedido/WSPedido/altaPedidoRequest", output = "http://wspedido/WSPedido/altaPedidoResponse")
    public int altaPedido(
        @WebParam(name = "id_clte", targetNamespace = "")
        int idClte,
        @WebParam(name = "lista_it", targetNamespace = "")
        List<ClsItem> listaIt);

    /**
     * 
     * @return
     *     returns java.util.List<wspedidos.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "catalogoCltes", targetNamespace = "http://wspedido/", className = "wspedidos.CatalogoCltes")
    @ResponseWrapper(localName = "catalogoCltesResponse", targetNamespace = "http://wspedido/", className = "wspedidos.CatalogoCltesResponse")
    @Action(input = "http://wspedido/WSPedido/catalogoCltesRequest", output = "http://wspedido/WSPedido/catalogoCltesResponse")
    public List<Customer> catalogoCltes();

    /**
     * 
     * @return
     *     returns java.util.List<wspedidos.Product>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "catalogoProds", targetNamespace = "http://wspedido/", className = "wspedidos.CatalogoProds")
    @ResponseWrapper(localName = "catalogoProdsResponse", targetNamespace = "http://wspedido/", className = "wspedidos.CatalogoProdsResponse")
    @Action(input = "http://wspedido/WSPedido/catalogoProdsRequest", output = "http://wspedido/WSPedido/catalogoProdsResponse")
    public List<Product> catalogoProds();

    /**
     * 
     * @param idPedido
     */
    @WebMethod
    @RequestWrapper(localName = "restitucionPedido", targetNamespace = "http://wspedido/", className = "wspedidos.RestitucionPedido")
    @ResponseWrapper(localName = "restitucionPedidoResponse", targetNamespace = "http://wspedido/", className = "wspedidos.RestitucionPedidoResponse")
    @Action(input = "http://wspedido/WSPedido/restitucionPedidoRequest", output = "http://wspedido/WSPedido/restitucionPedidoResponse")
    public void restitucionPedido(
        @WebParam(name = "idPedido", targetNamespace = "")
        int idPedido);

    /**
     * 
     * @param idProd
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerInventario", targetNamespace = "http://wspedido/", className = "wspedidos.ObtenerInventario")
    @ResponseWrapper(localName = "obtenerInventarioResponse", targetNamespace = "http://wspedido/", className = "wspedidos.ObtenerInventarioResponse")
    @Action(input = "http://wspedido/WSPedido/obtenerInventarioRequest", output = "http://wspedido/WSPedido/obtenerInventarioResponse")
    public int obtenerInventario(
        @WebParam(name = "idProd", targetNamespace = "")
        long idProd);

    /**
     * 
     * @param numPedido
     * @return
     *     returns java.math.BigDecimal
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "montoPedido", targetNamespace = "http://wspedido/", className = "wspedidos.MontoPedido")
    @ResponseWrapper(localName = "montoPedidoResponse", targetNamespace = "http://wspedido/", className = "wspedidos.MontoPedidoResponse")
    @Action(input = "http://wspedido/WSPedido/montoPedidoRequest", output = "http://wspedido/WSPedido/montoPedidoResponse")
    public BigDecimal montoPedido(
        @WebParam(name = "num_pedido", targetNamespace = "")
        int numPedido);

    /**
     * 
     * @param numPedido
     * @return
     *     returns wspedidos.Customer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "clteDelPedido", targetNamespace = "http://wspedido/", className = "wspedidos.ClteDelPedido")
    @ResponseWrapper(localName = "clteDelPedidoResponse", targetNamespace = "http://wspedido/", className = "wspedidos.ClteDelPedidoResponse")
    @Action(input = "http://wspedido/WSPedido/clteDelPedidoRequest", output = "http://wspedido/WSPedido/clteDelPedidoResponse")
    public Customer clteDelPedido(
        @WebParam(name = "num_pedido", targetNamespace = "")
        int numPedido);

}
