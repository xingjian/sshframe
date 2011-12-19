<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>注册用户</title>
</head>
<body>
	<br><br><br>
	<br><br><br>
	<br><br><br>
	<s:form action="register" namespace="/" method="post" theme="simple">
	<table width="550" border="1" align="center" cellspacing="0" cellpadding="0">
	  <caption>
	    SSHFrame测试
	  </caption>
	  <tr align="center">
	    <td>用户名：</td>
	    <td colspan="2"><input name="pbUser.name" border="" type="text" size="20" maxlength="20" /></td>
	  </tr>
	  <tr align="center">
	    <td>密&nbsp&nbsp码：</td>
	    <td colspan="2"><input name="pbUser.password" type="password" size="22" maxlength="10" /></td>
	  </tr>
	   <tr align="center">
	    <td>Email：</td>
	    <td colspan="2"><input name="pbUser.email" border="" type="text" size="20" maxlength="20" /></td>
	  </tr>
	  <tr align="center">
	   <td><input name="resetBtn" type="reset" value="重 置" /></td>
	  	<td><input name="registerBtn" type="submit" value="注册" /></td>
	  </tr>
	</table>
	<br><br><br>
	<br><br><br>
	<br><br><br>
	<center>需要用IE6.0或6.0以上的浏览器,1280*800分辨率<center>	
	</s:form>	
	</body>
</body>
</html>