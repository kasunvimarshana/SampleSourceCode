
package src.main.java.jcg.ssowmya.demo.jaxws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the src.main.java.jcg.ssowmya.demo.jaxws.client package. 
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

    private final static QName _DeleteByIdResponse_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "deleteByIdResponse");
    private final static QName _GetAllCurrenciesResponse_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "getAllCurrenciesResponse");
    private final static QName _FindByCode_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "findByCode");
    private final static QName _DeleteById_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "deleteById");
    private final static QName _Save_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "save");
    private final static QName _FindByCodeResponse_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "findByCodeResponse");
    private final static QName _GetCurrencyById_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "getCurrencyById");
    private final static QName _GetCurrencyByIdResponse_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "getCurrencyByIdResponse");
    private final static QName _GetAllCurrencies_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "getAllCurrencies");
    private final static QName _SaveResponse_QNAME = new QName("http://soapwebservices.demo.ssowmya.jcg/", "saveResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: src.main.java.jcg.ssowmya.demo.jaxws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteByIdResponse }
     * 
     */
    public DeleteByIdResponse createDeleteByIdResponse() {
        return new DeleteByIdResponse();
    }

    /**
     * Create an instance of {@link GetAllCurrenciesResponse }
     * 
     */
    public GetAllCurrenciesResponse createGetAllCurrenciesResponse() {
        return new GetAllCurrenciesResponse();
    }

    /**
     * Create an instance of {@link FindByCode }
     * 
     */
    public FindByCode createFindByCode() {
        return new FindByCode();
    }

    /**
     * Create an instance of {@link DeleteById }
     * 
     */
    public DeleteById createDeleteById() {
        return new DeleteById();
    }

    /**
     * Create an instance of {@link Save }
     * 
     */
    public Save createSave() {
        return new Save();
    }

    /**
     * Create an instance of {@link FindByCodeResponse }
     * 
     */
    public FindByCodeResponse createFindByCodeResponse() {
        return new FindByCodeResponse();
    }

    /**
     * Create an instance of {@link GetCurrencyById }
     * 
     */
    public GetCurrencyById createGetCurrencyById() {
        return new GetCurrencyById();
    }

    /**
     * Create an instance of {@link GetCurrencyByIdResponse }
     * 
     */
    public GetCurrencyByIdResponse createGetCurrencyByIdResponse() {
        return new GetCurrencyByIdResponse();
    }

    /**
     * Create an instance of {@link GetAllCurrencies }
     * 
     */
    public GetAllCurrencies createGetAllCurrencies() {
        return new GetAllCurrencies();
    }

    /**
     * Create an instance of {@link SaveResponse }
     * 
     */
    public SaveResponse createSaveResponse() {
        return new SaveResponse();
    }

    /**
     * Create an instance of {@link Currency }
     * 
     */
    public Currency createCurrency() {
        return new Currency();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "deleteByIdResponse")
    public JAXBElement<DeleteByIdResponse> createDeleteByIdResponse(DeleteByIdResponse value) {
        return new JAXBElement<DeleteByIdResponse>(_DeleteByIdResponse_QNAME, DeleteByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCurrenciesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "getAllCurrenciesResponse")
    public JAXBElement<GetAllCurrenciesResponse> createGetAllCurrenciesResponse(GetAllCurrenciesResponse value) {
        return new JAXBElement<GetAllCurrenciesResponse>(_GetAllCurrenciesResponse_QNAME, GetAllCurrenciesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "findByCode")
    public JAXBElement<FindByCode> createFindByCode(FindByCode value) {
        return new JAXBElement<FindByCode>(_FindByCode_QNAME, FindByCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "deleteById")
    public JAXBElement<DeleteById> createDeleteById(DeleteById value) {
        return new JAXBElement<DeleteById>(_DeleteById_QNAME, DeleteById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Save }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "save")
    public JAXBElement<Save> createSave(Save value) {
        return new JAXBElement<Save>(_Save_QNAME, Save.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "findByCodeResponse")
    public JAXBElement<FindByCodeResponse> createFindByCodeResponse(FindByCodeResponse value) {
        return new JAXBElement<FindByCodeResponse>(_FindByCodeResponse_QNAME, FindByCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "getCurrencyById")
    public JAXBElement<GetCurrencyById> createGetCurrencyById(GetCurrencyById value) {
        return new JAXBElement<GetCurrencyById>(_GetCurrencyById_QNAME, GetCurrencyById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "getCurrencyByIdResponse")
    public JAXBElement<GetCurrencyByIdResponse> createGetCurrencyByIdResponse(GetCurrencyByIdResponse value) {
        return new JAXBElement<GetCurrencyByIdResponse>(_GetCurrencyByIdResponse_QNAME, GetCurrencyByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCurrencies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "getAllCurrencies")
    public JAXBElement<GetAllCurrencies> createGetAllCurrencies(GetAllCurrencies value) {
        return new JAXBElement<GetAllCurrencies>(_GetAllCurrencies_QNAME, GetAllCurrencies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapwebservices.demo.ssowmya.jcg/", name = "saveResponse")
    public JAXBElement<SaveResponse> createSaveResponse(SaveResponse value) {
        return new JAXBElement<SaveResponse>(_SaveResponse_QNAME, SaveResponse.class, null, value);
    }

}
