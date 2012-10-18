<%@include file="/WEB-INF/jsp/include.jsp"%>
<form:form modelAttribute="estimate" action="./saveEstimate" id="estimate_pricing_form" method="POST">
<form:errors path="*" cssClass="error"  element="div"/>
<div id="film_service_pricing">
<script>
jQuery(document).ready(function(){	
	$("#film_service_sections").hide();
	$("#includedContent-common-1").html($("#film_service_pricing_exchange").html()); 
	$("#includedContent-common-2").html($("#film_service_pricing_section_common").html()); 
	$("#includedContent-section-1").html($("#film_service_pricing_section_1").html()).hide(); 
	$("#includedContent-section-2").html($("#film_service_pricing_section_2").html()).hide(); 
	$("#includedContent-section-3").html($("#film_service_pricing_section_3").html()).hide(); 
	$("#includedContent-section-4").html($("#film_service_pricing_section_4").html()).hide(); 
	$("#includedContent-section-5").html($("#film_service_pricing_total").html()); 
	$("#includedContent-footer").html($("#film_service_pricing_footer").html()); 
	//$("[id^=includedContent-section]").slideToggle(1000);
	$(".expandCollapseToggle").click(function() {
		curr_id = ($(this).attr("id").split("-"))[1];			
		if($(this).hasClass("expand")){
			$(this).removeClass("expand");
			$(this).addClass("collapse");
			$(this).attr("src","resources/images/collapse.png");									
			$("#includedContent-section-"+curr_id).slideDown(500);					
		} else if($(this).hasClass("collapse")){
			$(this).removeClass("collapse");
			$(this).addClass("expand");
			$(this).attr("src","resources/images/expand.png");				
			$("#includedContent-section-"+curr_id).slideUp(500);					
		}		   		 
	});
	
	var num_of_sections = 4;
	
	for (var sectionId=1; sectionId<=num_of_sections; sectionId++)  {  	       
		$("#addservice-"+sectionId).click(function() {	
				var sec_id = ($(this).attr("id").split("-"))[1];
				var service_count = parseInt($("#countServicesSection-"+sec_id).val());				
				var new_id = service_count+1;		
				var new_html = getCurrentRow(sec_id, new_id);			
				$("#section-"+sec_id+"-rows").append(new_html);		
				$("#removeService-"+sec_id+"-"+new_id).click(function() {
					if($("#deletedServicesSection-"+sec_id).val() != ""){
						$("#deletedServicesSection-"+sec_id).val($("#deletedServicesSection-"+sec_id).val()+","+new_id);		
					} else {
						$("#deletedServicesSection-"+sec_id).val(new_id);		
					}		
					$("#service_table_"+sec_id+"_"+new_id).remove();	
				});	
		});
		
		if(!($("#countServicesSection-"+sectionId).val() > 0)){
			var new_html = getCurrentRow(sectionId,1);			
			$("#section-"+sectionId+"-rows").append(new_html);	
		}
		
		$("#section-"+sectionId+"-rows #service_table_"+sectionId+"_1 #removeService-"+sectionId+"-1").replaceWith( "<div>ABC</div>");
	}
	
});		

function getCurrentRow(section_id, row_id){	
	$("#countServicesSection-"+section_id).val(row_id);
	var record_id = 0;
	if(row_id >0 ){
		record_id = row_id-1;
	}
	var html = "";	
	html = html +'<table id="service_table_'+section_id+'_'+row_id+'" width="960" border="0" cellspacing="1" cellpadding="1"><tr><td class="section-big-col"><img class="removeService" id="removeService-'+section_id+'-'+row_id+'" src="resources/images/collapse_alt.png" />'	
				+'<select name="lstEstimateCosting['+record_id+'].serviceId" id="lstEstimateCosting'+record_id+'.serviceId" style="max-width:155px;"><c:forEach var="item" items="${allServiceList}"><option value="${item.digiServiceId}">${item.digiServName}</option></c:forEach></select></td>'
				+'<td class="section-small-col"><label><input value="" type="text" class="textbox-datainput" name="lstEstimateCosting['+record_id+'].quantity" id="lstEstimateCosting'+record_id+'.quantity" /></label></td>'
				+'<td class="section-small-col"><input  type="text" value=""  class="textbox-computed" name="lstEstimateCosting['+record_id+'].localCurrentCost" id="lstEstimateCosting'+record_id+'.localCurrentCost"  /></td>'
				+'<td class="section-small-col">&nbsp;</td><td class="section-small-col">&nbsp;</td><td class="section-small-col">&nbsp;</td>'
				+'<td class="section-small-col"><input type="text" class="textbox-computed" value=""  name="lstEstimateCosting['+record_id+'].currecySelectedId" id="lstEstimateCosting'+record_id+'.currecySelectedId" /></td>'
				+'<td class="section-small-col">&nbsp;</td><td class="section-small-col"><input value="" type="text" class="textbox-standardprice" name="lstEstimateCosting['+record_id+'].totalcost" id="lstEstimateCosting'+record_id+'.totalcost" /></td>'
				+'<td class="section-small-col">&nbsp;</td><td class="section-small-col">&nbsp;</td></tr></table>';
	return html;
}

</script>
<!-- link href="style.css" rel="stylesheet" type="text/css" /-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="15">&nbsp;</td>
    <td width="100%" align="center" valign="top">
	<table width="960" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="resources/images/topbg.png" class="headingFilmEstimate" style="background-repeat:no-repeat">Film Estimate</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF">
    		<div id="includedContent-common-1"></div>
		</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF">
			<table width="960" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
				<td>
					<div id="includedContent-common-2"></div>
				</td>
			  </tr>
			  <tr>
				<td>&nbsp;					
				<!-- form:select path="" items="${allServiceList}" itemLabel="digiServName" /--></td>
			  </tr>
			   <tr>
				<td><img id="collapse-1" class="expandCollapseToggle expand" src="resources/images/expand.png" /><div class="sectionHeader"> Digital Feature Prints </div></td>
			  </tr>
			  <tr>
				<td>
					<div id="includedContent-section-1"></div>		
				</td>
			  </tr>
			  <tr>
				<td>&nbsp;</td>
			  </tr>
			   <tr>
				<td><img id="collapse-2" class="expandCollapseToggle expand" src="resources/images/expand.png" /><div class="sectionHeader"> Dubbing For Prints </div></td>
			  </tr>
			  <tr>
				<td>
					<div id="includedContent-section-2"></div>		
				</td>
			  </tr>
			   <tr>
				<td>&nbsp;</td>
			  </tr>
			  <tr>
				<td><img id="collapse-3" class="expandCollapseToggle expand" src="resources/images/expand.png" /><div class="sectionHeader"> Trailoring For Prints </div></td>
			  </tr>
			  <tr>
				<td>
					<div id="includedContent-section-3"></div>		
				</td>
			  </tr>
			  <tr>
				<td>&nbsp;</td>
			  </tr>
			  <tr>
				<td><img id="collapse-4" class="expandCollapseToggle expand" src="resources/images/expand.png" /><div class="sectionHeader"> Others </div></td>
			  </tr>
			  <tr>
			    <td>
					<div id="includedContent-section-4"></div>
				</td>
			  </tr>
			  <tr>
				<td>&nbsp;</td>
			  </tr>
			  <tr>
			    <td>
					<div id="includedContent-section-5"></div>
				</td>
			  </tr>
			  <tr>
				<td height="43px" background="resources/images/index_24.gif" class="copyright" style="background-repeat:repeat-x">
					<div id="includedContent-footer"></div>	
				</td>
			  </tr>
			</table>
		</td>
      </tr>
    </table>
	</td>
    <td width="15">&nbsp;</td>
  </tr>
</table>
</div>
<div id="film_service_sections">
<%@include file="/WEB-INF/jsp/overlay/film_service_pricing_exchange.jsp"%>
<%@include file="/WEB-INF/jsp/overlay/film_service_pricing_section_common.jsp"%>
<%@include file="/WEB-INF/jsp/overlay/film_service_pricing_section_1.jsp"%>
<%@include file="/WEB-INF/jsp/overlay/film_service_pricing_section_2.jsp"%>
<%@include file="/WEB-INF/jsp/overlay/film_service_pricing_section_3.jsp"%>
<%@include file="/WEB-INF/jsp/overlay/film_service_pricing_section_4.jsp"%>
<%@include file="/WEB-INF/jsp/overlay/film_service_pricing_total.jsp"%>
<%@include file="/WEB-INF/jsp/overlay/film_service_pricing_footer.jsp"%>
</div>
<input type="submit" value="Submit Estimate">
</form:form>