package com.whb.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testUtil {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format( new Date() );
		System.out.println(currentDate);
		
		//��ȡ��ǰʱ���
		Timestamp time= new Timestamp(System.currentTimeMillis());
	}
	
}
