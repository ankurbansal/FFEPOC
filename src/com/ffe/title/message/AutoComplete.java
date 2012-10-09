package com.ffe.title.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

public class AutoComplete implements Serializable{
  String searchText;
  List<AutoCompleteOption> options = new ArrayList<AutoCompleteOption>();
  String errorMsg;
  String resultsCount;
  
  public String getSearchText() {
    return searchText;
  }
  public void setSearchText(String searchText) {
	  this.searchText = StringEscapeUtils.escapeHtml((searchText));
  }
  public List<AutoCompleteOption> getOptions() {
    return options;
  }
  public void setOptions(List<AutoCompleteOption> options) {
    this.options = options;
  }
  public String getErrorMsg() {
    return errorMsg;
  }
  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
  public String getResultsCount() {
    return resultsCount;
  }
  public void setResultsCount(String resultsCount) {
    this.resultsCount = resultsCount;
  }
  
  
}
