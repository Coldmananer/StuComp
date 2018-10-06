<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="description" content="Reflect Template" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
        <title>竞赛列表</title>
        <link rel="stylesheet" href="css/style_all.css" type="text/css" media="screen" />
        
        
        
        <!-- to choose another color scheme uncomment one of the foloowing stylesheets and wrap styl1.css into a comment -->
        <link rel="stylesheet" href="css/style8.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />
        
        <!--Internet Explorer Trancparency fix-->
        <!--[if IE 6]>
        <script src="js/ie6pngfix.js"></script>
        <script>
          DD_belatedPNG.fix('#head, a, a span, img, .message p, .click_to_close, .ie6fix');
        </script>
        <![endif]--> 
        
        <script type='text/javascript' src='js/all-ck.js'></script>
        <script type='text/javascript' src='ueditor1_2_2_0-utf8-php/editor_config.js'></script>
        <script type='text/javascript' src='js/custom.js'></script>
        
        <script type="text/javascript">
    
        function validate()
        {
            var page = document.getElementsByName("page")[0].value;
                
            if( page > request.pageBean.totalPage)
            {
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                
                window.document.location.href = "personAction";
                
                return false;
            }
            
            return true;
        }
    
    </script>
  </head>
  
  <body>
    <div id="top">
        
            <div id="head">
            	<h1 class="logo">
                	<a href=""></a>
                </h1>
                <div class="head_memberinfo">
                    <div class="head_memberinfo_logo">
                        <span>1</span>
                        <img src="images/unreadmail.png" alt=""/>
                    </div>
                    
                    <span class='memberinfo_span'>
                         欢迎 <a href="">管理员</a>
                    </span>
                    
                    <span class='memberinfo_span'>
                        <a href="">设置</a>
                    </span>
                    
                    <span>
                        <a href="login.html">登出</a>
                    </span>
                    
                    <span class='memberinfo_span2'>
                        <a href="">1 条私信</a>
                    </span>
                </div>
                <!--end head_memberinfo-->
            
            </div><!--end head-->
           	
            	<div id="bg_wrapper">
                
                    <div id="main">
                        <div id="content">

                            <table class="table_auto datalist" cellspacing="0">
                                <caption>
                                    Table 2: 竞赛表单 (表格内容决定宽度) 
                                    <select name="" id="">
                                        <option value="">选择排序字段</option>
                                        <option value="">1</option>
                                        <option value="">2</option>
                                        <option value="">3</option>
                                        <option value="">4</option>
                                        <option value="">5</option>
                                    </select>
                                </caption>
                                <thead>
                                    <th class="nobg">弹性表格</th>
                                        <th>竞赛ID</th>
                                        <th>竞赛名</th>
                                        <th>竞赛人数</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                    <s:iterator value="#request.pageBean.list" id="competition">
                                        <th><s:property value="#competition.compId"/></th>
            							<th><s:property value="#competition.compName"/></th>
            							<th><s:property value="#competition.personNum"/></th>
            						</s:iterator>
                                </tbody>
                                
                                <tfoot>
								<tr>
									<font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage" /></font>页
									</font>&nbsp;&nbsp;
									<font size="5">共<font color="red"><s:property value="#request.pageBean.allRows" /></font>条记录
									</font>
									<br><br>
									<s:if test="#request.pageBean.currentPage == 1"> 首页&nbsp;&nbsp;&nbsp;上一页
	        						</s:if>
									<s:else>
										<a href="personAction.action">首页</a> &nbsp;&nbsp;&nbsp;
	            						<a href="personAction.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">
	            						上一页</a>
									</s:else>
									<s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
										<a href="personAction.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">
										下一页</a>&nbsp;&nbsp;&nbsp;
	            						<a href="personAction.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
									</s:if>
									<s:else> 下一页&nbsp;&nbsp;&nbsp;尾页
	        						</s:else>
								</tr>
						</tfoot>
                            </table>
                        </div>
                        <!--end content-->
                        
                    </div><!--end main-->
                    
                    <div id="sidebar">
                        <ul class="open">
                            <li><a class="headitem item1" href="1">主页</a></li>
                            
                            <li><a class="headitem item2" href="2">竞赛列表</a></li>
                            
                            <li><a class="headitem item4" href="<%=basePath%>teacher/webs/LaunchComp.jsp">发布竞赛</a></li>
                            
                            <li><a class="headitem item5" href="#">竞赛管理</a></li>
                            
                            <li><a class="headitem item6" href="#">信息管理</a></li>
                        </ul><!--end subnav-->

                        <div class="flexy_datepicker"></div>
     

                </div>
                    <!--end sidebar-->
                        
                     </div><!--end bg_wrapper-->
                     
                <div id="footer">
                
                </div><!--end footer-->
                
        </div><!-- end top -->
        
  </body>
</html>
