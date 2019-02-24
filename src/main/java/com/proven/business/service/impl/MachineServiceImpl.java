package com.proven.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.service.impl.BaseServiceImpl;
import com.proven.business.dao.MachineMapper;
import com.proven.business.model.Machine;
import com.proven.business.service.MachineService;

@Service
@Transactional
public class MachineServiceImpl extends BaseServiceImpl<Machine> implements MachineService{
	@Autowired
	private MachineMapper machineMapper;

	@Override
	public List<String> getAllIds() {
		return machineMapper.getAllIds();
	}

	@Override
	public List<String> selectByUpn(String upn) {
		return machineMapper.selectByUpn(upn);
	}

	@Override
	public void deleteAll() {
		machineMapper.deleteAll();
		
	}
	
	
}
