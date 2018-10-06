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
    <!-- <meta name="description" content="Vali is a responsive and free admin theme built with Bootstrap 4, SASS and PUG.js. It's fully customizable and modular."> -->
    <!-- Twitter meta-->
    <!-- <meta property="twitter:card" content="summary_large_image">
    <meta property="twitter:site" content="@pratikborsadiya">
    <meta property="twitter:creator" content="@pratikborsadiya">
     Open Graph Meta
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="Vali Admin">
    <meta property="og:title" content="Vali - Free Bootstrap 4 admin theme"> -->
    <!-- <meta property="og:url" content="http://pratikborsadiya.in/blog/vali-admin"> -->
    <!-- <meta property="og:image" content="http://pratikborsadiya.in/blog/vali-admin/hero-social.png"> -->
    <title>Data Table - Vali Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/teacher1/docs/css/main.css">
    <!--  
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/style_all.css" type="text/css" media="screen" />
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">   
        -->
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/competition_manager.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/competition_manager.css" type="text/css" media="screen" />
    <!--  
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/style8.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/jquery-ui.css" type="text/css" media="screen" />
    -->
  </head>
  <body class="app sidebar-mini rtl">
  
  	<!-- Navbar-->
    <!-- 边框即头部菜单 -->
    <%@include file="menu/compmanager_menu.jsp" %>
    <!--  -->
    <main class="app-content">
    <div class="app-title">
        <div>
          <h1><i class="fa fa-th-list"></i> 竞赛管理</h1>
          <p><s:property value="#session.competition.compName" />竞赛管理</p>
        </div>
      </div>
    
    <div class="container">         
      <div>
		<div class="comp-condition">          
            <p>竞赛状态:</p>
            <div id="competition-condition" class="comp-detail-codition">
                <p style="display:none;" value="1">开始报名</p>
                <p style="display:none;" value="2">竞赛准备</p>
                <p style="display:none;" value="3">开始竞赛</p>
                <p style="display:none;" value="4">结束竞赛</p>
                <p style="display:none;" value="5">发布成绩</p>
            </div>
         </div>
        <div class="team-list-style">团队名单</div>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <table class="table table-hover table-bordered" id="sampleTable">
                <thead>
                  <tr>
                    <th>序号</th>
                    <th>团队名称</th>
                    <th>审核结果</th>
                    <th>管理</th>                  
                  </tr>
                </thead>
				<tbody>
					<s:iterator value="#request.pageBean.list" id="teamcompetion">
						<tr>
							<td><s:property value="#teamcompetion.team.teamId" /></td>
							<td><s:property value="#teamcompetion.team.teamName" /></td>
							<td>
								<s:if test="#teamcompetion.isPass == null">待通过</s:if>
								<s:elseif test="#teamcompetion.isPass == true">已通过</s:elseif>
								<s:else>已拒绝</s:else>
							</td>
							<td>
								<a href="teamdetails?teamId=<s:property value="#teamcompetion.team.teamId" />&compId=
                    			<s:property value="#session.competition.compId" />">
   				 					<button class="btn btn-primary" type="button">管理</button>
								</a>
								<!--  
								<button style="border-style:none; width:30px; height:25px; color:#fff; background-color:#458B74;">管理</button>
								-->
							</td>
						</tr>
					</s:iterator>
				</tbody>
				</table>
            </div>
            <div class="attend-tail">
            <div class="button-style">         
            	<s:if test="#session.competition.compstatus.compStateId == 1">
					<div>
						<a href="personnelManage?page=0&CompId=<s:property value="#session.competition.compId" />">
	      					<input type="button" value="批量管理"/>
	      				</a>
						
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
						
						<a href="personnelManage?page=0&CompId=<s:property value="#session.competition.compId" />">
	      					<input type="button" value="批量管理"/>
	      				</a>
						
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
					
						<a href="personnelManage?page=0&CompId=<s:property value="#session.competition.compId" />">
	      					<input type="button" value="批量管理"/>
	      				</a>
					
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
						
						<a href="personnelManage?page=0&CompId=<s:property value="#session.competition.compId" />">
	      					<input type="button" value="批量管理"/>
	      				</a>
						
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
						
						<a href="personnelManage?page=0&CompId=<s:property value="#session.competition.compId" />">
	      					<input type="button" value="批量管理"/>
	      				</a>
						
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
    <!-- Data table plugin-->
    <script type="text/javascript" src="<%=basePath%>/teacher1/docs/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/teacher1/docs/js/plugins/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript">$('#sampleTable').DataTable();</script>
    <!-- Google analytics script-->
    <script type="text/javascript">  
    	function check(){
			if(confirm('是否进入下个竞赛状态')){
       			return true;
   			}else{
       			return false;
   			}
   			return false;
		
		}
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
  </body>
</html>