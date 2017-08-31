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
<title>首页</title>
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
    
    <div style="margin-top:4%;" align="center">
    
    
    
    
    <table>
    <tr>
      <td rowspan="3">
        <div class="easyui-tabs" style="width:160px;height:530px">
		  <div title="航班动态">
		    <table id="dg1"></table>
          </div>
        </div>
      </td>
      
      <td style="width:20px"></td>
      
      <td>
        <div class="easyui-tabs" style="width:1050px;height:250px">
		  <div title="当前派工任务" style="padding:10px">
		    <table id="dg2"></table>
          </div>
        </div>
      </td>
    </tr>
    
    <tr style="height:30px"></tr>
    
    <tr>
      <td style="width:50px"></td>
      <td>
        <div class="easyui-tabs" style="width:1050px;height:250px">
		  <div title="待派工任务" style="padding:10px">
		    <table id="dg3"></table>
          </div>
        </div>
      </td>
    </tr>
    </table>
  
    </div>
    
    
    <script src="js/jquery.js"></script>
    <script src="js/json2.js"></script>
    <script type="text/javascript" src="js/easyui.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
    
        var contextPath = '<%=path%>';
        var flightcolor = 0;
        FlightDynamicUpdate();
        FirstNowWorkerData();
        getDataGrid();
            
        setInterval(function(data)
        { 
	         $('#dg2').datagrid('reload');     	  
        }, 10000); 
        
        setInterval(function(data)
        {       	     
        	 $('#dg1').datagrid('reload');     	  
         }, 50000); 
       
           
        function FirstNowWorkerData()
        {
        	var chaxuntiaojian1={};
        	$('#dg2').datagrid({    
	    	    url:contextPath+'/FirstLoadWorkingSheetServlet',  
	    	    loadMsg:'正在读取....数据，请稍后...',
	    	    pagination : true,
	    	    singleSelect : true,
	    	    rownumbers:true,
	    	    fitColumns:true,
	    	    pageNumber : 1,
	    	    pageSize :5,
	    	    pageList : [5,10,20],
	    	    queryParams : {'chaxuntiaojian1':JSON.stringify(chaxuntiaojian1)},
	    	    sortName : 'earliestfueltime',
	    	    sortOrder : 'ASC',
	    	    columns:[[  
	    	        {field:'fuelsheetid',width:'0px',hidden:true,align:'center'},
	    	        {field:'fuelsheetnum',title:'加油单号',width:'140px',sortable:true,align:'center'},     
	    	        {field:'oilbrand',title:'航班号',width:'140px',sortable:true,align:'center'},    
	    	        {field:'arrivespecificlocationtime',title:'加油员姓名',width:'140px',sortable:true,align:'center'},    
	    	        {field:'waitimageurl',title:'加油车牌号',width:'140px',sortable:true,align:'center'},  
	    	        {field:'startfueltime',title:'停机位',width:'140px',sortable:true,align:'center'},
//	    	        {field:'speed',title:'加油车速度',width:'110px',sortable:true},
	    	        {field:'earliestfueltime',title:'状态',width:'246px',sortable:true,align:'center'},
	    	    ]],
	    	    rowStyler:function(index,row)
        	    {
        			if (row.oilbrand==flightcolor){
        				return 'background-color:pink;color:blue;font-weight:bold;';
        			}
        		}
	    	});
        }
        
        function WorkSheet(fuelsheetid)
    	{   	
    			var WorkSheet = confirm("确认派工？");
    			if(WorkSheet)
    			{
    				window.location.href=contextPath+'/PushMessageServlet?id='+fuelsheetid;
    				updateNowWorkerData(fuelsheetid);  				
    			}  		
    	}
     
        function updateNowWorkerData(fuelsheetid)
        {
        	var chaxuntiaojian2={};
        	$('#dg2').datagrid({    
	    	    url:contextPath+'/NowWorkSheetServlet?id='+fuelsheetid,  
	    	    loadMsg:'正在读取....数据，请稍后...',
	    	    pagination : true,
	    	    singleSelect : true,
	    	    rownumbers:true,
	    	    pageNumber : 1,
	    	    pageSize :5,
	    	    remoteSort: false,
	    	    pageList : [5,10,20],
	    	    queryParams : {'chaxuntiaojian2':JSON.stringify(chaxuntiaojian2)},
	    	    sortName : 'earliestfueltime',
	    	    sortOrder : 'ASC',
	    	    columns:[[  
	    	        {field:'fuelsheetid',width:'0px',hidden:true,align:'center'},
	    	        {field:'fuelsheetnum',title:'加油单号',width:'140px',sortable:true,align:'center'},     
	    	        {field:'oilbrand',title:'航班号',width:'140px',sortable:true,align:'center'},    
	    	        {field:'arrivespecificlocationtime',title:'加油员姓名',width:'140px',sortable:true,align:'center'},    
	    	        {field:'waitimageurl',title:'加油车牌号',width:'140px',sortable:true,align:'center'},  
	    	        {field:'startfueltime',title:'停机位',width:'140px',sortable:true,align:'center'},
	    	        {field:'earliestfueltime',title:'状态',width:'246px',sortable:true,align:'center'},
	    	    ]],	 
	    	    onLoadSuccess:function(data)
	    	    {
	    	    	alert(row.oilbrand);
	    	    	$('#dg3').datagrid('reload');
		    	},		 
/*	    	    rowStyler:function(index,row)
        	    {
        			if (row.oilbrand==flightcolor){
        				return 'background-color:pink;color:blue;font-weight:bold;';
        			}
        		}*/
	    	})
        }
        
        function getDataGrid()
        {
        	var chaxuntiaojian3={};
            $('#dg3').datagrid({    
        	    url:contextPath+'/WaitingForWorkSheetServlet',  
        	    loadMsg:'正在读取....数据，请稍后...',
        	    pagination : true,
        	    singleSelect : true,
        	    rownumbers:true,
        	    pageNumber : 1,
        	    pageSize :5,
        	    pageList : [5,10,20],
        	    queryParams : {'chaxuntiaojian3':JSON.stringify(chaxuntiaojian3)},
        	    remoteSort: false,
        	    sortName : 'earliestfueltime',
        	    sortOrder : 'ASC',
        	   
        	    columns:[[  
                    {field:'fuelsheetid',width:'0px',hidden:true},
        	        {field:'fuelsheetnum',title:'加油单号',width:'50px',sortable:true,align:'center'},
        	        {field:'oilbrand',title:'航班号',width:'40px',sortable:true,align:'center'},      
        	        {field:'arrivespecificlocationtime',title:'航空公司',width:'48px',sortable:true,align:'center'},    
        	        {field:'waitimageurl',title:'预计到达时间',width:'115px',sortable:true,align:'center'},    
        	        {field:'startfueltime',title:'预计起飞时间',width:'115px',sortable:true,align:'center'},  
        	        {field:'earliestfueltime',title:'最早开始加油时间',width:'115px',sortable:true,align:'center'},
        	        {field:'latestfueltime',title:'最晚开始加油时间',width:'115px',sortable:true,align:'center'},
        	        {field:'fuelduration',title:'预计加油时长',width:'75px',sortable:true,align:'center'},
        	        {field:'overfueltime',title:'停机位',width:'40px',sortable:true,align:'center'},
        	        {field:'vehiclenum',title:'加油车编号',width:'65px',sortable:true,align:'center'},
        	        {field:'workeruserid',title:'加油员姓名',width:'90px',sortable:true,align:'center',formatter:function(value,row,index)
        	        {
        	        	return getWorkerNames(value,row.fuelsheetid)
        	        }},
        	        {field:'AUTO',title:'派工操作',width:'56px',align:'center',formatter:function(value,row,index){
        	        	return '<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'icon-edit\'" onclick=WorkSheet('+row.fuelsheetid+')>派工</a>';
        	        }},
        	    ]],   
        	    rowStyler:function(index,row)
        	    {
        			if (row.oilbrand==flightcolor)
        			{
        				return 'background-color:pink;color:blue;font-weight:bold;';
        				
        			}
        		}
        	});
        }     
        
        function getWorkerNames(value,fuelsheetid)
        {
        	var html='<select onchange="updateWorker(this,'+fuelsheetid+');"style="width:85px">';      	
        	$.ajax
        	({
        		url:contextPath+'/GetAllOilWorkerServlet',
        		async:false,
        		success:function(data)
        		{
        			var result = $.parseJSON(data);
        		
        			for(var i=0,len=result.length;i<len;i++)
        			{
        				var worker = result[i];
        				if(worker.workerusername==value)
        				{
            				html=html+'<option selected="selected" value="'+worker.workeruserid+'">'+worker.workerusername+'</option>';
        				}
        				else
        				{
            				html=html+'<option value="'+worker.workeruserid+'">'+worker.workerusername+'</option>';
        				}
        				
        			}      			
        			html=html+'</select>';
        		
        		}   	   
        	});
            return html;	
        }
        	
        function updateWorker(obj,fuelsheetid)
        {
        	window.location.href=contextPath+'/FuelSheetModfiyWorkeruserid?Workeruserid='+obj.value+'&fuelsheetid='+fuelsheetid;
        }
        
        function FlightDynamicUpdate()
        {
        	var chaxuntiaojian={};
        	$('#dg1').datagrid({    
	    	    url:contextPath+'/FlightDynamicUpdateServlet',  
	    	    loadMsg:'正在读取....数据，请稍后...',
	            pagination : true,
	    	    singleSelect : true,
	    	    rownumbers:true,
	    	    fitColumns:true,
	    	    pageNumber : 1,
	    	    pageSize :5,
	    	    pageList : [5,10,20],
	    	    queryParams : {'chaxuntiaojian':JSON.stringify(chaxuntiaojian)},
	    	    sortName : 'dictionaryid',
	    	    sortOrder : 'ASC',
	    	    columns:[[  
	    	        {field:'flid',width:'0px',hidden:true,align:'center'},
	    	        {field:'flno',title:'航班号',width:'50px',sortable:true,align:'center',},    	        
	    	        {field:'reno',title:'更新状态',width:'50px',sortable:true,align:'center'},       	    	    
	    	    ]],
	    	    onDblClickRow: function(rowIndex) 
	    	    {
	    	    	 $('#dg1').datagrid('selectRow',rowIndex);
	    	    	 var currentRow = $("#dg1").datagrid("getSelected"); 
	    	    	 flightcolor = currentRow.flno;
	    	    	  $('#dg3').datagrid('reload'); 
	    	    	  $('#dg2').datagrid('reload');     	 
	    	    },
	    	});
        }
        
      </script>		
</body>
</html>