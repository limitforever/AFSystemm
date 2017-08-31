<%@ include  file="SessionCheck.jsp"%>
<%@page import="cauc.edu.cn.model.AFUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
		String path = request.getContextPath();
        AFUserInfo afuser = (AFUserInfo)session.getAttribute("CURRENTLOGINUSER");
        String usernum = null;
        if(afuser != null)
        {        	
        	usernum = afuser.getUsernum();
        }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Admin panel developed with the Bootstrap from Twitter.">
    <meta name="author" content="travis">

    <link href="css/bootstrap.css" rel="stylesheet">
	<link href="css/site.css" rel="stylesheet">
	<link href="css/css.css" rel="stylesheet">
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
<body style="font-family: '幼圆'">
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
   
	
	<div class="easyui-tabs" style="width:1000px;height:400px">
		<div title="权限设置" style="padding:10px">
		
		<table>
		<thead>
		<tr>
		<th style="width:200px">角色</th>
		<th style="width:700px">权限设置</th>
		</tr>
		</thead>
		<tr>
		<td>
		<select name="usersexuality" style="width:170px; height:24px; border-color:#B1C242">
           <option value="1">管理员</option>
           <option value="2">加油员</option>  
           <option value="3">调度员</option>            
        </select>
		
		</td>
		<td>
		
		<table>
		<tr>

		<td style="width:90px">管理用户信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px;" /></td>
		<td style="width:90px">管理加油员信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		<td style="width:90px">管理车辆信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		
		
		
        </tr>
        <tr>
        <td style="width:90px">管理环境信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		<td style="width:90px">查看用户信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		<td style="width:90px">查看加油员信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		
		</tr>
		<tr>
		<td style="width:90px">查看车辆信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		<td style="width:90px">查看环境信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		<td style="width:90px">查看操作记录</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		
		</tr>
		<tr>
		<td style="width:90px">查看超速信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		<td style="width:90px">查看航班信息</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		<td style="width:90px">查看派工单</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>

		</tr>
		
		<tr>

		<td style="width:90px">查看加油单</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>		
		<td style="width:90px">进行派工</td><td style="width:50px"><input class="easyui-switchbutton" style="width:40px; height:20px" /></td>
		</tr>

		</table>
		
		</td>
		<td style="width:100px">
		   <a class="easyui-linkbutton" iconCls="icon-ok">确认</a>
		</td>
		<td style="width:100px">
		   <a class="easyui-linkbutton" iconCls="icon-ok">重置</a>
		</td>
		</tr>
		</table>
		</div>
    </div>
    
    
    
    </div>
    
    
    <script src="js/jquery.js"></script>
    <script src="js/json2.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	
	
</body>
</html>