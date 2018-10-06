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

//����Properties�ೣ�õĲ���
public class TestProperties {
  //����Key��ȡValue
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
  
  //��ȡProperties��ȫ����Ϣ
  public static void GetAllProperties(String filePath) throws IOException {
      Properties pps = new Properties();
      InputStream in = new BufferedInputStream(new FileInputStream(filePath));
//      InputStream in = new Object().getClass().getResourceAsStream(filePath);
//      System.out.println(in);
      pps.load(in);
      Enumeration en = pps.propertyNames(); //�õ������ļ�������
      
      while(en.hasMoreElements()) {
          String strKey = (String) en.nextElement();
          String strValue = pps.getProperty(strKey);
          System.out.println(strKey + "=" + strValue);
      }
      
  }
  
  //д��Properties��Ϣ
  public static void WriteProperties (String filePath, String pKey, String pValue) throws IOException {
      Properties pps = new Properties();
      
      InputStream in = new FileInputStream(filePath);
      //���������ж�ȡ�����б�����Ԫ�ضԣ� 
      pps.load(in);
      //���� Hashtable �ķ��� put��ʹ�� getProperty �����ṩ�����ԡ�  
      //ǿ��Ҫ��Ϊ���Եļ���ֵʹ���ַ���������ֵ�� Hashtable ���� put �Ľ����
      OutputStream out = new FileOutputStream(filePath);
      pps.setProperty(pKey, pValue);
      //���ʺ�ʹ�� load �������ص� Properties ���еĸ�ʽ��  
      //���� Properties ���е������б�����Ԫ�ضԣ�д�������  
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