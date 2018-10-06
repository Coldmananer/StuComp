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
    <title>Data Table - Vali Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/teacher1/docs/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  	<link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/competition_manager.css" type="text/css" media="screen" />
  </head>
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <!-- 边框即头部菜单 -->
    <%@include file="menu/compmanager_menu.jsp" %>
    <!--  -->
    <main class="app-content">
	  <div style="position:relative; height:140px;">
	      <div style="position:absolute;">
	      	<h2><s:property value="#request.team.teamName" /></h2><br/>
	      	<div style="margin:5px 0;">
	      		<span class="intro-stat-style">队伍介绍:</span>
	      		<span class="intro-stat-style intro-stat-detail-style">
	      			<s:property value="#request.team.teamIntro" />
	      		</span>
	      	</div>
	      	<div style="margin:5px 0;">
	      		<span class="intro-stat-style">队伍状态:</span>
	      		<span class="intro-stat-style intro-stat-detail-style">
		      		<s:if test="#request.teamcompetion.isPass == null">
		      			待通过
		      		</s:if>
		      		<s:elseif test="#request.teamcompetion.isPass == true">
		      			已通过
		      		</s:elseif>
		      		<s:else>
		      			已拒绝
		      		</s:else>
	      		</span>
	      	</div>
	      </div>
	      <div style="position:absolute;left:70%;top:60%;">
		      <a href="teampass?teamId=<s:property value="#request.team.teamId" />&compId=<s:property value="#session.competition.compId" />">
		   				 		<button class="add-back-style" onclick="return check()">通过</button>
							</a>
		      <a href="teamrefuse?teamId=<s:property value="#request.team.teamId" />&compId=
		                    	<s:property value="#session.competition.compId" />">
		   				 		<button class="add-back-style" onclick="return check()">拒绝</button>
							</a>
			  <a href="compmanage?CompId=<s:property value="#session.competition.compId" />">
		   				 		<button class="add-back-style">返回</button>
							</a>
	      </div>
	  </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
					<table class="table table-hover table-bordered" id="sampleTable">
						<thead>
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>班级</th>
								<th>电话</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.students" id="student">
								<tr>
									<th><s:property value="#student.stuNum" /></th>

									<td><s:property value="#student.stuName" /></td>

									<td><s:property value="#student.class_" /></td>

									<td><s:property value="#student.phoneNum" /></td>

								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
          </div>
        </div>
      </div>

      <!-- <a href="teampass?teamId=<s:property value="#request.team.teamId" />&compId=<s:property value="#session.competition.compId" />">
   				 		<button class="add-back-style" onclick="return check()">通过</button>
					</a>
      <a href="teamrefuse?teamId=<s:property value="#request.team.teamId" />&compId=
                    	<s:property value="#session.competition.compId" />">
   				 		<button class="add-back-style" onclick="return check()">拒绝</button>
					</a>
	  <a href="compmanage?CompId=<s:property value="#session.competition.compId" />">
   				 		<button class="add-back-style">返回</button>
					</a>
		-->		
		
		<s:if test="#request.works != null">
		<div class="tile">
			<div style="font-weight:700;font-size:20px">已提交的作品</div>
            <div class="tile-body">
			<table class="table table-hover table-bordered" id="sampleTable">
					<thead>
						<tr>
							<th>作品ID</th>
							<th>作品名</th>
							<th>作品成绩</th>
							<th>下载</th>
							<th>修改成绩</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="#request.works" id="Works">
							<form action="givescore?workId=<s:property value="#Works.workId" />" method="post">
							<tr>
								<th><s:property value="#Works.workId" /></th>
								<td><s:property value="#Works.workName" /></td>
								<td id="grade<s:property value="#Works.workId" />" ><s:property value="#Works.score" /></td>
								<td>
								
								<form action="filedown" method="post">
										<input type="hidden" name="filePath" value="<s:property value="#Works.filePath"/>" />
										<!--  
										<input type="hidden" name="fileName" value="<s:property value="#quesion.fileName"/>" />
										-->
										<input type="submit" value="下载" class="add-back-style">
								</form>
								<!--  
								<a href="#">下载</a>
								 -->
								 </td>
								<td><button id="modify-grade" onclick="getnewgrade(<s:property value="#Works.workId" />)" class="add-back-style">修改成绩</button></td>
							</tr>
								<input id="score<s:property value="#Works.workId" />" name="score" value="<s:property value="#Works.score" />" style="display:none"/>
								<input id="submit<s:property value="#Works.workId" />" name="Submit" type="submit" style="display:none"/>
							</form>
						</s:iterator>
					</tbody>
				</table>
				</div>
			</div>
		</s:if>
    </main>
    <script type="text/javascript">
		function check(){
			if(confirm('是否确认通过/拒绝')){
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
    <!-- Data table plugin-->
    <script type="text/javascript" src="<%=basePath%>/teacher1/docs/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/teacher1/docs/js/plugins/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript">$('#sampleTable').DataTable();</script>
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
      
      /*新增加的修改成绩*/
      function getnewgrade(id){  
      	var oldgrade=document.getElementById('grade'+id);  	
      	var grade=prompt("请输入新的成绩:");
   		if (grade != null) {
   			oldgrade.innerText = grade;
   			//改变score的值
   			$("#score" + id).val(grade);
   			//触发action
   			document.getElementById('submit' + id).click();
   			}
    	}
      
    </script>
  </body>
</html>