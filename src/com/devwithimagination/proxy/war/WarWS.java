package com.devwithimagination.proxy.war;

import java.security.Principal;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;


@WebService
public class WarWS {
	
	@Resource
	private WebServiceContext wsContext;
	
	@RolesAllowed("master-technician")
    public String getHello(String name) {
        return "Hello " + name + "! " + getInfo();
    }
    
    private String getInfo() {
    	
    	Principal userPrincipal = wsContext.getUserPrincipal();
    	
    	String info;
    	
    	if(userPrincipal != null) {
    		info = "Principal is " + userPrincipal.getName();
    	} else {
    		info = "NULL principal";
    	}
    	
    	info += " in the role? " + wsContext.isUserInRole("master-technician");
    	
    	return info;
    }
}
