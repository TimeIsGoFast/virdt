/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.proven.system.service.impl 
 * @author: Administrator   
 * @date: 2018年9月21日 下午10:21:30 
 */
package com.proven.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.system.dao.UserMapper;
import com.proven.system.model.User;
import com.proven.system.service.UserService;

/**   
* Copyright: Copyright (c) 2018 Weilong Zeng
* 
* @ClassName: UserServiceImpl.java
* @Description: 
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年9月21日 下午10:21:30 
*
*/
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByUid(String uid) {
		return userMapper.getUserByUid(uid);
	}
}
