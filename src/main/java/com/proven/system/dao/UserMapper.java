package com.proven.system.dao;

import org.apache.ibatis.annotations.Param;

import com.proven.system.model.User;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

	/**   
	* @Function: UserMapper.java
	* @Description:
	*
	* @param:
	* @return：
	* @throws：
	*
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018年9月21日 下午10:42:18 
	*
	* History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年9月21日     Administrator           v1.0.0              
	*/
	User getUserByUid(@Param(value="uid")String uid);
}