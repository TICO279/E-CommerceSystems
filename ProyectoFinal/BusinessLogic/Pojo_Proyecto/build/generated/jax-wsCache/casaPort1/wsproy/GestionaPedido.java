
package wsproy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for gestionaPedido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gestionaPedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_clte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lista_items" type="{http://xml.netbeans.org/schema/ProyectoSCHEMA}ClsItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestionaPedido", propOrder = {
    "idClte",
    "listaItems"
})
public class GestionaPedido {

    @XmlElement(name = "id_clte")
    protected int idClte;
    @XmlElement(name = "lista_items", required = true)
    protected List<ClsItem> listaItems;

    /**
     * Gets the value of the idClte property.
     * 
     */
    public int getIdClte() {
        return idClte;
    }

    /**
     * Sets the value of the idClte property.
     * 
     */
    public void setIdClte(int value) {
        this.idClte = value;
    }

    /**
     * Gets the value of the listaItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsItem }
     * 
     * 
     */
    public List<ClsItem> getListaItems() {
        if (listaItems == null) {
            listaItems = new ArrayList<ClsItem>();
        }
        return this.listaItems;
    }

}
