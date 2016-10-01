package com.rest.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	
	private static String SENDER_FORMART = "EEE, dd MMM yyyy";
	private static String RECEIVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public DateFormatUtil() {
		
	}
	
	public static String getUserDisplayFormat(String date) {
		Date dateObj = getDate(date);
		SimpleDateFormat sdf = new SimpleDateFormat(SENDER_FORMART);
		return sdf.format(dateObj);
	}
	
	public static Date getDate(String userSent) {
		SimpleDateFormat sdf = new SimpleDateFormat(RECEIVER_FORMAT);
		try {
			return sdf.parse(userSent.substring(0, userSent.lastIndexOf(".")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
