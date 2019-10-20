package com.kimmy.web.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ContextHolderUtils {
	
	static{
		sessionMap = new HashMap<String, HttpSession>();
		System.out.print("创建了sessionMap:");
	}
	
	public static Map<String, HttpSession> sessionMap;
	
	public static void setSessionMap(Map<String, HttpSession> sessionMap) {
		ContextHolderUtils.sessionMap = sessionMap;
	}
	

	/**
	 * SpringMvc下获取request
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		return request;
	}

	/**
	 * SpringMvc下获取session
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();

		return session;
	}

	/**
	 * 获取 sessionMap
	 */
	public static Map<String, HttpSession> getSessionMap() {
		return sessionMap;
	}
}
