package com.treasure.dao.service;

import java.util.List;

import com.treasure.dao.po.User;
import com.treasure.dao.po.UserPoker;

public interface PokerService {

	List<UserPoker> getPokerList(User user);

	int pokerBind(UserPoker userPoker);

	int checkPoker(UserPoker userPoker);

}
