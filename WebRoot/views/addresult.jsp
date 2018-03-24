<%@ page language="java" contentType="text/html; charset=utf-8"%>
<% String result=(String)request.getAttribute("addresult"); %>
<!DOCTYPE html>
<html style="width:100%;height:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="width:100%;height:100%;">
	<div style="float: right; width:100px;height: 100px;display: inline;">
	<h2 style="float:left;display:inline; color: #04aad4" onclick="load('/webtest/views/addfriend.jsp')">返回</h2>
	</div>
	<h2><%=result %></h2>
</body>
</html>