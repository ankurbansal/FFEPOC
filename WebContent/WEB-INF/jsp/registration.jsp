<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.net.URL" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<title>FFE - Registration</title>
<link href="./resources/css/TVNDEstyle.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">
<!--
body {
	background-image: url();
	background-repeat: repeat-y;
	background-color: #f4f6f7;
}
-->
</style>
</head>

<body>
	<div id="BannerTopBgContainer">
		<!--BannerTopBgContainer start-->
		<div id="BannerMainContainer">
			<!--BannerMainContainer start-->
			<div class="LogoContainer">
				<img src="images/NBCUlogo.gif" border="0" />
			</div>
			<div class="WelcomeUserContainer">
				<!--WelcomeUserContainer start-->
				<div class="UserNameContainer">Welcome, Jane Smith</div>
				<div class="MyAccountContainer">My Account</div>
				<div class="CartTextContainer">0 Files in Cart</div>
				<div class="ClearFloat"></div>
			</div>
			<!--WelcomeUserContainer end-->
			<div class="ClearFloat"></div>
			<div id="MainNavigationContainer">
				<!--MainNavigationContainer start-->
				<div class="TopNavLinkContainer">
					<!--TopNavLinkContainer start-->
					<div class="TopNav_Link">
						<!--Footer_BotLink start-->
						<ul>
							<li><a href="#" class="TopNavLink">tecnical info</a></li>
							<li class="TopNavDivider"></li>
							<li><a href="#" class="TopNavLink">launch forms</a></li>
							<li><div class="TopNavArrow">
									<img src="images/DownArrowBlk.gif" border="0" />
								</div></li>
							<li class="TopNavDivider"></li>
							<li><a href="#" class="TopNavLink">help</a></li>
							<div class="ClearFloat"></div>
						</ul>
					</div>
					<!--Footer_BotLink end-->
				</div>
				<!--TopNavLinkContainer end-->
			</div>
			<!--MainNavigationContainer end-->
		</div>
		<!--BannerMainContainer end-->
	</div>
	<!--BannerTopBgContainer end-->
	<div id="InnerMainContainer">
		<!--InnerMainContainer start-->
		<div class="InnerTopCurveContainer"></div>
		<div class="InnerMidBgContainer">
			<!--InnerMidBgContainer start-->
			<div id="InnerContentMainContainer">
				<!--InnerContentMainContainer start-->
				<div class="InnerPageTitle">New User Registration</div>
				<div class="InnerHeaderDivLine">
					<img src="images/HeaderDivLine.jpg" border="0" />
				</div>
				<div class="InnerErrorMessageBox">
					<!--InnerErrorMessageBox start-->
					<div class="ErrorMessageContainer">
						<!--ErrorMessageContainer start-->
						<div class="ErrorMessageText">There were errors in your
							submission.</div>
						<div class="ErrorMessageSubText">Please correct the
							highlighted fields below</div>
					</div>
					<!--ErrorMessageContainer end-->
				</div>
				<!--InnerErrorMessageBox end-->
				<div class="SectionTitleText">About You</div>
				<div class="SectionTextSubDivLine">
					<img src="images/SubDivLine.jpg" border="0" />
				</div>
			<form:form modelAttribute="UserProfile" action="./register" method="POST" id="user_form" >
				<div class="InnerSubFormContainer">
					<!--InnerSubFormContainer start-->
					<div class="InnerFormLeftContainer">
						<!--InnerFormLeftContainer start-->
						<div class="ErrorFieldText">First Name is required</div>
						<div class="FieldText">
							First Name<span class="FieldTextStar">*</span>
						</div>
						<div class="TextBoxFld">
						<form:input path="firstName" maxlength="255" type="text" cssClass="TextBoxLong"/>
						</div>
					</div>
					<!--InnerFormLeftContainer end-->
					<div class="InnerFormRightContainer">
						<!--InnerFormRightContainer start-->
						<div class="ErrorFieldText">Last Name is required</div>
						<div class="FieldText">
							Last Name<span class="FieldTextStar">*</span>
						</div>
						<div class="TextBoxFld">
							<form:input path="lastName" maxlength="255" type="text" cssClass="TextBoxLong"/>
						</div>
					</div>
					<!--InnerFormRightContainer end-->
					<div class="ClearFloat"></div>
					<div class="LineHight"></div>
					<div class="InnerFormLeftContainer">
						<!--InnerFormLeftContainer start-->
						<div class="ErrorFieldText">Not a valid email address</div>
						<div class="FieldText">
							Email<span class="FieldTextStar">*</span>
						</div>
						<div class="TextBoxFld">
						<form:input path="email" maxlength="300"  type="text" cssClass="TextBoxLong"/>
						</div>
					</div>
					
					<div class="ClearFloat"></div>
					<div class="LineHight"></div>
					<div class="InnerFormLeftContainer">
						<!--InnerFormLeftContainer start-->
						<div class="ErrorFieldText">Password is required</div>
						<div class="FieldText">
							Password<span class="FieldTextStar">*</span>
						</div>
						<div class="TextBoxFld">
							<form:password path="password" maxlength="300"  cssClass="TextBoxLong"/>
						</div>
						<div class="FieldTextSub">Must be at least 8 characters</div>
					</div>
					<!--InnerFormLeftContainer end-->
					<div class="InnerFormRightContainer">
						<!--InnerFormRightContainer start-->
						<div class="ErrorFieldTextEmpt"></div>
						<div class="FieldText">
							Confirm Password<span class="FieldTextStar">*</span>
						</div>
						<div class="TextBoxFld">
							<input name="" type="password" class="TextBoxLong" />
						</div>
					</div>
					<!--InnerFormRightContainer end-->
					<div class="ClearFloat"></div>
					<div class="LineHight"></div>
					<div class="InnerFormLeftContainer">
						<!--InnerFormLeftContainer start-->
						<div class="ErrorFieldText"></div>
						<div class="FieldText">
							Job Title<span class="FieldTextStar">*</span>
						</div>
						<div class="TextBoxFld">
							<input name="" type="text" class="TextBoxLong"
								value="Senior UX Designer" />
						</div>
					</div>
					<!--InnerFormLeftContainer end-->
					<div class="InnerFormRightContainer">
						<!--InnerFormRightContainer start-->
						<div class="ErrorFieldText"></div>
						<div class="FieldText">
							Job Function<span class="FieldTextStar">*</span>
						</div>
						<div class="TextBoxFld">
							<label> 
							<form:select path="territoryId"  items="${territorys}" itemValue="territoryId"  itemLabel="name" cssClass="refTypeSelect" />
							</select>
							</label>
						</div>
						<div class="TextBoxFld">
							<label> 
							<form:select path="moneyFormatterId"  cssClass="refTypeSelect" >
							<form:option value="xxx,xxx,xxx,xxxx">xxx,xxx,xxx,xxxx</form:option>
							<form:option value="xx,xx,xx,xxxx">xx,xx,xx,xxxx</form:option>
							</form:select>
							</label>
						</div>
					</div>
					<!--InnerFormRightContainer end-->
					<div class="ClearFloat"></div>
					<div class="LineHight"></div>
					<!--InnerFormLeftContainer end-->
					
				</div>
				<input type="submit"/>
			</form:form>
					
				
				
				<!--InnerSubFormContainer end-->
			
			<!--InnerContentMainContainer end-->
	
		<!--InnerMidBgContainer end-->
	
		<div class="BottomFooterContainer">
			<!--BottomFooterContainer start-->
			<div class="BotFooterLinkContainer">
				<!--BotFooterLinkContainer start-->
				<div class="Footer_BotLink">
					<!--Footer_BotLink start-->
					<ul>
						<li><a href="#" class="FooterLink">shop</a></li>
						<li class="FooterDivider">|</li>
						<li><a href="#" class="FooterLink">newsletter</a></li>
						<li class="FooterDivider">|</li>
						<li><a href="#" class="FooterLink">Materials</a></li>
						<li class="FooterDivider">|</li>
						<li><a href="#" class="FooterLink">Usage Guidelines</a></li>
						<li class="FooterDivider">|</li>
						<li><a href="#" class="FooterLink">Terms &amp; Conditions</a></li>
						<li class="FooterDivider">|</li>
						<li><a href="#" class="FooterLink">Privacy Policy</a></li>
						<li class="FooterDivider">|</li>
						<li><a href="#" class="FooterLink">Site map</a></li>
						<li class="FooterDivider">|</li>
						<li><a href="#" class="FooterLink">Help</a></li>
						<div class="ClearFloat"></div>
					</ul>
				</div>
				<!--Footer_BotLink end-->
			</div>
			<!--TopNavContainer end-->
		</div>
		<!--BotFooterLinkContainer start-->
		<div class="CopyRightContainer">© 2011 NBCUniversal</div>
	</div>
	<!--InnerMainContainer end-->
	</div>
	</div>
</body>
</html>
