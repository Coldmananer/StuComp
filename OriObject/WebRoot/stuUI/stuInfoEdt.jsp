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
    <title>Form Components - Vali Admin</title>
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
          <h1><i class="fa fa-edit"></i> 编辑个人信息</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">个人信息管理</li>
          <li class="breadcrumb-item"><a href="#">编辑个人信息</a></li>
        </ul>
      </div>
      <div class="row" style="width:500px;">
        <div class="col-md-12">
          <div class="tile">
            <div class="row">
              <div class="col-lg-6">
                <form id="person_info" action = "studentUpdata.action" method="post">
                <s:hidden name="student.stuId" value="%{#session.student.stuId}" id="id"></s:hidden>
                 <s:hidden name="student.password" value="%{#session.student.password}" id="password"></s:hidden>
                 <s:hidden name="student.compNum" value="%{#session.student.compNum}" id="compNum"></s:hidden>
                 <s:hidden name="student.passwordQue" value="%{#session.student.passwordQue}" id="passwordQue"></s:hidden>
                 <s:hidden name="student.answer" value="%{#session.student.answer}" id="answer"></s:hidden>
                  <div class="form-group">
                    <label class="control-label">学号</label>
                    <input class="form-control" type="text" value= "${student.stuNum }" name="student.stuNum" placeholder="请输入学号" style="width:300px;">
                  </div>
                  <div class="form-group">
                    <label class="control-label">姓名</label>
                    <input class="form-control" type="text" value="${student.stuName}" name="student.stuName" placeholder="请输入姓名" style="width:300px;">
                  </div>
                  <div class="form-group">
                    <label class="control-label">班级</label>
                    <input class="form-control" type="text" value="${student.class_}" name="student.class_" placeholder="请输入班级" style="width:300px;">
                  </div>
                  <div class="form-group">
                    <label class="control-label">电话</label>
                    <input class="form-control" type="text" value="${student.phoneNum}" name="student.phoneNum" placeholder="请输入电话" style="width:300px;">
                  </div>
                  <div class="form-group">
                    <label class="control-label">QQ</label>
                    <input class="form-control" type="text" value="${student.qq}" name="student.qq" placeholder="请输入QQ" style="width:300px;">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">电子邮箱</label>
                    <input class="form-control" id="exampleInputEmail1" type="email" value="${student.email}" name="student.email" aria-describedby="emailHelp" placeholder="邮箱" style="width:300px;">
                  </div>                
                </form>
              </div>             
            </div>
            <div class="tile-footer">
              <button class="btn btn-primary" type="button" onclick="checkInput()">提交</button>
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
      function checkInput(){
        var form=document.getElementById('person_info');
        var inputs=form.getElementsByTagName('input');        
        for(var i=0;i<inputs.length;i++){
          var parent=inputs[i].parentNode;
          if(inputs[i].value==''){
            var small=document.createElement('small');
            var smalltext=document.createTextNode("输入不能为空!");
            small.appendChild(smalltext);
            addClass(small,"form-text");
            addClass(small,"text-muted");
            if(parent.getElementsByTagName('small').length==0){
              parent.appendChild(small);
            }
            return false;
          }
          if(inputs[i].value){
            if(parent.getElementsByTagName('small').length!=0){
              var smal=parent.getElementsByTagName('small');
              parent.removeChild(smal[0]);
            }
          } 
        }
        form.submit();
      }
      function addClass(element,value){
          var newClassName;
          if(!element.className){
            element.className=value;
          }else{
            newClassName=element.className;
            newClassName+=" ";
            newClassName+=value;
            element.className=newClassName;
          }
      }
    </script>
  </body>
</html>