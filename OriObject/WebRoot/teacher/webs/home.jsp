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
        <title>主页</title>
        <link rel="stylesheet" href="<%=basePath%>/teacher/css/style_all.css" type="text/css" media="screen" />
        
        
        
        <!-- to choose another color scheme uncomment one of the foloowing stylesheets and wrap styl1.css into a comment -->
        <link rel="stylesheet" href="<%=basePath%>/teacher/css/style8.css" type="text/css" media="screen" />
        
        <link rel="stylesheet" href="<%=basePath%>/teacher/css/jquery-ui.css" type="text/css" media="screen" />
        
        <link rel="stylesheet" href="<%=basePath%>/teacher/ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />
        
        <!--Internet Explorer Trancparency fix-->
        <!--[if IE 6]>
        <script src="js/ie6pngfix.js"></script>
        <script>
          DD_belatedPNG.fix('#head, a, a span, img, .message p, .click_to_close, .ie6fix');
        </script>
        <![endif]--> 
        
        <script type='text/javascript' src='<%=basePath%>/teacher/js/all-ck.js'></script>
        <script type='text/javascript' src='<%=basePath%>/teacher/ueditor1_2_2_0-utf8-php/editor_config.js'></script>
        <script type='text/javascript' src='<%=basePath%>/teacher/js/custom.js'></script>
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
                        <img src="<%=basePath%>/teacher/images/unreadmail.png" alt=""/>
                    </div>
                    
                    <span class='memberinfo_span'>
                       欢迎<a href="">${sessionScope.teaid}</a>
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
            
        </div>
            <!--end head-->
           	
            	<div id="bg_wrapper">
                
                    <div id="main">
                        <div id="content">

                                    <h2 class="jquery_tab_title">最新竞赛</h2>
                                    
                                    <a class="dashboard_button button1" href="#">
                                        <span class="dashboard_button_heading">面板</span>
                                        <span>编辑各种基本的设置和选项</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button2" href="#">
                                        <span class="dashboard_button_heading">è®¾ç½®</span>
                                        <span>ç¼è¾åç§åè¿çè®¾ç½®åéé¡¹</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button3" href="#">
                                        <span class="dashboard_button_heading">åºç¨</span>
                                        <span>æ·»å åç¼è¾åºç¨ç¨åº</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button4" href="#">
                                        <span class="dashboard_button_heading">èæ¬ç¼è¾å¨</span>
                                        <span>è¾å¥æ¨çJavaScriptåPHPèæ¬</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button5" href="#">
                                        <span class="dashboard_button_heading">æç´¢</span>
                                        <span>åºæ¬ååè¿çæç´¢åº</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button6" href="#">
                                        <span class="dashboard_button_heading">åºçº¸ç¯</span>
                                        <span>å é¤çé¡¹ç®åæ°æ®åºæ¡ç®</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button7" href="#">
                                        <span class="dashboard_button_heading two_lines">åå®¹ç®¡çå¨</span>
                                        <span>æ·»å æ°çéæåå¨æåå®¹</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button8" href="#">
                                        <span class="dashboard_button_heading">æä»¶</span>
                                        <span>æä»¶åä¸è½½ç®¡ç</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button9" href="#">
                                        <span class="dashboard_button_heading two_lines">éè®¯ç®¡ç</span>
                                        <span>æ·»å åç®¡çè®¢éçµå­æ¥</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button10" href="#">
                                        <span class="dashboard_button_heading two_lines">ç¨æ·ç®¡çå¨</span>
                                        <span>æ·»å åç¼è¾ç¨æ·è®¾ç½®</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button11" href="#">
                                        <span class="dashboard_button_heading">ç»å»</span>
                                        <span>ç®¡çæ¨çå¾çåº</span>
                                    </a><!--end dashboard_button-->
                                    
                                    <a class="dashboard_button button12" href="#">
                                        <span class="dashboard_button_heading">å¸®å©</span>
                                        <span>å¦ä½ä½¿ç¨èæ¬æç¨</span>
                                    </a><!--end dashboard_button-->
                                    
                            <h2>竞赛列表</h2>
                            <div>
                                <p>
                                    ECMall 2.2.1 åå¸ï¼æå¾æ¨åä¸æµè¯ã2010-09-28 
                                    <a href="">æ¥çè¯¦æ</a> <a href="">BUGåé¦</a>
                                </p>
                                <p>
                                    ECMall å®å¨è¡¥ä¸ï¼V2.1åV2.2ç¨æ·å¡å¿æ´æ°ï¼2010-07-19
                                    <a href="">æ¥çè¯¦æ</a>
                                </p>
                            </div>
                            <h2>优秀作品</h2>
                            <div>
                                <table>
                                    <tr>
                                        <th class="specalt">æ°å¢ä¼åæ°:  </th>
                                        <td>3   </td>
                                        <th class="specalt">æ°å¢åºéºæ°/ç³è¯·æ°:  </th>
                                        <td>0/0</td>
                                    </tr>
                                    <tr>
                                        <th class="specalt">æ°å¢ååæ°:  </th>
                                        <td>0   </td>
                                        <th class="specalt">æ°å¢è®¢åæ°:  </th>
                                        <td>0</td>
                                    </tr>
                                </table>
                            </div>
                            <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >ä¼ä¸ç½ç«æ¨¡æ¿</a></div>
                            <h2>ç»è®¡ä¿¡æ¯</h2>
                            <div>
                               <table>
                                   <tr>
                                       <th class="specalt">ä¼åæ»æ°: </th>
                                       <td>3</td>
                                       <th class="specalt">åºéºæ»æ°/ç³è¯·æ»æ°:  </th>
                                       <td>1/0</td>
                                   </tr>
                                   <tr>
                                       <th class="specalt">ååæ»æ°:</th>
                                       <td>29  </td>
                                       <th class="specalt">è®¢åæ»æ°:</th>
                                       <td>7</td>
                                   </tr>
                                   <tr>
                                       <th class="specalt">è®¢åæ»éé¢:  </th>
                                       <td>Â¥1,165.00</td>
                                   </tr>
                               </table>
                            </div>
                            <h2>ç³»ç»ä¿¡æ¯</h2>
                            <div>
                                <table>
                                    <tr>
                                        <th class="specalt">æå¡å¨æä½ç³»ç»: </th>
                                        <td>WINNT   WEB </td>
                                        <th class="specalt">æå¡å¨:</th>
                                        <td>Apache/2.2.9 (APMServ) PHP/5.2.6</td>
                                    </tr>
                                    <tr>
                                        <th class="specalt">PHP çæ¬: </th>
                                        <td>5.2.6   </td>
                                        <th class="specalt">MYSQL çæ¬:   </th>
                                        <td>5.1.28-rc-community-log</td>
                                    </tr>
                                    <tr>
                                        <th class="specalt">ECMall çæ¬:</th>
                                        <td>2.2.1 20100928  </td>
                                        <th class="specalt">å®è£æ¥æ:</th>
                                        <td>2012-08-09</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <!--end content-->
                        
                    </div><!--end main-->
                    
                    <div id="sidebar">
                        <ul class="nav">
                            <li><a class="headitem item1" href="#">主页</a></li>
                            <li><a class="headitem item2" href="#">竞赛列表</a></li>
                            <li><a class="headitem item4" href="#">发布竞赛</a></li>
                            <li><a class="headitem item5" href="#">竞赛管理</a></li>
                            <li><a class="headitem item6" href="#">信息管理</a></li>
                        </ul><!--end subnav-->

                        <div class="flexy_datepicker"></div>
     

                </div>
                    <!--end sidebar-->
                        
                     </div><!--end bg_wrapper-->
                     
                <div id="footer" style="color: #fff;text-align: center">
                More Templates <a href="http://www.cssmoban.com/" target="_blank" title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a> - Collect from <a href="http://www.cssmoban.com/" title="ç½é¡µæ¨¡æ¿" target="_blank">ç½é¡µæ¨¡æ¿</a>
                </div><!--end footer-->
                
        </div><!-- end top -->
        
    </body>
    
</html>