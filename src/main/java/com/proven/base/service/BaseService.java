/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.proven.base.service 
 * @author: Administrator   
 * @date: 2018年9月19日 下午8:10:48 
 */
package com.proven.base.service;

import java.util.List;

/**   
* Copyright: Copyright (c) 2018 Weilong Zeng
* 
* @ClassName: BaseService.java
* @Description: 
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年9月19日 下午8:10:48 
*
*/
public interface BaseService<T> {
	//select T by key
	T selectByKey(Object key);
    List<T>  selectAll();
	int save(T entity);

	int delete(Object key);

	int update(T entity);

	int updateNotNull(T entity);

	List<T> selectByExample(Object example);
	
}
