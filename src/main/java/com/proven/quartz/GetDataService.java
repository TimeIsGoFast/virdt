package com.proven.quartz;

import com.proven.base.vo.DataParam;

public interface GetDataService {
	public int getUserData(DataParam param);
	
	public int getSessionData(DataParam param);
	
	public int updateSessionData();
	
	public int getDesktopGroups(DataParam param);
	
	public int getMachineData(DataParam param);
}
