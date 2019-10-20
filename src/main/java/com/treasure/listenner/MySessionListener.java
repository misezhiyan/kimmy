package com.treasure.listenner;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.treasure.util.ContextHolderUtils;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		System.out.println("监听到  SESSION 创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = ContextHolderUtils.getSession();
		Map<String, HttpSession> sessionMap = ContextHolderUtils.getSessionMap();
		
		session = null;
		
		/*
		Set keys = sessionMap.keySet();
		Iterator iterator = keys.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next().toString();
			iterator.remove();
			System.err.println("监听中map中key:" + key);
			System.err.println("监听中map中session:" + sessionMap.get(key));
		}*/
		
		System.out.println("监听到  SESSION 摧毁");
	}

}
