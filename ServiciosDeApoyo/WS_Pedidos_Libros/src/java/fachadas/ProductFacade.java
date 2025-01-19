/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas;

import entidades.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

/**
 *
 * @author patri
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "WS_Pedidos_LibrosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public int agregaExistencia(long id_prod, int cant_a_agregar) {
        int cant_existente = 0;
        //Product prod   = this.find(new Integer(id_prod));
        //em.getTransaction().begin();
        Product prod = em.find(Product.class, new Long(id_prod), LockModeType.PESSIMISTIC_WRITE);
        if (prod != null) {
            cant_existente = prod.getExistencia();
            cant_existente += cant_a_agregar;
            prod.setExistencia(cant_existente);
            this.edit(prod);
        }
        //em.getTransaction().commit();
        prod = null;
        return cant_existente;
       
    }
    
     public int actualizaExistencia(long id_prod, int cant_solicitada) {
    int cant_posible = 0;
    int cant_existente;

    // Bloqueo pesimista para asegurar la coherencia del inventario
    Product prod = em.find(Product.class, new Long(id_prod), LockModeType.PESSIMISTIC_WRITE);
    
    if (prod == null) {
        cant_posible = 0;
    } else {
        cant_existente = prod.getExistencia();

        if (cant_solicitada < 0) {
            // Si es un backorder (cantidad negativa), incrementa la existencia
            cant_existente -= cant_solicitada;  // suma la cantidad (recordando que es negativa)
            cant_posible = cant_solicitada;     // cant_posible también será negativa en este caso
        } else {
            // Pedido normal: disminuye la existencia si hay suficiente inventario
            cant_posible = Math.min(cant_solicitada, cant_existente);
            cant_existente -= cant_posible;
        }

        // Actualiza la existencia en el producto
        prod.setExistencia(cant_existente);
        this.edit(prod);
    }

    prod = null;
    return cant_posible;
}

    
}
