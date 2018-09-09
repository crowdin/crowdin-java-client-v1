package com.crowdin.parameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ihor <ihor.popyk@crowdin.com>
 */
public class CrowdinApiParametersBuilder {

  private Boolean applyUntranslatedStringsOnly;

  private Boolean approveTranslated;
  
  private Boolean autoApproveImported;
  
  private Boolean autoTranslateDialects;

  private String branch;
  
  private String cname;

  private String charTransformation;
  
  private Boolean contentSegmentation;
  
  private String description;
  
  private String destinationFolder;
  
  private String downloadPackage;

  private String engine;
  
  private Integer escapeQuotes;
  
  private Boolean exportApprovedOnly;
  
  private String exportLanguage;
  
  private Map<String, String> exportPatterns = new HashMap<>();
  
  private Boolean exportTranslatedOnly;
  
  private String firstLineContainsHeader;
  
  private String file;
  
  private String files;
  
  private String format;
  
  private Map<String, String> headers = new HashMap<>();

  private Boolean hideDuplicates;
  
  private String identifier;
  
  private Boolean importDuplicates;
  
  private Boolean importEqSuggestion;
  
  private Boolean includeAssigned;
  
  private Boolean inContext;
  
  private Boolean isBranch;
  
  private String joinPolicy;
  
  private String json;
  
  private String jsonp;
  
  private String language;
  
  private List<String> languages = new ArrayList<>();
  
  private String languageAccessPolicy;

  private Integer lengthTransformation;
  
  private String login;
  
  private String logo;

  private String method;
  
  private String name;
  
  private String newName;

  private Boolean perfectMatch;

  private String prefix;
  
  private String projectIdentifier;
  
  private String pseudoLanguages;
  
  private Boolean publicDownlaod;
  
  private String scheme;
  
  private String sourceLanguage;

  private String suffix;
  
  private String title;
  
  private Map<String, String> titles = new HashMap<>();
  
  private List<String> translatableElements = new ArrayList<>();
  
  private Boolean translateAttributes;
  
  private Boolean translateContent;
  
  private String type;
  
  private String updateOption;

  private Boolean useGlobalTM;
  
  private String version;
  
  private String webhookFileProofread;
  
  private String webhookFileTranslated;
  
  private String webhookProjectProofread;
  
  private String webhookProjectTranslated;
  
  private String xml;

  public Boolean getApplyUntranslatedStringsOnly() {
    return this.applyUntranslatedStringsOnly;
  }

  /**
   *
   * @param applyUntranslatedStringsOnly
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder applyUntranslatedStringsOnly(Boolean applyUntranslatedStringsOnly) {
    this.applyUntranslatedStringsOnly = applyUntranslatedStringsOnly;
    return this;
  }

  public Boolean getApproveTranslated() {
    return this.approveTranslated;
  }

  /**
   *
   * @param approveTranslated
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder approveTranslated(Boolean approveTranslated) {
    this.approveTranslated = approveTranslated;
    return this;
  }

  public Boolean getAutoApproveImported() {
    return this.autoApproveImported;
  }

  /**
   *
   * @param autoApproveImported
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder autoApproveImported(Boolean autoApproveImported) {
    this.autoApproveImported = autoApproveImported;
    return this;
  }

  public Boolean getAutoTranslateDialects() {
    return this.autoTranslateDialects;
  }

  /**
   *
   * @param autoTranslateDialects
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder autoTranslateDialects(Boolean autoTranslateDialects) {
    this.autoTranslateDialects = autoTranslateDialects;
    return this;
  }

  public String getBranch() {
    return this.branch;
  }

  /**
   *
   * @param branch
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder branch(String branch) {
    this.branch = branch;
    return this;
  }

  public String getCname() {
    return this.cname;
  }

  /**
   *
   * @param cname
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder cname(String cname) {
    this.cname = cname;
    return this;
  }

  public String getCharTransformation() {
    return this.charTransformation;
  }

  /**
   *
   * @param charTransformation
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder charTransformation(String charTransformation) {
    this.charTransformation = charTransformation;
    return this;
  }

  public Boolean getContentSegmentation() {
    return this.contentSegmentation;
  }

  /**
   *
   * @param contentSegmentation
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder contentSegmentation(Boolean contentSegmentation) {
    this.contentSegmentation = contentSegmentation;
    return this;
  }

  public String getDownloadPackage() {
    return this.downloadPackage;
  }

  /**
   *
   * @param downloadPackage
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder downloadPackage(String downloadPackage) {
    this.downloadPackage = downloadPackage;
    return this;
  }

  public String getDescription() {
    return this.description;
  }

  /**
   *
   * @param description
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder description(String description) {
    this.description = description;
    return this;
  }

  public String getDestinationFolder() {
    return this.destinationFolder;
  }

  /**
   *
   * @param destinationFolder
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder destinationFolder(String destinationFolder) {
    this.destinationFolder = destinationFolder;
    return this;
  }

  public String getEngine() {
    return  this.engine;
  }

  /**
   *
   * @param engine
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder engine(String engine) {
    this.engine = engine;
    return this;
  }

  public Integer getEscapeQuotes() {
    return this.escapeQuotes;
  }

  /**
   *
   * @param escapeQuotes
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder escapeQuotes(Integer escapeQuotes) {
    this.escapeQuotes = escapeQuotes;
    return this;
  }

  public Boolean getExportApprovedOnly() {
    return this.exportApprovedOnly;
  }

  /**
   *
   * @param exportApprovedOnly
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder exportApprovedOnly(Boolean exportApprovedOnly) {
    this.exportApprovedOnly = exportApprovedOnly;
    return this;
  }
  
  public String getExportLanguage() {
    return this.exportLanguage;
  }

  public CrowdinApiParametersBuilder exportLanguage(String exportLanguage) {
    this.exportLanguage = exportLanguage;
    return this;
  }

  public Map<String, String>  getExportPatterns() {
    return this.exportPatterns;
  }

  /**
   *
   * @param exportPatterns
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder exportPatterns(String path, String exportPatterns) {
    this.exportPatterns.put(path, exportPatterns);
    return this;
  }

  public Boolean getExportTranslatedOnly() {
    return this.exportTranslatedOnly;
  }

  /**
   *
   * @param exportTranslatedOnly
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder exportTranslatedOnly(Boolean exportTranslatedOnly) {
    this.exportTranslatedOnly = exportTranslatedOnly;
    return this;
  }

  public String getFirstLineContainsHeader() {
    return this.firstLineContainsHeader;
  }

  /**
   *
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder firstLineContainsHeader() {
    this.firstLineContainsHeader = Boolean.TRUE.toString();
    return this;
  }

  public String getFile() {
    return this.file;
  }

  /**
   *
   * @param file
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder file(String file) {
    this.file = file;
    return this;
  }
  
  public String getFiles() {
    return this.files;
  }

  public CrowdinApiParametersBuilder files(String file) {
    this.files = file;
    return this;
  }

  public String getFormat() {
    return this.format;
  }

  /**
   *
   * @param format
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder format(String format) {
    this.format = format;
    return this;
  }

  public Map<String, String> getHeaders() {
    return this.headers;
  }

  public CrowdinApiParametersBuilder headers(String key, String value) {
    this.headers.put(key, value);
    return this;
  }

  public Boolean getHideDuplicates() {
    return this.hideDuplicates;
  }

  /**
   *
   * @param hideDuplicates
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder hideDuplicates(Boolean hideDuplicates) {
    this.hideDuplicates = hideDuplicates;
    return this;
  }

  public String getIdentifier() {
    return this.identifier;
  }

  /**
   *
   * @param identifier
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

  public Boolean getImportDuplicates() {
    return this.importDuplicates;
  }

  /**
   *
   * @param importDuplicates
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder importDuplicates(Boolean importDuplicates) {
    this.importDuplicates = importDuplicates;
    return this;
  }

  public Boolean getImportEqSuggestion() {
    return this.importEqSuggestion;
  }

  /**
   *
   * @param importEqSuggestion
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder importEqSuggestion(Boolean importEqSuggestion) {
    this.importEqSuggestion = importEqSuggestion;
    return this;
  }

  public Boolean getIncludeAssigned() {
    return this.includeAssigned;
  }

  /**
   *
   * @param includeAssigned
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder includeAssigned(Boolean includeAssigned) {
    this.includeAssigned = includeAssigned;
    return this;
  }

  public Boolean getInContext() {
    return this.inContext;
  }

  /**
   *
   * @param inContext
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder inContext(Boolean inContext) {
    this.inContext = inContext;
    return this;
  }

  public Boolean getIsBranch() {
    return this.isBranch;
  }

  /**
   *
   * @param isBranch
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder isBranch(Boolean isBranch) {
    this.isBranch = isBranch;
    return this;
  }

  public String getJoinPolicy() {
    return this.joinPolicy;
  }

  /**
   *
   * @param joinPolicy
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder joinPolicy(String joinPolicy) {
    this.joinPolicy = joinPolicy;
    return this;
  }

  public String getJson() {
    return this.json;
  }

  /**
   *
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder json() {
    this.json = Boolean.TRUE.toString();
    return this;
  }

  public String getJsonp() {
    return this.jsonp;
  }

  /**
   *
   * @param jsonp
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder jsonp(String jsonp) {
    this.jsonp = jsonp;
    return this;
  }

  public String getLanguage() {
    return this.language;
  }

  /**
   *
   * @param language
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder language(String language) {
    this.language = language;
    return this;
  }

  public List<String> getLanguages() {
    return this.languages;
  }

  /**
   *
   * @param languages
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder languages(List<String> languages) {
    this.languages.addAll(languages);
    return this;
  }

  public String getLanguageAccessPolicy() {
    return this.languageAccessPolicy;
  }

  /**
   *
   * @param languageAccessPolicy
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder languageAccessPolicy(String languageAccessPolicy) {
    this.languageAccessPolicy = languageAccessPolicy;
    return this;
  }

  public Integer lengthTransformation() {
    return this.lengthTransformation;
  }

  /**
   *
   * @param lengthTransformation
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder lengthTransformation(Integer lengthTransformation) {
    this.lengthTransformation = lengthTransformation;
    return this;
  }

  public String getLogin() {
    return this.login;
  }

  /**
   *
   * @param login
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder login(String login) {
    this.login = login;
    return this;
  }

  public String getLogo() {
    return this.logo;
  }

  /**
   *
   * @param logo
   * @return CrowdinApiParametersBuilder
   */
  public CrowdinApiParametersBuilder logo(String logo) {
    this.logo = logo;
    return this;
  }

  public String getMethod() {
    return this.method;
  }

  /**
   *
   * @param method
   * @return CrowdinApiParametersBuilder
   */
  public CrowdinApiParametersBuilder method(String method) {
    this.method = method;
    return this;
  }

  public String getName() {
    return this.name;
  }

  /**
   *
   * @param name
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder name(String name) {
    this.name = name;
    return this;
  }

  public String getNewName() {
    return this.newName;
  }

  /**
   *
   * @param newName
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder newName(String newName) {
    this.newName = newName;
    return this;
  }

  public Boolean getPerfectMatch() {
    return this.perfectMatch;
  }

  /**
   *
   * @param perfectMatch
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder perfectMatch(Boolean perfectMatch) {
    this.perfectMatch = perfectMatch;
    return this;
  }

  public String getPrefix() {
    return this.prefix;
  }

  /**
   *
   * @param prefix
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder prefix(String prefix) {
    this.prefix = prefix;
    return this;
  }

  public String getProjectIdentifier() {
    return this.projectIdentifier;
  }

  /**
   *
   * @param projectIdentifier
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder projectIdentifier(String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
    return this;
  }

  public String getPseudoLanguages() {
    return this.pseudoLanguages;
  }

  /**
   *
   * @param pseudoLanguages
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder pseudoLanguages(String pseudoLanguages) {
    this.pseudoLanguages = pseudoLanguages;
    return this;
  }

  public Boolean getPublicDownlaod() {
    return this.publicDownlaod;
  }

  /**
   *
   * @param publicDownlaod
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder publicDownlaod(Boolean publicDownlaod) {
    this.publicDownlaod = publicDownlaod;
    return this;
  }

  public String getScheme() {
    return this.scheme;
  }

  /**
   *
   * @param scheme
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder scheme(String scheme) {
    this.scheme = scheme;
    return this;
  }

  public String getSourceLanguage() {
    return this.sourceLanguage;
  }

  /**
   *
   * @param sourceLanguage
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder sourceLanguage(String sourceLanguage) {
    this.sourceLanguage = sourceLanguage;
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  /**
   *
   * @param title
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder title(String title) {
    this.title = title;
    return this;
  }

  public String getSuffix() {
    return this.suffix;
  }

  /**
   *
   * @param suffix
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder suffix(String suffix) {
    this.suffix = suffix;
    return this;
  }

  public Map<String, String> getTitles() {
    return this.titles;
  }

  /**
   *
   * @param path
   * @param title
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder titles(String path, String title) {
    this.titles.put(path, title);
    return this;
  }

  public List<String> getTranslatableElements() {
    return this.translatableElements;
  }

  /**
   *
   * @param translatableElements
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder translatableElements(List<String> translatableElements) {
    this.translatableElements.addAll(translatableElements);
    return this;
  }

  public Boolean getTranslateAttributes() {
    return this.translateAttributes;
  }

  /**
   *
   * @param translateAttributes
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder translateAttributes(Boolean translateAttributes) {
    this.translateAttributes = translateAttributes;
    return this;
  }

  public Boolean getTranslateContent() {
    return this.translateContent;
  }

  /**
   *
   * @param translateContent
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder translateContent(Boolean translateContent) {
    this.translateContent = translateContent;
    return this;
  }

  public String getType() {
    return this.type;
  }

  /**
   *
   * @param type
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder type(String type) {
    this.type = type;
    return this;
  }

  public String getUpdateOption() {
    return this.updateOption;
  }

  /**
   *
   * @param updateOption
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder updateOption(String updateOption) {
    this.updateOption = updateOption;
    return this;
  }

  public Boolean getUseGlobalTM() {
    return this.useGlobalTM;
  }

  /**
   *
   * @param useGlobalTM
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder useGlobalTM(Boolean useGlobalTM) {
    this.useGlobalTM = useGlobalTM;
    return this;
  }

  public String getVersion() {
    return this.version;
  }

  public CrowdinApiParametersBuilder version(String version) {
    this.version = version;
    return this;
  }

  public String getWebhookFileProofread() {
    return this.webhookFileProofread;
  }

  /**
   *
   * @param webhookFileProofread
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder webhookFileProofread(String webhookFileProofread) {
    this.webhookFileProofread = webhookFileProofread;
    return this;
  }

  public String getWebhookFileTranslated() {
    return this.webhookFileTranslated;
  }

  /**
   *
   * @param webhookFileTranslated
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder webhookFileTranslated(String webhookFileTranslated) {
    this.webhookFileTranslated = webhookFileTranslated;
    return this;
  }

  public String getWebhookProjectProofread() {
    return this.webhookProjectProofread;
  }

  /**
   *
   * @param webhookProjectProofread
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder webhookProjectProofread(String webhookProjectProofread) {
    this.webhookProjectProofread = webhookProjectProofread;
    return this;
  }

  public String getWebhookProjectTranslated() {
    return this.webhookProjectTranslated;
  }

  /**
   *
   * @param webhookProjectTranslated
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder webhookProjectTranslated(String webhookProjectTranslated) {
    this.webhookProjectTranslated = webhookProjectTranslated;
    return this;
  }

  public String getXml() {
    return this.xml;
  }

  /**
   *
   * @return CrowdinApiParametersBuilder
   *
   */
  public CrowdinApiParametersBuilder xml() {
    this.xml = Boolean.TRUE.toString();
    return this;
  }
}