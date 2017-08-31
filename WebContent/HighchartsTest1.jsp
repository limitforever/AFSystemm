<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/jquery.js"></script>
<script src="js/exporting.js"></script>

<script type="text/javascript">
$(function () {
    var chart;
   // var total;
   
    
    $(document).ready(function() {
    	
    	$.ajax({
          type: "POST",
          dataType: "JSON",
          url: "/AFSystem/servlet/OilTotalStatistic",
          success: function (msg) {
        	  
          	/*var str=JSON.stringify(msg);*/
      
          
          	/*var total=JSON.parse(str);*/
          	var total=msg;
          	chart = new Highcharts.Chart({
              	
                  chart: {
                      renderTo: 'container',
                      
                      type: 'column'
                  },
                  title: {
                      text: '航空公司加油量'
                  },
                  subtitle: {
                      text: 'CAUC'
                  },
                  xAxis: {
                      categories: [
                          '一月',
                          '二月',
                          '三月',
                          '四月',
                          '五月',
                          '六月',
                          '七月',
                          '八月',
                          '九月',
                          '十月',
                          '十一月',
                          '十二月',
                      ]
                  },
                  yAxis: {
                      min: 0,
                      title: {
                          text: ' 加油总量(kg)'
                      }
                  },
                  legend: {
                      layout: 'vertical',
                      backgroundColor: '#FFFFFF',
                      align: 'left',
                      verticalAlign: 'top',
                      x: 100,
                      y: 70,
                      floating: true,
                      shadow: true
                  },
                  tooltip: {
                      formatter: function() {
                      	
                          return ''+
                              this.x +': '+ this.y +' kg';
                      }
                  },
                  plotOptions: {
                      column: {
                          pointPadding: 0.2,
                          borderWidth: 0
                      }
                  },
                  series: total
              });
          	
          	
          	
             
          }
    	});
      
        
    });
    
});
    </script>	
</head>
<body>



<div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
</body>
</html>