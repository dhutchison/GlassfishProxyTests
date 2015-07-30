
package com.devwithimagination.proxy.ws.three;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WarWS", targetNamespace = "http://war.proxy.devwithimagination.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WarWS {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHello", targetNamespace = "http://war.proxy.devwithimagination.com/", className = "com.devwithimagination.proxy.ws.three.GetHello")
    @ResponseWrapper(localName = "getHelloResponse", targetNamespace = "http://war.proxy.devwithimagination.com/", className = "com.devwithimagination.proxy.ws.three.GetHelloResponse")
    @Action(input = "http://war.proxy.devwithimagination.com/WarWS/getHelloRequest", output = "http://war.proxy.devwithimagination.com/WarWS/getHelloResponse")
    public String getHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}