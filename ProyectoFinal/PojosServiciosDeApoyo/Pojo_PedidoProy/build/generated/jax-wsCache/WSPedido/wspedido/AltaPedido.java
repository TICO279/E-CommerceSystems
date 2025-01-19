
package wspedido;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for altaPedido complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="altaPedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_clte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lista_it" type="{http://wspedido/}clsItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "altaPedido", propOrder = {
    "idClte",
    "listaIt"
})
public class AltaPedido {

    @XmlElement(name = "id_clte")
    protected int idClte;
    @XmlElement(name = "lista_it")
    protected List<ClsItem> listaIt;

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
     * Gets the value of the listaIt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaIt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaIt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsItem }
     * 
     * 
     */
    public List<ClsItem> getListaIt() {
        if (listaIt == null) {
            listaIt = new ArrayList<ClsItem>();
        }
        return this.listaIt;
    }

}
