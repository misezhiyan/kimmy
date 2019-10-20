package com.treasure.web;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.treasure.base.BaseController;
import com.treasure.business.service.LoginBusinessService;
import com.treasure.dao.po.User;
import com.treasure.util.ContextHolderUtils;
import com.treasure.util.StringUtil;

/**
 * @Title: SignInController
 * @Description: 登录功能
 * @author Barry
 * @date 2016-09-07
 */
public class SignInController extends BaseController {

	private LoginBusinessService loginBusinessService;

	public void setLoginBusinessService(LoginBusinessService loginBusinessService) {
		this.loginBusinessService = loginBusinessService;
	}

	/*************************************************** 业务处理区  ************************************************************************************************************/

	/**
	 * 跳转到登录界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("signIn/index");
	}

	/**
	 * 跳转到登录界面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView signInPage(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("signIn/signIn");
	}

	/**
	 * 跳转到注册
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView registerPage(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("signIn/register");
	}

	/**
	 * check登录用户名和密码，进行登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 前台参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if (StringUtil.isEmpty(name) || StringUtil.isEmpty(password)) {
			// 相应页面不能为空
			
			response.getWriter().write("用户和密码不能为空!");
			return null;
		}

		boolean nameExist = loginBusinessService.checkName(name);
		if (nameExist) {
			// 用户已存在
			response.getWriter().write("用户已存在");
			return null;
		}

		User user = new User();
		user.setUser_id(StringUtil.toString(UUID.randomUUID()));
		user.setName(name);
		user.setPassword(password);
		user.setRegisterTime(new Date());

		boolean registSuccess = loginBusinessService.registUser(user);
		if (registSuccess) {
			// 注册成功并登录用户
			response.getWriter().write("注册成功");
			return null;
		} else {
			// 注册失败
			response.getWriter().write("注册失败, 请联系管理员");
			return null;
		}

	}

	/**
	 * check登录用户名和密码，进行登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		// 前台参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (StringUtil.isEmpty(name) || StringUtil.isEmpty(password)) {
			// 相应数据不能为空
			response.getWriter().write("账号和密码不能为空");
			return null;
		}

		// 校验用户是否存在
		boolean nameExist = loginBusinessService.checkName(name);
		if (!nameExist) {
			response.getWriter().write("账号不存在");
			return null;
		}

		// 校验登录信息是否正确
		User loginUser = new User();
		loginUser.setName(name);
		loginUser.setPassword(password);
		User user = loginBusinessService.checkLoginInfo(loginUser);

		if (user != null) {

			// 校验登录账户状态和当前连接登录状态
			HttpSession session = ContextHolderUtils.getSession();
			Map<String, HttpSession> sessionMap = ContextHolderUtils.getSessionMap();
			// 校验当前session是否有其它用户登录, 如果有, 注销该用户
			if (session.getAttribute("user") != null) {
				User logUser = (User) session.getAttribute("user");
				// Map<String, HttpSession> sessionMap = ContextHolderUtils.getSessionMap();
				// sessionMap.remove(logUser.getUser_id());
				session.setAttribute("user", null);
				sessionMap.remove(logUser.getUser_id());
			}

			// 检验该账号是否已处于异地登录状态, 如果已处于异地登录状态, 将异地登录的session(非当前登录session)解散掉
			HttpSession oldSession = sessionMap.get(user.getUser_id());
			if (null != oldSession && !session.equals(oldSession)) {
				oldSession.invalidate();
				oldSession = null;
			}

			// 登录当前用户
			session.setAttribute("user", user);
			sessionMap.put(user.getUser_id(), session);
		} else {
			response.getWriter().write("登录信息错误");
			return null;
		}

		return new ModelAndView("redirect:/poker/pokerBindPage.do");
		// return new ModelAndView(new RedirectView("xxx.do"), map);
	}

	/**
	 * 账号注销
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView logOut(HttpServletRequest request, HttpServletResponse response) {

		boolean success = loginBusinessService.logOut();

		return new ModelAndView("redirect:/signIn/signInPage.do");
	}
}
