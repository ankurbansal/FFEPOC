<%@include file="/WEB-INF/jsp/include.jsp"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="left" valign="top">    
	    <table id="title_results_table">
				<!-- thead>
					<tr>
						<th name ="title_id" width="156">Title Id</th>
						<th name ="title_name" width="156">Title Nam</th>
						<th name ="wpr_number" width="156">WPR Number</th>
						<th name ="product_number" width="156">Product Number</th>
						<th name ="edi_code"  width="156">EDI Code</th>
					</tr>
				</thead-->		
				</tbody>
				<tbody>
				<c:forEach items="${titlesList}" var="title" varStatus="itrStatus">
					<tr>
						<td>${title.titleId}</td>
						<td><a href="./viewtitle?titleId=${title.titleId}">${title.titleName}</a></td>
						<td>${title.wprNumber}</td>
						<td>${title.productNumber}</td>
						<td>${title.edicode}</td>						
					</tr>
				</c:forEach>				
			</table>   
    </td>
  </tr>
</table>
<script type="text/javascript">
/* 	jQuery(document).ready(function($) {
		$("#title_results_table").flexigrid({			
			title: "Title Results",
			sortname: "title_id",
			sortorder: "asc",
			width: 850,
			height: 400,
			//sortable: true,			
		});
	}); */ 
	if (!jQuery.cookie) {
		jQuery.cookie = function(){};
	}
	jQuery(document).ready(function($) {
		$("#title_results_table").flexigrid({
			dataType: 'json',
			colModel : [
				{display: 'Title Id', name : 'title_id', width : 155, sortable : true, align: 'center'},
				{display: 'Title Name', name : 'title_name', width : 155, sortable : true, align: 'left'},
				{display: 'WPR Number', name : 'wpr_number', width : 155, sortable : true, align: 'left'},
				{display: 'Product Number', name : 'product_number', width : 155, sortable : true, align: 'left'},
				{display: 'EDI Code', name : 'edi_code', width : 155, sortable : true, align: 'left'}
			],
			title: "Title Results",
			sortname: "product_number",
			sortorder: "asc",
			showTableToggleBtn: true,
			width: 837,
			height: 'auto',
			searchitems : [
				{display: 'title_id', name : 'iso'},
				{display: 'title_name', name : 'name', isdefault: true}
			],								
		});
	}); 
</script>
