package wspedido;

import entidades.Customer;
import entidades.Product;
import fachadas.CustomerFacade;
import fachadas.CustomerOrderFacade;
import fachadas.OrderedProductFacade;
import fachadas.ProductFacade;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

/**
 *
 * @author RGAMBOAH
 */
@WebService(serviceName = "WSPedido")
public class WSPedido {

    @EJB
    private OrderedProductFacade orderedProductFacade;
    @EJB
    private CustomerOrderFacade customerOrderFacade;
    @EJB
    private ProductFacade productFacade;
    @EJB
    private CustomerFacade customerFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    
    @WebMethod(operationName = "altaPedido")
public int altaPedido(@WebParam(name = "id_clte") int id_clte, 
                      @WebParam(name = "lista_it") List<ClsItem> lista_it) 
{
    List<entidades.OrderedProduct> lista_orderedProducts = new ArrayList<>();
    entidades.OrderedProduct ordered_product;
    entidades.Product prod;
    int num_conf;
    int num_pedido;
    
    BigDecimal bd_monto_pedido = BigDecimal.ZERO;
    BigDecimal bd_monto_item;

    for (ClsItem it : lista_it) 
    {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO,
                "Product_id:" + it.getId_prod() + ", cantidad:" + it.getCantidad());

        // Verifica si es un pedido en backorder (cantidad negativa)
        if (it.getCantidad() < 0) {
            // Crea el pedido con cantidades negativas
            ordered_product = new entidades.OrderedProduct();
            prod = productFacade.find(new Long(it.getId_prod()));
            ordered_product.setProduct(prod);
            ordered_product.setQuantity((short) it.getCantidad()); // Almacena cantidad negativa
            lista_orderedProducts.add(ordered_product);

            // Actualiza el inventario con la cantidad negativa para revertirlo
            productFacade.actualizaExistencia(it.getId_prod(), it.getCantidad());

            // Calcula el monto con el valor absoluto de la cantidad
            bd_monto_item = prod.getPrice().multiply(BigDecimal.valueOf(-it.getCantidad())); 
            bd_monto_item = bd_monto_item.setScale(2, BigDecimal.ROUND_HALF_UP);
            bd_monto_pedido = bd_monto_pedido.add(bd_monto_item);  
        } else {
            // Pedido normal: verifica inventario y ajusta cantidad posible
            int cantidad_posible = productFacade.actualizaExistencia(it.getId_prod(), it.getCantidad());
            
            if (cantidad_posible > 0) {
                ordered_product = new entidades.OrderedProduct();
                prod = productFacade.find(new Long(it.getId_prod()));
                ordered_product.setProduct(prod);
                ordered_product.setQuantity((short) cantidad_posible);
                lista_orderedProducts.add(ordered_product);

                Logger.getLogger(this.getClass().getName()).log(Level.INFO,
                        "Product_id:" + prod.getId() + ", " + prod.getName() + ", "
                        + prod.getDescription() + ", " + prod.getCategoryId().getName() + ", "
                        + prod.getPrice());

                bd_monto_item = prod.getPrice().multiply(BigDecimal.valueOf(cantidad_posible));
                bd_monto_item = bd_monto_item.setScale(2, BigDecimal.ROUND_HALF_UP);
                bd_monto_pedido = bd_monto_pedido.add(bd_monto_item);  
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO,
                        "Clave de producto " + it.getId_prod() + " INEXISTENTE o sin existencias");
            }
        }
    }

    if (lista_orderedProducts.size() > 0) // hay items en el pedido o backorder
    {
        entidades.Customer clte = customerFacade.find(new Integer(id_clte));
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
              "Pedido del cliente:" + clte.getId() + ", " + clte.getName() + " por " + bd_monto_pedido);

        entidades.CustomerOrder customer_order = new entidades.CustomerOrder();
        customer_order.setCustomerId(clte);
        java.util.Date d = new java.util.Date();
        customer_order.setDateCreated(d);
        customer_order.setAmount(bd_monto_pedido);

        num_conf = customerOrderFacade.next_conf_number();
        customer_order.setConfirmationNumber(num_conf);
        customerOrderFacade.create(customer_order);
        num_pedido = customer_order.getId();

        entidades.OrderedProductPK oppk;
        List<entidades.OrderedProduct> listaBuena = new ArrayList<>();
        for (entidades.OrderedProduct op : lista_orderedProducts) 
        {
            oppk = new entidades.OrderedProductPK();
            oppk.setCustomerOrderId(customer_order.getId());
            oppk.setProductId(op.getProduct().getId());
            op.setOrderedProductPK(oppk);
            op.setCustomerOrder(customer_order);
            
            orderedProductFacade.create(op);
            listaBuena.add(op);
        }
        customer_order.setOrderedProductList(listaBuena);
        customerOrderFacade.edit(customer_order);
    }
    else
    {
        num_pedido = 0;  // no hay items a surtir en el pedido
    }
    
    return num_pedido;
}


    // =========================================================================
    //             Para el catálogo de clientes y de productos
    // =========================================================================
    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "catalogoCltes")
    public java.util.List<entidades.Customer> catalogoCltes() 
    {
        return customerFacade.findAll();
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "catalogoProds")
    public java.util.List<entidades.Product> catalogoProds() 
    {   
        return productFacade.findAll();
    }
    
    // =============================================================================
// Nuevos servicios
// =============================================================================
/**
* Web service operation
*/
@WebMethod(operationName = "montoPedido")
public BigDecimal montoPedido(@WebParam(name = "num_pedido") int num_pedido)
{
java.math.BigDecimal monto_del_pedido;

monto_del_pedido = customerOrderFacade.find(num_pedido).getAmount();

return monto_del_pedido;
}

/**
* Web service operation
*/
@WebMethod(operationName = "clteDelPedido")
public Customer clteDelPedido(@WebParam(name = "num_pedido") int num_pedido)
{
return customerOrderFacade.find(num_pedido).getCustomerId();
}

// =============================================================================
// Fin de Nuevos servicio
// =============================================================================


//Metodo agregado por nuestra parte
/**
 * Web service operation para obtener la cantidad de inventario disponible de un producto.
 * @param idProd ID del producto
 * @return Cantidad de inventario disponible
 */
@WebMethod(operationName = "obtenerInventario")
public int obtenerInventario(@WebParam(name = "idProd") long idProd) {
    entidades.Product producto = productFacade.find(idProd);
    if (producto != null) {
        return producto.getExistencia(); // Usamos el campo existencia para la cantidad de inventario
    } else {
        Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Producto con ID " + idProd + " no encontrado.");
        return 0; // Retornamos 0 si el producto no existe
    }
}

 /**
     * Web service operation
     */
    @WebMethod(operationName = "restitucionPedido")
    public void restitucionPedido(@WebParam(name = "idPedido") int idPedido) {
        //TODO write your implementation code here:

        entidades.CustomerOrder co = customerOrderFacade.find(idPedido);

        entidades.Product prod;
        if (co != null) {
            java.util.List<entidades.OrderedProduct> items = (java.util.List<entidades.OrderedProduct>) co.getOrderedProductList();
            for (entidades.OrderedProduct op : items) {
                prod = productFacade.find(op.getProduct().getId());
                productFacade.agregaExistencia(prod.getId(), op.getQuantity());

            }
            
        }
        
    }

// Método privado para verificar la disponibilidad de inventario para cada item en la lista
private boolean verificarInventario(List<wspedido.ClsItem> listaIt) {
    
    for (wspedido.ClsItem item : listaIt) {
        long idProd = item.getId_prod();
        int cantidadRequerida = item.getCantidad();
        
        // Supongamos que tenemos un método en el servicio de pedidos que verifica la cantidad en inventario
        entidades.Product producto = productFacade.find(idProd);
        
        int cantidadDisponible = producto.getExistencia();  // Método a implementar en el servicio de pedidos

        if (cantidadDisponible < cantidadRequerida) {
            return false;
        }
    }
    return true;
}

// Método privado para verificar la disponibilidad de credito para cada item en la lista
private BigDecimal verificarCredito(List<wspedido.ClsItem> listaIt) {
    BigDecimal suma = new BigDecimal(0);
   
    for (wspedido.ClsItem item : listaIt) {
        
        long idProd = item.getId_prod();
        entidades.Product producto = productFacade.find(idProd);
        int cantidadRequerida = item.getCantidad();
        BigDecimal precioporitem = producto.getPrice();
        
        // Supongamos que tenemos un método en el servicio de pedidos que verifica la cantidad en inventario
        suma = suma.add(BigDecimal.valueOf(cantidadRequerida).multiply(precioporitem));
        
         // Método a implementar en el servicio de pedidos

        
    }
    return suma;
}




}

