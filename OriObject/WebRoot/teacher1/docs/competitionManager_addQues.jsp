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
    <!--  -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/teacher1/docs/css/main.css">    
    
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">   
        
        <!-- to choose another color scheme uncomment one of the foloowing stylesheets and wrap styl1.css into a comment -->
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/style8.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/jquery-ui.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/css/competition_manager.css" type="text/css" media="screen" />
    <!-- Font-icon css-->
    
    <link rel="stylesheet" href="<%=basePath%>/teacher1/docs/ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />
  	<style>
             /*蓝色按钮,绝对定位*/
            .upFile{
                position: relative;
                display: block;
                margin:5px 0;
                height:30px;
            }
            .blueButton
            {
                position: absolute;
                display: block;
                width: 80px;
                height: 30px;
                line-height:30px;
                background-color: #009688;
                color: #fff;
                text-decoration: none;
                text-align: center;
                cursor: pointer;
                border-radius: 2px;
                font-weight: bold;
            }
            .blueButton:hover
            {
                text-decoration: none;
            }
            /*自定义上传,位置大小都和a完全一样,而且完全透明*/
            .myFileUpload
            {
                position: absolute;
                display: block;
                width: 80px;
                height: 30px;
                opacity: 0;
            }
            /*显示上传文件夹名的Div*/
            .show
            {
                position: absolute;
                top:5%;
                left:6%;
                width: 15%;
                overflow: hidden;
                text-overflow:ellipsis;
                white-space: nowrap;
                height: 30px;
            }
            .dFile{
                position: absolute;
                top:5%;
                left:22%;
                width: 30%;
                height: 30px;
                text-decoration: none;
                color:#009688;
            }
            .addNew{
                text-decoration: none;
                color:#009688;
            }
			.tijiao-quxiao-style{
				outline:none;
				width:50px;
				height:30px;
				border:1px solid #009688;
				background-color:#009688;
				color:#ffffff;
			}
        </style>
  	
  	
  </head>
  
  <body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <!-- 边框即头部菜单 -->
    <%@include file="menu/compmanager_menu.jsp" %>
    <!--  -->
    <main class="app-content">
    
		<form class="body" action="addQuestion?CompId=<s:property value="#session.competition.compId" />" 
		enctype="multipart/form-data" method="post">
    	<div class="comp-quesansw">
        	<label for="comp-ques">题目</label><br>
        	<input type="text" id="comp-ques" name="ques"/><br>
        	<label for="comp-ques_desc">题目描述</label><br>
        	<!-- <input type="text" id="comp-answ" name="desc"/><br> -->
        	<!--  <textarea cols="50" rows="2" name="desc"></textarea><br> -->
        	<script type="text/plain" class="uEditor" name="desc"></script>
        	<label for="comp-answ">答案</label><br>
        	<!-- <input type="text" id="comp-answ" name="answ"/><br> -->
        	<script type="text/plain" class="uEditor" name="answ"></script>
        	<label for="comp-file">附件</label><br> 
        	
        	<a href="javascript:void();" onclick="addFile();" class="addNew">添加文件</a>
			<div class="upFile" id="addFile">
				<a href='javascript:void(0);' class="blueButton">选择文件</a> 
				<input type="file" class="myFileUpload" name="file" id="file1" onchange="appFileName(this,1)" />
				<div class="show" id="show1"></div>
			</div>

			<div id="add"></div>
			</br>
        	     
     	</div>
  
    	<div>
         	<input type="submit" value="提交" name="Submit" class="tijiao-quxiao-style"/>
         	<input type="button" value="取消" class="tijiao-quxiao-style"/>
    	</div>

  </form>


	</main>
    
    <!-- Essential javascripts for application to work-->
    <script src="<%=basePath%>/teacher1/docs/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>/teacher1/docs/js/popper.min.js"></script>
    <script src="<%=basePath%>/teacher1/docs/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/teacher1/docs/js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <!--<script src="<%=basePath%>/teacher1/docs/js/plugins/pace.min.js"></script>-->
    <!-- Page specific javascripts-->
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
    <script>
    function appFileName(obj,id)
    {
        var file=$(obj).val().split("\\");
        var file_name=file[file.length-1];
        //var num=id[id.length-1].trim();
        $("#show"+id).html(file_name);
    };
    function addFileName(){

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