<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%
   response.setHeader( "Pragma", "No-cache" );
   response.setHeader( "Cache-Control", "no-cache, no-store, must-revalidate" );
   response.setDateHeader( "Expires", -1 );
%>
<html>
	<head>
		<title>FFEPOC</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="-1">
		<meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate, Post-Check=0, Pre-Check=0">
		
		<script type="text/javascript" src="<c:url value="/resources/js/dojo/dojo.js" />"></script>		
		<script type="text/javascript" src="<c:url value="/resources/js/spring/Spring.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/spring/Spring-Dojo.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery/jquery-1.7.1.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/autosuggest/jquery.autosuggest.js" />"></script>
		
		<link rel="stylesheet" href="<c:url value="/resources/js/autosuggest/jqueryAutoSuggest.css"/>" type="text/css" media="print, projection, screen" />
		<link href="<c:url value="/resources/css/fsdfe.css"/>" rel="stylesheet" type="text/css" />
		<link href="resources/css/style.css" rel="stylesheet" type="text/css" />		
		<style type="text/css">		
		.InnerFormBoxContainer {			
			padding: 10px;
		}		
		.AddInnerFormBoxContainer {			
			padding: 10px;
		}		
		</style>
	</head>
	<body>		
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr>	  
	    <td height="121" align="left" valign="top" background="resources/images/index_01.gif" style="background-repeat:repeat-x">	    
	    <div class="TopBannerBgContainer"><!--Header Tiles Start-->
		 	<tiles:insertAttribute name="header" />
		</div><!--Header Tiles End-->
	    </td>
	  </tr>	  
	  <tr>
      <td height="133"  align="center" valign="top">
      	<div id="MainContainer"><!--MainContainer start-->
			<div id="InnerMainContainer"><!--InnerMainContainer start-->
	      	<table width="100%" height="500px" border="0" cellspacing="0" cellpadding="0">
	      	<tr>
		        <td align="left" valign="top" background="resources/images/index_07.gif" style="background-repeat:repeat-y">&nbsp;</td>
	        	<td width="80%" height="500px" align="center" valign="top">
					<table  bgcolor="#FFFFFF" width="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr>
	            		<td>	            						
							<div class="TopTabContainer"><!--Menu Tiles start-->
								<tiles:insertAttribute name="menu" />
							</div><!--Menu Tiles end-->		
						</td>
          			 </tr>
                     <tr>
                       <td><table width="100%" height="500px" border="0" cellspacing="0" cellpadding="0">
              			<tr>
                		 <td>				
							<div class="InnerFormMainContainer"><!--InnerFormMainContainer start-->
								<div class="EntryMainLeft"><!--EntryMainLeft start-->
									<div class="InnerFormBoxContainer"><!--Business Entity InnerFormBoxContainer start-->
										<tiles:insertAttribute name="innerContainer" />						
									</div><!--Business Entity InnerFormBoxContainer end-->					
								</div><!--EntryMainLeft end-->
								<div class="EntryMainRight"><!--EntryMainRight start-->
									<div class="AddInnerFormBoxContainer"><!--Address InnerFormBoxContainer start-->
										<!-- tiles:insertAttribute name="innerContainer2" /-->						
									</div><!--Address InnerFormBoxContainer end-->					
								</div><!--EntryMainRight end-->
								<div class="ClearFloat"></div>
								<div class="BotHeight"></div>
							</div><!--InnerFormMainContainer end-->
						</td>
               			 <td align="left" valign="top">&nbsp;</td>
              			</tr>
           			 </table></td>
         			 </tr>	
         			 <tr>         			
          			   <td background="resources/images/index_24.gif" style="background-repeat:repeat-x" height="43px">
          			   	  <div class=""><!--Footer Tiles Start-->
							<tiles:insertAttribute name="footer" /><br />
		  				  </div><!--Footer Tiles End--></td>
        			  </tr>
        			   </table>
					</td>
					<td width="10%" align="left" valign="top" background="resources/images/index_07.gif" style="background-repeat:repeat-y">&nbsp;</td>
				</tr>
   			</table>
			</div><!--InnerMainContainer end-->
			<div id="actionsDiv" class="divPopup"></div><br />				
		  </div><!--MainContainer end-->									
		</td>
 	 </tr>
	</table>
	</body>
</html>