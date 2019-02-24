package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.DeskUserMapper;
import com.proven.business.model.DeskUser;
import com.proven.business.service.DeskUserService;

@Service
@Transactional
public class DeskUserServiceImpl extends BaseServiceImpl<DeskUser> implements DeskUserService{

	@Autowired
	private DeskUserMapper deskUserMapper;
	@Override
	public List<Integer> getIds() {
		return deskUserMapper.getIds();
	}
	@Override
	public void deleteAll() {
		deskUserMapper.deleteAll();
		
	}

}
