<%@ include  file="SessionCheck.jsp"%>
<%@page import="cauc.edu.cn.model.AFUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		String path = request.getContextPath();
        AFUserInfo afuser = (AFUserInfo)session.getAttribute("CURRENTLOGINUSER");
        String usernum = null;
        String nonenpassword = null;
        String username = null;
        String sex = null;
        String phonenum = null;
        String age = null;
        
        if(afuser != null)       	
        {        	
        	usernum = afuser.getUsernum();
        	nonenpassword = afuser.getNonenpassword();
        	username = afuser.getUsername();
        	sex = afuser.getSex();
            age =String.valueOf(afuser.getAge());
        	phonenum = afuser.getPhonenum();
        }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Admin panel developed with the Bootstrap from Twitter.">
    <meta name="author" content="travis">

    <link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/site.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="js/html5.js"></script>
    <![endif]-->
    
    <!-- easyUI -->
    <link rel="stylesheet" type="text/css" href="css/easyui.css">
    <link rel="stylesheet" type="text/css" href="css/easyuiicon.css">
    <link rel="stylesheet" type="text/css" href="css/easyuicolor.css">
    <link rel="stylesheet" type="text/css" href="css/easyuidemo.css">
</head>
<body  style="font-family: '幼圆'">
    <!-- 导航栏 -->
    <div class="navbar navbar-fixed-top" style="color:#507F6B">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="Index.jsp">中航油加油站信息系统</a>
          <div class="btn-group pull-right">
			
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <%=usernum%>
     <span class="caret"></span>
  </button>
            <ul class="dropdown-menu">
              <li><a href="Profile.jsp">个人信息</a></li>
              <li class="divider"></li>
              <li><a href="#">退出</a></li>
            </ul>
          </div>
         
      
          <div class="nav-collapse" >
            <ul class="nav">
			<li><a href="Index.jsp">首页</a></li>
              <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">信息维护 <b class="caret"></b></a>
				<ul class="dropdown-menu">
				    <li><a href="OilWorkerManage.jsp">加油员管理</a></li>
					<li class="divider"></li>
					<li><a href="UsersManage.jsp">用户管理</a></li>
					<li class="divider"></li>
					<li><a href="VehicleManage.jsp">车辆管理</a></li>
					<li class="divider"></li>
					<li><a href="LimitsManage.jsp">权限管理</a></li>
					<li class="divider"></li>
					<li><a href="ClientManage.jsp">设备管理</a></li>
					<li class="divider"></li>
					<li><a href="Environment.jsp">环境信息管理</a></li>
				</ul>
			  </li>

			  <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">信息记录<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="OperationList.jsp">操作记录</a></li>
					<li class="divider"></li>
					<li><a href="OverSpeedList.jsp">超速记录</a></li>
					<li class="divider"></li>
					<li><a href="FlightInfo.jsp">航班信息</a></li>
					<li class="divider"></li>
					<li><a href="Figure.jsp">油量统计</a></li>
					<li class="divider"></li>
					<li><a href="WorkOrder.jsp">派工单</a></li>
					<li class="divider"></li>
					<li><a href="FuelSheet.jsp">加油单</a></li>
				</ul>
			  </li>
            </ul>
          </div>
          </div>
      </div>
    </div><!-- 导航栏结束 -->
    
    <div style="margin-top:5%;" align="center">        

	 
	  <div class="easyui-tabs" style="width:800px;height:450px" align="center">
		<div title="用户信息" style="padding-top:30px"  align="center">

  <form  class="form-horizontal" action="<%=path%>/UserUpdateServlet" method="post">
        
            <div class="fitem" style="height:40px">
                <label>员工号</label>
                <input name="usernum" value="<%=usernum%>"class="easyui-textbox" style="width:250px; height:30px">
            </div>
            
            <div class="fitem" style="height:40px">
                <label>密码</label>
                <input name="pwd"  type="password" value="<%=nonenpassword %>" class="easyui-textbox" style="width:250px; height:30px">
            </div>
            
            <div class="fitem" style="height:40px">
                <label>姓名</label>
                <input name="username"  value="<%=username %>"  class="easyui-textbox" style="width:250px; height:30px">
            </div>
            
            <div class="fitem" style="height:40px">
                <label>性别</label>
                <input name="sex" value="<%=sex %>" class="easyui-textbox" style="width:250px; height:30px">
            </div>
            
            <div class="fitem" style="height:40px">
                <label>年龄</label>
                <input name="age" value="<%= age%>" class="easyui-textbox" style="width:250px; height:30px">
            </div>
   
            <div class="fitem" style="height:40px">
                <label>联系方式</label>
                <input name="phonenum" value="<%= phonenum%>"class="easyui-textbox" style="width:250px; height:30px">
            </div>
            
            <div class="fitem" style="height:40px">
               <a><input type="submit" class="easyui-linkbutton" plain="true" value="保存" iconCls="icon-ok"/></a>
            </div>
          </form>
                                   
        
    </div>
    </div>
    </div>

    
    
    
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
	<script src="js/bootstrap.min.js"></script>   
    <script src="js/json2.js"></script>    
    
        <script type="text/javascript">
    

        
        </script>
    
    
</body>
</html>