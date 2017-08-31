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
<title>环境信息管理</title>
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
  
      <div style="margin:20px 0 10px 0;"></div>
      
	  <div class="easyui-tabs" style="width:1000px;height:550px">
		<div title="环境信息" style="padding:10px">
		<table id="queryConditionTable">			
				<tr>
			    <td>从</td>
			    <td><input type="text" id="messuredtime_1" class="easyui-datetimebox"  required style="width:200px"></td>
			    <td style="text-align:center">到</td>
			    <td><input type="text" id="messuredtime_2" class="easyui-datetimebox"  required style="width:200px"></td>
			    <td style="padding-left:20px"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="getDataGrid()">查询</a></td>
			</tr>
					  
		</table>
		
			<table id="dg" data-options="toolbar: '#toolbar'"></table>
		</div>
	</div>
	
	<div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newEnvionment()">添加</a>
    </div>
   
    <div id="dlg" class="easyui-dialog" style="width:400px;height:350px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">环境信息</div>
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>油温</label>
                <input name="temperature" class="easyui-textbox">
            </div>
            <div class="fitem">
                <label>油密度</label>
                <input name="fueldensity" class="easyui-textbox">
            </div>
            <div class="fitem">
                <label>获取时间</label>
                <input name="messuredtime" class="easyui-datetimebox">                
        </form>
    </div>
    
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveEnvionment()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
         
    <script src="js/jquery.js"></script>
    <script type="text/javascript"src="js/easyui.js"></script>
	<script src="js/bootstrap.min.js"></script>   
    <script src="js/json2.js"></script>
    <script type="text/javascript">
    
    $('#messuredtime_1').datetimebox({ 
		
		 showSeconds: true   

		});  
	 $('#messuredtime_2').datetimebox({ 
		 showSeconds: true   
		});  
	 
    
    
    var contextPath = '<%=path%>';
    getDataGrid();
    function getDataGrid(){
    	var chaxuntiaojian={};
    	chaxuntiaojian.messuredtime_1 = $('#messuredtime_1').datetimebox('getValue');
    	chaxuntiaojian.messuredtime_2 = $('#messuredtime_2').datetimebox('getValue');
          
        $('#dg').datagrid({    
    	    url:contextPath+'/EnvironmentServlet', 
    	    loadMsg:'正在读取....数据，请稍后...',
    	    pagination : true,
    	    singleSelect : true,
    	    rownumbers:true,
    	    fitColumns:true,
    	    pageNumber : 1,
    	    pageSize :10,
    	    pageList : [10,20,50],
    	    queryParams : {'chaxuntiaojian':JSON.stringify(chaxuntiaojian)},
    //	    sortName : 'messuredtime',
    	    sortOrder : 'ASC',
    	    columns:[[    
    	        {field:'temperature',title:'油温',width:'220px',sortable:true,align:'center'},    
    	        {field:'fueldensity',title:'油密度',width:'220px',sortable:true,align:'center'},    
    	        {field:'messuredtime',title:'获取时间',width:'220px',sortable:true,align:'center'},    
    	        {field:'repwd',title:'',width:'250px',sortable:true,align:'center'},      
    	    ]]
    	});
    }
        var url;
        
        function newEnvionment()
        {
            $('#dlg').dialog('open').dialog('setTitle','添加车辆');
            $('#fm').form('clear');
            url = "<%=path %>/EnvironmentAddServlet";   
        }
        
        function saveEnvionment()
        {
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.resultMsg=='fail')
                    {
                        $.messager.show({
                            title: 'Error',
                            msg: result.resultMsg
                        });
                    } 
                    else 
                    {
                        $.messager.show({
                            title: 'Register Finish',
                            msg: result.resultMsg
                        });
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
    </script>
 
</body>
</html>