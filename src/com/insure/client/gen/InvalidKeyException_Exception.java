
package com.insure.client.gen;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "InvalidKeyException", targetNamespace = "http://server.insure.com/")
public class InvalidKeyException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private InvalidKeyException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public InvalidKeyException_Exception(String message, InvalidKeyException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public InvalidKeyException_Exception(String message, InvalidKeyException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.insure.client.gen.InvalidKeyException
     */
    public InvalidKeyException getFaultInfo() {
        return faultInfo;
    }

}