
package com.insure.client.gen;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ClaimDataStoreService", targetNamespace = "http://server.insure.com/", wsdlLocation = "http://localhost:8090/claimservice?wsdl")
public class ClaimDataStoreService
    extends Service
{

    private final static URL CLAIMDATASTORESERVICE_WSDL_LOCATION;
    private final static WebServiceException CLAIMDATASTORESERVICE_EXCEPTION;
    private final static QName CLAIMDATASTORESERVICE_QNAME = new QName("http://server.insure.com/", "ClaimDataStoreService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8090/claimservice?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CLAIMDATASTORESERVICE_WSDL_LOCATION = url;
        CLAIMDATASTORESERVICE_EXCEPTION = e;
    }

    public ClaimDataStoreService() {
        super(__getWsdlLocation(), CLAIMDATASTORESERVICE_QNAME);
    }

    public ClaimDataStoreService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CLAIMDATASTORESERVICE_QNAME, features);
    }

    public ClaimDataStoreService(URL wsdlLocation) {
        super(wsdlLocation, CLAIMDATASTORESERVICE_QNAME);
    }

    public ClaimDataStoreService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CLAIMDATASTORESERVICE_QNAME, features);
    }

    public ClaimDataStoreService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ClaimDataStoreService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ClaimDataStore
     */
    @WebEndpoint(name = "ClaimDataStorePort")
    public ClaimDataStore getClaimDataStorePort() {
        return super.getPort(new QName("http://server.insure.com/", "ClaimDataStorePort"), ClaimDataStore.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ClaimDataStore
     */
    @WebEndpoint(name = "ClaimDataStorePort")
    public ClaimDataStore getClaimDataStorePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.insure.com/", "ClaimDataStorePort"), ClaimDataStore.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CLAIMDATASTORESERVICE_EXCEPTION!= null) {
            throw CLAIMDATASTORESERVICE_EXCEPTION;
        }
        return CLAIMDATASTORESERVICE_WSDL_LOCATION;
    }

}
