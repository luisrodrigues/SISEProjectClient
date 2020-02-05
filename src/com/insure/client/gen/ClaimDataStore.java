
package com.insure.client.gen;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ClaimDataStore", targetNamespace = "http://server.insure.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClaimDataStore {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     * @throws InvalidSignatureException_Exception
     * @throws ClaimNotFoundException_Exception
     * @throws InvalidKeySpecException_Exception
     * @throws IllegalBlockSizeException_Exception
     * @throws IOException_Exception
     * @throws InvalidKeyException_Exception
     * @throws BadPaddingException_Exception
     * @throws NoSuchAlgorithmException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listDocumentsOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ListDocumentsOfClaim")
    @ResponseWrapper(localName = "listDocumentsOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ListDocumentsOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = BadPaddingException_Exception.class, value = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaim/Fault/BadPaddingException"),
        @FaultAction(className = InvalidKeySpecException_Exception.class, value = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaim/Fault/InvalidKeySpecException"),
        @FaultAction(className = NoSuchAlgorithmException_Exception.class, value = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaim/Fault/NoSuchAlgorithmException"),
        @FaultAction(className = IOException_Exception.class, value = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaim/Fault/IOException"),
        @FaultAction(className = IllegalBlockSizeException_Exception.class, value = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaim/Fault/IllegalBlockSizeException"),
        @FaultAction(className = InvalidKeyException_Exception.class, value = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaim/Fault/InvalidKeyException"),
        @FaultAction(className = InvalidSignatureException_Exception.class, value = "http://server.insure.com/ClaimDataStore/listDocumentsOfClaim/Fault/InvalidSignatureException")
    })
    public List<String> listDocumentsOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws BadPaddingException_Exception, ClaimNotFoundException_Exception, IOException_Exception, IllegalBlockSizeException_Exception, InvalidKeyException_Exception, InvalidKeySpecException_Exception, InvalidSignatureException_Exception, NoSuchAlgorithmException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws InvalidSignatureException_Exception
     * @throws ClaimNotFoundException_Exception
     * @throws InvalidKeySpecException_Exception
     * @throws IllegalBlockSizeException_Exception
     * @throws IOException_Exception
     * @throws NoSuchAlgorithmException_Exception
     * @throws BadPaddingException_Exception
     * @throws DocumentNotFoundException_Exception
     * @throws InvalidKeyException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readDocumentOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentOfClaim")
    @ResponseWrapper(localName = "readDocumentOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/readDocumentOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/readDocumentOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = BadPaddingException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/BadPaddingException"),
        @FaultAction(className = InvalidSignatureException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/InvalidSignatureException"),
        @FaultAction(className = NoSuchAlgorithmException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/NoSuchAlgorithmException"),
        @FaultAction(className = IOException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/IOException"),
        @FaultAction(className = IllegalBlockSizeException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/IllegalBlockSizeException"),
        @FaultAction(className = InvalidKeyException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/InvalidKeyException"),
        @FaultAction(className = InvalidKeySpecException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/InvalidKeySpecException"),
        @FaultAction(className = DocumentNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/DocumentNotFoundException")
    })
    public String readDocumentOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws BadPaddingException_Exception, ClaimNotFoundException_Exception, DocumentNotFoundException_Exception, IOException_Exception, IllegalBlockSizeException_Exception, InvalidKeyException_Exception, InvalidKeySpecException_Exception, InvalidSignatureException_Exception, NoSuchAlgorithmException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws InvalidSignatureException_Exception
     * @throws ClaimNotFoundException_Exception
     * @throws IllegalBlockSizeException_Exception
     * @throws IOException_Exception
     * @throws InvalidKeySpecException_Exception
     * @throws NoSuchAlgorithmException_Exception
     * @throws InvalidKeyException_Exception
     * @throws BadPaddingException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createDocumentOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.CreateDocumentOfClaim")
    @ResponseWrapper(localName = "createDocumentOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.CreateDocumentOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/createDocumentOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/createDocumentOfClaimResponse", fault = {
        @FaultAction(className = BadPaddingException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/BadPaddingException"),
        @FaultAction(className = InvalidSignatureException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/InvalidSignatureException"),
        @FaultAction(className = NoSuchAlgorithmException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/NoSuchAlgorithmException"),
        @FaultAction(className = IOException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/IOException"),
        @FaultAction(className = IllegalBlockSizeException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/IllegalBlockSizeException"),
        @FaultAction(className = InvalidKeyException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/InvalidKeyException"),
        @FaultAction(className = InvalidKeySpecException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/InvalidKeySpecException"),
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/ClaimNotFoundException")
    })
    public int createDocumentOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3)
        throws BadPaddingException_Exception, ClaimNotFoundException_Exception, IOException_Exception, IllegalBlockSizeException_Exception, InvalidKeyException_Exception, InvalidKeySpecException_Exception, InvalidSignatureException_Exception, NoSuchAlgorithmException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns com.insure.client.gen.Claim
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.RetrieveClaim")
    @ResponseWrapper(localName = "retrieveClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.RetrieveClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/retrieveClaimRequest", output = "http://server.insure.com/ClaimDataStore/retrieveClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/retrieveClaim/Fault/ClaimNotFoundException")
    })
    public Claim retrieveClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClaimNotFoundException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "storeClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.StoreClaim")
    @ResponseWrapper(localName = "storeClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.StoreClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/storeClaimRequest", output = "http://server.insure.com/ClaimDataStore/storeClaimResponse")
    public void storeClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Claim arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.CreateClaim")
    @ResponseWrapper(localName = "createClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.CreateClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/createClaimRequest", output = "http://server.insure.com/ClaimDataStore/createClaimResponse")
    public int createClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "printClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.PrintClaim")
    @ResponseWrapper(localName = "printClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.PrintClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/printClaimRequest", output = "http://server.insure.com/ClaimDataStore/printClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/printClaim/Fault/ClaimNotFoundException")
    })
    public String printClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClaimNotFoundException_Exception
    ;

}
