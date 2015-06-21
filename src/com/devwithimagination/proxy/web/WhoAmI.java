package com.devwithimagination.proxy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/whoami")
public class WhoAmI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/plain");

            final PrintWriter out = new PrintWriter(response.getOutputStream());
            final String remoteUser = request.getRemoteUser();
            out.println("AuthType: " + request.getAuthType());

            out.println("Remote user: "+remoteUser);
            out.println("User in role? "+request.isUserInRole("master-technician"));

            out.println("Proxy IP: " + request.getHeader("Proxy-ip"));
            out.println("Proxy-keysize: " + request.getHeader("Proxy-keysize"));
            out.println("Proxy-auth-cert: " + request.getHeader("Proxy-auth-cert"));
            
//            String header = request.getHeader("Proxy-auth-cert");
//            if(header != null) {
//            	for (int i=0; i<header.length(); i++) {
//            		char c = header.charAt(i);
//            		System.out.println(Character.toString(c) + " " + ((int)c));
//            	}
//            }
//            
//            System.out.println("Header: \n" + header);
            
            Object certificate = request.getAttribute("javax.servlet.request.X509Certificate");
            out.println("Certificate: " + certificate);
            if (certificate != null){
            	out.println("Certificate is a " + certificate.getClass().getName());
            	
            	if(certificate.getClass().isArray()) {
            		Object[] array = (Object[]) certificate;
            		
            		for(Object o : array) {
            			if (o instanceof X509Certificate) {
                        	X509Certificate xcert = (X509Certificate) o;
                        	out.println("X509Certificate: " + o);
                        	
                        	X500Principal subjectX500Principal = xcert.getSubjectX500Principal();
                        	if (subjectX500Principal != null) {
                        		out.println("Cert principal: " + subjectX500Principal.getName());
                        	}
                        }
            		}
            	}
            }
            
            
            
            out.println();

            final Principal principal = request.getUserPrincipal();
            final String name = (principal != null ? principal.getName() : "(null principal)");
            out.println(name); 
            out.println( principal );
            out.println();
            out.flush();
    }
}

