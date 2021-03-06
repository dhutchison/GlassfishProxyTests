
package com.devwithimagination.proxy.ws.one;

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
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HelloWS", targetNamespace = "http://ws.proxy.devwithimagination.com/", wsdlLocation = "https://dev-ws.local/HelloWS?wsdl")
public class HelloWS_Service
    extends Service
{

    private final static URL HELLOWS_WSDL_LOCATION;
    private final static WebServiceException HELLOWS_EXCEPTION;
    private final static QName HELLOWS_QNAME = new QName("http://ws.proxy.devwithimagination.com/", "HelloWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://dev-ws.local/HelloWS?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOWS_WSDL_LOCATION = url;
        HELLOWS_EXCEPTION = e;
    }

    public HelloWS_Service() {
        super(__getWsdlLocation(), HELLOWS_QNAME);
    }

    public HelloWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOWS_QNAME, features);
    }

    public HelloWS_Service(URL wsdlLocation) {
        super(wsdlLocation, HELLOWS_QNAME);
    }

    public HelloWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOWS_QNAME, features);
    }

    public HelloWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HelloWS
     */
    @WebEndpoint(name = "HelloWSPort")
    public HelloWS getHelloWSPort() {
        return super.getPort(new QName("http://ws.proxy.devwithimagination.com/", "HelloWSPort"), HelloWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWS
     */
    @WebEndpoint(name = "HelloWSPort")
    public HelloWS getHelloWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.proxy.devwithimagination.com/", "HelloWSPort"), HelloWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOWS_EXCEPTION!= null) {
            throw HELLOWS_EXCEPTION;
        }
        return HELLOWS_WSDL_LOCATION;
    }

}
