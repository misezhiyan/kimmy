package com.treasure.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonArray implements Iterable, Serializable{

	private List<Json> JsonList = new ArrayList<Json>() {
		public String toString() {
			if(null == this) return null;
			String toString = "[";
			if (this.size() > 0) {

				for (Json json : this) {
					toString += json + ",";
				}
				toString = toString.substring(0, toString.length() - 1);
			}
			toString += "]";
			return toString;
		}
	};

	public static JsonArray fromObject(Object object) {
		
		if(null == object) return null;
		
		JsonArray jArray = new JsonArray();
		
		if(object instanceof List) {
			List list = (List) object;
			for(int i = 0; i < list.size(); i++) {
				Object objTemp = list.get(i);
				try {
					jArray.add(Json.fromBean(objTemp));
				}catch(Exception e) {
					try {
						throw new Exception("JsonArray中不能保存非Json类型数据: " + (i+1) + " 位元素");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}else {
			try {
				throw new Exception("JsonArray不能识别数据类型");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return jArray;
	}
	
	public void add(Json json) {
		this.JsonList.add(json);
	}
	
	public String toString() {
		return this.JsonList.toString();
	}
	
	public int size() {
		return this.JsonList.size();
	}
	
	@Override
	public Iterator iterator() {
		return this.JsonList.iterator();
	}
	
}
