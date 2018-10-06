<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
  <base href="<%=basePath%>"/>
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
    <title>Form Samples - Vali Admin</title>
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
          <h1><i class="fa fa-edit"></i> 查看竞赛详情</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">报名中的竞赛</li>
          <li class="breadcrumb-item"><a href="#">查看竞赛详情</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <!-- <h3 class="tile-title">新建团队</h3> -->
            <div class="tile-body">            
                <div class="form-group">
                  <label class="control-label"><strong>竞赛名称</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;">${comp.compName}</div>
                </div>
                 <div class="form-group">
                  <label class="control-label"><strong>竞赛类型</strong></label>
                   <div style="font-size:17px;color:#808069;width:300px;">${comp.compcode.compName}</div>
                </div>
                 <div class="form-group">
                  <label class="control-label"><strong>开始时间</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;">${comp.startTime}</div>
                </div>
                 <div class="form-group">
                  <label class="control-label"><strong>结束时间</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;">${comp.endTime}</div>
                </div>
                 <div class="form-group">
                  <label class="control-label"><strong>人数限制</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;">${comp.personNum}</div>
                </div>
                 <div class="form-group">
                  <label class="control-label"><strong>指导老师</strong></label>
                  <div style="font-size:17px;color:#808069;width:300px;">${comp.teacher}</div>
                </div>
                <div class="form-group">
                  <label class="control-label"><strong>竞赛描述</strong></label>
                   <div style="font-size:17px;color:#808069;width:300px;">${comp.compIntro}</div>
                </div>             
            <div class="tile-footer">
            <s:if test="%{comp.personNum > 1}">
           <button class="btn btn-primary" type="button" onclick="javascript:window.location.href='selectTeam.action?studentId=<s:property value="#session.student.stuId"/>'">选择队伍报名</button>
           </s:if>
           <s:else>
            <button class="btn btn-primary" type="button" onclick="javascript:window.location.href='IndivAplForComp.action?studentId=<s:property value="#session.student.stuId"/>'">报名</button>
           </s:else>
            </div>
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
    <script src="<%=basePath%>stuUI/js/plugins/pace.min.js"></script>
    <!-- Page specific javascripts-->
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