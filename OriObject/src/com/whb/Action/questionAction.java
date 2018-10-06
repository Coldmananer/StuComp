package com.whb.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.Model.Competition;
import com.Model.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.whb.Dao.competitionDao;
import com.whb.Dao.questionDao;
import com.whb.Dao.impl.competitionDaoImpl;
import com.whb.Dao.impl.questionDaoImpl;
import com.zhh.downloadPart.TestProperties;

public class questionAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	private String questionId;
    private String ques;		//�����Ŀʱ����������
    private String desc;		//�����Ŀʱ����������
    private String answ;		//�������ʱ�������
    private File[] file;            //�ļ�  
    private String[] fileFileName;  //�ļ���   
    private String[] filePath;        //�ļ�·��
    private String downloadFilePath;  //�ļ�����·��
	private String CompId;
	
	
    
	public String getAnsw() {
		return answ;
	}

	public void setAnsw(String answ) {
		this.answ = answ;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFilePath() {
		return filePath;
	}

	public void setFilePath(String[] filePath) {
		this.filePath = filePath;
	}

	public String getDownloadFilePath() {
		return downloadFilePath;
	}

	public void setDownloadFilePath(String downloadFilePath) {
		this.downloadFilePath = downloadFilePath;
	}

	public String getCompId() {
		return CompId;
	}

	public void setCompId(String compId) {
		CompId = compId;
	}

	public String questionModify()throws Exception{
		int questionid = Integer.parseUnsignedInt(questionId);
		questionDao questiondao = new questionDaoImpl();
		Question question = questiondao.findbyQuestionId(questionid);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.removeAttribute("question");
		request.setAttribute("question", question);
		//���ļ���ʾ
		String savePath = question.getFileDesc();
		String realName = question.getFileName();
		if(savePath!=null){
			List<String> savePaths = Arrays.asList(savePath.split(";"));
			List<String> realNames = Arrays.asList(realName.split(";"));
			Map<String, String> files = new HashMap<String, String>();
			for(int i=0;i<savePaths.size();i++)
				files.put(savePaths.get(i), realNames.get(i));
			request.setAttribute("files", files);
		}
		return SUCCESS;
	}
	
	//��������Ŀ��ť�����¼�
	public String addQuestion() throws Exception{

		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession(); 
        int compId;
		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		competitionDao competitiondao = new competitionDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
		questionDao questiondao = new questionDaoImpl();
		List<Question> list = questiondao.findbyCompId(compId);
		Question question = new Question();
		question.setCompetition(competition);
		question.setQuestionIntro(desc);
		question.setQuestionName(ques);
		question.setQuestionAnsw(answ);
//		System.out.println("list.size()����");
//		System.out.println(list.size());
		int i ;
		if(list==null)	i=0;
		else	i = list.size();
		question.setQuestionNum(String.valueOf(i+1));
		if(file != null){
			String savedFileName ="";
			String realFileName="";
			// 1.�õ�ServletContext
			//ServletContext servletContext = ServletActionContext.getServletContext();
			// 2.����realPath��������ȡ����һ������Ŀ¼�õ�����ʵĿ¼
			//String realPath = servletContext.getRealPath("/WEB-INF/comptopicfile");
			//�������ļ��涨�ϴ������λ��
			String realPath1 = TestProperties.GetValueByKey("Test.properties","uploadquestion");
			System.out.println(realPath1);
			// 3.��������ʵ��Ŀ¼�����ڣ���Ҫ����
			File file = new File(realPath1);
			if (!file.exists()) {
				file.mkdirs();
				System.out.println("������");
			}
			File f[] = this.getFile();
			filePath = new String[f.length];
			for (int j = 0; j < f.length; j++) {
				String fileName = java.util.UUID.randomUUID().toString(); // ����ʱ��+UUID�ķ�ʽ�漴����
				String name = fileName+ fileFileName[j].substring(fileFileName[j].lastIndexOf(".")); // ������Ӳ���е��ļ���
				savedFileName +=name+";";
				realFileName += fileFileName[j]+";";
				FileInputStream inputStream = new FileInputStream(f[j]);
				FileOutputStream outputStream = new FileOutputStream(realPath1
						+ "\\" + name);
				byte[] buf = new byte[1024];
				int length = 0;
				while ((length = inputStream.read(buf)) != -1) {
					outputStream.write(buf, 0, length);
				}
				inputStream.close();
				outputStream.flush();
				// �ļ����������·��
				// ���磺D:\tomcat6\webapps\struts_ajaxfileupload\\upload\a0be14a1-f99e-4239-b54c-b37c3083134a.png
			}
//			// 4.���ļ����ȥ
//			// ���������ļ�����ʱ�ļ����Ƶ�ָ����λ�á�ע�⣺��ʱ�ļ�����
//			FileUtils.copyFile(myfile, new File(file,myfileFileName));
//			// ���У�����ʱ�ļ�����ָ����λ�ã����Ҹ����������� ע�⣺��ʱ�ļ�û����
//			//myfile.renameTo(new File(file, myfileFileName));
//			question.setFileDesc(realPath1+"\\"+myfileFileName);
//			//�ļ��ϴ��������ģ��������ص�ʱ��ֻ����Ӣ�ģ�������Ҫ�������ݿ����Ƿ����ģ�
//			//���ݿ����и��ֶα����ļ��� ,�ļ�����ʱ�����һ������ֶ�
//			//��ȡʱ��� new Date().getTime();
			System.out.println(realFileName+":"+savedFileName);
			question.setFileName(realFileName);
			question.setFileDesc(savedFileName);
		}
		
		questiondao.save(question);
		request.setAttribute("CompId", CompId);
		return SUCCESS;
	}
	
	public String questionFileDownload()throws Exception{
		
		return SUCCESS;
	}
	
	public String questionDelete()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("CompId", CompId);
		ActionContext actionContext = ActionContext.getContext();  
        Map session = actionContext.getSession(); 
        int compId;
		System.out.println(CompId);
		try {
			compId =Integer.parseInt(CompId);
		} catch (Exception e) {
			return ERROR;
		}
		competitionDao competitiondao = new competitionDaoImpl();
		Competition competition = competitiondao.findbyCompId(compId);
		questionDao questiondao = new questionDaoImpl();
		Question question = questiondao.findbyQuestionId(Integer.valueOf(questionId));
		questiondao.delete(question);
		List<Question> questions = questiondao.findbyCompId(compId);
		for(int i=0;i<questions.size();i++){
			questions.get(i).setQuestionNum(String.valueOf(i+1));
		}
		questiondao.updates(questions);
		return SUCCESS;
	}
	
}
