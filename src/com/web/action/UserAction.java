package com.web.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.model.User;
import com.web.service.UserManager;
import com.web.vo.UserRegisterInfo;
@Component("u")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven {
	
	
	private UserRegisterInfo userRegisterInfo=new UserRegisterInfo();
	private UserManager userManager ;
	
	@Resource(name="userManager")
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	private List<User>users;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		user.setUsername(userRegisterInfo.getUsername());
		user.setPassword(userRegisterInfo.getPassword());
		if(userManager.exists(user)){
			return "fail";
		}
		userManager.add(user);
		return "success";
	}
	
	//list()
	public String list() {
			users = userManager.getUsers();
			return "list";
		}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userRegisterInfo;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}

	public UserRegisterInfo getUserRegisterInfo() {
		return userRegisterInfo;
	}
	public List<User> getUsers() {
		return users;
	}
	
	public void setUserRegisterInfo(UserRegisterInfo userRegisterInfo) {
		this.userRegisterInfo = userRegisterInfo;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
