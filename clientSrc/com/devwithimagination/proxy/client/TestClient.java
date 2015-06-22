package com.devwithimagination.proxy.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.devwithimagination.proxy.ws.one.HelloWS;
import com.devwithimagination.proxy.ws.one.HelloWS_Service;
import com.devwithimagination.proxy.ws.two.HelloTwoWS;
import com.devwithimagination.proxy.ws.two.HelloTwoWS_Service;

public class TestClient {

	private static String DIRECT_HTTPS_SERVER = "https://dev-ws.local/";
	private static String DIRECT_HTTP_SERVER = "http://dev-ws.local/";
	private static String PROXY_SERVER_AJP = "https://dev-lamp.local/earajp/";
	private static String PROXY_SERVER_HTTPS = "https://dev-lamp.local/earhttpcustomhandler/";
	
	public TestClient() {
	
		
		
		
	}
	
	public void doTests() {
		
		try {
			testOne(DIRECT_HTTPS_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testOne(PROXY_SERVER_AJP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testOne(PROXY_SERVER_HTTPS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testTwo(DIRECT_HTTP_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testTwo(PROXY_SERVER_AJP);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testTwo(PROXY_SERVER_HTTPS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void testOne(String server) throws MalformedURLException {
		
		URL url = new URL(server + "HelloWS?wsdl");
		String sourceString = "Testing 1: " + url;
		System.out.println("Source 1: " + sourceString);
		System.out.flush();
		
		HelloWS_Service service = new HelloWS_Service(url);
		HelloWS port = service.getHelloWSPort();
		
		
		
		String result = port.getHelloWithAuth(sourceString);
		System.out.println("Result 1: " + result);
		System.out.flush();
	}
	
	private void testTwo(String server) throws MalformedURLException {
		
		URL url = new URL(server + "HelloTwoWS?wsdl");
		String sourceString = "Testing 2: " + url;
		System.out.println("Source 2: " + sourceString);
		System.out.flush();
		
		HelloTwoWS_Service service = new HelloTwoWS_Service(url);
		HelloTwoWS port = service.getHelloTwoWSPort();
		
		
		
		String result = port.getHelloWithAuth(sourceString);
		System.out.println("Result 2: " + result);
		System.out.flush();
		
		
	}
	
	
	
	public static void main(String[] args) {
	
		TestClient testClient = new TestClient();
		testClient.doTests();
		
	}
	
}
