package com.treasure.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.treasure.base.BaseController;

public class MainController extends BaseController{
	
	public ModelAndView loginsuccess(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("main/logInSuccess");
	}
}
