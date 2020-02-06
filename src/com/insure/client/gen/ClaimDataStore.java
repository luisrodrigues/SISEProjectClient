
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

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws InvalidClaimDescriptionException_Exception
     * @throws InvalidUserException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.CreateClaim")
    @ResponseWrapper(localName = "createClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.CreateClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/createClaimRequest", output = "http://server.insure.com/ClaimDataStore/createClaimResponse", fault = {
        @FaultAction(className = InvalidClaimDescriptionException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createClaim/Fault/InvalidClaimDescriptionException"),
        @FaultAction(className = InvalidUserException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createClaim/Fault/InvalidUserException")
    })
    public int createClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws InvalidClaimDescriptionException_Exception, InvalidUserException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "updateClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.UpdateClaim")
    @ResponseWrapper(localName = "updateClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.UpdateClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/updateClaimRequest", output = "http://server.insure.com/ClaimDataStore/updateClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/updateClaim/Fault/ClaimNotFoundException")
    })
    public void updateClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
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
     *     returns java.lang.String
     * @throws DocumentNotFoundException_Exception
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readAndTamperDocumentContentOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadAndTamperDocumentContentOfClaim")
    @ResponseWrapper(localName = "readAndTamperDocumentContentOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadAndTamperDocumentContentOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/readAndTamperDocumentContentOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/readAndTamperDocumentContentOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readAndTamperDocumentContentOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = DocumentNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readAndTamperDocumentContentOfClaim/Fault/DocumentNotFoundException")
    })
    public String readAndTamperDocumentContentOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClaimNotFoundException_Exception, DocumentNotFoundException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.Integer>
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDocumentKeysOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.GetDocumentKeysOfClaim")
    @ResponseWrapper(localName = "getDocumentKeysOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.GetDocumentKeysOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/getDocumentKeysOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/getDocumentKeysOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/getDocumentKeysOfClaim/Fault/ClaimNotFoundException")
    })
    public List<Integer> getDocumentKeysOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0)
        throws ClaimNotFoundException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws DocumentNotFoundException_Exception
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readDocumentUserOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentUserOfClaim")
    @ResponseWrapper(localName = "readDocumentUserOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentUserOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/readDocumentUserOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/readDocumentUserOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentUserOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = DocumentNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentUserOfClaim/Fault/DocumentNotFoundException")
    })
    public String readDocumentUserOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClaimNotFoundException_Exception, DocumentNotFoundException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws DocumentNotFoundException_Exception
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readDocumentOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentOfClaim")
    @ResponseWrapper(localName = "readDocumentOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/readDocumentOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/readDocumentOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = DocumentNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentOfClaim/Fault/DocumentNotFoundException")
    })
    public String readDocumentOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClaimNotFoundException_Exception, DocumentNotFoundException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws DocumentNotFoundException_Exception
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readDocumentContentOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentContentOfClaim")
    @ResponseWrapper(localName = "readDocumentContentOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentContentOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/readDocumentContentOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/readDocumentContentOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentContentOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = DocumentNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentContentOfClaim/Fault/DocumentNotFoundException")
    })
    public String readDocumentContentOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClaimNotFoundException_Exception, DocumentNotFoundException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws InvalidKeySpecException_Exception
     * @throws IOException_Exception
     * @throws InvalidKeyException_Exception
     * @throws InvalidUserException_Exception
     * @throws IllegalBlockSizeException_Exception
     * @throws InvalidSignatureException_Exception
     * @throws ClaimNotFoundException_Exception
     * @throws InvalidDocumentContentException_Exception
     * @throws NoSuchAlgorithmException_Exception
     * @throws InvalidDocumentTypeException_Exception
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
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = InvalidUserException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/InvalidUserException"),
        @FaultAction(className = InvalidDocumentTypeException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/InvalidDocumentTypeException"),
        @FaultAction(className = InvalidDocumentContentException_Exception.class, value = "http://server.insure.com/ClaimDataStore/createDocumentOfClaim/Fault/InvalidDocumentContentException")
    })
    public int createDocumentOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4)
        throws BadPaddingException_Exception, ClaimNotFoundException_Exception, IOException_Exception, IllegalBlockSizeException_Exception, InvalidDocumentContentException_Exception, InvalidDocumentTypeException_Exception, InvalidKeyException_Exception, InvalidKeySpecException_Exception, InvalidSignatureException_Exception, InvalidUserException_Exception, NoSuchAlgorithmException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws DocumentNotFoundException_Exception
     * @throws ClaimNotFoundException_Exception
     * @throws NotSameUserException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteDocumentOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.DeleteDocumentOfClaim")
    @ResponseWrapper(localName = "deleteDocumentOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.DeleteDocumentOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/deleteDocumentOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/deleteDocumentOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/deleteDocumentOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = DocumentNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/deleteDocumentOfClaim/Fault/DocumentNotFoundException"),
        @FaultAction(className = NotSameUserException_Exception.class, value = "http://server.insure.com/ClaimDataStore/deleteDocumentOfClaim/Fault/NotSameUserException")
    })
    public void deleteDocumentOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws ClaimNotFoundException_Exception, DocumentNotFoundException_Exception, NotSameUserException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws DocumentNotFoundException_Exception
     * @throws ClaimNotFoundException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "readDocumentSignatureOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentSignatureOfClaim")
    @ResponseWrapper(localName = "readDocumentSignatureOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.ReadDocumentSignatureOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/readDocumentSignatureOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/readDocumentSignatureOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentSignatureOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = DocumentNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/readDocumentSignatureOfClaim/Fault/DocumentNotFoundException")
    })
    public String readDocumentSignatureOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1)
        throws ClaimNotFoundException_Exception, DocumentNotFoundException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @throws DocumentNotFoundException_Exception
     * @throws ClaimNotFoundException_Exception
     * @throws NotSameUserException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "updateDocumentOfClaim", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.UpdateDocumentOfClaim")
    @ResponseWrapper(localName = "updateDocumentOfClaimResponse", targetNamespace = "http://server.insure.com/", className = "com.insure.client.gen.UpdateDocumentOfClaimResponse")
    @Action(input = "http://server.insure.com/ClaimDataStore/updateDocumentOfClaimRequest", output = "http://server.insure.com/ClaimDataStore/updateDocumentOfClaimResponse", fault = {
        @FaultAction(className = ClaimNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/updateDocumentOfClaim/Fault/ClaimNotFoundException"),
        @FaultAction(className = DocumentNotFoundException_Exception.class, value = "http://server.insure.com/ClaimDataStore/updateDocumentOfClaim/Fault/DocumentNotFoundException"),
        @FaultAction(className = NotSameUserException_Exception.class, value = "http://server.insure.com/ClaimDataStore/updateDocumentOfClaim/Fault/NotSameUserException")
    })
    public void updateDocumentOfClaim(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4)
        throws ClaimNotFoundException_Exception, DocumentNotFoundException_Exception, NotSameUserException_Exception
    ;

}
