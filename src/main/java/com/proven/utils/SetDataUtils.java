package com.proven.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.proven.business.model.DeskUser;
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

	public static List<DeskUser> setDeskUserData(List<Map<String, String>> list) {
		List<DeskUser> userList = new ArrayList<>();
		
		for(Map<String,String> map:list){
			DeskUser deskUser = new DeskUser();
			deskUser.setCreatDate(DateFormatUtil.dealDateFormat(map.get("CreatedDate")));
			deskUser.setDomain(map.get("Domain"));
			deskUser.setFullName(map.get("FullName"));
			deskUser.setId(Integer.parseInt(map.get("Id")));
			deskUser.setModifiedDate(DateFormatUtil.dealDateFormat(map.get("ModifiedDate")));
			deskUser.setSid(map.get("Sid"));
			deskUser.setUpn(map.get("Upn"));
			deskUser.setUserName(map.get("UserName"));
			userList.add(deskUser);
		}
		return userList;
	}
}
