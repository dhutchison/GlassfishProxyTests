package com.devwithimagination.proxy.handler;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sun.appserv.ProxyHandler;

public class ApacheProxyHandler extends ProxyHandler {

	@Override
	public X509Certificate[] getSSLClientCertificateChain(
			HttpServletRequest request) throws CertificateException {

		/* Pull the certificates out of the headers in the format used by Apache */
		List<X509Certificate> certs = new ArrayList<X509Certificate>();

		for (int i = 0; i < 3; i++) {

			X509Certificate clientCert = getCert(request,
					"PROXY-SSL_CLIENT_CERT_CHAIN_" + i);
			if (clientCert != null) {
				certs.add(clientCert);
			}
		}

		if (certs.isEmpty()) {
			/* Fallback */
			X509Certificate clientCert = getCert(request,
					"PROXY-SSL_CLIENT_CERT");
			if (clientCert != null) {
				certs.add(clientCert);
			}
		}

		X509Certificate[] certArray = null;
		if (!certs.isEmpty()) {
			certArray = certs.toArray(new X509Certificate[certs.size()]);
		}

		return certArray;
	}

	private X509Certificate getCert(HttpServletRequest request,
			String headerName) throws CertificateException {

		X509Certificate cert = null;

		String clientCert = request.getHeader(headerName);
		System.out.println("Header: " + headerName);
		if (clientCert != null && !"(null)".equals(clientCert)) {

			System.out.println("Certificate: \n\"" + clientCert + "\"");

			clientCert = clientCert.replaceAll("(?<!(BEGIN|END)) ", "\n");
			
			System.out.println("Certificate (post change): \n\"" + clientCert + "\"");
			byte[] certBytes = null;
			try {
				certBytes = clientCert.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			ByteArrayInputStream bais = new ByteArrayInputStream(certBytes);
			CertificateFactory cf = CertificateFactory.getInstance("X.509");

			cert = (X509Certificate) cf.generateCertificate(bais);
			
			System.out.println("Loaded certificate: \n" + cert);
		} else {
			System.out.println("Null cert");
		}

		return cert;

	}

	@Override
	public int getSSLKeysize(HttpServletRequest request) {
		/* Just get this from the same header as the default implementation */

		int keySize = -1;

		String header = request.getHeader("Proxy-keysize");
		if (header != null) {
			keySize = Integer.parseInt(header);
		}

		return keySize;
	}

	@Override
	public String getRemoteAddress(HttpServletRequest request) {
		/* Just get this from the same header as the default implementation */
		return request.getHeader("Proxy-ip");
	}
}
