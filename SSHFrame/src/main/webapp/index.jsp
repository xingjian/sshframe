<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>PromisePB软件</title>
	</head>
	<body background="images/background.jpg">
	<bgsound src="music/backgroundmusic.mp3" loop="-1">
	<marquee behavior=alternate>PromisePB软件欢迎您光临！</marquee>
	<br><br><br>
	<br><br><br>
	<br><br><br>
	<s:form action="login" method="post" theme="simple">
	<table width="250" border="1" align="center" cellspacing="0" cellpadding="0">
	  <caption>
	    PromisePB软件登录系统
	  </caption>
	  <tr align="center">
	    <td>用户名：</td>
	    <td colspan="2"><input name="username" border="" type="text" size="20" maxlength="20" /></td>
	  </tr>
	  <tr align="center">
	    <td>密&nbsp&nbsp码：</td>
	    <td colspan="2"><input name="password" type="password" size="22" maxlength="10" /></td>
	  </tr>
	  <tr align="center">
	  	 <td><input name="registerBtn" type="button" value="注 册" /></td>
	     <td><input name="loginBtn" type="submit" value="登 录" /></td>
		 <td><input name="resetBtn" type="reset" value="重 置" /></td>
	  </tr>
	</table>
	<br><br><br>
	<br><br><br>
	<br><br><br>
	<center>需要用IE6.0或6.0以上的浏览器,1280*800分辨率<center>	
	</s:form>	
	</body>
</html>