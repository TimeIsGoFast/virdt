package com.proven.business.service;

import java.util.List;

import com.proven.base.service.BaseService;
import com.proven.business.model.Machine;

public interface MachineService extends BaseService<Machine>{

	List<String> getAllIds();

}
