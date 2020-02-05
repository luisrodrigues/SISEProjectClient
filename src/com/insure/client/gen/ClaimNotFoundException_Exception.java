
package com.insure.client.gen;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ClaimNotFoundException", targetNamespace = "http://server.insure.com/")
public class ClaimNotFoundException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ClaimNotFoundException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ClaimNotFoundException_Exception(String message, ClaimNotFoundException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ClaimNotFoundException_Exception(String message, ClaimNotFoundException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.insure.client.gen.ClaimNotFoundException
     */
    public ClaimNotFoundException getFaultInfo() {
        return faultInfo;
    }

}
