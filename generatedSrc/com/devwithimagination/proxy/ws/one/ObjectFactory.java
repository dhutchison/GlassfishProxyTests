
package com.devwithimagination.proxy.ws.one;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.devwithimagination.proxy.ws.one package. 
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

    private final static QName _GetHelloWithAuthResponse_QNAME = new QName("http://ws.proxy.devwithimagination.com/", "getHelloWithAuthResponse");
    private final static QName _GetHello_QNAME = new QName("http://ws.proxy.devwithimagination.com/", "getHello");
    private final static QName _GetHelloWithAuth_QNAME = new QName("http://ws.proxy.devwithimagination.com/", "getHelloWithAuth");
    private final static QName _GetHelloResponse_QNAME = new QName("http://ws.proxy.devwithimagination.com/", "getHelloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.devwithimagination.proxy.ws.one
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHelloWithAuthResponse }
     * 
     */
    public GetHelloWithAuthResponse createGetHelloWithAuthResponse() {
        return new GetHelloWithAuthResponse();
    }

    /**
     * Create an instance of {@link GetHelloResponse }
     * 
     */
    public GetHelloResponse createGetHelloResponse() {
        return new GetHelloResponse();
    }

    /**
     * Create an instance of {@link GetHelloWithAuth }
     * 
     */
    public GetHelloWithAuth createGetHelloWithAuth() {
        return new GetHelloWithAuth();
    }

    /**
     * Create an instance of {@link GetHello }
     * 
     */
    public GetHello createGetHello() {
        return new GetHello();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWithAuthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.proxy.devwithimagination.com/", name = "getHelloWithAuthResponse")
    public JAXBElement<GetHelloWithAuthResponse> createGetHelloWithAuthResponse(GetHelloWithAuthResponse value) {
        return new JAXBElement<GetHelloWithAuthResponse>(_GetHelloWithAuthResponse_QNAME, GetHelloWithAuthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.proxy.devwithimagination.com/", name = "getHello")
    public JAXBElement<GetHello> createGetHello(GetHello value) {
        return new JAXBElement<GetHello>(_GetHello_QNAME, GetHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloWithAuth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.proxy.devwithimagination.com/", name = "getHelloWithAuth")
    public JAXBElement<GetHelloWithAuth> createGetHelloWithAuth(GetHelloWithAuth value) {
        return new JAXBElement<GetHelloWithAuth>(_GetHelloWithAuth_QNAME, GetHelloWithAuth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.proxy.devwithimagination.com/", name = "getHelloResponse")
    public JAXBElement<GetHelloResponse> createGetHelloResponse(GetHelloResponse value) {
        return new JAXBElement<GetHelloResponse>(_GetHelloResponse_QNAME, GetHelloResponse.class, null, value);
    }

}
