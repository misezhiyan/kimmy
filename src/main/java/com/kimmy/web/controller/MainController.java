package com.kimmy.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.kimmy.base.BaseController;

public class MainController extends BaseController{
	
	public ModelAndView loginsuccess(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("main/logInSuccess");
	}
}
