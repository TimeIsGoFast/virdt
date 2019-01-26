package com.proven.quartz;

import java.util.List;

import com.proven.base.vo.DataParam;
import com.proven.business.model.SessionView;

public interface GetDataService {
	public int getUserData(DataParam param);
	
	public int getSessionData(DataParam param);
	
	public int updateSessionData();
	
	public int getDesktopGroups(DataParam param);
	
	public int getMachineData(DataParam param);

	public List<SessionView> getCurrentStatus();
}
