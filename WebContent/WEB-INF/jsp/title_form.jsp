<%@include file="/WEB-INF/jsp/include.jsp"%>
<script>
function submitTitleForm(){
	document.getElementById("title_form").submit();	
}
</script>
<form:form modelAttribute="title" action="./addtitle" id="title_form" method="POST">
	<form:errors path="*" cssClass="error"  element="div"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td align="left" valign="top"><table width="100%" border="0" cellspacing="2" cellpadding="2">
	      <tr>
	        <td class="heading">ADD TITLE</td>
	      </tr>
	      <tr>
	        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td width="15%" class="headingbutton1">Title</td>              
	                <td width="85%">&nbsp;</td>
	              </tr>
	            </table></td>
	          </tr> 
	          <tr>
	            <td height="271" align="left" valign="top" class="table1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="11%" height="32" align="left" valign="middle" class="content">Name</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="23%" align="left" valign="middle"><form:input path="titleName" /></td>
	                    <td width="12%" align="left" valign="middle" class="content">WPR Number</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="18%" align="left" valign="middle"><form:input path="wprNumber" /></td>
	                    <td width="14%" align="left" valign="middle" class="content">Product Number</td>
	                    <td width="1%" align="left" valign="middle" class="content">:</td>
	                    <td width="17%" align="left" valign="middle"><form:input path="productNumber" /></td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="11%" height="31" align="left" valign="middle" class="content">MPA Number</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="23%" align="left" valign="middle"><form:input path="mpaNumber" /></td>
	                    <td width="12%" align="left" valign="middle" class="content">Video Catelog #</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="18%" align="left" valign="middle"><form:input path="videoCatelog" /></td>
	                    <td width="14%" align="left" valign="middle" class="content">Visa</td>
	                    <td width="1%" align="left" valign="middle" class="content">:</td>
	                    <td width="17%" align="left" valign="middle"><form:input path="visa" /></td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="11%" height="29" align="left" valign="middle" class="content">EDI Code</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="23%" align="left" valign="middle"><form:input path="edicode" /></td>
	                    <td width="12%" align="left" valign="middle" class="content">Release year</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="18%" align="left" valign="middle">
		                    <form:select id="releaseYearSelect" path="releaseyear" style="max-width:146px;">
								<form:option value="0" label="" />								
								<form:option value="1999" label="1999" />
								<form:option value="2000" label="2000" />
								<form:option value="2001" label="2001" />
								<form:option value="2002" label="2002" />
								<form:option value="2003" label="2003" />
								<form:option value="2004" label="2004" />
								<form:option value="2005" label="2005" />
								<form:option value="2006" label="2006" />
								<form:option value="2007" label="2007" />								
								<form:option value="2008" label="2008" />
								<form:option value="2009" label="2009" />
								<form:option value="2010" label="2010" />
								<form:option value="2011" label="2011" />
								<form:option value="2012" label="2012" />
								<form:option value="2013" label="2013" />
								<form:option value="2014" label="2014" />
								<form:option value="2015" label="2015" />
								<form:option value="2016" label="2016" />									
								<!-- form:options items="" itemLabel="name" /-->
							</form:select>	                    
	                    </td>
	                    <td width="14%" align="left" valign="middle" class="content">Country of Origin</td>
	                    <td width="1%" align="left" valign="middle" class="content">:</td>
	                    <td width="17%" align="left" valign="middle">
	                    	<form:select id="countrySelect" path="countryid" style="max-width:146px;">
								<form:option value="0" label="" />								
								<form:option value="HT" label="Haiti" />
								<form:option value="HM" label="Heard and Mc Donald Islands" />
								<form:option value="VA" label="Holy See" />
								<form:option value="HN" label="Honduras" />
								<form:option value="HK" label="Hong Kong" />
								<form:option value="HU" label="Hungary" />
								<form:option value="IS" label="Iceland" />
								<form:option value="IN" label="India" />
								<form:option value="ID" label="Indonesia" />
								<form:option value="IR" label="Iran" />
								<form:option value="IQ" label="Iraq" />
								<form:option value="IE" label="Ireland" />
								<form:option value="IL" label="Israel" />
								<form:option value="IT" label="Italy" />							
								<form:option value="PN" label="Pitcairn" />						
								<form:option value="YE" label="Yemen" />
								<form:option value="YU" label="Yugoslavia" />
								<form:option value="ZM" label="Zambia" />
								<form:option value="ZW" label="Zimbabwe" />								
							</form:select>
						</td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="11%" height="28" align="left" valign="middle" class="content">Running Time</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="23%" align="left" valign="middle">hh
	                      <form:input path="hh" size="2"/>
	                      mm
	                      <form:input path="mm" size="2"/>
	                      ss
	                      <form:input path="ss" size="2"/>
	                    </td>
	                    <td width="12%" align="left" valign="middle" class="content">Aspect Ratio</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="18%" align="left" valign="middle">
	                    	<form:select id="aspectRatioSelect" path="aspectRatio" style="max-width:146px;">
								<form:option value="0" label="" />								
								<form:option value="1" label="Haiti" />
								<form:option value="2" label="Heard and Mc Donald Islands" />
								<form:option value="3" label="Holy See (Vatican City State)" />
								<form:option value="4" label="Honduras" />
								<form:option value="5" label="Hong Kong" />
								<form:option value="6" label="Hungary" />								
							</form:select>	</td>
	                    <td width="14%" align="left" valign="middle" class="content">Language</td>
	                    <td width="1%" align="left" valign="middle" class="content">:</td>
	                    <td width="17%" align="left" valign="middle">
	                    	<form:select id="languageSelect" path="languageId" style="max-width:146px;">
								<form:option value="0" label="" />
								<form:option value="1" label="Arabic" />								
								<form:option value="2" label="English" />
								<form:option value="3" label="German" />
								<form:option value="4" label="Mandarian" />
								<form:option value="5" label="French" />
								<form:option value="6" label="Japanese" />
								<form:option value="7" label="Latin" />
								<form:option value="8" label="Singalese" />
								<form:option value="9" label="Telugu" />
								<form:option value="10" label="Kannada" />								
								<form:option value="11" label="Malayalam" />
								<form:option value="12" label="Spanish" />								
								<form:option value="13" label="Urdu" />
								<form:option value="14" label="Hindi" />															
								<form:option value="15" label="Punjabi" />
								<form:option value="16" label="Marathi" />
								<form:option value="17" label="Gujrathi" />						
								<form:option value="18" label="Bengali" />
								<form:option value="19" label="Tamil" />								
							</form:select></td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td height="32" align="left" valign="middle">Active Flag
	                	<form:checkbox path="activeFlag" />	                  
	              </tr>
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="16%" height="107" align="left" valign="top">Rights 
	                      Notification</td>
	                    <td width="84%" align="left" valign="top"><form:textarea path="rightsNotification" cols="45" rows="5"/></td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td align="center" valign="top"><table width="20%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>	                    
	                    <td align="center" valign="top"><a href="#" onclick="submitTitleForm();"><img src="resources/images/index_20.gif" width="55" height="23"/></a></td>	                    
	                  </tr>
	                </table></td>
	              </tr>
	            </table></td>
	          </tr>
	        </table></td>
	      </tr>
	    </table></td>
	  </tr>
	</table>
	<!-- form:hidden path="createdDateTime" /-->
	<form:hidden path="titleId" />		
</form:form>