<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>添加题目</title>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>/teacher1/docs/css/main1.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/teacher1/docs/css/common.css">
  	<link rel="stylesheet" href="<%=basePath%>/teacher1/docs/ueditor1_2_2_0-utf8-php/themes/default/ueditor.css" type="text/css" media="screen" />
</head>
<body>

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
        	 
        	<s:file name="myfile"  theme="simple"></s:file><br>
			<!--
			<div id="addFile1">
			<input type="file" id="file1" name="file" /><a id="add" href="javascript:void();" onclick="addFile();">添加</a>
			<span>
				<table id="down">
				</table>
			</span>
			</div>
			-->
			</br>
        	     
     	</div>
  
    	<div class="but-style">
         	<input type="submit" value="提交" name="Submit"/>
         	<input type="button" value="取消"/>
    	</div>

  </form>


	<script type="text/javascript" src="<%=basePath%>/teacher1/docs/js/jquery-1.8.0.min.js"></script>
	<script type='text/javascript' src='<%=basePath%>/teacher1/docs/ueditor1_2_2_0-utf8-php/editor_config.js'></script>
	<script type="text/javascript">
		//添加附件 
		function addFile() {
			var fileLength = $("input[name=file]").length + 1;
			var inputFile = "<div id='addFile" + fileLength + "'><input type='file' id='file" + fileLength + "' name='file' />"
				+ "<a href='javascript:void();' onclick='delFile(" + fileLength + ");'>删除</a></div>";
			$("#add").after(inputFile);
		}
		//删除附件
		function delFile(id) {
			$("#addFile" + id).remove();
		}
		function fileUpload() {
			var files = "";
			//获取所有 <input type="file" id="file1" name="file" /> 的ID属性值 
			$("input[name=file]").each(function() {
				files = files + $(this).attr("id") + ",";
			})
			files = files.substring(0, files.length - 1);
			console.info(typeof (files));
			$.ajaxFileUpload({
				url : 'fileupload', //用于文件上传的服务器端请求地址  
				secureuri : false, //一般设置为false  
				fileElementId : files, //文件上传空间的id属性  <input type="file" id="file" name="file" />  
				dataType : 'json', //返回值类型 一般设置为json  
				success : function(data, status) {
					var fileNames = data.fileFileName; //返回的文件名 
					var filePaths = data.filePath; //返回的文件地址 
					for (var i = 0; i < data.fileFileName.length; i++) {
						$("#down").after("<tr><td height='25'>" + fileNames[i] + "</td><td><a href='downloadFile?downloadFilePath=" + filePaths[i] + "'>下载</a></td></tr>")
					}
				}
			})
		}
		$(function() {})
	</script>
</body>
</html>
