package com.proven.business.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.proven.base.service.BaseService;
import com.proven.base.vo.BarData;
import com.proven.business.model.SessionView;
import com.proven.parambean.SessionParam;
public interface SessionViewService extends BaseService<SessionView>{

	List<SessionView> selectAllOrderByEndDate();

	List<SessionView> selectByDeskgroupIdAndPassTime(String deskgroupId, String passTime);

	BarData refershBarData(String date);

	/**
	 * @param sessionParam   
	* @Title: getPageData  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param row
	* @param @param page
	* @param @param search
	* @param @return  
	* @return PageInfo<SessionView> 
	* @throws  
	*/
	PageInfo<SessionView> getPageData(int row, int page, String search, SessionParam sessionParam);

	/**  
	* @Title: getSessionDataByParam  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @return List<SessionView> 
	* @throws
	* Author:Zeng,weilong
	* @date 2019年4月22日
	*/
	List<SessionView> getSessionDataByParam(SessionParam sessionParam);

	
}
