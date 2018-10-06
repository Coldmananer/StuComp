<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.Model.Competition" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>	
    <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <!-- Twitter meta-->
    <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
    <!-- Open Graph Meta-->
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme">
    <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin">
    <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png">
    <meta property="og:description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular.">
    <title>Charts - Vali Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/style_all.css" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/teacher1/docs/css/main.css">    
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">   
        
        <!-- to choose another color scheme uncomment one of the foloowing stylesheets and wrap styl1.css into a comment -->
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/style8.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/jquery-ui.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/competition_manager.css" type="text/css" media="screen" />
    <!-- Font-icon css-->
    
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />
  </head>
  
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <!-- 边框即头部菜单 -->
    <%@include file="menu/compmanager_menu.jsp" %>
    <!--  -->
    <main class="app-content">
    
    
      <div class="container">
    	<p class="title">${sessionScope.competition.compName}竞赛管理</p>
        <div class="attend-list">
            <div class="attend-head">
            </div>
            <div class="attend-body">
            <s:iterator value="#request.map" id="map">
            	<div>ID:<s:property value="key.teamId"/></div>
            	<div>队伍名:<s:property value="key.teamName"/></div>
				<div>Score:<s:property value="value.score"/></div>
				<div>---------------------------------------</div>
            </s:iterator>
            
             <!-- 
            <s:iterator value="#request.map" id="map">
            	<div class="condition-style"> -->
            		<!--<s:property value="#map"/><br> -->  
   					<!-- ID: <s:property value="key.teamCompId"/><br>   
   					Name:<s:property value="value.workName"/><br>
   					Score: <s:property value="key.score"/><br>    
   					--------------------------------------<br>   
            		
                    <div><s:property value="#works"/>
                    ....................................................................................
                    <form action="givescore">
                    <input type="hidden" name="teamCompId" value="<s:property value="key.teamCompId"/>" />
                    <input type="text" name="score" /><br>
                    </div>
                    <input type="submit" name="Submit"  value="评分" />
                    </form>
             	</div>     
            </s:iterator> -->
            
            </div>
        </div>
      
    </main>
    
    <!-- Essential javascripts for application to work-->
    <script src="<%=basePath%>/teacher1/docs/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>/teacher1/docs/js/popper.min.js"></script>
    <script src="<%=basePath%>/teacher1/docs/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/teacher1/docs/js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="<%=basePath%>/teacher1/docs/js/plugins/pace.min.js"></script>
    <!-- Page specific javascripts-->
   <!--  <script type='text/javascript' src='js/custom.js'></script> -->
    <script type='text/javascript' src='<%=basePath%>/teacher1/docs/js/all-ck.js'></script>
    <script type='text/javascript' src='<%=basePath%>/teacher1/docs/ueditor1_2_2_0-utf8-php/editor_config.js'></script>
    <script type='text/javascript' src='<%=basePath%>/teacher1/docs/js/custom.js'></script>
    <script type="text/javascript">
     
      var pdata = [
      	{
      		value: 300,
      		color:"#F7464A",
      		highlight: "#FF5A5E",
      		label: "Red"
      	},
      	{
      		value: 50,
      		color: "#46BFBD",
      		highlight: "#5AD3D1",
      		label: "Green"
      	},
      	{
      		value: 100,
      		color: "#FDB45C",
      		highlight: "#FFC870",
      		label: "Yellow"
      	}
      ]
      
      var ctxl = $("#lineChartDemo").get(0).getContext("2d");
      var lineChart = new Chart(ctxl).Line(data);
      
      var ctxb = $("#barChartDemo").get(0).getContext("2d");
      var barChart = new Chart(ctxb).Bar(data);
      
      var ctxr = $("#radarChartDemo").get(0).getContext("2d");
      var radarChart = new Chart(ctxr).Radar(data);
      
      var ctxpo = $("#polarChartDemo").get(0).getContext("2d");
      var polarChart = new Chart(ctxpo).PolarArea(pdata);
      
      var ctxp = $("#pieChartDemo").get(0).getContext("2d");
      var pieChart = new Chart(ctxp).Pie(pdata);
      
      var ctxd = $("#doughnutChartDemo").get(0).getContext("2d");
      var doughnutChart = new Chart(ctxd).Doughnut(pdata);
    </script>
    <!-- Google analytics script-->
    <script type="text/javascript">
      if(document.location.hostname == 'pratikborsadiya.in') {
      	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      	})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
      	ga('create', 'UA-72504830-1', 'auto');
      	ga('send', 'pageview');
      }
    </script>
  </body>
</html>