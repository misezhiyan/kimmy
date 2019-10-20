package com.treasure.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	//判断字符串为空
	public static boolean isEmpty(String str) {
		if (null == str || str.trim().equals("")) return true;
		
		return false;
	}
	
	//防止 toString 时 obj 为 null 的报错
	public static String toString(Object obj) {
		if (null == obj || obj.equals("")) return "";
		
		return String.valueOf(obj);
	}
	
	//字符串中匹配字符
	public static List<String> match(String string, String regex) {
		if(isEmpty(string)) return null;
		
		Pattern pattern = Pattern.compile(regex); 
		Matcher matcher = pattern.matcher(string);
		
		List<String> resultList = new ArrayList<String>();
		while(matcher.find()) {
			String result = matcher.group(0);
			resultList.add(result);
		}
		
		return resultList;
	}
}
