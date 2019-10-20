package com.treasure.po;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Json {
	
	private Map<String, Object> json = new HashMap<String, Object>(){
		public String toString(){
			if(null == this) return null;
			String toString = "{";
			Set<String> keySet = this.keySet();
			Iterator<String> iterator = keySet.iterator();
			while(iterator.hasNext()) {
				String key = iterator.next();
				Object value = this.get(key);
				
				if(value == null) {
					continue;
				}
				
				String valueString = null;
				if(value instanceof Date) {
					valueString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
					valueString = "\"" + valueString + "\"";
				}else if(value instanceof String){
					valueString = "\"" + value.toString() + "\"";
				}else {
					valueString = value.toString();
				}
				
				toString += "\"" + key + "\"" + ":" + valueString + ",";
			}
			toString = toString.substring(0, toString.length()-1);
			toString += "}";
			return toString;
		}
	};
	
	
	public static Json fromBean(Object obj) {
		if(null == obj)return null;
		
		Json json = new Json();
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field:fields) {
			String fieldName = field.getName();
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Method getMethod;
			try {
				getMethod = clazz.getMethod(getMethodName);
				Object value = getMethod.invoke(obj);
				
				json.put(fieldName, value);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return json;
	}
	
	public void put(String key, Object obj) {
		this.json.put(key, obj);
	}
	public void putAll(Map map) {
		this.json.putAll(map);
	}
	
	public String toString() {
		return this.json.toString();
	}
	
}
