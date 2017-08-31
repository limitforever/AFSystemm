<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    	String path = request.getContextPath();
  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Admin panel developed with the Bootstrap from Twitter.">
    <meta name="author" content="travis">

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    
    <!--[if lt IE 9]>
      <script src="js/html5.js"></script>
    <![endif]-->
 
</head>
<body>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

</head>
<body style="font-family: '幼圆'">

<!-- login-form-->
	<div class="login-form" style="padding-top:5%; ">
	    <!-- 标题图片 -->
		<img src="img/logo.png" style="padding-left:7%">
		<br /><br />
		
	
		<div style="background-color:#ffffff; width:600px; height:350px">
		<div style="padding-top:10%; padding-left:20%">
			<form action="<%=path %>/LoginServlet" method="post">			
			<table style="padding-top:3%" align="center">			
			<tr>
			    <td style="width:50px"><i class="icon-user icon-2x" style="color:#507F6B"></i></td>
				<td><div class="email">			
					<input style="width:300px; height:30px" type="text" name="usernum" placeholder="用户名" class="form-control" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
					<div class="clear"> </div>
                </div></td>
			</tr>
			
			<tr>
			    <td><i class="icon-lock icon-2x" style="color:#507F6B; font-size:30px"></i></td>
				<td><div class="password">					
					<input style="width:300px; height:30px" type="password" name="nonenpassword" placeholder="密码" class="form-control" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">	
					<div class="clear"> </div>			
				</div></td>
			</tr>
 
			     <tr>
			        <td> </td>
			        <td><input style="width:220px; height:30px" type="text" name="check" placeholder="验证码" /> <img  src="<%=path %>/LoginServlet"></td>		        
			     </tr>    
		

			<tr>
			    <td></td>
				<td><p><a href="#">忘记密码</a></p></td>
			</tr>
			
			</table>
			<br/>
			<table align="center">
			<tr>
			    <td style="width:50px"></td>
				<td><input type="radio" name="identity" value="管理员" checked>管理员</input></td>
				<td style="width:50px"></td>
				<td><input type="radio" name="identity" value="调度员" >调度员</input></td>
			</tr>
			</table>
			<br/>
			
			<table align="center">
			<tr>
			    <td style="width:50px"></td>	
				<td><button class="btn" type="submit" style="width:220px;" >登陆</button></td>
			</tr>
			
			</table>
			
			</form>
		</div>
		<!--form-left-->
		
		</div>
	</div>
	<!-- login-form-->

    
    <script src="js/jquery.js"></script>
    <script src="js/json2.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>