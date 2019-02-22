/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.proven.base.test 
 * @author: Administrator   
 * @date: 2018年9月18日 下午9:56:30 
 */
package com.proven.base.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.proven.base.vo.DataParam;
import com.proven.business.model.SessionView;
import com.proven.business.service.SessionService;
import com.proven.quartz.GetDataService;
import com.proven.system.model.User;
import com.proven.system.service.UserService;


/**   
* Copyright: Copyright (c) 2018 Weilong Zeng
* 
* @ClassName: SpringTest.java
* @Description: 
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年9月18日 下午9:56:30 
*
*/
@ContextConfiguration(locations = { "classpath:application.xml" })

@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest extends AbstractJUnit4SpringContextTests{
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private GetDataService GetDataService;
	
	
	@Test
	public void TestGetUser(){
		List<User> users =  userService.selectAll();
		users.forEach(user->System.err.println(user.toString()));
	}
	
	@Test
	public void TestGetUserData(){
		GetDataService.getUserData(new DataParam());
		
	}
	
	@Test
	public void testGetEndDateIsNull(){
		List<String> list = sessionService.getEndDateIsnull();
		for (String string : list) {
			System.out.println(string);
		}
		
	}
	@Test
	public void testupdateSessionData(){
		DataParam param = new DataParam();
		param.setPassTime("1y");
		GetDataService.getSessionData(param);
	}
	
	@Test
	public void testDeleteSessionBySessionKey(){
		sessionService.deleteBySessionKey("aaa");
	}
	
	@Test
	public void testGetDesktopGroups(){
		GetDataService.getDesktopGroups(null);
	}
	
	@Test
	public void testGetMachineData(){
		GetDataService.getMachineData(null);
	}
	
	/*@Test
	public void testDeskUserCacheService(){
		logger.debug("first time from db!");
		deskuserService.getDeskUserById(1);
		
		logger.debug("second time data from cache!");
		deskuserService.getDeskUserById(1);
	}*/
	
	@Test
	public void testGetCurrentStatus(){
		List<SessionView> sessionList = GetDataService.getCurrentStatus();
		for (SessionView sessionView : sessionList) {
			logger.info(sessionView.getComputerName()+sessionView.getFullName()+sessionView.getTimeDiff());
			
		}
	}

	
}
