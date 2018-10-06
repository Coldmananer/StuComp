package com.whb.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zhh.downloadPart.TestProperties;

public class fileDownloadAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String f;
	private String realName;
    private String contentType;

    
    
    public String getRealName() {
    	String name = "";
    	
    	try {
			name = new String(realName.getBytes("utf-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��getRealName����������");
		}
    	
		return name ;
	}

	public void setRealName(String realName) {

		try {
			this.realName = new String(realName.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��setRealName����������");
		}
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public InputStream getIs() throws FileNotFoundException{
//        System.out.println(ServletActionContext.getServletContext().getMimeType(f));
        System.out.println("f:"+f);
		String realPath = TestProperties.GetValueByKey("Test.properties","uploadquestion")+"\\"+f;
        String realFile = realName;
        System.out.println("realName:"+realName);
        File file = new File(realPath);

        
        FileInputStream is = new FileInputStream(file);
        return is;
//        return new FileInputStream(ServletActionContext.
//                getServletContext().getRealPath("/download")+"/"+f);
    }

    public String getF() throws UnsupportedEncodingException {

        return f;
    }

    public void setF(String f) {
        /*
         * �� tomcat7 �д�get�����ȡ���������������ģ�
         * ��ᷢ��������������
         * ��Ϊ���������������������utf-8����ģ��ڷ�����tomcat����iso-8859-1����
         * ���������룬���������Խ��������
         * new String(f.getBytes("ISO-8859-1"),"UTF-8");
         * */

        this.f = f;
    }


//    public String getContentType() {
////        System.out.println(f);
////        System.out.println(ServletActionContext.getServletContext().getMimeType(f));
//        return ServletActionContext.getServletContext().getMimeType(f);
//
//    }

}

