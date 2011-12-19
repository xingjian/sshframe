<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>loginSuccess</title>
</head>
<body>
	 <div>
          <h4>欢迎你!</h4><font color="red">${requestScope.userName}</font>
          <h4>你登录的密码是<h4><font color="red">${password}</font>
      </div>
</body>
</html>