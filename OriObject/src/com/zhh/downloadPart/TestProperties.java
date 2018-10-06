package com.zhh.downloadPart;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

//关于Properties类常用的操作
public class TestProperties {
  //根据Key读取Value
  public static String GetValueByKey(String filename, String key) {
      Properties pps = new Properties();
      try {
//    	  String filepath=new File(".").getAbsolutePath();
//    	  filepath = filepath.substring(0, filepath.length()-1)+"src\\";
//          InputStream in = new BufferedInputStream(new FileInputStream(filepath+filename));  
//    	  InputStream in = TestProperties.class   
//        	        .getResourceAsStream(filename); 
    	  String path=TestProperties.class.getClassLoader().getResource("//").getPath();
          path = path.substring(1,path.length()-1)+"/"+filename;
          System.out.println(path);
          File file= new File(path);
          InputStream in = new FileInputStream(file);
          pps.load(in);
          String value = pps.getProperty(key);
          System.out.println(key + " = " + value);
          return value;
          
      }catch (IOException e) {
          e.printStackTrace();
          return null;
      }
  }
  
  //读取Properties的全部信息
  public static void GetAllProperties(String filePath) throws IOException {
      Properties pps = new Properties();
      InputStream in = new BufferedInputStream(new FileInputStream(filePath));
//      InputStream in = new Object().getClass().getResourceAsStream(filePath);
//      System.out.println(in);
      pps.load(in);
      Enumeration en = pps.propertyNames(); //得到配置文件的名字
      
      while(en.hasMoreElements()) {
          String strKey = (String) en.nextElement();
          String strValue = pps.getProperty(strKey);
          System.out.println(strKey + "=" + strValue);
      }
      
  }
  
  //写入Properties信息
  public static void WriteProperties (String filePath, String pKey, String pValue) throws IOException {
      Properties pps = new Properties();
      
      InputStream in = new FileInputStream(filePath);
      //从输入流中读取属性列表（键和元素对） 
      pps.load(in);
      //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
      //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
      OutputStream out = new FileOutputStream(filePath);
      pps.setProperty(pKey, pValue);
      //以适合使用 load 方法加载到 Properties 表中的格式，  
      //将此 Properties 表中的属性列表（键和元素对）写入输出流  
      pps.store(out, "Update " + pKey + " name");
  }
  
  public static void main(String [] args) throws IOException{
	  System.out.println(new File(".").getAbsolutePath());
      //String value = GetValueByKey("Test.properties", "name");
      //System.out.println(value);
//	  String filepath=new File(".").getAbsolutePath();
//	  filepath = filepath.substring(0, filepath.length()-1)+"src\\";
//	  System.out.println(filepath);
//      GetAllProperties(filepath+"Test.properties");
      //WriteProperties("Test.properties","long", "212");
      GetValueByKey("Test.properties","name");
      String name = GetValueByKey("Test.properties","name");
      System.out.println(name);
//      String path=TestProperties.class.getClassLoader().getResource("//").getPath();
//      path = path.substring(1,path.length()-1);
//      System.out.println(path);
  }
}