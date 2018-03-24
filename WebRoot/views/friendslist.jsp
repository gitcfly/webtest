<%@ page language="java" pageEncoding="utf-8"
import="java.util.*" 
import="main.*" 
import="java.sql.*" 
%>
<%String isonline=(String)session.getAttribute("isonline");
	String admine="";
	String name="";
	ArrayList<User> friends=new ArrayList<User>();
  if(isonline==null||isonline.equals("false")){
  	   response.sendRedirect("/webtest/index.jsp");
  }else{
  		admine=(String)session.getAttribute("admine");
  		name=(String)session.getAttribute("name");
  		String sql="select * from users where admine in (select admine2 from friendship where admine1='"+admine+"')";
  		ResultSet set=tomysql.querysql(sql);
  		try{
  			while(set.next()){
  				User user=new User(set.getString("name"),set.getString("admine"));
  				friends.add(user);
  			}
  		}catch(Exception e){
  			e.printStackTrace();
  		}
  		session.setAttribute("friends",friends);
  }
 %>
<!DOCTYPE html>

<html style="width:100%;height:99%;">
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<script src="./js/chat.js"></script>
        <link href="/webtest/views/css/base.css" rel="stylesheet" style="text/css"/>
        <title>好友列表</title>
    </head>
    <body id="bd" style="text-align: center;width:100%;height:100%;">
        <div class="topdiv">
        	<div style="height:20%"></div>
            <label style="float: left;margin-left: 30px;" class="h2">欢迎，<%=name%></label>
            <label style="margin: auto;" class="h1">畅&nbsp;&nbsp;&nbsp;聊</label>
            <label style="float: right;margin-right: 30px;" class="h2" onclick="load('/webtest/index.jsp')">退出</label>
        	<div style="height:20%"></div>
        </div>
        <div class="leftdiv">
            <img src="../file/timg.jpg" class="myimg"><br>
            <label>账号：<%=admine %></label><br>
            <label>姓名：<%=name %></label><br>
            <br>
            <label class="h2" style="color: lavenderblush" onclick="load('/webtest/views/addfriend.jsp')">添加好友</label></a>
        </div>
        <div  class="contentdiv">
            <h2>畅聊，拉近你我的距离</h2>
            <% for (User user:friends ){ %>
                <div id="app" class="mydiv">
                    <img src="../file/timg.jpg" height="50px" style="float: left;">
                    <label style="float: left" class="text">><%=user.name%></label>
             
                    <button class="text" style="float:right;" onclick="chat(<%="'"+user.admine+"'"%>,<%="'"+user.name+"'"%>)" >聊天</button>
                </div>
            <% }%>
        </div>
    </body>
</html>