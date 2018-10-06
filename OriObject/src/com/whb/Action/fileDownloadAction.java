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
			System.out.println("在getRealName处发生错误");
		}
    	
		return name ;
	}

	public void setRealName(String realName) {

		try {
			this.realName = new String(realName.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("在setRealName处发生错误");
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
         * 在 tomcat7 中从get请求获取参数是若包含中文，
         * 则会发现中文乱码现象
         * 因为浏览器传送来的数据是以utf-8编码的，在服务器tomcat则以iso-8859-1解码
         * 产生了乱码，下面代码可以解决该问题
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

