package com.ffe.title.message;

import java.io.Serializable;

import org.apache.commons.lang.StringEscapeUtils;

public class AutoCompleteOption implements Serializable{
  String id;
  String value;
  
//  private final static Logger log = UXCommonLogger.getLogger(AutoCompleteOption.class);
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id =id;
  }
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
	  this.value =  StringEscapeUtils.escapeXml(value);
  }
  
}
