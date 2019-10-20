package com.kimmy.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BaseController extends MultiActionController {
	
	public static String userId;
	/*public static TEUser userBean;*/
	
	/**
	 * 初始化
	 */
	/*protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(true));
		super.initBinder(request, binder);
	}*/

	/*public static void getSessionInfo() {
		HttpSession session = ContextHolderUtils.getSession();
		// 登录用户CustomerId
		if (session.getAttribute(Constant.SESSION_LOGIN_USER_ID) != null) {
			userId = (String) session.getAttribute(Constant.SESSION_LOGIN_USER_ID);
		}else{
			userId = "";
		}
		
		// 登录用户Bean
		if (session.getAttribute(Constant.SESSION_LOGIN_USER_BEAN) != null) {
			userBean = (TEUser) session.getAttribute(Constant.SESSION_LOGIN_USER_BEAN);
		}else{
			userBean = null;
		}
	}*/
}