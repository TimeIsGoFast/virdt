/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.proven.system.controller 
 * @author: Administrator   
 * @date: 2018年9月21日 下午10:22:16 
 */
package com.proven.system.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proven.base.controller.BaseController;
import com.proven.system.model.User;
import com.proven.system.service.UserService;

/**   
* Copyright: Copyright (c) 2018 Weilong Zeng
* 
* @ClassName: UserController.java
* @Description: 
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年9月21日 下午10:22:16 
*
*/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User>{
	@Autowired
	private UserService userService;
	
    private static final Logger logger  = Logger.getLogger(UserController.class);
    		
	@RequestMapping("/register")
	@ResponseBody
	public int register(User user){
		logger.info("username="+user.getUid()+" ,password"+user.getPassword()+" ,fullname"+user.getName()+" ,deskUserId"+user.getDeskUserId());
		//TODO
		//judge user is exist in database
		User dbuser = userService.getUserByUid(user.getUid());
		if(dbuser!=null){
			//register
			
		}else{
			return 0;
		}
		return 1;
	}
}
