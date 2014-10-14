package com.tmpb.service;

import junit.framework.Assert;

import org.junit.Test;

import com.web.model.User;
import com.web.service.UserManager;
import com.web.service.impl.UserManagerImpl;

public class UserManagerTest {

	@Test
	public void testExists() throws Exception {
		UserManager userManager=new UserManagerImpl();
		User user=new User();
		user.setUsername("a");
		user.setPassword("a");
		boolean exists=userManager.exists(user);
		
		Assert.assertEquals(true, exists);
	}

	@Test
	public void testAdd() throws Exception {
		UserManagerImpl userManager=new UserManagerImpl();
		User user=new User();
		user.setUsername("b");
		user.setPassword("b");
		boolean exists=userManager.exists(user);
		if(!exists){
			userManager.add(user);
			user.setUsername("b");
			exists=userManager.exists(user);
			Assert.assertEquals(true, exists);
		}else {
			Assert.fail("not added");
		}
		
	}

}
