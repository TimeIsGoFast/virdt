package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.SessionViewMapper;
import com.proven.business.model.SessionView;
import com.proven.business.service.SessionViewService;
import com.proven.utils.DateFormatUtil;

@Service
@Transactional
public class SessionViewServiceImpl extends BaseServiceImpl<SessionView> implements SessionViewService{
	
	private static final String DEFAULT_PASS_TIME = "24h";	
	private static final String DEFAULT_DESK_GROUP_ID = "all";
	@Autowired
	private SessionViewMapper sessionViewMapper;
	
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


}
