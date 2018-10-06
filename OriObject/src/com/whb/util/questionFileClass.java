package com.whb.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.Model.Question;

public class questionFileClass {

	private Question question;
	private Map<String, String> file;
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Map<String, String> getFile() {
		return file;
	}
	public void setFile(Map<String, String> file) {
		 Map<String, String> map = new TreeMap<String, String>(
	                new Comparator<String>() {
	                    public int compare(String obj1, String obj2) {
	                        // Ωµ–Ú≈≈–Ú
	                        return obj2.compareTo(obj1);
	                    }
	                });
		 Iterator<Map.Entry<String, String>> it = file.entrySet().iterator();
	        while (it.hasNext()) {
	             Map.Entry<String, String> entry = it.next();
	             map.put( entry.getKey(), entry.getValue());
	        }
		this.file = map;
	}
	
	
	
}
