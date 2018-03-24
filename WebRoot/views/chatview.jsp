<%@page language="java" contentType="text/html; charset=utf-8"
import="java.util.*" 
import="main.*" %>
<%  response.setContentType("text/html; charset=utf-8");
	request.setCharacterEncoding("utf-8");
	String isonline=(String)session.getAttribute("isonline");
	String admine="";
	String name="";
	String toadmine="";
	String toname="";
	List<User> fs=null;
  if(isonline==null||isonline.equals("false")){
  	   response.sendRedirect("/webtest/index.jsp");
  }else{
  		admine=(String)session.getAttribute("admine");
  		name=(String)session.getAttribute("name");
  	    toadmine=(String)request.getParameter("toadmine");
  	    toname=(String)request.getParameter("toname");    
  }
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>聊天</title>
    <link href="/webtest/views/css/base.css" rel="stylesheet" style="text/css"/>
</head>
<body style="text-align: center;height: 100%">
<div class="topdiv">
    <div style="height:20%"></div>
    <label style="float: left;margin-left: 30px;" class="h2">与<%=toname%>聊天中</label>
    <label style="margin: auto;" class="h1">畅&nbsp;&nbsp;&nbsp;聊</label>
    <label style="float: right;margin-right: 30px;" class="h2" onclick="goback()">返回</label>
    <div style="height:20%"></div>
</div>
<div class="leftdiv">
<div style="height: 20px;width: 100%;"></div>
    <label class="h2" style="margin-top:10px;">好友信息</label>
    <img src="../file/timg.jpg" class="myimg"><br>
    <label>账号：<span id="admine"><%=toadmine %></span></label><br>
    <label>姓名：<span id="name"><%=toname %></span></label>
</div>
<div class="contentdiv">
    <label class="h1" style="display table;height: 5%;"><%=toname%></label>
    <div class="chatdiv" id="chat">
    <div style="height: 1px"></div>
    </div>
    <div id="app" class="msgdiv" >
        <textarea onkeydown="entersend(<%="'"+toadmine+"'"%>)" style="width: 80%;height: 100%;float: left;" class="textarea" id="msg"></textarea>
        <div style="display: inline-block;height:100%;width:20%;">
        <div style="height:30%;"></div>
        <button onclick="sendmsg(<%="'"+toadmine+"'"%>)" style="width: 80%;height: 40%;">发送</button>
        <div style="height:30%;"></div>
        </div>
    </div>
</div>
</body>
</html>