<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html style="height:100%;width:100%;">
    <head>
   		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>设置用户名</title>
        <link href="/webtest/views/css/firstpage.css" rel="stylesheet" style="text/css"/>
		<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
		<script type="text/javascript">
			login();
			function login(){
				document.getElementById("register").style.display="none";
				document.getElementById("login").style.display="block";
			}
			function register(){
				document.getElementById("login").style.display="none";
				document.getElementById("register").style.display="block";
			}
		</script>
    </head>
    <body   style="height:100%;width:100%;">
        <div id="app" style="margin: auto;text-align: center;vertical-align: middle;width: 100%;height: 100%; ">
            <h2>畅聊，即使天涯，也在咫尺！</h2>
            <div style="height: 10%;width: 100%;"></div>
           	<div style="width: 35%;height: 400px;float: left;"></div> 
            <el-form id="login" method="post" ref="form" label-width="40px" size="mini" style="padding: 20px;width:30%; float:left; background-color: #64B9B8;" action="/webtest/Login" >
 			   
 			    <el-button type="primary" style="margin:10px; width: 40%">登录</el-button>
 			    <el-form-item style="color: #ffffff;" label="账号">
    				<el-input name="admine"></el-input>
 			    </el-form-item>
 			    <el-form-item style="color: #ffffff;" label="密码">
    				<el-input type="password" name="password"></el-input>
 			    </el-form-item>
 			    <el-form-item>
 			    	<el-input type="submit" value="登录" style="width: 120px;"></el-input>
 			    	<el-button onclick="register()" style="width: 120px;" type="primary" plain>注册</el-button>
  				</el-form-item>
            </el-form>
         
            <el-form id="register" method="post" ref="form" label-width="40px" size="mini" style="padding: 20px;background-color: #64B9B8;width:30%;float:left;display:none;" action="/webtest/Register" >
  				<el-button type="primary" style="margin:10px;width: 40% ">注册</el-button>
  				<el-form-item style="color: #ffffff;"  label="姓名" >
    				<el-input name="name"></el-input>
 			    </el-form-item>
 			    <el-form-item style="color: #ffffff;"  label="账号">
    				<el-input name="admine"></el-input>
 			    </el-form-item>
 			    <el-form-item style="color: #ffffff;" label="密码">
    				<el-input type="password" name="password"></el-input>
 			    </el-form-item>
 			     <el-form-item style="color: #ffffff;" label="确认">
    				<el-input type="password" name="repassword"></el-input>
 			    </el-form-item>
 			    <el-form-item>
 			    	<el-input type="submit" value="提交" style="width: 120px;"></el-input>
 			    	<el-button onclick="login()" style="width: 120px;" type="primary" plain>登录</el-button>
  				</el-form-item>
            </el-form>
            <div style="width: 35%;height: 400px;float: left;"></div>
        </div>
    </body>
    <!-- 先引入 Vue -->
  <script src="https://unpkg.com/vue/dist/vue.js"></script>
  <!-- 引入组件库 -->
  <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script>
   	  var app= new Vue({el: '#app'})
  </script>
</html>
