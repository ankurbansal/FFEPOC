<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%
   response.setHeader( "Pragma", "No-cache" );
   response.setHeader( "Cache-Control", "no-cache, no-store, must-revalidate" );
   response.setDateHeader( "Expires", -1 );
%>
<html>
<head>
<title>Address Book</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<meta http-equiv="Cache-Control"
	content="no-store, no-cache, must-revalidate, Post-Check=0, Pre-Check=0">
<script type="text/javascript"
	src="<c:url value="/resources/js/dojo/dojo.js" />">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/spring/Spring.js" />">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/spring/Spring-Dojo.js" />">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery/jquery-1.7.1.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/autosuggest/jquery.autosuggest.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/js/autosuggest/jqueryAutoSuggest.css"/>"
	type="text/css" media="print, projection, screen" />
<link href="<c:url value="/resources/css/addressBook.css"/>"
	rel="stylesheet" type="text/css" />
	
	
	<style type="text/css">
	body {
		background-color: #FFFFFF;
		background-image: url(resources/images/bg.jpg);
		background-repeat: repeat-x;
	}
	</style>
</head>
<body>	
	<div class="TopBannerBgContainer">
		<!--Header Tiles Start-->
		<tiles:insertAttribute name="header" />
	</div>
	<!--Header Tiles End-->

	<div id="MainContainer">
		<!--MainContainer start-->
		<div id="InnerMainContainer">
			
			<!--InnerMainContainer start-->
			<div class="TopTabContainer"><!--Menu Tiles start-->
				<tiles:insertAttribute name="menu" />
			</div>			
			<!--Menu Tiles end-->
						
			<div class="InnerFormMainContainer">
				<!--InnerFormMainContainer start-->
				
				<div class="EntryMainLeft"><!--EntryMainLeft start-->
					
					
					<div class="InnerFormBoxContainer">
						<!--Business Entity InnerFormBoxContainer start-->
							<tiles:insertAttribute name="innerBox1" />
						<!--Business Entity InnerFormBoxContainer end-->
					</div>					
				</div><!--EntryMainLeft end-->

				<div class="EntryMainRight">
					<!--EntryMainRight start-->

					<div class="AddInnerFormBoxContainer">
						<!--Address InnerFormBoxContainer start-->
							<tiles:insertAttribute name="innerBox2" />
						<!--Address InnerFormBoxContainer end-->
					</div>				

					<div class="ClearFloat"></div>
					
				</div>
				<!--EntryMainRight end-->

				<div class="ClearFloat"></div>
				<div class="BotHeight"></div>
			</div>
			<!--InnerFormMainContainer end-->
		</div>
		<!--InnerMainContainer end-->
		<tiles:insertAttribute name="footer" />
		<br/>
		
	</div>
	<div id="actionsDiv" class="divPopup"></div>
	<br/>
	<!--MainContainer end-->	
</body>
</html>