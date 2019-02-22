package com.proven.business.service;

import java.util.List;

import com.proven.base.service.BaseService;
import com.proven.business.model.Session;

public interface SessionService extends BaseService<Session>{

	List<String> getEndDateIsnull();

	void deleteBySessionKey(String sessionKey);

	void deleteByLastDate(String date);

}
