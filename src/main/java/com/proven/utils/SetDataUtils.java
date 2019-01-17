package com.proven.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.proven.business.model.Session;

public class SetDataUtils {
	
	/**
	 * setSessionData
	 * @param list
	 * @return
	 * @throws Exception 
	 */
	public static List<Session> setSessionData( List<Map<String,String>> list) throws Exception{
		
		List<Session> sessionList = new ArrayList<>();
		for(Map<String,String> map:list){
			Session se = new Session();
			se.setConnectionState(map.get("ConnectionState"));
			se.setConnectionStateChangeDate(DateFormatUtil.dealDateFormat(map.get("ConnectionStateChangeDate")));
			se.setSessionKey(map.get("SessionKey"));
			se.setStartDate(DateFormatUtil.dealDateFormat(map.get("StartDate")));
			se.setLogonDuration(Integer.parseInt(map.get("LogOnDuration")));
			se.setEndDate(DateFormatUtil.dealDateFormat(map.get("EndDate")));
			se.setExitCode(map.get("ExitCode"));
			se.setFailureDate(DateFormatUtil.dealDateFormat(map.get("FailureDate")));
			se.setLifeCycleState(map.get("LifecycleState"));
			se.setCurrentConnectionId(Integer.parseInt(map.get("CurrentConnectionId")));
			se.setUserId(Integer.parseInt(map.get("UserId")));
			se.setMachineId(map.get("MachineId"));
			se.setCreatedDate(DateFormatUtil.dealDateFormat(map.get("CreatedDate")));
			se.setModifiedDate(DateFormatUtil.dealDateFormat(map.get("ModifiedDate")));
			sessionList.add(se);
		}
		
		return sessionList;
	}
}
