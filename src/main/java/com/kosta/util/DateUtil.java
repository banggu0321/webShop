package com.kosta.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	public static Date convertToDate(String strdate) {
		//�ڹ��� ���� MM, ���� mm
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = null; //Util
		Date d2 = null;			 //SQL
		try {
			d = sdf.parse(strdate);
			d2 = new Date(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d2;
	}
}
