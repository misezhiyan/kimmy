package com.treasure.business.service.impl;

import java.util.List;

import com.treasure.business.service.PokerBusinessService;
import com.treasure.dao.po.User;
import com.treasure.dao.po.UserPoker;
import com.treasure.dao.service.PokerService;

/**
 * @Title: SignInController
 * @Description: 绑定并展示poker账号信息功能
 * @author Barry
 * @date 2016-09-07
 */
public class PokerBusinessServiceImpl implements PokerBusinessService {

	private PokerService pokerService;

	public void setPokerService(PokerService pokerService) {
		this.pokerService = pokerService;
	}

	/*************************** 业务功能区	 *****************************************************/
	
	@Override
	public List<UserPoker> getPokerList(User user) {
		
		return pokerService.getPokerList(user);
	}

	@Override
	public int pokerBind(UserPoker userPoker) {
		
		return pokerService.pokerBind(userPoker);
	}

	@Override
	public int checkPoker(String name, String user_id) {
		
		UserPoker userPoker = new UserPoker();
		userPoker.setName(name);
		userPoker.setUser_id(user_id);
		
		return pokerService.checkPoker(userPoker);
	}



}
