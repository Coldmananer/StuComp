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
    
      <div style="width:800px;height:600px;z-index:1;background-color:#fff;box-shadow:0px 5px 5px #888888;">
      <div class="container">
    	<p class="title">${sessionScope.competition.compName}竞赛管理</p>
        <div class="attend-list">
            <div class="attend-head">
                <div>
                	人员名单........................................................................................................
                	...........
                	<a href="personnelManage?page=0&CompId=<s:property value="#session.competition.compId" />">
							<input type="button" value="批量管理" id="per_manager"  style="border-style:none; width:90px; height:25px; color:#fff; background-color:#458B74;"/>
						</a>
                </div>
                <!-- <div class="search">
                    <input type="text" placeholder="搜索人员"/>
                    <img src="<%=basePath%>/teacher1/src/search.png"/>
                </div> -->
            </div>
            <div class="attend-body">
             
            <s:iterator value="#request.pageBean.list" id="teamcompetion">
            	<div class="condition-style">
            		
                    <div><s:property value="#teamcompetion.team.teamId" />
                    <s:property value="#teamcompetion.team.teamName" />
                    ...................................................................................
                    
                    <s:if test="#teamcompetion.isPass == null">待通过</s:if>
					<s:elseif test="#teamcompetion.isPass == true">已通过</s:elseif>
					<s:else>已拒绝</s:else>
                
                </div>
                    <a href="teamdetails?teamId=<s:property value="#teamcompetion.team.teamId" />&compId=
                    	<s:property value="#session.competition.compId" />">
   				 		<button style="border-style:none; width:30px; height:25px; color:#fff; background-color:#458B74;">管理</button>
					</a>
                    
             	</div>     
            </s:iterator>
            	<div class="condition-style">

					<font size="5">共 <font color="red"><s:property
								value="#request.pageBean.totalPage" /> </font>页
					</font>&nbsp;&nbsp; <font size="5">共 <font
						color="red"><s:property value="#request.pageBean.allRows" />
					</font>条记录
					</font><br> <br>
					<s:if test="#request.pageBean.currentPage == 1">
            										首页&nbsp;&nbsp;&nbsp;上一页
        										</s:if>
					<s:else>
						<a href="compmanage">首页</a>
            										&nbsp;&nbsp;&nbsp;
            									<a
							href="compmanage?page=<s:property value=" #request.pageBean.currentPage - 1"/>">上一页</a>
					</s:else>
					<s:if
						test="#request.pageBean.currentPage != #request.pageBean.totalPage &&
						#request.pageBean.totalPage != 0 ">
						<a
							href="compmanage?page=<s:property value=" #request.pageBean.currentPage + 1"/>">下一页</a>
            										&nbsp;&nbsp;&nbsp;
            										<a
							href="compmanage?page=<s:property value=" #request.pageBean.totalPage"/>">尾页</a>
					</s:if>
					<s:else>
            										下一页&nbsp;&nbsp;&nbsp;尾页
        										</s:else>

				</div>     
            </div>
        </div>
        <div class="attend-tail">
            <div class="comp-condition">          
                <p>竞赛状态:</p>
                <div id="competition-condition">
                    <p style="display:none;" value="1">开始报名</p>
                    <p style="display:none;" value="2">竞赛准备</p>
                    <p style="display:none;" value="3">开始竞赛</p>
                    <p style="display:none;" value="4">结束竞赛</p>
                    <p style="display:none;" value="5">发布成绩</p>
                </div>
                
                  	<script type="text/javascript">
            	 		function selectstate(value){
            	 			var compstate=document.getElementById("competition-condition");
		 					var ps=compstate.getElementsByTagName('p');
		  					for(var i=0;i<ps.length;i++){
			  					if(ps[i].getAttribute("value")==value){
				  					ps[i].style.display="block";
				  					}
			  				}
		  				}
		  				function hidebutton(id){
							var but=document.getElementById(id);
							but.style.display="none";
						}
		  				var value = ${sessionScope.competition.compstatus.compStateId};
		  				selectstate(value);		  				
     				</script>
                
            </div>
            <div class="button-style">
            	<s:if test="#session.competition.compstatus.compStateId == 1">
						<div>
							
							<a href="showQuestion?page=0&CompId=<s:property value="#session.competition.compId" />">
								<input type="button" value="竞赛题目管理" id="compe_exercise"
								onclick="javascrtpt:window.location.href='competitionManager_AddQues.jsp'" />
							</a>
						
							
							<input type="button" value="竞赛信息修改" id="compe_modify"
								onclick="javascrtpt:window.location.href='compInformationChange.jsp'" />
								
							<a href="endSignUpComp">
								<input type="button" onclick="return check()" value="截止报名" id="endsignup_manager" />
							</a> 
							
						</div>
				</s:if>
					
				<s:elseif test="#session.competition.compstatus.compStateId == 2">
					<div>
						
						<a href="showQuestion?page=0&CompId=<s:property value="#session.competition.compId" />">
								<input type="button" value="竞赛题目管理" id="compe_exercise"
								onclick="javascrtpt:window.location.href='competitionManager_AddQues.jsp'" />
						</a>
						
						
						<input type="button" value="竞赛信息修改" id="compe_modify"
							onclick="javascrtpt:window.location.href='compInformationChange.jsp'" />
							
						<a href="startcomp"><input onclick="return check()" type="button" value="开始竞赛" id="start_comp" /></a>
					</div>
				</s:elseif>
				
				<s:elseif test="#session.competition.compstatus.compStateId == 3">
					<div>
					
						<a href="showQuestion?page=0&CompId=<s:property value="#session.competition.compId" />">
								<input type="button" value="竞赛题目管理" id="compe_exercise"
								onclick="javascrtpt:window.location.href='competitionManager_AddQues.jsp'" />
						</a>
							
						<input type="button" value="竞赛信息修改" id="compe_modify"
								onclick="javascrtpt:window.location.href='compInformationChange.jsp'" />
								
						<a href="endcomp"><input onclick="return check()" type="button" value="结束竞赛" id="end_comp"/></a>
					</div>	
					
					<div>
						
						<a href="#">
                    		<input type="button" value="查看作品" id="look"/>
                    	</a>
						
					</div>
				</s:elseif>
				
				<s:elseif test="#session.competition.compstatus.compStateId == 4">
					<div>
						
						<a href="showQuestion?page=0&CompId=<s:property value="#session.competition.compId" />">
								<input type="button" value="竞赛题目管理" id="compe_exercise"
								onclick="javascrtpt:window.location.href='competitionManager_AddQues.jsp'" />
						</a> 
							
						<input type="button" value="竞赛信息修改" id="compe_modify"
								onclick="javascrtpt:window.location.href='compInformationChange.jsp'" />
						
						<a href="uploadscore?CompId=<s:property value="#session.competition.CompId" />">
	                    	<input onclick="return check()" type="button" value="发布成绩" id="regis_grade"/>
	                    </a>
	                    
					</div>
					<div>
					
						<a href="preGradeList?page=0&CompId=<s:property value="#session.competition.CompId" />">
                    		<input type="button" value="评分" id="grade"/>
                    	</a>
                    	
                    	<a href="preGrade?CompId=<s:property value="#session.competition.CompId" />">
                    		<input type="button" value="预生成榜单" id="pregrade"/>
                    	</a>
                    	
					</div>	
				</s:elseif>
				<s:elseif test="#session.competition.compstatus.compStateId == 5">
					<div>
						
						<a href="showQuestion?page=0&CompId=<s:property value="#session.competition.compId" />">
								<input type="button" value="竞赛题目管理" id="compe_exercise"
								onclick="javascrtpt:window.location.href='competitionManager_AddQues.jsp'" />
						</a> 
							
						<input type="button" value="竞赛信息修改" id="compe_modify"
								onclick="javascrtpt:window.location.href='compInformationChange.jsp'" />
					
					</div>
					<div>
					
						<a href="preGrade?CompId=<s:property value="#session.competition.CompId" />">
                    		<input type="button" value="修改榜单" id="changegrade"/>
                    	</a>
                    	
                    	<a href="show_complist?CompId=<s:property value="#session.competition.CompId" />">
                    		<input type="button" id="show_complist" value="查看榜单" />
                    	</a>
                    	
					</div>
				</s:elseif>
     		</div>


    </div>
    </div>
      
    </main>
    <script type="text/javascript">
		function check(){
			if(confirm('是否进入下个竞赛状态')){
       			return true;
   			}else{
       			return false;
   			}
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