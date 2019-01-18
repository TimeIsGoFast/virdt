package com.proven.business.service;

import java.util.List;

import com.proven.base.service.BaseService;
import com.proven.business.model.DeskUser;

public interface DeskUserService extends BaseService<DeskUser>{

	List<Integer> getIds();

}
