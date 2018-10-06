package com.zhh.downloadPart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;


public class downloadQue extends ActionSupport{
    private String downPath;        // 下载时的文件名
    private String contentType;     // 保存文件类型
    private String filename;        // 保存时的文件名

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDownPath() {
        return downPath;
    }
    public void setDownPath(String downPath) {
        try {
            // 解决下载时候的中文文件乱码问题
            downPath = new String(downPath.getBytes("ISO-8859-1"),"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        this.downPath = downPath;
    }

   /*
    *下载用的Action返回一个InputString实例，该方法对应Action配置
    *里面的result的inputName参数，值为inputStream
    *
    */

   public InputStream getInputStream(){
	   File file = new File(downPath);  
	   
	   InputStream is = null;
	try {
		is = new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	     
	   return is;
   }

   public String execute(){
       // 下载保存时的文件名和被下载的文件名一样
	  
       filename = downPath;
       // 下载的文件路径，请在webapps目录下创建images
       downPath = "D:\\电赛1\\" + downPath;
       // 保存文件的类型

       contentType = "application/x-msdownload";

       /*
        *对下载的文件名按照UTF-8进行编码，解决下载窗口中的中文乱码问题
        * 其中,MyUtil是自己定义的一个类
        */

       filename = MyUtil.toUTF8String(filename);
       return SUCCESS;
   }
}
