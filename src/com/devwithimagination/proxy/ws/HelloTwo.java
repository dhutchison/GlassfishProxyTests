
package com.devwithimagination.proxy.ws;

import java.security.Principal;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService(name="HelloTwoWS", serviceName="HelloTwoWS")
@Stateless(name="com.devwithimagination.proxy.ws.HelloTwo")
public class HelloTwo {
	
	@Resource
	private WebServiceContext wsContext;
	
    public String getHello(String name) {
    	
    	StringBuilder response = new StringBuilder();
    	response.append("Hello " + name + "!");
    	response.append(getInfo());
    	
    	
    	return response.toString();
    }
    
    @RolesAllowed("master-technician")
    public String getHelloWithAuth(String name) {
    	StringBuilder response = new StringBuilder();
    	response.append("Hello authenticated " + name + "!");
    	response.append(getInfo());
    	
    	
    	return response.toString();
    }
    
    private String getInfo() {
    	
    	Principal userPrincipal = wsContext.getUserPrincipal();
    	
    	String info;
    	
    	if(userPrincipal != null) {
    		info = "Principal is " + userPrincipal.getName();
    	} else {
    		info = "NULL principal";
    	}
    	
    	return info;
    }
}


