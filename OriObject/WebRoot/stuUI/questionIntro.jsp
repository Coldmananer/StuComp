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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>stuUI/css/common.css">
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
          <h1><i class="fa fa-edit"></i> 查看题目详情</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item">进行中的竞赛</li>
          <li class="breadcrumb-item"><a href="#">查看题目详情</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="tile">
            <!-- <h3 class="tile-title">新建团队</h3> -->
            <div class="tile-body">        
               <div class="question-type">${question.questionName}</div>    
               <div style="margin-bottom:10px;">${question.questionIntro}</div>
            </div>
            </div>
             
          </div>
        </div>
		
		<div class="row">
        <div class="col-md-6">
          <div class="tile">
            <!-- <h3 class="tile-title">新建团队</h3> -->
            <div class="tile-body">            
               <div style="color:#009668;font-size:17px;">填写上交作品信息</div>
              
               <s:if test="#session.comp.personNum==1">
               <form action="PsubmitWork.action" method="post" enctype="multipart/form-data">
                <input type="hidden" value=${question.questionId } name="works.question">
                <s:hidden name="works.submitId" value="%{#session.student.stuId}"></s:hidden>
               <div class="form-group">
                  <label class="control-label" style="font-size:15px;">作品名称</label>
                  <input class="form-control" type="text" name="works.workName">
                </div>
                 <div class="form-group">
                  <label class="control-label" style="font-size:15px;">作品介绍</label>
                  <textarea class="form-control" name="works.introduction" rows="10"></textarea>
                </div>
                <div class="form-group">
                  <label class="control-label">作品文件</label>
                  <input type="file" id="upfile" name="work"/><br>                 
                </div>
                <div class="tile-footer">
              <button class="btn btn-primary" type="submit" >提交</button>
            </div>
               </form> 
               </s:if>
               <s:else>
               <form action="submitWork.action" method="post" enctype="multipart/form-data">
               <input type="hidden" value=${question.questionId } name="works.question">
                <s:hidden name="works.submitId" value="%{#session.student.stuId}"></s:hidden>
               <div class="form-group">
                  <label class="control-label" style="font-size:15px;">作品名称</label>
                  <input class="form-control" type="text" name="works.workName">
                </div>
                 <div class="form-group">
                  <label class="control-label" style="font-size:15px;">作品介绍</label>
                  <textarea class="form-control" name="works.introduction" rows="10"></textarea>
                </div>
                <div class="form-group">
                  <label class="control-label">作品文件</label>
                  <!-- <input type="file" id="upfile" name="work"/><br> --> 
                  
                  
                <div class="upFile" id="addFile"> 
	              	<a href='javascript:void(0);' class="blueButton">选择文件</a>
	              	<input type="file" class="myFileUpload" name="file" id="file1" onchange="appFileName(this,1)" />
	              	<div class="show" id="show1"></div>
                  </div>
       			  <a href="javascript:void();" onclick="addFile();" class="addNew">添加</a>
        		  <div id="add"></div>                
                </div>
                  
                                 
                </div>
                <div class="tile-footer">
              <button class="btn btn-primary" type="submit" >提交</button>
            </div>
               </form>
               </s:else>
              
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
      
      function appFileName(obj,id){
        var file=$(obj).val().split("\\");
        var file_name=file[file.length-1];
        $("#show"+id).html(file_name);
      }
    	
	   function addFile(){
	       var fileLength = $("input[name=file]").length+1;
	       var inputFile = "<div class='upFile' id='addFile" + fileLength + "'><a href='javascript:void(0);' class='blueButton'>选择文件</a><input type='file' class='myFileUpload' id='file" + fileLength + "' name='file' onchange='appFileName(this,"+fileLength+")'/>" + "<div class='show' id='show"+fileLength+"'></div><a href='javascript:void();' class='dFile' onclick='delFile(" + fileLength + ");'>删除</a></div>";
	       $("#add").before(inputFile);
	  }
       function delFile(id) {
            $("#addFile" + id).remove();
      }
      
    </script>
  </body>
</html>