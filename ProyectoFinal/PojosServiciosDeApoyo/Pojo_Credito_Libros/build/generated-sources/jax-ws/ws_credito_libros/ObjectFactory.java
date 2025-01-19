
package ws_credito_libros;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws_credito_libros package. 
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

    private final static QName _FindRange_QNAME = new QName("http://wscredito/", "findRange");
    private final static QName _Edit_QNAME = new QName("http://wscredito/", "edit");
    private final static QName _Autoriza_QNAME = new QName("http://wscredito/", "autoriza");
    private final static QName _Remove_QNAME = new QName("http://wscredito/", "remove");
    private final static QName _ExcepNoExisteClte_QNAME = new QName("http://wscredito/", "ExcepNoExisteClte");
    private final static QName _FindAll_QNAME = new QName("http://wscredito/", "findAll");
    private final static QName _AutorizaResponse_QNAME = new QName("http://wscredito/", "autorizaResponse");
    private final static QName _CountResponse_QNAME = new QName("http://wscredito/", "countResponse");
    private final static QName _FindResponse_QNAME = new QName("http://wscredito/", "findResponse");
    private final static QName _Count_QNAME = new QName("http://wscredito/", "count");
    private final static QName _Find_QNAME = new QName("http://wscredito/", "find");
    private final static QName _FindRangeResponse_QNAME = new QName("http://wscredito/", "findRangeResponse");
    private final static QName _AutorizaDouble_QNAME = new QName("http://wscredito/", "autoriza_double");
    private final static QName _ExcepNoCredito_QNAME = new QName("http://wscredito/", "ExcepNoCredito");
    private final static QName _AutorizaDoubleResponse_QNAME = new QName("http://wscredito/", "autoriza_doubleResponse");
    private final static QName _FindAllResponse_QNAME = new QName("http://wscredito/", "findAllResponse");
    private final static QName _Create_QNAME = new QName("http://wscredito/", "create");
    private final static QName _Credito_QNAME = new QName("http://wscredito/", "credito");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws_credito_libros
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Autoriza }
     * 
     */
    public Autoriza createAutoriza() {
        return new Autoriza();
    }

    /**
     * Create an instance of {@link Edit }
     * 
     */
    public Edit createEdit() {
        return new Edit();
    }

    /**
     * Create an instance of {@link FindRange }
     * 
     */
    public FindRange createFindRange() {
        return new FindRange();
    }

    /**
     * Create an instance of {@link Count }
     * 
     */
    public Count createCount() {
        return new Count();
    }

    /**
     * Create an instance of {@link AutorizaResponse }
     * 
     */
    public AutorizaResponse createAutorizaResponse() {
        return new AutorizaResponse();
    }

    /**
     * Create an instance of {@link CountResponse }
     * 
     */
    public CountResponse createCountResponse() {
        return new CountResponse();
    }

    /**
     * Create an instance of {@link FindResponse }
     * 
     */
    public FindResponse createFindResponse() {
        return new FindResponse();
    }

    /**
     * Create an instance of {@link ExcepNoExisteClte }
     * 
     */
    public ExcepNoExisteClte createExcepNoExisteClte() {
        return new ExcepNoExisteClte();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link AutorizaDouble }
     * 
     */
    public AutorizaDouble createAutorizaDouble() {
        return new AutorizaDouble();
    }

    /**
     * Create an instance of {@link FindRangeResponse }
     * 
     */
    public FindRangeResponse createFindRangeResponse() {
        return new FindRangeResponse();
    }

    /**
     * Create an instance of {@link Find }
     * 
     */
    public Find createFind() {
        return new Find();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link Credito }
     * 
     */
    public Credito createCredito() {
        return new Credito();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link ExcepNoCredito }
     * 
     */
    public ExcepNoCredito createExcepNoCredito() {
        return new ExcepNoCredito();
    }

    /**
     * Create an instance of {@link AutorizaDoubleResponse }
     * 
     */
    public AutorizaDoubleResponse createAutorizaDoubleResponse() {
        return new AutorizaDoubleResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "findRange")
    public JAXBElement<FindRange> createFindRange(FindRange value) {
        return new JAXBElement<FindRange>(_FindRange_QNAME, FindRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Edit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "edit")
    public JAXBElement<Edit> createEdit(Edit value) {
        return new JAXBElement<Edit>(_Edit_QNAME, Edit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autoriza }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "autoriza")
    public JAXBElement<Autoriza> createAutoriza(Autoriza value) {
        return new JAXBElement<Autoriza>(_Autoriza_QNAME, Autoriza.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepNoExisteClte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "ExcepNoExisteClte")
    public JAXBElement<ExcepNoExisteClte> createExcepNoExisteClte(ExcepNoExisteClte value) {
        return new JAXBElement<ExcepNoExisteClte>(_ExcepNoExisteClte_QNAME, ExcepNoExisteClte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutorizaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "autorizaResponse")
    public JAXBElement<AutorizaResponse> createAutorizaResponse(AutorizaResponse value) {
        return new JAXBElement<AutorizaResponse>(_AutorizaResponse_QNAME, AutorizaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "countResponse")
    public JAXBElement<CountResponse> createCountResponse(CountResponse value) {
        return new JAXBElement<CountResponse>(_CountResponse_QNAME, CountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "findResponse")
    public JAXBElement<FindResponse> createFindResponse(FindResponse value) {
        return new JAXBElement<FindResponse>(_FindResponse_QNAME, FindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Count }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "count")
    public JAXBElement<Count> createCount(Count value) {
        return new JAXBElement<Count>(_Count_QNAME, Count.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Find }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "find")
    public JAXBElement<Find> createFind(Find value) {
        return new JAXBElement<Find>(_Find_QNAME, Find.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "findRangeResponse")
    public JAXBElement<FindRangeResponse> createFindRangeResponse(FindRangeResponse value) {
        return new JAXBElement<FindRangeResponse>(_FindRangeResponse_QNAME, FindRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutorizaDouble }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "autoriza_double")
    public JAXBElement<AutorizaDouble> createAutorizaDouble(AutorizaDouble value) {
        return new JAXBElement<AutorizaDouble>(_AutorizaDouble_QNAME, AutorizaDouble.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepNoCredito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "ExcepNoCredito")
    public JAXBElement<ExcepNoCredito> createExcepNoCredito(ExcepNoCredito value) {
        return new JAXBElement<ExcepNoCredito>(_ExcepNoCredito_QNAME, ExcepNoCredito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutorizaDoubleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "autoriza_doubleResponse")
    public JAXBElement<AutorizaDoubleResponse> createAutorizaDoubleResponse(AutorizaDoubleResponse value) {
        return new JAXBElement<AutorizaDoubleResponse>(_AutorizaDoubleResponse_QNAME, AutorizaDoubleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Credito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wscredito/", name = "credito")
    public JAXBElement<Credito> createCredito(Credito value) {
        return new JAXBElement<Credito>(_Credito_QNAME, Credito.class, null, value);
    }

}
