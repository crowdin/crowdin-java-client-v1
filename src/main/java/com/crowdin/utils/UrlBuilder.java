package com.crowdin.utils;

import com.crowdin.exceptions.EmptyParameterException;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ihor
 */
public class UrlBuilder {
  
  private static final String PROJECT_IDENTIFIER_PATTERN = "project-identifier";
  
  private static final String PROJECT_KEY_PATTERN = "project-key";
  
  private static final String DOWNLOAD_PACKAGE_PATTERN = "download-package";
  
  private static final String ACCOUNT_KEY_PATTERN = "account-key";
  
  private static final String EXPORT_LANGUAGE_PATTERN = "export-language";
  
  private static final String PLACEHOLDER_START = "%(";
  
  private static final String PLACEHOLDER_END = ")";
  
  /**
   *
   * @param baseUrl
   * @param path
   * @param projectIdentifier
   * @param projectKey
   * @param downloadPackage
   * @param accountKey
   * @param exportLanguage
   * @return String
   * @throws com.crowdin.exceptions.EmptyParameterException
   */
  public String build(String baseUrl, String path, String projectIdentifier, String projectKey, String downloadPackage, String accountKey, String exportLanguage) 
          throws EmptyParameterException {
    if (baseUrl == null || "".equalsIgnoreCase(baseUrl) || baseUrl.isEmpty()) {
      throw new EmptyParameterException("Parameter 'baseUrl' is empty");
    }
    if (path == null || "".equalsIgnoreCase(path) || path.isEmpty()) {
      throw new EmptyParameterException("Parameter 'path' is empty");
    }
    if (path.contains(PROJECT_IDENTIFIER_PATTERN) 
            && (projectIdentifier == null || "".equalsIgnoreCase(projectIdentifier) || projectIdentifier.isEmpty())) {
      throw new EmptyParameterException("Parameter 'projectIdentifier' is empty");
    }
    if (path.contains(PROJECT_KEY_PATTERN) 
            && (projectKey == null || "".equalsIgnoreCase(projectKey) || projectKey.isEmpty())) {
      throw new EmptyParameterException("Parameter 'projectKey' is empty");
    }
    if (path.contains(DOWNLOAD_PACKAGE_PATTERN) 
            && (downloadPackage == null || "".equalsIgnoreCase(downloadPackage) || downloadPackage.isEmpty())) {
      throw new EmptyParameterException("Parameter 'downloadPackage' is empty");
    }
    if (path.contains(ACCOUNT_KEY_PATTERN) 
            && (accountKey == null || "".equalsIgnoreCase(accountKey) || accountKey.isEmpty())) {
      throw new EmptyParameterException("Parameter 'accountKey' is empty");
    }
    if (path.contains(EXPORT_LANGUAGE_PATTERN) 
            && (exportLanguage == null || "".equalsIgnoreCase(exportLanguage) || exportLanguage.isEmpty())) {
      exportLanguage = "";
    }
    StringBuilder url = new StringBuilder();
    url.append(baseUrl);
    
    Map<String, String> parameters = new HashMap<>();
    parameters.put(PROJECT_IDENTIFIER_PATTERN, projectIdentifier);
    parameters.put(PROJECT_KEY_PATTERN, projectKey);
    parameters.put(ACCOUNT_KEY_PATTERN, accountKey);
    parameters.put(DOWNLOAD_PACKAGE_PATTERN, downloadPackage);
    parameters.put(EXPORT_LANGUAGE_PATTERN, exportLanguage);
    
    StrSubstitutor strSubstitutor = new StrSubstitutor(parameters, PLACEHOLDER_START, PLACEHOLDER_END);
    url.append(strSubstitutor.replace(path));
    
    return url.toString();
  }
  
}