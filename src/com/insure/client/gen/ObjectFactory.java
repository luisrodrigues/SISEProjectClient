
package com.insure.client.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.insure.client.gen package. 
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

    private final static QName _BadPaddingException_QNAME = new QName("http://server.insure.com/", "BadPaddingException");
    private final static QName _ClaimNotFoundException_QNAME = new QName("http://server.insure.com/", "ClaimNotFoundException");
    private final static QName _DocumentNotFoundException_QNAME = new QName("http://server.insure.com/", "DocumentNotFoundException");
    private final static QName _IOException_QNAME = new QName("http://server.insure.com/", "IOException");
    private final static QName _IllegalBlockSizeException_QNAME = new QName("http://server.insure.com/", "IllegalBlockSizeException");
    private final static QName _InvalidKeyException_QNAME = new QName("http://server.insure.com/", "InvalidKeyException");
    private final static QName _InvalidKeySpecException_QNAME = new QName("http://server.insure.com/", "InvalidKeySpecException");
    private final static QName _InvalidSignatureException_QNAME = new QName("http://server.insure.com/", "InvalidSignatureException");
    private final static QName _NoSuchAlgorithmException_QNAME = new QName("http://server.insure.com/", "NoSuchAlgorithmException");
    private final static QName _CreateClaim_QNAME = new QName("http://server.insure.com/", "createClaim");
    private final static QName _CreateClaimResponse_QNAME = new QName("http://server.insure.com/", "createClaimResponse");
    private final static QName _CreateDocumentOfClaim_QNAME = new QName("http://server.insure.com/", "createDocumentOfClaim");
    private final static QName _CreateDocumentOfClaimResponse_QNAME = new QName("http://server.insure.com/", "createDocumentOfClaimResponse");
    private final static QName _ListDocumentsOfClaim_QNAME = new QName("http://server.insure.com/", "listDocumentsOfClaim");
    private final static QName _ListDocumentsOfClaimResponse_QNAME = new QName("http://server.insure.com/", "listDocumentsOfClaimResponse");
    private final static QName _PrintClaim_QNAME = new QName("http://server.insure.com/", "printClaim");
    private final static QName _PrintClaimResponse_QNAME = new QName("http://server.insure.com/", "printClaimResponse");
    private final static QName _ReadDocumentOfClaim_QNAME = new QName("http://server.insure.com/", "readDocumentOfClaim");
    private final static QName _ReadDocumentOfClaimResponse_QNAME = new QName("http://server.insure.com/", "readDocumentOfClaimResponse");
    private final static QName _RetrieveClaim_QNAME = new QName("http://server.insure.com/", "retrieveClaim");
    private final static QName _RetrieveClaimResponse_QNAME = new QName("http://server.insure.com/", "retrieveClaimResponse");
    private final static QName _StoreClaim_QNAME = new QName("http://server.insure.com/", "storeClaim");
    private final static QName _StoreClaimResponse_QNAME = new QName("http://server.insure.com/", "storeClaimResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.insure.client.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BadPaddingException }
     * 
     */
    public BadPaddingException createBadPaddingException() {
        return new BadPaddingException();
    }

    /**
     * Create an instance of {@link ClaimNotFoundException }
     * 
     */
    public ClaimNotFoundException createClaimNotFoundException() {
        return new ClaimNotFoundException();
    }

    /**
     * Create an instance of {@link DocumentNotFoundException }
     * 
     */
    public DocumentNotFoundException createDocumentNotFoundException() {
        return new DocumentNotFoundException();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link IllegalBlockSizeException }
     * 
     */
    public IllegalBlockSizeException createIllegalBlockSizeException() {
        return new IllegalBlockSizeException();
    }

    /**
     * Create an instance of {@link InvalidKeyException }
     * 
     */
    public InvalidKeyException createInvalidKeyException() {
        return new InvalidKeyException();
    }

    /**
     * Create an instance of {@link InvalidKeySpecException }
     * 
     */
    public InvalidKeySpecException createInvalidKeySpecException() {
        return new InvalidKeySpecException();
    }

    /**
     * Create an instance of {@link InvalidSignatureException }
     * 
     */
    public InvalidSignatureException createInvalidSignatureException() {
        return new InvalidSignatureException();
    }

    /**
     * Create an instance of {@link NoSuchAlgorithmException }
     * 
     */
    public NoSuchAlgorithmException createNoSuchAlgorithmException() {
        return new NoSuchAlgorithmException();
    }

    /**
     * Create an instance of {@link CreateClaim }
     * 
     */
    public CreateClaim createCreateClaim() {
        return new CreateClaim();
    }

    /**
     * Create an instance of {@link CreateClaimResponse }
     * 
     */
    public CreateClaimResponse createCreateClaimResponse() {
        return new CreateClaimResponse();
    }

    /**
     * Create an instance of {@link CreateDocumentOfClaim }
     * 
     */
    public CreateDocumentOfClaim createCreateDocumentOfClaim() {
        return new CreateDocumentOfClaim();
    }

    /**
     * Create an instance of {@link CreateDocumentOfClaimResponse }
     * 
     */
    public CreateDocumentOfClaimResponse createCreateDocumentOfClaimResponse() {
        return new CreateDocumentOfClaimResponse();
    }

    /**
     * Create an instance of {@link ListDocumentsOfClaim }
     * 
     */
    public ListDocumentsOfClaim createListDocumentsOfClaim() {
        return new ListDocumentsOfClaim();
    }

    /**
     * Create an instance of {@link ListDocumentsOfClaimResponse }
     * 
     */
    public ListDocumentsOfClaimResponse createListDocumentsOfClaimResponse() {
        return new ListDocumentsOfClaimResponse();
    }

    /**
     * Create an instance of {@link PrintClaim }
     * 
     */
    public PrintClaim createPrintClaim() {
        return new PrintClaim();
    }

    /**
     * Create an instance of {@link PrintClaimResponse }
     * 
     */
    public PrintClaimResponse createPrintClaimResponse() {
        return new PrintClaimResponse();
    }

    /**
     * Create an instance of {@link ReadDocumentOfClaim }
     * 
     */
    public ReadDocumentOfClaim createReadDocumentOfClaim() {
        return new ReadDocumentOfClaim();
    }

    /**
     * Create an instance of {@link ReadDocumentOfClaimResponse }
     * 
     */
    public ReadDocumentOfClaimResponse createReadDocumentOfClaimResponse() {
        return new ReadDocumentOfClaimResponse();
    }

    /**
     * Create an instance of {@link RetrieveClaim }
     * 
     */
    public RetrieveClaim createRetrieveClaim() {
        return new RetrieveClaim();
    }

    /**
     * Create an instance of {@link RetrieveClaimResponse }
     * 
     */
    public RetrieveClaimResponse createRetrieveClaimResponse() {
        return new RetrieveClaimResponse();
    }

    /**
     * Create an instance of {@link StoreClaim }
     * 
     */
    public StoreClaim createStoreClaim() {
        return new StoreClaim();
    }

    /**
     * Create an instance of {@link StoreClaimResponse }
     * 
     */
    public StoreClaimResponse createStoreClaimResponse() {
        return new StoreClaimResponse();
    }

    /**
     * Create an instance of {@link Claim }
     * 
     */
    public Claim createClaim() {
        return new Claim();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadPaddingException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BadPaddingException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "BadPaddingException")
    public JAXBElement<BadPaddingException> createBadPaddingException(BadPaddingException value) {
        return new JAXBElement<BadPaddingException>(_BadPaddingException_QNAME, BadPaddingException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClaimNotFoundException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClaimNotFoundException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "ClaimNotFoundException")
    public JAXBElement<ClaimNotFoundException> createClaimNotFoundException(ClaimNotFoundException value) {
        return new JAXBElement<ClaimNotFoundException>(_ClaimNotFoundException_QNAME, ClaimNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentNotFoundException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentNotFoundException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "DocumentNotFoundException")
    public JAXBElement<DocumentNotFoundException> createDocumentNotFoundException(DocumentNotFoundException value) {
        return new JAXBElement<DocumentNotFoundException>(_DocumentNotFoundException_QNAME, DocumentNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IllegalBlockSizeException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IllegalBlockSizeException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "IllegalBlockSizeException")
    public JAXBElement<IllegalBlockSizeException> createIllegalBlockSizeException(IllegalBlockSizeException value) {
        return new JAXBElement<IllegalBlockSizeException>(_IllegalBlockSizeException_QNAME, IllegalBlockSizeException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidKeyException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidKeyException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "InvalidKeyException")
    public JAXBElement<InvalidKeyException> createInvalidKeyException(InvalidKeyException value) {
        return new JAXBElement<InvalidKeyException>(_InvalidKeyException_QNAME, InvalidKeyException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidKeySpecException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidKeySpecException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "InvalidKeySpecException")
    public JAXBElement<InvalidKeySpecException> createInvalidKeySpecException(InvalidKeySpecException value) {
        return new JAXBElement<InvalidKeySpecException>(_InvalidKeySpecException_QNAME, InvalidKeySpecException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidSignatureException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InvalidSignatureException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "InvalidSignatureException")
    public JAXBElement<InvalidSignatureException> createInvalidSignatureException(InvalidSignatureException value) {
        return new JAXBElement<InvalidSignatureException>(_InvalidSignatureException_QNAME, InvalidSignatureException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoSuchAlgorithmException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NoSuchAlgorithmException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "NoSuchAlgorithmException")
    public JAXBElement<NoSuchAlgorithmException> createNoSuchAlgorithmException(NoSuchAlgorithmException value) {
        return new JAXBElement<NoSuchAlgorithmException>(_NoSuchAlgorithmException_QNAME, NoSuchAlgorithmException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "createClaim")
    public JAXBElement<CreateClaim> createCreateClaim(CreateClaim value) {
        return new JAXBElement<CreateClaim>(_CreateClaim_QNAME, CreateClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "createClaimResponse")
    public JAXBElement<CreateClaimResponse> createCreateClaimResponse(CreateClaimResponse value) {
        return new JAXBElement<CreateClaimResponse>(_CreateClaimResponse_QNAME, CreateClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDocumentOfClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateDocumentOfClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "createDocumentOfClaim")
    public JAXBElement<CreateDocumentOfClaim> createCreateDocumentOfClaim(CreateDocumentOfClaim value) {
        return new JAXBElement<CreateDocumentOfClaim>(_CreateDocumentOfClaim_QNAME, CreateDocumentOfClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateDocumentOfClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateDocumentOfClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "createDocumentOfClaimResponse")
    public JAXBElement<CreateDocumentOfClaimResponse> createCreateDocumentOfClaimResponse(CreateDocumentOfClaimResponse value) {
        return new JAXBElement<CreateDocumentOfClaimResponse>(_CreateDocumentOfClaimResponse_QNAME, CreateDocumentOfClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDocumentsOfClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListDocumentsOfClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "listDocumentsOfClaim")
    public JAXBElement<ListDocumentsOfClaim> createListDocumentsOfClaim(ListDocumentsOfClaim value) {
        return new JAXBElement<ListDocumentsOfClaim>(_ListDocumentsOfClaim_QNAME, ListDocumentsOfClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDocumentsOfClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListDocumentsOfClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "listDocumentsOfClaimResponse")
    public JAXBElement<ListDocumentsOfClaimResponse> createListDocumentsOfClaimResponse(ListDocumentsOfClaimResponse value) {
        return new JAXBElement<ListDocumentsOfClaimResponse>(_ListDocumentsOfClaimResponse_QNAME, ListDocumentsOfClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "printClaim")
    public JAXBElement<PrintClaim> createPrintClaim(PrintClaim value) {
        return new JAXBElement<PrintClaim>(_PrintClaim_QNAME, PrintClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "printClaimResponse")
    public JAXBElement<PrintClaimResponse> createPrintClaimResponse(PrintClaimResponse value) {
        return new JAXBElement<PrintClaimResponse>(_PrintClaimResponse_QNAME, PrintClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadDocumentOfClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadDocumentOfClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "readDocumentOfClaim")
    public JAXBElement<ReadDocumentOfClaim> createReadDocumentOfClaim(ReadDocumentOfClaim value) {
        return new JAXBElement<ReadDocumentOfClaim>(_ReadDocumentOfClaim_QNAME, ReadDocumentOfClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadDocumentOfClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReadDocumentOfClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "readDocumentOfClaimResponse")
    public JAXBElement<ReadDocumentOfClaimResponse> createReadDocumentOfClaimResponse(ReadDocumentOfClaimResponse value) {
        return new JAXBElement<ReadDocumentOfClaimResponse>(_ReadDocumentOfClaimResponse_QNAME, ReadDocumentOfClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RetrieveClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "retrieveClaim")
    public JAXBElement<RetrieveClaim> createRetrieveClaim(RetrieveClaim value) {
        return new JAXBElement<RetrieveClaim>(_RetrieveClaim_QNAME, RetrieveClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RetrieveClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "retrieveClaimResponse")
    public JAXBElement<RetrieveClaimResponse> createRetrieveClaimResponse(RetrieveClaimResponse value) {
        return new JAXBElement<RetrieveClaimResponse>(_RetrieveClaimResponse_QNAME, RetrieveClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreClaim }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StoreClaim }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "storeClaim")
    public JAXBElement<StoreClaim> createStoreClaim(StoreClaim value) {
        return new JAXBElement<StoreClaim>(_StoreClaim_QNAME, StoreClaim.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StoreClaimResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StoreClaimResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server.insure.com/", name = "storeClaimResponse")
    public JAXBElement<StoreClaimResponse> createStoreClaimResponse(StoreClaimResponse value) {
        return new JAXBElement<StoreClaimResponse>(_StoreClaimResponse_QNAME, StoreClaimResponse.class, null, value);
    }

}
