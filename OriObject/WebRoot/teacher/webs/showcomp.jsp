<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>    
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
        <title>åè¡¨é¡µ</title>
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
                         	欢迎  <a href="">管理员</a>
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

                            <h2>Table 例子</h2>


                            <table class="table_liquid datalist" cellspacing="0">
                                <caption>
                                    <form action="">
                                        Table 3: 流体布局示例
                                        <select name="" id="">
                                            <option value="">筛选</option>
                                            <option value="">1</option>
                                            <option value="">2</option>
                                            <option value="">3</option>
                                            <option value="">4</option>
                                            <option value="">5</option>
                                        </select>
                                        <input type="text" name="keyword"/>
                                        <button>查找</button>
                                    </form>
                                </caption>
                                <thead>
                                    <tr>
                                        <th class="nobg">流体表格</th>
                                        <th>种类</th>
                                        <th>标签</th>
                                        <th>选项</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <tr>
                                        <th>Lorem ipsum dolor</th>
                                        <td>Blog post</td>
                                        <td>latin, blind copy</td>
                                        <td>none</td>
                                    </tr>
                                    <tr>
                                        <th>About me</th>
                                        <td>Static content</td>
                                        <td>personal, information</td>
                                        <td>none</td>
                                    </tr>
                                    <tr>
                                        <th>Portfolio</th>
                                        <td>Portfolio entry</td>
                                        <td>project, graphic, web design</td>
                                        <td>none</td>
                                        
                                    </tr>
                                    <tr>
                                        <th>A random Blog post</th>
                                        <td>Blog post</td>
                                        <td>random, post, fun</td>
                                        <td>none</td>
                                    </tr>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <td colspan="4">
                                            <div class="pagination">
                                                <a href="#" title="First Page">« 首页</a>
                                                <a href="#" title="Previous Page">« 前一页</a>
                                                <a href="#" class="number" title="1">1</a>
                                                <a href="#" class="number" title="2">2</a>
                                                <a href="#" class="number current" title="3">3</a>
                                                <a href="#" class="number" title="4">4</a>
                                                <a href="#" title="Next Page">后一页 »</a>
                                                <a href="#" title="Last Page">尾页 »</a>
                                            </div>
                                        </td>
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