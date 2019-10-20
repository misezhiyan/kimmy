package com.kimmy.web.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kimmy.web.dao.po.User;
import com.kimmy.web.dao.service.LoginService;
import com.kimmy.web.util.ContextHolderUtils;

public class LoadOnFilter implements Filter{
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
/*************************************************************************************************************************************************/
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("启动了请求过滤器");
		/*ContextHolderUtils.setSessionMap(new HashMap<String, HttpSession>());*/
		System.out.print("创建了sessionMap:" + ContextHolderUtils.getSessionMap());
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session=request.getSession();
		User user = (User) session.getAttribute("user");

		String uri = request.getRequestURI();
		String targetURL = uri.substring(uri.indexOf("/", 1));
		String web = uri.replace(targetURL, "");
		
		if(user != null){
			//更新最后请求时间
			user.setLastRequestTime(new Date());
			if(null != loginService)loginService.updateLastRequestTime(user);
			chain.doFilter(request, response);
		}else{//注册,登录跳页动作
			if("/signIn/indexPage.do".equals(targetURL) || "/signIn/signInPage.do".equals(targetURL) || "/signIn/registerPage.do".equals(targetURL) ||
					//注册,登录动作
					"/signIn/login.do".equals(targetURL) || "/signIn/register.do".equals(targetURL)){
				chain.doFilter(request, response);
			}else{
				response.sendRedirect(web + "/signIn/indexPage.do");
			}
		}
	}

	@Override
	public void destroy() {
		System.out.println("关闭了请求过滤器");
	}
	
}
