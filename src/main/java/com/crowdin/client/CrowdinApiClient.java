package com.crowdin.client;

import com.crowdin.Credentials;
import com.crowdin.exceptions.EmptyParameterException;
import com.crowdin.parameters.CrowdinApiParametersBuilder;
import com.sun.jersey.api.client.ClientResponse;

/**
 *
 * @author ihor <ihor.popyk@crowdin.com>
 * @see https://crowdin.com/page/api
 */
public interface CrowdinApiClient {
  
  /**
   * Add directory to Crowdin project.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/add-directory
   * 
   */
  public ClientResponse addDirectory(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Add new file to Crowdin project.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/add-file
   */
  public ClientResponse addFile(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Rename directory or modify its attributes. 
   * When renaming directory the path can not be changed (it means new_name parameter can not contain path, name only).
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/change-directory
   */
  public ClientResponse changeDirectory(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Create Crowdin project.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/create-project
   */
  public ClientResponse createProject(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Delete Crowdin project directory. 
   * All nested files and directories will be deleted too.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/delete-directory
   */
  public ClientResponse deleteDirectory(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Delete file from Crowdin project.
   * All the translations will be lost without ability to restore them.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/delete-file
   */
  public ClientResponse deleteFile(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Delete Crowdin project with all translations.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/delete-project
   */
  public ClientResponse deleteProject(Credentials credentials, CrowdinApiParametersBuilder params);
  
  /**
   * Download Crowdin project glossaries as TBX file.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/download-glossary
   */
  public ClientResponse downloadGlossary(Credentials credentials, CrowdinApiParametersBuilder params);
  
  /**
   * Download Crowdin project Translation Memory as TMX file.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/download-tm
   */
  public ClientResponse downloadTM(Credentials credentials, CrowdinApiParametersBuilder params);
  
  /**
   * Download ZIP file with translations.
   * You can choose the language of translation you need or download all of them at once.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/download
   */
  public ClientResponse downloadTranslations(Credentials credentials, CrowdinApiParametersBuilder params);
  
  /**
   * Edit Crowdin project.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/edit-project
   */
  public ClientResponse editProject (Credentials credentials, CrowdinApiParametersBuilder params);
  
  /**
   * This method exports single translated files from Crowdin. Additionally, it can be applied to export XLIFF files for offline localization.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/export-file
   */
  public ClientResponse exportFile(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Build ZIP archive with the latest translations. 
   * Please note that this method can be invoked only once per 30 minutes 
   * (there is no such restriction for organization plans). 
   * Also API call will be ignored if there were no changes in the project since previous export. 
   * You can see whether ZIP archive with latest translations was actually build by status attribute 
   * ("built" or "skipped") returned in response.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/export
   */
  public ClientResponse exportTranslations(Credentials credentials, CrowdinApiParametersBuilder params);
  
  /**
   * Get Crowdin Project details.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/get-projects
   */
  public ClientResponse getAccountProject(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Get Crowdin Project details.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/info
   */
  public ClientResponse getInfo(Credentials credentials, CrowdinApiParametersBuilder params);
  
  /**
   * Get the detailed translation progress for specified language.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/language-status
   */
  public ClientResponse getLanguageStatus(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Get supported languages list with Crowdin codes mapped to locale name and standardized codes.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/supported-languages
   */
  public ClientResponse getSupportedLanguages(Credentials credentials, CrowdinApiParametersBuilder params);
  
  /**
   * Track overall translation and proofreading progresses of each target language.
   * Default response format is XML.
   *
   * @param credentials
   * @param params
   * @return ClientResponse
   * @see https://support.crowdin.com/api/status
   */
  public ClientResponse getTranslationStatus(Credentials credentials, CrowdinApiParametersBuilder params);


  /**
   * Pre-translate Crowdin project files.
   *
   * @param credentials
   * @param parameters
   * @return ClientResponse
   * @see https://support.crowdin.com/api/pre-translate/
   *
   */
  public ClientResponse preTranslate(Credentials credentials, CrowdinApiParametersBuilder parameters) throws EmptyParameterException;

    /**
     * Download ZIP file with pseudo translations.
     *
     * @param credentials
     * @param parameters
     * @return ClientResponse
     * @see https://support.crowdin.com/api/pseudo-download/
     *
     */
  public ClientResponse pseudoDownload(Credentials credentials, CrowdinApiParametersBuilder parameters);

    /**
     * Download ZIP file with pseudo translations.
     *
     * @param credentials
     * @param parameters
     * @return ClientResponse
     * @see https://support.crowdin.com/api/pseudo-export/
     *
     */
  public ClientResponse pseudoExport(Credentials credentials, CrowdinApiParametersBuilder parameters);
  
  /**
   * Upload latest version of your localization file to Crowdin.
   *
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/update-file
   */
  public ClientResponse updateFile(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Upload your glossaries for Crowdin Project in TBX, CSV or XLS/XLSX file formats.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/upload-glossary
   */
  public ClientResponse uploadGlossary(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
  /**
   * Upload your Translation Memory for Crowdin Project in TMX file format.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/upload-tm
   */
  public ClientResponse uploadTM(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
 
  /**
   * Upload existing translations to your Crowdin project.
   * 
   * @param credentials
   * @param params
   * @return ClientResponse
   * @throws com.crowdin.exceptions.EmptyParameterException
   * @see https://support.crowdin.com/api/upload-translation
   *
   */
  public ClientResponse uploadTranslations(Credentials credentials, CrowdinApiParametersBuilder params) throws EmptyParameterException;
  
}