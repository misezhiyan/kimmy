package com.treasure.dao.service.impl;

import java.util.List;

import com.treasure.dao.QueryDao;
import com.treasure.dao.UpdateDao;
import com.treasure.dao.po.User;
import com.treasure.dao.po.UserPoker;
import com.treasure.dao.service.PokerService;

public class PokerServiceImpl implements PokerService {
	private QueryDao queryDao;
	private UpdateDao updateDao;

	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}

	public void setUpdateDao(UpdateDao updateDao) {
		this.updateDao = updateDao;
	}

	/****************************************************************************************************************************************************************/


	@Override
	public List<UserPoker> getPokerList(User user) {
		
		return (List<UserPoker>) queryDao.queryList("com.treasure.dao.po.mapper.UserPokerMapper.getPokerList", user);
	}

	@Override
	public int pokerBind(UserPoker userPoker) {
		
		return updateDao.insert("com.treasure.dao.po.mapper.UserPokerMapper.pokerBind", userPoker);
	}

	@Override
	public int checkPoker(UserPoker userPoker) {
		
		return (int) queryDao.queryOne("com.treasure.dao.po.mapper.UserPokerMapper.checkPoker", userPoker);
	}
	
}
