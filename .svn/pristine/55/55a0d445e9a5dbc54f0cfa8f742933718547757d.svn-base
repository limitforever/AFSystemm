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
    
    <div style="margin-top:4%; width:1000px" align="center">
       <table>
       <tr>
       <td style="height:50px">
       <select>
       <option>一个月内</option>
       <option>两个月内</option>
       <option>三个月内</option>
       </select>
       </td>
       <td><a href="javascript:void(0)" class="btn"  onclick="gotoHighchart()" style="width:40px">确定</a></td>      
       </tr>
       </table>
       <div id="container" style="min-width:400px;height:400px"></div>
    </div>
    
    <script type="text/javascript" src="highchartsjquery.js"></script>
    <script src="js/highcharts.js"></script>
    <script src="js/exporting.js"></script>
    <script type="text/javascript" src="js/grid-light.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/json2.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
	
	//highcharts
    $(function()
    {
    var x = [];//X轴
    var y = [];//Y轴
    var xtext = [];//X轴TEXT
    var color = ["gray","pink","red","blue","yellow","green","#fff"];
    $.ajax
    ({
        type:'get',
        url:'${ctx}/user/chart',//请求数据的地址
        success:function(data){
            var json = eval("("+data+")");
            var s = 1;
            for(var key in json.list){
                json.list[key].y = json.list[key].age; //给Y轴赋值
                xtext = json.list[key].name;//给X轴TEXT赋值
                json.list[key].color= color[key];
            }
                chart.series[0].setData(json.list);//数据填充到highcharts上面
        },
        error:function(e){
        } 
    });
    var chart = new Highcharts.Chart({
        chart:{
            renderTo:'container',
            type:'column' //显示类型 柱形
        },
        title:{
            text:'加油量统计表'    //图表的标题
        },
        xAxis:{
            categories:xtext
        },
        yAxis:{
            title:{
                text:'加油量'   //Y轴的名称
            },
        },
        series:[{
            name:"",
            name:"",
            name:"",
        }]
    });
});
	
	
	
	
	function gotoHighchart(){
        var url = '${ctx }/user/chartpage';
        window.location.href=url;
    }
	
       
      </script>		
</body>
</html>