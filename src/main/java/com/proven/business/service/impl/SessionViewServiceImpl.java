package com.proven.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.base.vo.BarData;
import com.proven.business.dao.SessionViewMapper;
import com.proven.business.model.SessionView;
import com.proven.business.service.SessionViewService;
import com.proven.parambean.SessionParam;
import com.proven.quartz.GetDataService;
import com.proven.utils.DateFormatUtil;

@Service
@Transactional
public class SessionViewServiceImpl extends BaseServiceImpl<SessionView> implements SessionViewService{
	
	private static final Logger logger = Logger.getLogger(SessionViewServiceImpl.class);
	private static final String DEFAULT_PASS_TIME = "7d";	
	private static final String DEFAULT_DESK_GROUP_ID = "all";
	@Autowired
	private SessionViewMapper sessionViewMapper;
	
	@Autowired
	private GetDataService getDataService;
	@Override
	public List<SessionView> selectAllOrderByEndDate() {
		return	sessionViewMapper.selectAllOrderByEndDate();
	}

	@Override
	public List<SessionView> selectByDeskgroupIdAndPassTime(String deskgroupId, String passTime) {
		String orderDate ;
		if(StringUtils.isEmpty(passTime)){
			orderDate = DateFormatUtil.getDifferTime(DEFAULT_PASS_TIME);
		}else{
			orderDate = DateFormatUtil.getDifferTime(passTime);
		}
		if(DEFAULT_DESK_GROUP_ID.equalsIgnoreCase(deskgroupId)||StringUtils.isEmpty(deskgroupId)){
			return sessionViewMapper.selectByPassTime(orderDate);
		}else{
			return sessionViewMapper.selectByDeskgroupIdAndPassTime(deskgroupId,orderDate);
		}
	}
    
	/**
	 * 通过date 从seesionview 中得到当天的数据并且将返回数据
	 */
	@Override
	public BarData refershBarData(String date) {
		//判断date 是否是当前日期，如果是的话，从api中将数据load过来，如果不是的话，从数据库中load数据
		List<SessionView> sList = new ArrayList<>();
		String startDate = date+" 00:00:00";
		String endDate;
		try{
			if(DateFormatUtil.isCurrentDay(date)){
				StringBuilder strbui = new StringBuilder("StartDate ge DateTime");
				strbui.append(DateFormatUtil.getCurrentTime(DateFormatUtil.parseDate(startDate)));
				String filter = strbui.toString();
				logger.info("filter = "+filter);
				sList = getDataService.getCurrentStatus(filter);
			}else{
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				endDate = DateFormatUtil.getStringDate(Calendar.DATE, -1,format.parse(startDate));
				sList = sessionViewMapper.getDataByCurrentDay(startDate,endDate);	
			}
		}catch (Exception e){
			logger.info(e.getMessage());
		}
		//load 完数据之后要进行数据处理，处理得到用户名，和该用户所使用的时间
		//如果同一个用户今天使用时间有两次，则将这个用户的实际使用时间进行相加
		return getMapByNameAndTime(sList);
	}

	/**
	 * 处理得到用户名，和该用户所使用的时间
	 * @param sList
	 * @return
	 */
	private BarData getMapByNameAndTime(List<SessionView> sList) {
		Map<String,Integer> map =new HashMap<>();
		//将list 中的数据遍历到map里
		String key="";
		Integer value = 0;
		for(SessionView sessionView : sList){
			//当fullName 为null的时候，默认取username
			if(StringUtils.isEmpty(sessionView.getFullName())){
				key = sessionView.getUserName();
				//当该用户有两条数据的时候，直接相加
				value = getValue(map,sessionView,key,value);
				
			}else{
				key = sessionView.getFullName();
				value = getValue(map,sessionView,key,value);
			}
			map.put(key, value);
		}
		//遍历该map 组装成BarData 的数据返回到前端
		Iterator<String> it =  map.keySet().iterator();
		StringBuilder categore = new StringBuilder();
		StringBuilder datas = new StringBuilder();
		boolean isStart = true;
		while(it.hasNext()){
			String mapKey = it.next();
			if(isStart){
				categore.append(mapKey);
				datas.append(map.get(mapKey));
				isStart = false;
			}else{
				categore.append(","+mapKey);
				datas.append(","+map.get(mapKey));
			}
			
		}
		logger.info("categore="+categore.toString());
		logger.info("datas="+datas.toString());
		
		return new BarData(categore.toString(),datas.toString());
	}
	
	private static Integer getValue(Map<String,Integer> map,SessionView sessionView,String key,Integer value){
		if(StringUtils.isEmpty(map.get(key))){
			//当time 为null 的时候说明这台机器还在用，默认给他24小时
			value = DateFormatUtil.calculatorTime(sessionView.getTimeDiff());
		}else{
			Integer time = map.get(key);
			value = time+DateFormatUtil.calculatorTime(sessionView.getTimeDiff());
		}
		return value;
	}

	/**
	* <p>Title: getPageData</p>  
	* <p>Description: </p>  
	* @param row
	* @param page
	* @param search
	* @return  
	* @see com.proven.business.service.SessionViewService#getPageData(int, int, java.lang.String)  
	*/  
	@Override
	public PageInfo<SessionView> getPageData(int row, int page, String search,SessionParam sessionParam) {
		String orderDate = getOrderDate(sessionParam);
		
		logger.info("getPageData method getDeskgroupId"+sessionParam.getDeskgroupId());
		PageHelper.startPage(page, row);
		List<SessionView> sessionList = sessionViewMapper.selectByDeskgroupIdAndPassTime(sessionParam.getDeskgroupId(),orderDate);
		return new PageInfo<SessionView>(sessionList);
	}

	/**
	* <p>Title: getSessionDataByParam</p>  
	* <p>Description: </p>  
	* @param sessionParam
	* @return  
	* @see com.proven.business.service.SessionViewService#getSessionDataByParam(com.proven.parambean.SessionParam)  
	*/  
	@Override
	public List<SessionView> getSessionDataByParam(SessionParam sessionParam) {
		String orderDate = getOrderDate(sessionParam);
		return sessionViewMapper.selectByDeskgroupIdAndPassTime(sessionParam.getDeskgroupId(),orderDate);
	}

	
	private static String getOrderDate(SessionParam sessionParam){
		if(StringUtils.isEmpty(sessionParam.getPassTime())){
			return DateFormatUtil.getDifferTime(DEFAULT_PASS_TIME);
		}else{
			return DateFormatUtil.getDifferTime(sessionParam.getPassTime());
		}
		
	}
	

}
