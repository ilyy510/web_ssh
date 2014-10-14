package com.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;
import org.springframework.stereotype.Component;

import com.web.dao.UserDao;
import com.web.dao.impl.UserDaoImpl;
import com.web.model.User;
import com.web.service.UserManager;
@Component(value="userManager")
public class UserManagerImpl implements UserManager {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	@Resource(name="userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	@Override
	public boolean exists(User user) throws Exception {

		return userDao.checkUserExistsWithName(user.getUsername());
	}

	
	@Override
	public void add(User user) throws Exception {

		userDao.save(user);

	}

	@Override
	public List<User> getUsers() {
	return userDao.getUsers();
		
	}
	
	
}
