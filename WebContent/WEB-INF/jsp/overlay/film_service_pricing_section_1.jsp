<div id="film_service_pricing_section_1">
<table width="960" border="0" cellspacing="1" cellpadding="1">
  <tr>
	<td class="section-big-header">Service</td>
	<td class="section-small-header">No Prints</td>
	<td class="section-small-header">Price</td>
	<td class="section-small-header">Net Cost per Foot</td>
	<td class="section-small-header">Net Cost per Foot</td>
	<td class="section-small-header">Net Cost per Foot</td>
	<td class="section-small-header">Net Cost per Print</td>
	<td class="section-small-header">Net Cost per Print</td>
	<td class="section-small-header">Net Cost per Print</td>
	<td class="section-small-header">Total</td>
	<td class="section-small-header">Total</td>
  </tr>
  <tr>
	<td class="section-big-subcol">
		<div id="addservice-1">	
			<img class="addService" src="resources/images/expand_alt.png" />
			<div class="sectionSubHeader">Add Service</div>		
		</div>
		<input type="hidden" id="countServicesSection-1" value='<c:out value="${fn:length(estimate.lstEstimateCosting)}" />' />
		<input type="hidden" id="deletedServicesSection-1" value="" />		
	</td>
	<td class="section-small-subcol">&nbsp;</td>
	<td class="section-small-subcol">&nbsp;</td>
	<td class="section-small-subcol">EURO</td>
	<td class="section-small-subcol">USD</td>
	<td class="section-small-subcol">GBP</td>
	<td class="section-small-subcol">EURO</td>
	<td class="section-small-subcol">USD</td>
	<td class="section-small-subcol">GBP</td>
	<td class="section-small-subcol">GBP</td>
	<td class="section-small-subcol">EURO</td>
  </tr>
</table>

<div id="section-1-rows">
<c:if test="${not empty estimate.lstEstimateCosting}">
<c:forEach var="lstEstimateCosting" items="${estimate.lstEstimateCosting}" varStatus="itr">			
	<table id="service_table_${estimate.lstEstimateCosting[itr.index].estimateCostTypeId}_${((itr.index)+1)}" width="960" border="0" cellspacing="1" cellpadding="1">
		<tr>
			<td class="section-big-col">
				<img class="removeService" id="removeService-${estimate.lstEstimateCosting[itr.index].estimateCostTypeId}-${((itr.index)+1)}" src="resources/images/collapse_alt.png" />
				<form:select path="lstEstimateCosting[${itr.index}].serviceId" style="max-width:155px;">						
						<form:option value="0" label="Select" />
						<form:options items="${allServiceList}" itemValue="digiServiceId" itemLabel="digiServName" />						
				</form:select>
			</td>
			<td class="section-small-col">
				<label><form:input path="lstEstimateCosting[${itr.index}].quantity" class="textbox-datainput"  /></label>
			</td>
			<td class="section-small-col">
				<form:input path="lstEstimateCosting[${itr.index}].localCurrentCost" class="textbox-computed"  />											
			</td>
			<td class="section-small-col">&nbsp;</td>
			<td class="section-small-col">&nbsp;</td>
			<td class="section-small-col">&nbsp;</td>
			<td class="section-small-col">
				<form:input path="lstEstimateCosting[${itr.index}].currecySelectedId" class="textbox-computed"  />				
			</td>
			<td class="section-small-col">&nbsp;</td>
			<td class="section-small-col">
				<form:input  path="lstEstimateCosting[${itr.index}].totalcost" class="textbox-standardprice"  />				
			</td>
			<td class="section-small-col">&nbsp;</td>
			<td class="section-small-col">&nbsp;</td>	
		</tr>
	</table>
</c:forEach>
</c:if>
</div>	
<table width="960" border="0" cellspacing="1" cellpadding="1">  
	<tr>
		<td class="section-subTotal-header">Subtotal Digital Feature Prints</td>
		<td class="section-small-header">xyz</td>
		<td class="section-small-header">xyz</td>
	</tr>
</table>
</div>