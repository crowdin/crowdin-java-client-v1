package com.crowdin.utils;

import com.crowdin.parameters.CrowdinApiParameters;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import com.sun.jersey.multipart.impl.MultiPartWriter;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ihor <ihor.popyk@crowdin.com>
 */
public class HttpRequest {
  
  public static final String FILE_EXTENTION_ZIP = ".zip";
  
  public static final String REQUEST_POST_EXPANDED_UPLOAD = "upload";
  
  public static final String REQUEST_POST_EXPANDED_DOWNLOAD = "download";
  
  public static final String OPEN_BRACKET = "[";
  
  public static final String CLOSE_BRACKET = "]";

  public static final String HTTP_PROXY_HOST = "HTTP_PROXY_HOST";

  public static final String HTTP_PROXY_PORT = "HTTP_PROXY_PORT";
  
  /**
   *
   * @param url
   * @param parameters
   * @return String
   */
  public ClientResponse get(String url, MultivaluedMap<String, String> parameters) {
    URLConnectionClientHandler urlConnectionClientHandler  = new URLConnectionClientHandler(new ConnectionFactory());
    Client client = new Client(urlConnectionClientHandler);
    WebResource webResource = client.resource(url);
    webResource = webResource.queryParams(parameters);
    ClientResponse response = webResource.get(ClientResponse.class);
    return response;
  }
  
  /**
   *
   * @param url
   * @param parameters
   * @param type
   * @return String
   */
  public ClientResponse post(String url, MultivaluedMap<String, String> parameters, String type) {
    URLConnectionClientHandler urlConnectionClientHandler  = new URLConnectionClientHandler(new ConnectionFactory());
    Client client = new Client(urlConnectionClientHandler);
    ClientResponse clientResponse;
    WebResource webResource = client.resource(url);
    if (type != null && REQUEST_POST_EXPANDED_UPLOAD.equalsIgnoreCase(type)) {
      clientResponse = uploadFiles(parameters, url);
    } else if (type != null && REQUEST_POST_EXPANDED_DOWNLOAD.equalsIgnoreCase(type)) {
      webResource = webResource.queryParams(parameters);
      clientResponse = webResource.post(ClientResponse.class);
      clientResponse = downloadFiles(parameters, clientResponse);
    } else {
      webResource = webResource.queryParams(parameters);
      clientResponse = webResource.post(ClientResponse.class);
    }
    return clientResponse;
  }
  
  private ClientResponse uploadFiles(MultivaluedMap<String, String> parameters, String url) {
    DefaultClientConfig clientConfig = new DefaultClientConfig();
    clientConfig.getClasses().add(MultiPartWriter.class);
    if (System.getenv(HTTP_PROXY_HOST) != null) {
      String proxyHost = System.getenv(HTTP_PROXY_HOST);
      Integer proxyPort = 80;
      if (System.getenv(HTTP_PROXY_PORT) != null) {
        proxyPort = Integer.valueOf(System.getenv(HTTP_PROXY_PORT));
      }
      clientConfig.getProperties().put("jersey.config.client.proxy.uri", proxyHost + ":" + proxyPort);
    }
    Client client = Client.create(clientConfig);
    FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
    ClientResponse clientResponse = null;
    WebResource webResource;
    if (parameters.size() > 0) {
      webResource = client.resource(url);
      for (Map.Entry<String, List<String>> parameter : parameters.entrySet()) {
        if (parameter.getKey().startsWith(CrowdinApiParameters.FILES)) {
          File file = new File(parameter.getValue().get(0));
          String crowdinPath = CrowdinApiParameters.FILES + OPEN_BRACKET + file.getName() + CLOSE_BRACKET;
          for (Map.Entry<String, List<String>> title : parameters.entrySet()) {
            if (title.getKey().startsWith(CrowdinApiParameters.TITLES)) {
              if (parameter.getValue().get(0) != null && title.getKey() != null 
                      && parameter.getKey().replaceFirst(CrowdinApiParameters.FILES, "").equals(title.getKey().replaceFirst(CrowdinApiParameters.TITLES, "")) ) {
                crowdinPath = CrowdinApiParameters.FILES + OPEN_BRACKET + title.getValue().get(0) + CLOSE_BRACKET;
              }
            }
          }
          formDataMultiPart.bodyPart(new FileDataBodyPart(crowdinPath, file, MediaType.APPLICATION_OCTET_STREAM_TYPE));
        } else {
          if (CrowdinApiParameters.FILE.equalsIgnoreCase(parameter.getKey())) {
            File file = new File(parameter.getValue().get(0));
            formDataMultiPart.bodyPart(new FileDataBodyPart(CrowdinApiParameters.FILE, file, MediaType.APPLICATION_OCTET_STREAM_TYPE));
          } else if (CrowdinApiParameters.LOGO.equalsIgnoreCase(parameter.getKey())) {
            File file = new File(parameter.getValue().get(0));
            formDataMultiPart.bodyPart(new FileDataBodyPart(CrowdinApiParameters.LOGO, file, MediaType.APPLICATION_OCTET_STREAM_TYPE));
          } else {
            webResource = webResource.queryParam(parameter.getKey(), parameter.getValue().get(0));
          }
        }
      }
      if (formDataMultiPart.getBodyParts() != null && formDataMultiPart.getBodyParts().size() > 0) {
        clientResponse = webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE)
                                    .post(ClientResponse.class, formDataMultiPart);
      } else {
        clientResponse = webResource.type(MediaType.MULTIPART_FORM_DATA_TYPE)
                                    .post(ClientResponse.class);
      }
    }
    return clientResponse;
  }
  
  private ClientResponse downloadFiles(MultivaluedMap<String, String> parameters, ClientResponse clientResponse) {
    File file = new File(parameters.getFirst(CrowdinApiParameters.DESTINATION_FOLDER) + parameters.getFirst(CrowdinApiParameters.DOWNLOAD_PACKAGE) + FILE_EXTENTION_ZIP);
    InputStream inputStream = clientResponse.getEntity(InputStream.class);
    try {
      Files.copy(inputStream, file.toPath());
    } catch (IOException ex) {
    }
    return clientResponse;
  }
  
}