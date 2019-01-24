package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.SessionViewMapper;
import com.proven.business.model.SessionView;
import com.proven.business.service.SessionViewService;

@Service
@Transactional
public class SessionViewServiceImpl extends BaseServiceImpl<SessionView> implements SessionViewService{
	
	@Autowired
	private SessionViewMapper sessionViewMapper;
	
	@Override
	public List<SessionView> selectAllOrderByEndDate() {
		return	sessionViewMapper.selectAllOrderByEndDate();
	}

}
