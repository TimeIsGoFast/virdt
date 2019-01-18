package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.SessionMapper;
import com.proven.business.model.Session;
import com.proven.business.service.SessionService;

@Service
@Transactional
public class SessionServiceImpl extends BaseServiceImpl<Session> implements SessionService{
	@Autowired
	private SessionMapper sessionMapper;
	
	@Override
	public List<String> getEndDateIsnull() {
		return sessionMapper.getEndDateIsnull();
	}

	@Override
	public void deleteBySessionKey(String sessionKey) {
		 sessionMapper.deleteBySessionKey(sessionKey);
		
	}

}
