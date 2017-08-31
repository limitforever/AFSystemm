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
<title>航班信息</title>
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

  <div style="margin-top:5%" align="center">

  <div class="easyui-tabs" style="width:1000px;height:550px">
   <div title="航班信息" style="padding:10px" style="padding-bottom:10px">
   
    <table id="queryConditionTable">			
			
			<tr>
				<td>航班号：</td>
				<td><input type="text" id="flno"  style="width:200px"></td>			    
				<td style="padding-left:20px">航空公司代码：</td>
				<td><input type="text" id="alcd_l" style="width:200px"></td>				
			</tr>
			
			<tr>
			    <td>预计到达时间：从</td>
			    <td><input type="text" id="scat_1" class="easyui-datebox"  required style="width:200px"></td>
			    <td style="text-align:center">到</td>
			    <td><input type="text" id="scat_2" class="easyui-datetimebox"  required style="width:200px"></td>
			</tr>
			
			<tr>
			    <td>预计起飞时间：从</td>
			    <td><input type="text" id="scdt_1"  class="easyui-datetimebox"  required style="width:200px"></td>
			    <td style="text-align:center">到</td>
			    <td><input type="text" id="scdt_2"  class="easyui-datetimebox"  required style="width:200px"></td>
			    <td style="padding-left:20px"><a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="getDataGrid()">查询</a></td>
			</tr>
		
			<tr style="height:20px"></tr>
	</table>	  
	
    <table id="dg" data-options="toolbar: '#toolbar'"></table>
    <div id="toolbar" style="padding-bottom:10px">
      <table>
      <tr>
        <td><input class="easyui-filebox" style="width:300px" buttonText="导入航班计划" id="xml"></td>
        <td style="padding-left:10px"><a href="#" class="easyui-linkbutton" style="width:100%" onclick="importxml()">确定导入</a></td>
        </tr>
      </table>
    </div>
  </div>
  </div>
  
  
  </div>


    <script src="js/jquery.js"></script>
    <script src="js/json2.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	 <script type="text/javascript">
	

	 $('#flno').textbox({ })	
	 $('#alcd_l').textbox({ })

	 $('#scat_1').datetimebox({ 
		
		 showSeconds: true   

		});  
	 $('#scat_2').datetimebox({ 
		 showSeconds: true   
		});  
	 
	 $('#scdt_1').datetimebox({  
		 showSeconds: true   
		});  
	 
	 $('#scdt_2').datetimebox({  
		 showSeconds: true   
		});  
	 
	 var contextPath = '<%=path%>';
        getDataGrid();
        
        //获取查询语句中的查询条件
        function getDataGrid()
        {
        	var query={};
          
            query.flno=$('#flno').textbox('getText');
            query.alcd_l=$('#alcd_l').textbox('getText');
            query.scat_1 = $('#scat_1').datetimebox('getValue');
            query.scat_2 = $('#scat_2').datetimebox('getValue');
            query.scdt_1 = $('#scdt_1').datetimebox('getValue');
            query.scdt_2 = $('#scdt_2').datetimebox('getValue');
    			    
            $('#dg').datagrid({    
        	    url:contextPath+'/FlightInfoServlet', 
        	    loadMsg:'正在读取....数据，请稍后...',
        	    pagination : true,
        	    singleSelect : true,
        	    rownumbers:true,
        	    fitColumns:true,
        	    pageNumber : 1,
        	    pageSize :10,
        	    pageList : [10,20,50],
        	    queryParams : {'query':JSON.stringify(query)},
        	    sortName : 'flid',
        	    sortOrder : 'ASC',
        	    columns:[[    
        	        {field:'flid',title:'航班编号',width:'130px',sortable:true},    
        	        {field:'flno',title:'航班号',width:'130px',sortable:true},    
        	        {field:'alcd',title:'航空公司代码',width:'130px',sortable:true},    
        	        {field:'scat',title:'预计到达时间',width:'130px',sortable:true},    
        	        {field:'scdt',title:'预计起飞时间',width:'130px',sortable:true}, 
        	        {field:'scdt',title:'最终到达时间',width:'130px',sortable:true}, 
        	        {field:'stnd',title:'停机位',width:'108px',sortable:true},      
        	    ]]
        	});
        }

        //导入航班计划
        function importxml(){
        	var filename = $('#xml').filebox('getValue');
        	
        	alert(filename);
        	//进行基本校验  
            if(filename==""){     
               alert('请选择上传文件！');   
            }else{  
                //对文件格式进行校验  
                var file=/\.[^\.]+$/.exec(filename);
                alert(file);
                if(file == '.xml'){                	
				    window.location.href=contextPath+'/ParsingScheduleFlightServlet?filePath='+filename;
                }
            }
        }//importxml()
        
    </script>
    
</body>
</html>