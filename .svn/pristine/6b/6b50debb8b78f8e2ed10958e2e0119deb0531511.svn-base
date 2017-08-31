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
<title>派工任务</title>
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
					<li><a href="VehicleManage.jsp">加油车管理</a></li>
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
      <div style="margin:20px 0 10px 0;"></div>
      
    <div class="easyui-tabs" style="width:1000px;height:550px">
		<div title="派工单信息" style="padding:10px">
			<table id="dg3" ></table>
		</div>
	</div>



    <script src="js/jquery.js"></script>
    <script src="js/json2.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	
	 <script type="text/javascript">
    
    var contextPath = '<%=path%>';
    getDataGrid();
    
	function getDataGrid()
    {
    	var chaxuntiaojian3={};
        $('#dg3').datagrid({    
    	    url:contextPath+'/WorkOrderSheetServlet',  
    	    loadMsg:'正在读取....数据，请稍后...',
    	    pagination : true,
    	    singleSelect : true,
    	    rownumbers:true,
    	    fitColumns:true,
    	    pageNumber : 1,
    	    pageSize :5,
    	    pageList : [5,10,20],
    	    queryParams : {'chaxuntiaojian3':JSON.stringify(chaxuntiaojian3)},
    	    sortName : 'earliestfueltime',
    	    sortOrder : 'ASC',
    	    columns:[[  
                {field:'fuelsheetid',width:'0px',hidden:true},
    	        {field:'fuelsheetnum',title:'加油单号',width:'55px',sortable:true,align:'center'},
    	        {field:'oilbrand',title:'航班号',width:'45px',sortable:true,align:'center'},      
    	        {field:'arrivespecificlocationtime',title:'航空公司',width:'55px',sortable:true,align:'center'},    
    	        {field:'waitimageurl',title:'预计到达时间',width:'113px',sortable:true,align:'center'},    
    	        {field:'startfueltime',title:'预计起飞时间',width:'113px',sortable:true,align:'center'},  
    	        {field:'earliestfueltime',title:'最早开始加油时间',width:'115px',sortable:true,align:'center'},
    	        {field:'latestfueltime',title:'最晚开始加油时间',width:'115px',sortable:true,align:'center'},
    	        {field:'fuelduration',title:'预计加油时长',width:'75px',sortable:true,align:'center'},
    	        {field:'overfueltime',title:'停机位',width:'40px',sortable:true,align:'center'},
    	        {field:'vehiclenum',title:'加油车编号',width:'65px',sortable:true,align:'center'},
    	        {field:'workeruserid',title:'加油员姓名',width:'65px',sortable:true,align:'center'},
    	    ]]
    	});
    }  
    </script>
    
</body>
</html>