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
          <h1><i class="fa fa-pie-chart"></i>竞赛信息修改</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
          <li class="breadcrumb-item"><a href="#">竞赛信息修改</a></li>
        </ul>
      </div>
      <div> 
      <div style="width:1200px;height:700px;z-index:1;background-color:#fff;padding:20px;box-shadow:0px 5px 5px #888888;">
        <form method="post" action="compupdate">
          <table class="form_h">
          <input name="CompId" value=<s:property value="#session.competition.compId"/>  type="hidden" />
            <tr>
              <th>
                <label for="compName">竞赛名称</label>
              </th>
              <td>
                <input class="input-small" type="text" value=<s:property value="#session.competition.compName"/> name="compName" id="compName"/>
              </td>
            </tr>
            <tr>
              <th>
                <label for="comptypeid">竞赛类型</label>
              </th>
              <td>
                <select name="comptypeid" id="comptypeid" value=<s:property value="#session.competition.compcode.compTypeid"/>>
                    <option value="1">ACM</option>
                    <option value="2">电子竞赛</option>
                    <option value="3">服务外包</option>
                    <option value="4">数学建模</option>
                </select>
              </td>
            </tr>
            <%
            	Competition competition = (Competition)session.getAttribute("competition");
            	int comptypeid = competition.getCompcode().getCompTypeid();
            	int memberNum =competition.getPersonNum();
            	session.setAttribute("memberNum", memberNum);
            	session.setAttribute("comptypeid", comptypeid);
             %>
            <script type="text/javascript">
            	function selectComptypeid(){
            		var memberNum = '<%=session.getAttribute("comptypeid")%>';
            		var options=document.getElementById('comptypeid').childNodes;
            		for(var j=0;j<options.length;j++){
            			if(options[j].value==memberNum){
            				options[j].selected=true;
            				break;
            			}
            		}
            	}
            	selectComptypeid();
            </script>
            
            <tr>
              <th class="vat">
                <label for="compIntro">竞赛介绍</label>
              </th>
              <td>
                <script type="text/plain" class="uEditor" name="compIntro">${sessionScope.competition.compIntro}</script>
              </td>
            </tr>
            <tr>
              <th>
                <label for="selectbox">人数限制</label>
              </th>
              <td>
                 <select name="memberNum" id="memberNum" value=<s:property value="#session.competition.personNum"/> >
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                </select>
              </td>
            </tr>
            <script type="text/javascript">
            	function selectNumber(){
            		var memberNum = '<%=session.getAttribute("memberNum")%>';
            		var options=document.getElementById('memberNum').childNodes;
            		
            		//var numbers = $("#memberNum").find("option");
            		for(var j=0;j<options.length;j++){
            			//if($(numbers[j]).val() == memberNum){
            				//$(numbers[j]).attr("selected", "selected");
            			//}
            			if(options[j].value==memberNum){
            				options[j].selected=true;
            				break;
            			}
            		}
            		//document.getElementById("memberNum")[memberNum].selected=true;
            	}
            	selectNumber();
            </script>
            <tr>
              <th>硬件管理</th>
                <td >
                  <input type="radio" name="HardwareManagement" value="Need" checked>需要</input><br/>
                  <input type="radio" name="HardwareManagement" value="Unneed" >不需要</input><br/>
                </td>
            </tr>
            <tr>
              <th></th>
              <td>
                <input class="button" name="submit" type="submit" value="修改"/>
                <a href="compmanage?CompId=<s:property value=" #session.competition.compId"/>">
					<button style="border-style:none; width:60px; height:25px; color:#fff; background-color:#458B74;" type="button">返回</button>
				</a>
              </td>
            </tr>
          </table>
        </form>
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