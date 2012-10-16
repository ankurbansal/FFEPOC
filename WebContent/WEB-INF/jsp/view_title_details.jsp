<%@include file="/WEB-INF/jsp/include.jsp"%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td align="left" valign="top"><table width="100%" border="0" cellspacing="2" cellpadding="2">
	      <tr>
	        <td class="heading">TITLE - ${title.titleName}</td>
	      </tr>
	      <tr>
	        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td width="15%" class="headingbutton1">View</td>              
	                <td width="85%">&nbsp;</td>
	              </tr>
	            </table></td>
	          </tr>
	          <tr>
	            <td height="271" align="left" valign="top" class="table1"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="11%" height="32" align="left" valign="middle" class="content">Title Id</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="23%" align="left" valign="middle">${title.titleId}</td>
	                    <td width="12%" align="left" valign="middle" class="content">WPR Number</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="18%" align="left" valign="middle">${title.wprNumber}</td>
	                    <td width="14%" align="left" valign="middle" class="content">Product Number</td>
	                    <td width="1%" align="left" valign="middle" class="content">:</td>
	                    <td width="17%" align="left" valign="middle">${title.productNumber}</td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="11%" height="31" align="left" valign="middle" class="content">MPA Number</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="23%" align="left" valign="middle">${title.mpaNumber}</td>
	                    <td width="12%" align="left" valign="middle" class="content">Video Catelog #</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="18%" align="left" valign="middle">${title.videoCatelog}</td>
	                    <td width="14%" align="left" valign="middle" class="content">Visa</td>
	                    <td width="1%" align="left" valign="middle" class="content">:</td>
	                    <td width="17%" align="left" valign="middle">${title.visa}</td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="11%" height="29" align="left" valign="middle" class="content">EDI Code</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="23%" align="left" valign="middle">${title.edicode}</td>
	                    <td width="12%" align="left" valign="middle" class="content">Release year</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="18%" align="left" valign="middle">
		                    <select id="releaseYearSelect" style="max-width:146px;" disabled>
								<option value="0"></option>								
								<option value="1999" ${title.releaseyear == '1999' ? 'selected' : ''} >1999</option>
								<option value="2000" ${title.releaseyear == '2000' ? 'selected' : ''} >2000</option>
								<option value="2001" ${title.releaseyear == '2001' ? 'selected' : ''} >2001</option>
								<option value="2002" ${title.releaseyear == '2002' ? 'selected' : ''} >2002</option>
								<option value="2003" ${title.releaseyear == '2003' ? 'selected' : ''} >2003</option>
								<option value="2004" ${title.releaseyear == '2004' ? 'selected' : ''} >2004</option>
								<option value="2005" ${title.releaseyear == '2005' ? 'selected' : ''} >2005</option>
								<option value="2006" ${title.releaseyear == '2006' ? 'selected' : ''} >2006</option>
								<option value="2007" ${title.releaseyear == '2007' ? 'selected' : ''} >2007</option>								
								<option value="2008" ${title.releaseyear == '2008' ? 'selected' : ''} >2008</option>
								<option value="2009" ${title.releaseyear == '2009' ? 'selected' : ''} >2009</option>
								<option value="2010" ${title.releaseyear == '2010' ? 'selected' : ''} >2010</option>
								<option value="2011" ${title.releaseyear == '2011' ? 'selected' : ''} >2011</option>
								<option value="2012" ${title.releaseyear == '2012' ? 'selected' : ''} >2012</option>
								<option value="2013" ${title.releaseyear == '2013' ? 'selected' : ''} >2013</option>
								<option value="2014" ${title.releaseyear == '2014' ? 'selected' : ''} >2014</option>
								<option value="2015" ${title.releaseyear == '2015' ? 'selected' : ''} >2015</option>
								<option value="2016" ${title.releaseyear == '2016' ? 'selected' : ''} >2016</option>	
							</select>	                    
	                    </td>
	                    <td width="14%" align="left" valign="middle" class="content">Country of Origin</td>
	                    <td width="1%" align="left" valign="middle" class="content">:</td>
	                    <td width="17%" align="left" valign="middle">
	                    	<select id="countrySelect" path="countryid" style="max-width:146px;" disabled>
								<option value="0"></option>								
								<option value="HT" ${title.countryid == 'HT' ? 'selected' : ''} >Haiti</option>
								<option value="HM" ${title.countryid == 'HM' ? 'selected' : ''} >Heard and Mc Donald Islands</option>
								<option value="VA" ${title.countryid == 'VA' ? 'selected' : ''} >Holy See (Vatican City State)</option>
								<option value="HN" ${title.countryid == 'HN' ? 'selected' : ''} >Honduras</option>
								<option value="HK" ${title.countryid == 'HK' ? 'selected' : ''} >Hong Kong</option>
								<option value="HU" ${title.countryid == 'HU' ? 'selected' : ''} >Hungary</option>
								<option value="IS" ${title.countryid == 'IS' ? 'selected' : ''} >Iceland</option>
								<option value="IN" ${title.countryid == 'IN' ? 'selected' : ''} >India</option>
								<option value="ID" ${title.countryid == 'ID' ? 'selected' : ''} >Indonesia</option>
								<option value="IR" ${title.countryid == 'IR' ? 'selected' : ''} >Iran (Islamic Republic of)</option>
								<option value="IQ" ${title.countryid == 'IQ' ? 'selected' : ''} >Iraq</option>
								<option value="IE" ${title.countryid == 'IE' ? 'selected' : ''} >Ireland</option>
								<option value="IL" ${title.countryid == 'IL' ? 'selected' : ''} >Israel</option>
								<option value="IT" ${title.countryid == 'IT' ? 'selected' : ''} >Italy</option>							
								<option value="PN" ${title.countryid == 'PN' ? 'selected' : ''} >Pitcairn</option>						
								<option value="YE" ${title.countryid == 'YE' ? 'selected' : ''} >Yemen</option>
								<option value="YU" ${title.countryid == 'YU' ? 'selected' : ''} >Yugoslavia</option>
								<option value="ZM" ${title.countryid == 'ZM' ? 'selected' : ''} >Zambia</option>
								<option value="ZW" ${title.countryid == 'ZW' ? 'selected' : ''} >Zimbabwe</option>								
							</select>
						</td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="11%" height="28" align="left" valign="middle" class="content">Running Time</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="23%" align="left" valign="middle">  ${title.hh} : ${title.mm} : ${title.ss} </td>
	                    <td width="12%" align="left" valign="middle" class="content">Aspect Ratio</td>
	                    <td width="2%" align="left" valign="middle" class="content">:</td>
	                    <td width="18%" align="left" valign="middle">
	                    	<select id="aspectRatioSelect" path="aspectRatio" style="max-width:146px;" disabled>
								<option value="0"></option>								
								<option value="1" ${title.aspectRatio == 1 ? 'selected' : ''} >Haiti</option>
								<option value="2" ${title.aspectRatio == 2 ? 'selected' : ''} >Heard and Mc Donald Islands</option>
								<option value="3" ${title.aspectRatio == 3 ? 'selected' : ''} >Holy See (Vatican City State)</option>
								<option value="4" ${title.aspectRatio == 4 ? 'selected' : ''} >Honduras</option>
								<option value="5" ${title.aspectRatio == 5 ? 'selected' : ''} >Hong Kong</option>
								<option value="6" ${title.aspectRatio == 6 ? 'selected' : ''} >Hungary</option>																			
							</select>	</td>
	                    <td width="14%" align="left" valign="middle" class="content">Language</td>
	                    <td width="1%" align="left" valign="middle" class="content">:</td>
	                    <td width="17%" align="left" valign="middle">
	                    	<select id="languageSelect" path="languageId" style="max-width:146px;" value="${title.languageId}" disabled>
								<option value="0"></option>
								<option value="1" ${title.languageId == 1 ? 'selected' : ''} >Arabic</option>								
								<option value="2" ${title.languageId == 2 ? 'selected' : ''} >English</option>
								<option value="3" ${title.languageId == 3 ? 'selected' : ''} >German</option>
								<option value="4" ${title.languageId == 4 ? 'selected' : ''} >Mandarian</option>
								<option value="5" ${title.languageId == 5 ? 'selected' : ''} >French</option>
								<option value="6" ${title.languageId == 6 ? 'selected' : ''} >Japanese</option>
								<option value="7" ${title.languageId == 7 ? 'selected' : ''} >Latin</option>
								<option value="8" ${title.languageId == 8 ? 'selected' : ''} >Singalese</option>
								<option value="9" ${title.languageId == 9 ? 'selected' : ''} >Telugu</option>
								<option value="10" ${title.languageId == 10 ? 'selected' : ''} >Kannada</option>								
								<option value="11" ${title.languageId == 11 ? 'selected' : ''} >Malayalam</option>
								<option value="12" ${title.languageId == 12 ? 'selected' : ''} >Spanish</option>								
								<option value="13" ${title.languageId == 13 ? 'selected' : ''} >Urdu</option>
								<option value="14" ${title.languageId == 14 ? 'selected' : ''} >Hindi</option>															
								<option value="15" ${title.languageId == 15 ? 'selected' : ''} >Punjabi</option>
								<option value="16" ${title.languageId == 16 ? 'selected' : ''} >Marathi</option>
								<option value="17" ${title.languageId == 17 ? 'selected' : ''} >Gujrathi</option>						
								<option value="18" ${title.languageId == 18 ? 'selected' : ''} >Bengali</option>
								<option value="19" ${title.languageId == 19 ? 'selected' : ''} >Tamil</option>																					
							</select></td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td height="32" align="left" valign="middle">Active Flag
	                	<input type="checkbox" id="activeFlag" value="${title.activeFlag}" disabled/>	                  
	              </tr>
	              <tr>
	                <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>
	                    <td width="16%" height="107" align="left" valign="top">Rights 
	                      Notification</td>
	                    <td width="84%" align="left" valign="top">${title.rightsNotification}</td>
	                  </tr>
	                </table></td>
	              </tr>
	              <tr>
	                <td align="center" valign="top"><table width="20%" border="0" cellspacing="0" cellpadding="0">
	                  <tr>	                   
	                    <td align="center" valign="top"><a href="./edittitle?titleId=${title.titleId}">Edit Title</a></td>
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
	<input type="hidden" id="titleId" value="${title.titleId}"/>		
