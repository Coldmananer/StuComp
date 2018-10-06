package com.zhh.downloadPart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;


public class downloadQue extends ActionSupport{
    private String downPath;        // ����ʱ���ļ���
    private String contentType;     // �����ļ�����
    private String filename;        // ����ʱ���ļ���

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
            // �������ʱ��������ļ���������
            downPath = new String(downPath.getBytes("ISO-8859-1"),"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        this.downPath = downPath;
    }

   /*
    *�����õ�Action����һ��InputStringʵ�����÷�����ӦAction����
    *�����result��inputName������ֵΪinputStream
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
       // ���ر���ʱ���ļ����ͱ����ص��ļ���һ��
	  
       filename = downPath;
       // ���ص��ļ�·��������webappsĿ¼�´���images
       downPath = "D:\\����1\\" + downPath;
       // �����ļ�������

       contentType = "application/x-msdownload";

       /*
        *�����ص��ļ�������UTF-8���б��룬������ش����е�������������
        * ����,MyUtil���Լ������һ����
        */

       filename = MyUtil.toUTF8String(filename);
       return SUCCESS;
   }
}
