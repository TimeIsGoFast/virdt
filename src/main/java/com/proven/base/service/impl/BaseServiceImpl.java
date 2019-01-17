/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.proven.base.service.impl 
 * @author: Administrator   
 * @date: 2018年9月19日 下午8:11:25 
 */
package com.proven.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proven.base.service.BaseService;

import tk.mybatis.mapper.common.Mapper;

/**   
* Copyright: Copyright (c) 2018 Weilong Zeng
* 
* @ClassName: BaseServiceImpl.java
* @Description: 
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年9月19日 下午8:11:25 
*
*/
public  class BaseServiceImpl<T> implements BaseService<T>{
	
	@Autowired
	protected Mapper<T> mapper;
	@Override
	public T selectByKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public List<T> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public int save(T entity) {
		return mapper.insert(entity);
	}

	@Override
	public int delete(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int update(T entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	@Override
	public int updateNotNull(T entity) {
		 return mapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public List<T> selectByExample(Object example) {
		 return mapper.selectByExample(example);
	}

}
