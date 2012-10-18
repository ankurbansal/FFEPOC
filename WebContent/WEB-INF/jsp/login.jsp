<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TVNDE - Login</title>
<link href="./resources/css/login_page_style.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-image: url();
	background-repeat: repeat-y;
	background-color: #f4f6f7;
}
-->
</style></head>

<body>
<div id="BannerTopBgContainer"><!--BannerTopBgContainer start-->
	<div id="BannerMainContainer"><!--BannerMainContainer start-->
    	<div class="LogoContainer"><img src="./resources/images/FFElogo.jpg" border="0" style="margin-top: -72px;" /></div>
        <div class="ClearFloat"></div>
        <div class="NavTopHeight"></div>
        <div id="MainNavigationContainer"><!--MainNavigationContainer start-->
            <div class="TopNavLinkContainer"><!--TopNavLinkContainer start-->
                <div class="TopNav_Link"><!--Footer_BotLink start-->
                </div><!--Footer_BotLink end-->
            </div><!--TopNavLinkContainer end-->
        </div><!--MainNavigationContainer end-->
    </div><!--BannerMainContainer end-->
</div><!--BannerTopBgContainer end-->
<div id="InnerMainContainer"><!--InnerMainContainer start-->
	<div class="InnerTopCurveContainer"></div>
    <div class="InnerMidBgContainer"><!--InnerMidBgContainer start-->
		<div id="InnerContentMainContainer"><!--InnerContentMainContainer start-->
          <div class="LoginBoxContainer"><!--LoginBoxContainer start-->
            	<div class="LoginPreLoginTextMessage">Log in to FFE Affiliate Site</div>
                <div class="InnerPreLoginContainer"><!--InnerPreLoginContainer start-->
                <form  action="./j_spring_security_check"  id="tiles_person_form" method="post">
                	<div class="PreLoginLbl">Email</div>
            
                    <div class="PreLoginFld"><input name="userloginid" type="text" class="PreLoginTextBox"/></div>
                    <div class="ClearFloat"></div>
                    <div class="PreLoginLblHeight"></div>
                    <div class="PreLoginLbl">Password</div>
                    <div class="PreLoginFld"><input name="userloginpassword" type="password" class="PreLoginTextBox"/></div>
                    <div class="ClearFloat"></div>
                    <div class="LoginLblHeight"></div>
                  	<div class="PreLoginLblEmpty"><img src="./resources/images/Spacer.png" border="0" width="62px" height="1px"/></div>
                    <div class="LoginCheckBox"><input name="input2" type="checkbox" value="" /></div>
                  	<div class="LoginCheckFld">Remember me</div>
                  	<div class="LoginBtnContainer" >
                  	<input type="submit"/>
                  	<img src="./resources/images/Btn_Submit.jpg" border="0" /></div>
                    <div class="ClearFloat"></div>
              </div><!--InnerPreLoginContainer end-->
              </form />
              <div class="PreLoginFooterLinkContainer"><!--PreLoginFooterLinkContainer Start-->
       	    <div class="PreLoginForgotPass">Forgot Password?</div>
                    <div class="PreLoginFooterDivLine"><img src="./resources/images/PreLoginFooterDivLine.jpg" border="0" /></div>
                    <div class="PreLoginRegister">Register for a new account</div>
                    <div class="ClearFloat"></div>
                </div><!--PreLoginFooterLinkContainer end-->
          </div><!--LoginBoxContainer end-->
            <div class="PreLoginBotSpace"></div>
        </div><!--InnerContentMainContainer end-->
    </div><!--InnerMidBgContainer end-->
    <div class="InnerBotCurveContainer"></div>
    <div class="BottomFooterContainerSmall"><!--BottomFooterContainerSmall start-->
			<div class="BotFooterLinkContainer"><!--BotFooterLinkContainer start-->
    			<div class="Footer_BotLink"><!--Footer_BotLink start-->
                        <ul>
                        <li><a href="#" class="FooterLink">help</a></li>
                        <li class="FooterDivider">|</li>
                        <li><a href="#" class="FooterLink">Materials Usage Guidelines</a></li>
                        <li class="FooterDivider">|</li>
                        <li><a href="#" class="FooterLink">Terms &amp; Conditions</a></li>
                        <li class="FooterDivider">|</li>
                        <li><a href="#" class="FooterLink">Privacy Policy</a></li>
                        <div class="ClearFloat"></div>
                        </ul> 
				</div><!--Footer_BotLink end-->
            </div><!--TopNavContainer end-->
    </div><!--BotFooterLinkContainerSmall start-->
    <div class="CopyRightContainer">© 2011 xxxxxxxxxx</div>
</div><!--InnerMainContainer end-->

</body>
</html>
