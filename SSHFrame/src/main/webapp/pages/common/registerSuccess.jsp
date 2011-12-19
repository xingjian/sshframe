<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>loginSuccess</title>
</head>
<body>
	<div>
          <h4>注册用户成功,请记住以下信息:</h4>
          <h4>用户ID:<h4><font color="red">${pbUser.id}</font>
          <h4>用户名:<h4><font color="red">${pbUser.name}</font>
          <h4>密码:<h4><font color="red">${pbUser.password}</font>
          <h4>Email:<h4><font color="red">${pbUser.email}</font>
    </div>
</body>
</html>