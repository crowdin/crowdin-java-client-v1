package com.crowdin.utils;

import com.sun.jersey.client.urlconnection.HttpURLConnectionFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class ConnectionFactory implements HttpURLConnectionFactory {

    public static final String HTTP_PROXY_HOST = "HTTP_PROXY_HOST";
    public static final String HTTP_PROXY_PORT = "HTTP_PROXY_PORT";

    Proxy proxy;

    private void initializeProxy() {
        if (System.getenv(HTTP_PROXY_HOST) != null) {
            String proxyHost = System.getenv(HTTP_PROXY_HOST);
            Integer proxyPort = 80;
            if (System.getenv(HTTP_PROXY_PORT) != null) {
                proxyPort = Integer.valueOf(System.getenv(HTTP_PROXY_PORT));
            }
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
        }
    }

    public HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        initializeProxy();
        if (proxy != null) {
            return (HttpURLConnection) url.openConnection(proxy);
        } else {
            return (HttpURLConnection) url.openConnection();
        }
    }

}
