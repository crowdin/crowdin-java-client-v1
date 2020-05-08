package com.crowdin.client;

import com.crowdin.Credentials;
import com.crowdin.exceptions.DirectoryNotFoundException;
import com.crowdin.exceptions.EmptyParameterException;
import com.crowdin.exceptions.UnAcceptableParametersValueException;
import com.crowdin.utils.HttpRequest;
import com.crowdin.utils.UrlBuilder;
import com.crowdin.parameters.CrowdinApiParametersBuilder;
import com.crowdin.parameters.CrowdinApiParametersValidator;
import com.sun.jersey.api.client.ClientResponse;

/**
 *
 * @author ihor <ihor.popyk@crowdin.com>
 */
public class CrowdinApiClientImpl implements CrowdinApiClient{

  public static final String REQUEST_TYPE_GET= "get";

  public static final String REQUEST_TYPE_POST= "post";

  public static final String REQUEST_TYPE_POST_UPLOAD= "upload";

  public static final String REQUEST_TYPE_POST_DOWNLOAD= "download";

  public static final String CROWDIN_API_ACCOUNT_PROJECTS_URL = "account/get-projects?account-key=%(account-key)";

  public static final String CROWDIN_API_ADD_DIRECTORY_URL = "project/%(project-identifier)/add-directory?key=%(project-key)";

  public static final String CROWDIN_API_ADD_FILE_URL = "project/%(project-identifier)/add-file?key=%(project-key)";

  public static final String CROWDIN_API_CHANGE_DIRECTORY_URL = "project/%(project-identifier)/change-directory?key=%(project-key)";

  public static final String CROWDIN_API_CREATE_PROJECT_URL = "account/create-project?account-key=%(account-key)";

  public static final String CROWDIN_API_DELETE_DIRECTORY_URL = "project/%(project-identifier)/delete-directory?key=%(project-key)";

  public static final String CROWDIN_API_DELETE_FILE_URL = "project/%(project-identifier)/delete-file?key=%(project-key)";

  public static final String CROWDIN_API_DELETE_PROJECT_URL = "project/%(project-identifier)/delete-project?key=%(project-key)";

  public static final String CROWDIN_API_DOWNLOAD_GLOSSARY_URL = "project/%(project-identifier)/download-glossary?key=%(project-key)";

  public static final String CROWDIN_API_DOWNLOAD_TM_URL = "project/%(project-identifier)/download-tm?key=%(project-key)";

  public static final String CROWDIN_API_DOWNLOAD_TRANSLATIONS_URL = "project/%(project-identifier)/download/%(download-package).zip?key=%(project-key)";

  public static final String CROWDIN_API_EDIT_PROJECT_URL = "project/%(project-identifier)/edit-project?key=%(project-key)";

  public static final String CROWDIN_API_EXPORT_FILE_URL = "project/%(project-identifier)/export-file?key=%(project-key)";

  public static final String CROWDIN_API_EXPORT_TRANSLATIONS_URL = "project/%(project-identifier)/export?key=%(project-key)";

  public static final String CROWDIN_API_LANGUAGE_STATUS_URL = "project/%(project-identifier)/language-status?key=%(project-key)";

  public static final String CROWDIN_API_PRE_TRANSLATE_URL = "project/%(project-identifier)/pre-translate?key=%(project-key)";

  public static final String CROWDIN_API_PROJECT_INFO_URL = "project/%(project-identifier)/info?key=%(project-key)";

  public static final String CROWDIN_API_PSEUDO_DOWNLOAD_URL = "project/%(project-identifier)/pseudo-download?key=%(project-key)";

  public static final String CROWDIN_API_PSEUDO_EXPORT_URL = "project/%(project-identifier)/pseudo-export?key=%(project-key)";

  public static final String CROWDIN_API_SUPPORTED_LANGUAGES_URL = "project/%(project-identifier)/supported-languages?key=%(project-key)";

  public static final String CROWDIN_API_TRANSLATION_STATUS_URL = "project/%(project-identifier)/status?key=%(project-key)";

  public static final String CROWDIN_API_UPLOAD_TRANSLATION_URL = "project/%(project-identifier)/upload-translation?key=%(project-key)";

  public static final String CROWDIN_API_UPDATE_FILE_URL = "project/%(project-identifier)/update-file?key=%(project-key)";

  public static final String CROWDIN_API_UPLOAD_GLOSSARY_URL = "project/%(project-identifier)/upload-glosssary?key=%(project-key)";

  public static final String CROWDIN_API_UPLOAD_TM_URL = "project/%(project-identifier)/upload-tm?key=%(project-key)";

  @Override
  public ClientResponse addDirectory(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getName() == null || params.getName().isEmpty()) {
      throw new EmptyParameterException("Parameter `NAME` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_ADD_DIRECTORY_URL, REQUEST_TYPE_POST);
    }
    return response;
  }

  @Override
  public ClientResponse addFile(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException{
    ClientResponse response;
    if (params.getFiles() == null || params.getFiles().isEmpty()) {
      throw new EmptyParameterException("Parameter `FILES` can not be empty");
    } else {
      response =  proccesing(credentials, params, CROWDIN_API_ADD_FILE_URL, REQUEST_TYPE_POST_UPLOAD);
    }
    return response;
  }

  @Override
  public ClientResponse changeDirectory(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getName() == null || params.getName().isEmpty()) {
      throw new EmptyParameterException("Parameter `NAME` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_CHANGE_DIRECTORY_URL, REQUEST_TYPE_POST);
    }
    return response;
  }

  @Override
  public ClientResponse createProject(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getLogin() == null || params.getLogin().isEmpty()) {
      throw new EmptyParameterException("Parameter `LOGIN` can not be empty");
    } else if (params.getName() == null || params.getName().isEmpty()) {
      throw new EmptyParameterException("Parameter `NAME` can not be empty");
    } else if (params.getIdentifier() == null || params.getIdentifier().isEmpty()) {
      throw new EmptyParameterException("Parameter `IDENTIFIER` can not be empty");
    } else if (params.getSourceLanguage() == null || params.getSourceLanguage().isEmpty()) {
      throw new EmptyParameterException("Parameter `SOURCE_LANGUAGE` can not be empty");
    } else if (params.getLanguages() == null || params.getLanguages().isEmpty()) {
      throw new EmptyParameterException("Parameter `LANGUAGES` can not be empty");
    } else if (params.getJoinPolicy() == null || params.getJoinPolicy().isEmpty()) {
      throw new EmptyParameterException("Parameter `JOIN_POLICY` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_CREATE_PROJECT_URL, REQUEST_TYPE_POST_UPLOAD);
    }
    return response;
  }

  @Override
  public ClientResponse deleteDirectory(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getName() == null || params.getName().isEmpty()) {
      throw new EmptyParameterException("Parameter `NAME` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_DELETE_DIRECTORY_URL, REQUEST_TYPE_POST);
    }
    return response;
  }

  @Override
  public ClientResponse deleteFile(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException{
    ClientResponse response;
    if (params.getFile() == null || params.getFile().isEmpty()) {
      throw new EmptyParameterException("Parameter `FILE` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_DELETE_FILE_URL, REQUEST_TYPE_POST);
    }
    return response;
  }

  @Override
  public ClientResponse deleteProject(Credentials credentials, CrowdinApiParametersBuilder params) {
    return proccesing(credentials, params, CROWDIN_API_DELETE_PROJECT_URL, REQUEST_TYPE_GET);
  }

  @Override
  public ClientResponse downloadGlossary(Credentials credentials, CrowdinApiParametersBuilder params) {
    return proccesing(credentials, params, CROWDIN_API_DOWNLOAD_GLOSSARY_URL, REQUEST_TYPE_GET);
  }

  @Override
  public ClientResponse downloadTM(Credentials credentials, CrowdinApiParametersBuilder params) {
    return proccesing(credentials, params, CROWDIN_API_DOWNLOAD_TM_URL, REQUEST_TYPE_GET);
  }

  @Override
  public ClientResponse downloadTranslations(Credentials credentials, CrowdinApiParametersBuilder params) {
    return proccesing(credentials, params, CROWDIN_API_DOWNLOAD_TRANSLATIONS_URL, REQUEST_TYPE_POST_DOWNLOAD);
  }

  @Override
  public ClientResponse editProject(Credentials credentials, CrowdinApiParametersBuilder params) {
    String requestType;
    if (params.getLogo() != null) {
      requestType = REQUEST_TYPE_POST_UPLOAD;
    } else {
      requestType = REQUEST_TYPE_POST;
    }
    return proccesing(credentials, params, CROWDIN_API_EDIT_PROJECT_URL, requestType);
  }

  @Override
  public ClientResponse exportFile(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getFile() == null || params.getFile().isEmpty()) {
      throw new EmptyParameterException("Parameter `FILE` can not be empty");
    } else if (params.getLanguage() == null || params.getLanguage().isEmpty()) {
      throw new EmptyParameterException("Parameter `LANGUAGE` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_EXPORT_FILE_URL, REQUEST_TYPE_GET);
    }
    return response;
  }

  @Override
  public ClientResponse exportTranslations(Credentials credentials, CrowdinApiParametersBuilder params) {
    return proccesing(credentials, params, CROWDIN_API_EXPORT_TRANSLATIONS_URL, REQUEST_TYPE_GET);
  }

  @Override
  public ClientResponse getAccountProject(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getLogin() == null || params.getLogin().isEmpty()) {
      throw new EmptyParameterException("Parameter `LOGIN` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_ACCOUNT_PROJECTS_URL, REQUEST_TYPE_POST);
    }
    return response;
  }

  @Override
  public ClientResponse getLanguageStatus(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getLanguage() == null || params.getLanguage().isEmpty()) {
      throw new EmptyParameterException("Parameter `LANGUAGE` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_LANGUAGE_STATUS_URL, REQUEST_TYPE_POST);
    }
    return response;
  }

  @Override
  public ClientResponse getInfo(Credentials credentials, CrowdinApiParametersBuilder params) {
    return proccesing(credentials, params, CROWDIN_API_PROJECT_INFO_URL, REQUEST_TYPE_GET);
  }

  @Override
  public ClientResponse getSupportedLanguages(Credentials credentials, CrowdinApiParametersBuilder params) {
    return proccesing(credentials, params, CROWDIN_API_SUPPORTED_LANGUAGES_URL, REQUEST_TYPE_POST);
  }

  @Override
  public ClientResponse getTranslationStatus(Credentials credentials, CrowdinApiParametersBuilder params) {
    return proccesing(credentials, params, CROWDIN_API_TRANSLATION_STATUS_URL, REQUEST_TYPE_POST);
  }

  @Override
  public ClientResponse preTranslate(Credentials credentials, CrowdinApiParametersBuilder parameters) throws EmptyParameterException {
    ClientResponse response;
    if (parameters.getFiles() == null || parameters.getFiles().isEmpty()) {
      throw new EmptyParameterException("Parameter `FILES` can not be empty");
    } else if (parameters.getLanguages() == null || parameters.getLanguages().isEmpty()) {
      throw new EmptyParameterException("Parameters `LANGUAGES` can not be empty");
    } else {
      response =  proccesing(credentials, parameters, CROWDIN_API_PRE_TRANSLATE_URL, REQUEST_TYPE_POST);
    }
    return response;
  }

  @Override
  public ClientResponse pseudoDownload(Credentials credentials, CrowdinApiParametersBuilder parameters) {
    return proccesing(credentials, parameters, CROWDIN_API_PSEUDO_DOWNLOAD_URL, REQUEST_TYPE_GET);
  }

  @Override
  public ClientResponse pseudoExport(Credentials credentials, CrowdinApiParametersBuilder parameters) {
    return proccesing(credentials, parameters, CROWDIN_API_PSEUDO_EXPORT_URL, REQUEST_TYPE_GET);
  }

  @Override
  public ClientResponse updateFile(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getFiles() == null || params.getFiles().isEmpty()) {
      throw new EmptyParameterException("Parameter `FILES` can not be empty");
    } else {
      response =  proccesing(credentials, params, CROWDIN_API_UPDATE_FILE_URL, REQUEST_TYPE_POST_UPLOAD);
    }
    return response;
  }

  @Override
  public ClientResponse uploadGlossary(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getFile() == null || params.getFile().isEmpty()) {
      throw new EmptyParameterException("Parameter `FILE` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_UPLOAD_GLOSSARY_URL, REQUEST_TYPE_POST_UPLOAD);
    }
    return response;
  }

  @Override
  public ClientResponse uploadTM(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getFile() == null || params.getFile().isEmpty()) {
      throw new EmptyParameterException("Parameter `FILE` can not be empty");
    } else {
      response = proccesing(credentials, params, CROWDIN_API_UPLOAD_TM_URL, REQUEST_TYPE_POST_UPLOAD);
    }
    return response;
  }

  @Override
  public ClientResponse uploadTranslations(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException {
    ClientResponse response;
    if (params.getFiles() == null || params.getFiles().isEmpty()) {
      throw new EmptyParameterException("Parameter `FILES` can not be empty");
    } else if (params.getLanguage() == null || params.getLanguage().isEmpty()) {
      throw new EmptyParameterException("Parameter `LANGUAGE` can not be empty");
    } else {
      response =  proccesing(credentials, params, CROWDIN_API_UPLOAD_TRANSLATION_URL, REQUEST_TYPE_POST_UPLOAD);
    }
    return response;
  }

  /**
   *
   * @param credentials
   * @param params
   * @param crowdinApiUrl
   * @param requestType
   * @return String
   */
  private ClientResponse proccesing(Credentials credentials, CrowdinApiParametersBuilder params, String crowdinApiUrl, String requestType) {
    HttpRequest request = new HttpRequest();
    UrlBuilder builder = new UrlBuilder();
    String url = null;
    try {
      url = builder.build(credentials.getBaseUrl(), crowdinApiUrl, credentials.getProjectIdentifier(), credentials.getProjectKey(), params.getDownloadPackage(), credentials.getAccountKey(), params.getExportLanguage());
    } catch (EmptyParameterException ex) {
    }
    CrowdinApiParametersValidator parameters = new CrowdinApiParametersValidator();
    ClientResponse response = null;

    try {
      if (requestType != null && REQUEST_TYPE_POST_UPLOAD.equalsIgnoreCase(requestType)) {
        response = request.post(url, parameters.validate(params), REQUEST_TYPE_POST_UPLOAD);
      } else if (requestType != null && REQUEST_TYPE_POST.equalsIgnoreCase(requestType)) {
        response = request.post(url, parameters.validate(params), null);
      } else if (requestType != null && REQUEST_TYPE_POST_DOWNLOAD.equalsIgnoreCase(requestType)) {
        response = request.post(url, parameters.validate(params), REQUEST_TYPE_POST_DOWNLOAD);
      } else {
        response = request.get(url, parameters.validate(params));
      }
    } catch (DirectoryNotFoundException ex) {
    } catch (UnAcceptableParametersValueException ex) {
    }
    return response;
  }

}
