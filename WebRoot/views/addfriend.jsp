<%@page language="java" pageEncoding="utf-8"
import="java.util.*" 
import="main.*" %>
<% 
	String isonline=(String)session.getAttribute("isonline");
	String admine="";
	String name="";
	ArrayList<User> fs=null;
  if(isonline==null||isonline.equals("false")){
  	   response.sendRedirect("/webtest/index.jsp");
  }
  else{
  	  fs=(ArrayList<User>)session.getAttribute("result");
  	  if(fs==null)
  	  fs=new ArrayList<User>();
  }
  
%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>添加好友</title>
    </head>
    <body style="width: 100%;height: 100%;text-align: center;">
		<h3 onclick="goback()" style="float: right; margin-right:80px;display:inline;color: #04aad4">返回</h3>
        <h2>&nbsp;&nbsp;&nbsp;&nbsp;添加好友</h2>
        <div style="text-align:center">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;按账号/姓名查找：<br>
            
                <input id="findvalue" type="text" name="searchwho" value="账号或姓名">
                <input type="submit" value="查找" onclick="find()" >
            <br>
            <br>
            
            <% if(fs.size()==0){%>
            		<h2 style="color: red;">没有此用户！！！</h2>
           		<% }else{
           		for(int i=0;i<fs.size();i++){
            		User item=fs.get(i);
            %>
            <div style="width: 50%;display: inline-block;border: 2px solid cornflowerblue;height: 40px;line-height: 40px;margin: 5px">
                <img src="../file/timg.jpg" style="height: 40px;float: left">
                <label style="float: left">账号：<%=item.admine%></label>
                <label style="width: 30%">&nbsp;</label>
                <label style="float: left">姓名：<%=item.name%></label>
                <button style="float: right; margin-top: 1%;margin-right: 10px" onclick="add(<%="'"+item.admine+"'"%>,<%="'"+item.name+"'"%>)">添加</button>
            </div>
            <% }
            }%>
        </div>
    </body>
</html>
