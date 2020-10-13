package com.crowdin.parameters;

import com.crowdin.exceptions.DirectoryNotFoundException;
import com.crowdin.exceptions.UnAcceptableParametersValueException;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MultivaluedMap;
import java.io.File;
import java.util.Map;

/**
 *
 * @author ihor <ihor.popyk@crowdin.com>
 */
public class CrowdinApiParametersValidator {
  
  public static final String TRUE_VALUE = "1";
  
  public static final String FALSE_VALUE = "0";
  
  public static final String OPEN_BRACKET = "[";
  
  public static final String CLOSE_BRACKET = "]";
  
  public static final String OPEN = "open";
  
  public static final String PRIVATE = "private";
  
  public static final String MODERATE = "moderate";
  
  /**
   *
   * @param parameters
   * @return
   * @throws com.crowdin.exceptions.DirectoryNotFoundException
   * @throws com.crowdin.exceptions.UnAcceptableParametersValueException
   */
  public MultivaluedMap<String, String> validate (CrowdinApiParametersBuilder parameters) 
          throws DirectoryNotFoundException, UnAcceptableParametersValueException {
    MultivaluedMap<String, String> params = new MultivaluedMapImpl();
    
    if (parameters.getAutoApproveImported() != null) {
      String autoApproveImported = (parameters.getAutoApproveImported() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.AUTO_APPROVE_IMPORTED, autoApproveImported);
    }
    
    if (parameters.getAutoTranslateDialects() !=  null) {
      String autoTranslateDialects = (parameters.getAutoTranslateDialects() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.AUTO_TRANSLATE_DIALECTS, autoTranslateDialects);
    }
    
    if (parameters.getBranch() != null) {
      params.add(CrowdinApiParameters.BRANCH, parameters.getBranch());
    }
    
    if (parameters.getCname() != null) {
      params.add(CrowdinApiParameters.CNAME, parameters.getCname());
    }
    
    if (parameters.getContentSegmentation() != null) {
      String contentSegmentation = (parameters.getContentSegmentation() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.CONTENT_SEGMENTATION, contentSegmentation);
    }
    
    if (parameters.getDescription() != null) {
      params.add(CrowdinApiParameters.DESCRIPTION, parameters.getDescription());
    }
    
    if (parameters.getDestinationFolder() != null) {
      File dir = new File(parameters.getDestinationFolder());
      if (!dir.isDirectory()) {
        dir.mkdirs();
      }
      params.add(CrowdinApiParameters.DESTINATION_FOLDER, parameters.getDestinationFolder());
    }
    
    if (parameters.getDownloadPackage() != null) {
      params.add(CrowdinApiParameters.DOWNLOAD_PACKAGE, parameters.getDownloadPackage());
    }
    
    if (parameters.getEscapeQuotes() != null) {
      if (parameters.getEscapeQuotes() < 0 || parameters.getEscapeQuotes() > 3) {
        throw new UnAcceptableParametersValueException("Value " + parameters.getEscapeQuotes().toString() + " is not acceptable for escape quotes parameter.");
      } else {
        params.add(CrowdinApiParameters.ESCAPE_QUOTES, parameters.getEscapeQuotes().toString());
      }
    }
    
    if (parameters.getExportApprovedOnly() !=  null) {
      String exportApprovedOnly = (parameters.getExportApprovedOnly() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.EXPORT_APPROVED_ONLY, exportApprovedOnly);
    }
    
    if (parameters.getExportTranslatedOnly() !=  null) {
      String exportTranslatedOnly = (parameters.getExportTranslatedOnly() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.EXPORT_TRANSLATED_ONLY, exportTranslatedOnly);
    }
    
    if (parameters.getExportPatterns() != null) {
      for (Map.Entry<String, String> exportPattern : parameters.getExportPatterns().entrySet()) {
        params.add(CrowdinApiParameters.EXPORT_PATTERNS + OPEN_BRACKET + exportPattern.getKey() + CLOSE_BRACKET, exportPattern.getValue());
      }
    }
    
    if (parameters.getFile() != null) {
      if (new File(parameters.getFile()).isFile()) {
        params.add(CrowdinApiParameters.FILE, parameters.getFile());
      }
    }
    
    if (parameters.getFiles() != null) {
      params.add(CrowdinApiParameters.FILES + OPEN_BRACKET + parameters.getFiles() + CLOSE_BRACKET, parameters.getFiles());
    }

    if (parameters.getFirstLineContainsHeader() != null) {
      params.add(CrowdinApiParameters.FIRST_LINE_CONTAINS_HEADER, parameters.getFirstLineContainsHeader());
    }
    
    if (parameters.getFormat() != null) {
      params.add(CrowdinApiParameters.FORMAT, parameters.getFormat());
    }
    
    if (parameters.getHeaders() != null) {
      for (Map.Entry<String, String> header : parameters.getHeaders().entrySet()) {
        params.add(CrowdinApiParameters.HEADERS + OPEN_BRACKET + header.getKey() + CLOSE_BRACKET, header.getValue());
      }
    }
    
    if (parameters.getHideDuplicates() !=  null) {
      String hideDuplicates = (parameters.getHideDuplicates() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.HIDE_DUPLICATES, hideDuplicates);
    }
    
    if (parameters.getIdentifier() != null) {
      params.add(CrowdinApiParameters.IDENTIFIER, parameters.getIdentifier());
    }
    
    if (parameters.getImportDuplicates() != null) {
      String importDuplicates = (parameters.getImportDuplicates() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.IMPORT_DUPLICATES, importDuplicates);
    }
    
    if (parameters.getImportEqSuggestion() != null) {
      String importEqSuggestion = (parameters.getImportEqSuggestion() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.IMPORT_EQ_SUGGESTIONS, importEqSuggestion);
    }
    
    if (parameters.getInContext() != null) {
      params.add(CrowdinApiParameters.IN_CONTEXT, parameters.getInContext().toString());
    }
    
    if (parameters.getIncludeAssigned() != null) {
      String includeAssigned = (parameters.getIncludeAssigned() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.INCLUDE_ASSIGNED, includeAssigned);
    }
    
    if (parameters.getIsBranch() != null) {
      String isBranch = (parameters.getIsBranch() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.IS_BRANCH, isBranch);
    }
    
    if (parameters.getJoinPolicy() != null) {
      if (OPEN.equalsIgnoreCase(parameters.getJoinPolicy()) || PRIVATE.equalsIgnoreCase(parameters.getJoinPolicy())) {
        params.add(CrowdinApiParameters.JOIN_POLICY, parameters.getJoinPolicy());
      } else {
        throw new UnAcceptableParametersValueException("Value " + parameters.getJoinPolicy() + " is not acceptable for join_policy parameter");
      }
    }
    
    if (parameters.getJson() != null) {
      params.add(CrowdinApiParameters.JSON, parameters.getJson());
    }
    
    if (parameters.getJsonp() != null) {
      params.add(CrowdinApiParameters.JSONP, parameters.getJsonp());
    }
    
    if (parameters.getLanguage() != null) {
      params.add(CrowdinApiParameters.LANGUAGE, parameters.getLanguage());
    }
    
    if (parameters.getLanguages() != null) {
      for (String  language : parameters.getLanguages()) {
        params.add(CrowdinApiParameters.LANGUAGES + OPEN_BRACKET + language + CLOSE_BRACKET, language);
      }
    }
    
    if (parameters.getLanguageAccessPolicy() != null) {
      if (OPEN.equalsIgnoreCase(parameters.getLanguageAccessPolicy()) || MODERATE.equalsIgnoreCase(parameters.getLanguageAccessPolicy())) {
        params.add(CrowdinApiParameters.LANGUAGES_ACCESS_POLICY, parameters.getLanguageAccessPolicy());
      } else {
        throw new UnAcceptableParametersValueException("Value " + parameters.getLanguageAccessPolicy() + " is not acceptable for language_access_policy parameter");
      }
    }
    
    if (parameters.getLogin() != null) {
      params.add(CrowdinApiParameters.LOGIN, parameters.getLogin());
    }
    
    if (parameters.getLogo() != null) {
      params.add(CrowdinApiParameters.LOGO, parameters.getLogo());
    }

    if (parameters.getName() != null) {
      params.add(CrowdinApiParameters.NAME, parameters.getName());
    }
    
    if (parameters.getNewName()!= null) {
      params.add(CrowdinApiParameters.NEW_NAME, parameters.getNewName());
    }
    
    if (parameters.getProjectIdentifier() != null) {
      params.add(CrowdinApiParameters.PROJECT_IDENTIFIER, parameters.getProjectIdentifier());
    }
    
    if (parameters.getPublicDownlaod() != null) {
      params.add(CrowdinApiParameters.PUBLIC_DOWNLOADS, parameters.getPublicDownlaod().toString());
    }
    
    if (parameters.getPseudoLanguages() != null) {
      params.add(CrowdinApiParameters.PSEUDO_LANGUAGES, parameters.getPseudoLanguages());
    }
    
    if (parameters.getScheme() != null) {
      params.add(CrowdinApiParameters.SCHEME, parameters.getScheme());
    }
    
    if (parameters.getSourceLanguage() != null) {
      params.add(CrowdinApiParameters.SOURCE_LANGUAGE, parameters.getSourceLanguage());
    }
    
    if (parameters.getTitle()!= null) {
      params.add(CrowdinApiParameters.TITLE, parameters.getTitle());
    }
    
    if (parameters.getTitles() != null) {
      for (Map.Entry<String, String> title : parameters.getTitles().entrySet()) {
        params.add(CrowdinApiParameters.TITLES + OPEN_BRACKET + title.getKey() + CLOSE_BRACKET, title.getValue());
      }
    }
    
    if (parameters.getTranslateAttributes() != null) {
      String translateAttributes = (parameters.getTranslateAttributes() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.TRANSLATE_ATTRIBUTES, translateAttributes);
    }
    
    if (parameters.getTranslateContent() != null) {
      String translateContent = (parameters.getTranslateContent() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.TRANSLATE_CONTENT, translateContent);
    }
    
    if (parameters.getTranslatableElements() != null) {
      for (String translatableElement : parameters.getTranslatableElements()) {
        params.add(CrowdinApiParameters.TRANSLATABLE_ELEMENTS + OPEN_BRACKET + translatableElement + CLOSE_BRACKET, translatableElement);
      }
    }
    
    if (parameters.getType() != null) {
      params.add(CrowdinApiParameters.TYPE, parameters.getType());
    }
    
    if (parameters.getUpdateOption()!= null) {
      params.add(CrowdinApiParameters.UPDATE_OPTION, parameters.getUpdateOption());
    }
    
    if (parameters.getUseGlobalTM() != null) {
      String useGlobalTM = (parameters.getUseGlobalTM() == true) ? TRUE_VALUE : FALSE_VALUE;
      params.add(CrowdinApiParameters.USE_GLOBAL_TM, useGlobalTM);
    }
    
    if (parameters.getVersion() != null) {
      params.add(CrowdinApiParameters.VERSION, parameters.getVersion());
    }
    
    if (parameters.getWebhookFileProofread() != null) {
      params.add(CrowdinApiParameters.WEBHOOK_FILE_PROOFREAD, parameters.getWebhookFileProofread());
    }
    
    if (parameters.getWebhookFileTranslated() != null) {
      params.add(CrowdinApiParameters.WEBHOOK_FILE_TRANSLATED, parameters.getWebhookFileTranslated());
    }
    
    if (parameters.getWebhookProjectProofread() != null) {
      params.add(CrowdinApiParameters.WEBHOOK_PROJECT_PROOFREAD, parameters.getWebhookProjectProofread());
    }
    
    if (parameters.getWebhookProjectTranslated() != null) {
      params.add(CrowdinApiParameters.WEBHOOK_PROJECT_TRANSLATED, parameters.getWebhookProjectTranslated());
    }
    
    if (parameters.getXml() !=  null) {
      params.add(CrowdinApiParameters.XML, parameters.getXml());
    }
    
    return params;
  }
}