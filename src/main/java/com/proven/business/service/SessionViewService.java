package com.proven.business.service;

import java.util.List;

import com.proven.base.service.BaseService;
import com.proven.base.vo.BarData;
import com.proven.business.model.SessionView;
public interface SessionViewService extends BaseService<SessionView>{

	List<SessionView> selectAllOrderByEndDate();

	List<SessionView> selectByDeskgroupIdAndPassTime(String deskgroupId, String passTime);

	BarData refershBarData(String date);

	
}
