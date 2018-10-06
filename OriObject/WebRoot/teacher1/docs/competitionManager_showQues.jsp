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
    <div class="app-title">
        <div>
          <h1><i class="fa fa-th-list"></i> 竞赛题目管理</h1>
          <p><s:property value="#session.competition.compName" />竞赛题目管理</p>
        </div>
      </div>

	<div class="row">
		<div class="col-md-12">
			<div class="tile">
				<div class="tile-body">
					<table class="table table-hover table-bordered" id="sampleTable">
						<thead>
							<tr>
								<th style="background-color:#fff; color:#388E8E;">题号</th>
								<th style="background-color:#fff; color:#388E8E;">题目</th>
								<th style="background-color:#fff; color:#388E8E;">附加文件</th>
								<th style="background-color:#fff; color:#388E8E;">修改</th>
								<th style="background-color:#fff; color:#388E8E;">删除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.pageBean.list" id="questionFileClass">
								<tr>
									
									<td style="background-color:#EDEDED;"><s:property value="#questionFileClass.question.questionNum" /></td>

									<td style="background-color:#EDEDED;"><s:property value="#questionFileClass.question.questionName" /></td>
									
									<s:if test="#questionFileClass.question.fileDesc != null">
										<!--  -->
										<td style="background-color:#EDEDED;">
											<s:iterator value="#questionFileClass.file" id="questionClass2">
												<a href="filedown?f=<s:property value="key"/>&realName=<s:property value="value"/>">
													<s:property value="value"/>
												</a>
												<br>
											</s:iterator>
											<!--  
											<a href="filedown?f=<s:property value="#question.fileDesc" />">下载</a>
											<a href="#">全部下载</a>
											-->
										</td>
									</s:if>
									<s:else>
										<td style="background-color:#EDEDED;">
											无文件
										</td>
									</s:else>

									<td style="background-color:#EDEDED;">
										<a href="questionModify?questionId=<s:property value="#questionFileClass.question.questionId"/>">修改</a>
									</td>
									
									<td style="background-color:#EDEDED;">
										<a href="questionDelete?questionId=<s:property value="#questionFileClass.question.questionId"/>
											&CompId=<s:property value="#session.competition.CompId"/>" onclick="return check()">删除</a>
									</td>
									
								</tr>
							</s:iterator>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="5">
									<div>
										<font size="5">共 <font color="red"><s:property
													value="#request.pageBean.totalPage" /> </font>页
										</font>&nbsp;&nbsp; <font size="5">共 <font color="red"><s:property
													value="#request.pageBean.allRows" /> </font>条记录
										</font><br> <br>
										<s:if test="#request.pageBean.currentPage == 1">
            										首页&nbsp;&nbsp;&nbsp;上一页
        										</s:if>
										<s:else>
											<a href="showQuestion?compId
            									=<s:property value=" #session.competition.compId"/>">首页</a>
            										&nbsp;&nbsp;&nbsp;
            									<a
												href="showQuestion?compId
            									=<s:property value=" #session.competition.compId"/>&page=<s:property value=" #request.pageBean.currentPage - 1"/>">上一页</a>
										</s:else>
										<s:if
											test="#request.pageBean.currentPage != #request.pageBean.totalPage && #request.pageBean.totalPage !=0 ">
											<a
												href="showQuestion?compId
            									=<s:property value=" #session.competition.compId"/>&page=<s:property value=" #request.pageBean.currentPage + 1"/>">下一页</a>
            										&nbsp;&nbsp;&nbsp;
            										<a
												href="showQuestion?compId
            									=<s:property value=" #session.competition.compId"/>&page=<s:property value=" #request.pageBean.totalPage"/>">尾页</a>
										</s:if>
										<s:else>
            										下一页&nbsp;&nbsp;&nbsp;尾页
        										</s:else>
									</div>
								</td>
							</tr>
						</tfoot>
					</table>
					<a href="competitionManager_addQues.jsp"><button class="add-back-style">添加题目</button></a>
					<a href="compmanage?CompId=<s:property value=" #session.competition.compId"/>"><button class="add-back-style">返回管理</button></a>
				</div>
			</div>
		</div>
	</div>

	</main>
    <script type="text/javascript">
		function check(){
			if(confirm('是否删除')){
       			return true;
   			}else
   				return false;
		}
	</script>
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