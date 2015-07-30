package com.devwithimagination.proxy.client;

import java.net.MalformedURLException;
import java.net.URL;

import com.devwithimagination.proxy.ws.one.HelloWS;
import com.devwithimagination.proxy.ws.one.HelloWS_Service;
import com.devwithimagination.proxy.ws.three.WarWSService;
import com.devwithimagination.proxy.ws.two.HelloTwoWS;
import com.devwithimagination.proxy.ws.two.HelloTwoWS_Service;

public class TestClient {

	private static String DIRECT_HTTPS_GF3_SERVER = "https://dev-gf3.local/";
	private static String DIRECT_HTTPS_GF4_SERVER = "https://dev-gf4.local/";
	private static String DIRECT_HTTPS_PROXY_SERVER = "https://dev-lamp.local/";
	private static String PROXY_SERVER_AJP_GF3 = "https://dev-lamp.local/earajp3/";
	private static String PROXY_SERVER_AJP_GF4 = "https://dev-lamp.local/earajp4/";
	private static String PROXY_SERVER_HTTPS_GF3 = "https://dev-lamp.local/earhttpcustomhandler3/";
	private static String PROXY_SERVER_HTTPS_GF4 = "https://dev-lamp.local/earhttpcustomhandler4/";
	
	public TestClient() {
	
		
		
		
	}
	
	public void doTests() {
		
		try {
			testOne(DIRECT_HTTPS_GF3_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			testOne(DIRECT_HTTPS_GF3_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testOne(PROXY_SERVER_AJP_GF3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testOne(PROXY_SERVER_AJP_GF4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testOne(DIRECT_HTTPS_PROXY_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* This fails as the WS is configured to require HTTPS  */
//		try {
//			Thread.sleep(1000);
//			
//			testOne(PROXY_SERVER_HTTPS_GF3);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		/* This fails as the WS is configured to require HTTPS but we are attempting to proxy to HTTP, this results in a redirect */
//		try {
//			Thread.sleep(1000);
//			
//			testOne(PROXY_SERVER_HTTPS_GF4);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		try {
			Thread.sleep(1000);
			
			testTwo(DIRECT_HTTPS_GF3_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testTwo(DIRECT_HTTPS_GF4_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testTwo(PROXY_SERVER_AJP_GF3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testTwo(PROXY_SERVER_AJP_GF4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			Thread.sleep(1000);
//			
//			testTwo(PROXY_SERVER_HTTPS);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			testThree(DIRECT_HTTPS_GF3_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			testThree(DIRECT_HTTPS_GF3_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testThree(PROXY_SERVER_AJP_GF3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			
			testThree(PROXY_SERVER_AJP_GF4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* This fails with a 500 error - null pointer in apache connector */
//		try {
//			Thread.sleep(1000);
//			
//			testThree(DIRECT_HTTPS_PROXY_SERVER);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		/* This fails as the WS is configured to require HTTPS  */
		try {
			Thread.sleep(1000);
			
			testThree(PROXY_SERVER_HTTPS_GF3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/* This fails as the WS is configured to require HTTPS but we are attempting to proxy to HTTP, this results in a redirect */
		try {
			Thread.sleep(1000);
			
			testThree(PROXY_SERVER_HTTPS_GF4);
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
		
		
		try {
			String result = port.getHelloWithAuth(sourceString);
			System.out.println("Result 2-1: " + result);
			System.out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(1000);
			String result = port.getHello(sourceString);
			System.out.println("Result 2-2: " + result);
			System.out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void testThree(String server) throws MalformedURLException {
		
		URL url = new URL(server + "WarWSService?wsdl");
		String sourceString = "Testing 3: " + url;
		System.out.println("Source 3: " + sourceString);
		System.out.flush();
		
		WarWSService service = new WarWSService(url);
		com.devwithimagination.proxy.ws.three.WarWS port = service.getWarWSPort();
		
		
		
		String result = port.getHello(sourceString);
		System.out.println("Result 3: " + result);
		System.out.flush();
	}
	
	
	
	public static void main(String[] args) {
	
		TestClient testClient = new TestClient();
		testClient.doTests();
		
	}
	
}
