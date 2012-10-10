<%@include file="/WEB-INF/jsp/include.jsp"%>
<form:form modelAttribute="title" action="./savetitle" method="POST">
 					<form:errors path="*" cssClass="error"  element="div"/>
					<table
						style="border-bottom-width: thin; border-top-style: solid; font-style: normal; width: auto; border-right-style: solid; font-weight: normal; border-top-width: thin; clear: left; border-bottom-style: solid; line-height: normal; height: auto; border-left-style: solid; font-size: 14px; border-right-width: thin; font-family: Verdana, Arial, Sans-Serif; border-left-width: thin">
						<thead>
							<tr>
								<td colspan="2" style="font-weight: bold">Title Details</td>
							</tr>
						</thead>
						<tr>
							<td style="font-weight: bold">Title ID</td>
							<td><form:input path="titleId" value="v567" readonly="true" />
								<form:hidden path="titleId" /></td>
						</tr>
						<tr>
							<td style="font-weight: bold">WPR Number</td>
							<td><form:input path="wprNumber" /></td>
						</tr>						
						<tr>
							<td style="font-weight: bold">Product Number</td>
							<td><form:input path="productNumber" /></td>
						</tr>
						<tr>
							<td style="font-weight: bold">MPA Number</td>
							<td><form:input path="mpaNumber" /></td>
						</tr>
						<tr>
							<td style="font-weight: bold">Video Catalog</td>
							<td><form:input path="videoCatelog" /></td>
						</tr>
						<tr>
							<td style="font-weight: bold">EdiCode</td>
							<td><form:input path="edicode" /></td>
						</tr>					
						<tr>
							<td><input type="submit" value="Save Title" /></td>
						</tr>
					</table> 
					<form:hidden path="createdDateTime" />		
	</form:form>

