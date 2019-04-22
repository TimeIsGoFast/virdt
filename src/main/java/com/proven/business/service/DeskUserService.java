package com.proven.business.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.proven.base.service.BaseService;
import com.proven.business.model.DeskUser;

public interface DeskUserService extends BaseService<DeskUser>{

	List<Integer> getIds();

	void deleteAll();

	/**  
	* @Title: selectUserData  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @return  
	* @return List<DeskUser> 
	* @throws  
	*/
	List<DeskUser> selectUserData();

	/**  
	* @Title: getPage  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param row
	* @param @param page
	* @param @return  
	* @return PageInfo<DeskUser> 
	* @throws  
	*/
	PageInfo<DeskUser> getPage(int row, int page);

}
