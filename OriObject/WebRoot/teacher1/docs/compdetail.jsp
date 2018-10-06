<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    
    <!-- Font-icon css-->
    
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />
  </head>
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <!-- 边框即头部菜单 -->
    <s:if test="#session.isAll == true">
    	<%@include file="menu/complist_menu.jsp" %>
    </s:if>
    <s:elseif test="#session.isAll == false">
    	<%@include file="menu/compmanager_menu.jsp" %>
    </s:elseif>
    
    <!--  -->
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-pie-chart"></i> 竞赛详情</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item"><a href="#">竞赛详情</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <!-- <h3 class="tile-title">新建团队</h3> -->
            <div class="tile-body"> 
        <form method="post" action="compmanage?page=0&CompId=<s:property value="#request.competition.CompId"/>">
        
          <div class="form-group">
                  <label class="control-label"><strong>竞赛名称</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;"><s:property value="#request.competition.compName"/></div>
          </div>
          <div class="form-group">
                  <label class="control-label"><strong>竞赛类型</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;"><s:property value="#request.compType"/></div>
          </div>
          <div class="form-group">
                  <label class="control-label"><strong>竞赛介绍</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;">${request.competition.compIntro}</div>
          </div>
          <div class="form-group">
                  <label class="control-label"><strong>人数限制</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;"><s:property value="#request.competition.personNum"/></div>
          </div>
          <div class="form-group">
                  <label class="control-label"><strong>竞赛状态</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;"><s:property value="#request.compstatus"/></div>
          </div>
          <div class="tile-footer">
          <s:if test="#session.teacher.compcode.compTypeid == #request.competition.compcode.compTypeid">
                <input class="button" name="submit" type="submit" value="管理" style="font-size:14px;border-style:none;" id="manager"/>
          </s:if>
          <s:if test="#session.isAll == true">
          	<a href="compshow"><button type="button" style="border-style:none; width:60px; height:25px; color:#fff; background-color:#458B74;">返回</button></a>
          </s:if>
          <s:elseif test="#session.isAll == false">
          	<a href="compshowbycomptypeid?comptypeid=<s:property value="#session.teacher.compcode.compTypeid"/>"><button type="button" style="border-style:none; width:60px; height:25px; color:#fff; background-color:#458B74;">返回</button></a>
          </s:elseif>
          </div>
        </form>
               
      </div>
      </div>
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
      
      //var manager=document.getElementById("manager");
      $("#manager").removeClass("hover");
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