package com.treasure.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.treasure.base.BaseController;
import com.treasure.business.service.PokerBusinessService;
import com.treasure.dao.po.User;
import com.treasure.dao.po.UserPoker;
import com.treasure.po.Json;
import com.treasure.po.JsonArray;
import com.treasure.util.ContextHolderUtils;
import com.treasure.util.HttpUtil;
import com.treasure.util.StringUtil;

/**
 * @Title: SignInController
 * @Description: 绑定poker账号密码功能
 * @author Barry
 * @date 2016-09-07
 */
public class PokerController extends BaseController {

	private PokerBusinessService pokerBusinessService;

	public void setPokerBusinessService(PokerBusinessService pokerBusinessService) {
		this.pokerBusinessService = pokerBusinessService;
	}
	
	//跳转poker绑定页面, 同时也是已绑定账户展示和绑定账号登录页面
	public ModelAndView pokerBindPage(HttpServletRequest request, HttpServletResponse response) {
		//获取当前登录用户
		User user = getCurrentUser();
		
		List<UserPoker> pokerList = pokerBusinessService.getPokerList(user);
		
		//最失败的测试
//		JsonArray jsonArray = JsonArray.fromObject(pokerList);
		
//		String jsonArrayStr = jsonArray.toString();
//		try {
//			response.getWriter().write(jsonArrayStr);
//			response.getWriter().close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		UserPoker userPoker = new UserPoker();
//		userPoker.setBind_time(new Date());
//		userPoker.setId(1);
//		userPoker.setName("haha");
//		UserPoker userPoker2 = new UserPoker();
//		userPoker2.setBind_time(new Date());
//		userPoker2.setId(2);
//		userPoker2.setName("hehe");
//		pokerList.add(userPoker);
//		pokerList.add(userPoker2);
//		jsonArray.add(Json.fromBean(userPoker2));
//		jsonArray.add(Json.fromBean(userPoker));
//		JSONArray jsonarray = new JSONArray();
//		jsonarray.add(userPoker);
//		jsonarray.add(userPoker2);
		
		request.setAttribute("pokerList", pokerList);
		
		return new ModelAndView("poker/pokerList");
	}
	
	
	public static void main(String[] args) {

		/*List<UserPoker> pokerList = new ArrayList<>();
		UserPoker userPoker = new UserPoker();
		userPoker.setBind_time(new Date());
		userPoker.setId(1);
		userPoker.setName("haha");
		UserPoker userPoker2 = new UserPoker();
		userPoker2.setBind_time(new Date());
		userPoker2.setId(2);
		userPoker2.setName("hehe");
		pokerList.add(userPoker);
		pokerList.add(userPoker2);
		
		JsonArray jsonArray = JsonArray.fromObject(pokerList);
		String jsonArrayStr = jsonArray.toString();
		
		System.out.println(jsonArrayStr);*/
		
	}
	
	
	//触碰poker网站, 获取 cookie 及加密参数
	public void pokerBindMessage(HttpServletRequest request, HttpServletResponse response) {
		//设置参数
		String url = "http://cms.pokermanager.club/cms/";
		//获取cookie
		String cookies = HttpUtil.getCookiesByGet(url);
		//保存到session中
		HttpSession session = ContextHolderUtils.getSession();
		session.setAttribute("pokerCookies", cookies);
		
		String html = HttpUtil.sendGetWithCookie(url, cookies);
		System.out.println(html);
//		Document doc = Jsoup.parse(html);
//		String key = "input";
//		Elements elements = doc.getElementsByAttribute(key);
		
		String regex = "ng-init=\"";
		List<String> match = StringUtil.match(html, regex);
		
		
		Json json = new Json();
		String jsonStr = json.toString();
		try {
			response.getWriter().write(jsonStr);
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//获取poker验证码
	public ModelAndView pokerSafeCode(HttpServletRequest request, HttpServletResponse response) {
		
		return new ModelAndView("poker/pokerCountList");
	}
	
	//绑定poker
	public void pokerBind(HttpServletRequest request, HttpServletResponse response) {
		
		//获取当前登录用户user_id
		String user_id = getCurrentUserId();
		//绑定账户信息
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//校验账户是否已绑定过
		int pokerCount = pokerBusinessService.checkPoker(name, user_id);
		if(pokerCount > 0) {
			try {
				//账号已绑定过
				response.getWriter().write("3");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		//参数
		String poker_id = UUID.randomUUID().toString();
		
		UserPoker userPoker = new UserPoker();
		userPoker.setName(name);
		userPoker.setPassword(password);
		userPoker.setUser_id(user_id);
		userPoker.setPoker_id(poker_id);
		userPoker.setBind_time(new Date());
		
		int ret = pokerBusinessService.pokerBind(userPoker);
		
		try {
			if(ret > 0) {
				//绑定成功
				response.getWriter().write("1");
			}else {
				//绑定失败
				response.getWriter().write("2");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//登录poker
	public ModelAndView pokerLogin(HttpServletRequest request, HttpServletResponse response) {
		
		
		return new ModelAndView("poker/pokerCountList");
	}
}
