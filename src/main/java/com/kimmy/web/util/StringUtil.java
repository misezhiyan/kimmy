package com.kimmy.web.util;

public class StringUtil {
	
	public static boolean isEmpty(String str) {
		if (null == str || str.trim().equals("")) {
			return true;
		}
		
		return false;
	}
	
	
	public static String toString(Object obj) {
		if (null == obj || obj.equals("")) {
			return "";
		}
		
		return String.valueOf(obj);
	}
}
