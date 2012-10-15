<%@include file="/WEB-INF/jsp/include.jsp"%>
<script>
function submitTitleSearchForm(){
	document.getElementById("search_title_form").submit();	
}
</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td background="resources/images/index_10.gif" style="background-repeat:no-repeat" height="36"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="40%" align="left" valign="middle" class="mainmenu">SEARCH</td>
                        <td width="60%" align="right" valign="middle" class="advancesearch"><a href="#" class="advancesearch">ADVANCE SEARCH</a></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="left" valign="top">
                    <form:form modelAttribute="searchcriteria" action="./searchtitle" id="search_title_form" method="POST">
	                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                      <tr>
	                        <td align="center" valign="middle"><form:input path="fieldValue" /></td>
	                        <td align="left" valign="middle"><a href="#" onclick="submitTitleSearchForm();"><img src="resources/images/index_14.gif" width="26" height="25" /></a></td>
	                      </tr>
	                      <tr>
	                        <td colspan="2" align="center" valign="middle">                         
	                        	<form:errors path="*" cssClass="error"  element="div"/>                      
		                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		                          <tr>
		                            <td align="left" valign="middle"><form:radiobutton path="fieldName" value="TITLENAME"/></td>
		                            <td align="left" valign="middle" class="lefttext">Title</td>
		                            <td align="left" valign="middle"><form:radiobutton path="fieldName" value="WPR"/></td>
		                            <td align="left" valign="middle" class="lefttext">WPR No.</td>
		                            <td align="left" valign="middle"></td>
		                            <td align="left" valign="middle" class="lefttext"></td>
		                          </tr>
		                        </table>                     
	                        </td>
	                        </tr>
	                    </table>                    
                    </form:form>
                   </td>
                  </tr>
                  <tr>
                    <td align="left" valign="top">&nbsp;</td>
                  </tr>
                  <tr>
                    <td align="left" valign="top"><table width="100%" border="0" cellspacing="1" cellpadding="1">
                      <tr>
                        <td class="leftmenu"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="left" valign="middle">Home</td>
                            <td align="right" valign="middle"><img src="resources/images/arrow.png" width="8" height="10" /></td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td class="leftmenu"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="left" valign="middle">Search</td>
                            <td align="right" valign="middle"><img src="resources/images/arrow.png" width="8" height="10" /></td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td class="leftmenu"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="left" valign="middle">Requests</td>
                            <td align="right" valign="middle"><img src="resources/images/arrow.png" width="8" height="10" /></td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td class="leftmenu"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="left" valign="middle">Search</td>
                            <td align="right" valign="middle"><img src="resources/images/arrow.png" width="8" height="10" /></td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td class="leftmenu"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td align="left" valign="middle">Admin</td>
                            <td align="right" valign="middle"><img src="resources/images/arrow.png" width="8" height="10" /></td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td class="leftmenu">Help</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td align="left" valign="top">&nbsp;</td>
                  </tr>
                </table>