package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	/**
	* <p>Title: selectUserData</p>  
	* <p>Description: </p>  
	* @return  
	* @see com.proven.business.service.DeskUserService#selectUserData()  
	*/  
	@Override
	public List<DeskUser> selectUserData() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	* <p>Title: getPage</p>  
	* <p>Description: </p>  
	* @param row
	* @param page
	* @return  
	* @see com.proven.business.service.DeskUserService#getPage(int, int)  
	*/  
	@Override
	public PageInfo<DeskUser> getPage(int row, int page) {
		PageHelper.startPage(page, row);
		List<DeskUser> list = deskUserMapper.selectAll();
		return  new PageInfo<DeskUser>(list);
	}

}
