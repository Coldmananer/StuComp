<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>"/>
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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>stuUI/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="index.html">Vali</a>
      <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
      <!-- Navbar Right Menu-->
      <ul class="app-nav">
        <li class="app-search">
          <input class="app-search__input" type="search" placeholder="搜索">
          <button class="app-search__button"><i class="fa fa-search"></i></button>
        </li>
        <!-- User Menu-->
        <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
          <ul class="dropdown-menu settings-menu dropdown-menu-right">
            <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-cog fa-lg"></i> Settings</a></li>
            <li><a class="dropdown-item" href="page-user.html"><i class="fa fa-user fa-lg"></i> Profile</a></li>
            <li><a class="dropdown-item" href="<%=basePath%>student/index.html"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
          </ul>
        </li>
      </ul>
    </header>
    <!-- Sidebar menu-->
     <%@include file ="sidebar.jsp" %>
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-th-list"></i> 详细列表</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb side">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">我的团队</li>
          <li class="breadcrumb-item active"><a href="#">详细列表</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <table class="table table-hover table-bordered" id="sampleTable">
                <thead>
                  <tr>
                    <th>团队名称</th>
                    <th>队长名称</th>
                    <th>队长学号</th>
                  </tr>
                </thead>
                <tbody>
							<s:iterator value="#request.pageBean.list" id="stuTeam">
								<tr>
									<th><s:property value="#stuTeam.Team.teamName" /></th>

									<td><s:property value="#stuTeam.Student.stuName" /></td>

									<td><s:property value="#stuTeam.Student.stuNum" /></td>

									  <td><a href="showMyTeamDetial?stuteamId
            									=<s:property value=" #stuTeam.stuteamid"/>">详情</a>
								</tr>
							</s:iterator>
				</tbody>
						<tfoot>
							<tr>
								<td colspan="4">
									<div >
										<font size="5">共 <font color="red"><s:property
													value="#request.pageBean.totalPage" /> </font>页
										</font>&nbsp;&nbsp; <font size="5">共 <font color="red"><s:property
													value="#request.pageBean.allRows" /> </font>条记录
										</font><br>
										<br>
										<s:if test="#request.pageBean.currentPage == 1">
            										首页&nbsp;&nbsp;&nbsp;上一页
        										</s:if>
										<s:else>
											<a href="showTeams?page=1">首页</a>
            										&nbsp;&nbsp;&nbsp;
            									<a href="showTeams?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
										</s:else>
										<s:if
											test="#request.pageBean.currentPage != #request.pageBean.totalPage">
											<a href="showTeams?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
            										&nbsp;&nbsp;&nbsp;
            										<a href="showTeams?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
										</s:if>
										<s:else>
            										下一页&nbsp;&nbsp;&nbsp;尾页
        										</s:else>
									</div>
								</td>
							</tr>
						</tfoot>
					</table>
            </div>
          </div>
        </div>
      </div>
    </main>
    <!-- Essential javascripts for application to work-->
    <script src="<%=basePath%>stuUI/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>stuUI/js/popper.min.js"></script>
    <script src="<%=basePath%>stuUI/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>stuUI/js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="<%=basePath%>stuUI/docs/js/plugins/pace.min.js"></script>
    <!-- Page specific javascripts-->
    <!-- Data table plugin-->
    <script type="text/javascript" src="<%=basePath%>stuUI/js/plugins/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>stuUI/js/plugins/dataTables.bootstrap.min.js"></script>
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
    </script>
  </body>
</html>