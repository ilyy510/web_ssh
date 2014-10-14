package com.web.action;

import static org.junit.Assert.assertEquals;

import org.jboss.weld.context.ApplicationContext;
import org.junit.Test;

import com.web.vo.UserRegisterInfo;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction ua=new UserAction();
		UserRegisterInfo userRegisterInfo=new UserRegisterInfo();
		userRegisterInfo.setUsername("x");
		userRegisterInfo.setPassword("x");
		userRegisterInfo.setPassword2("x");
		ua.setUserRegisterInfo(userRegisterInfo);
		String ret=ua.execute();
		assertEquals("success",ret);
		
	}
	public void listTest(){
		
	}

}
