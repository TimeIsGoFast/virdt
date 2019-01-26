package com.proven.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.proven.business.model.DeskGroups;
import com.proven.business.model.DeskUser;
import com.proven.business.model.Machine;
import com.proven.business.model.Session;
import com.proven.business.model.SessionView;

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

	public static List<DeskGroups> setDeskGroupData(List<Map<String, String>> querylist) {
		List<DeskGroups> deskList = new ArrayList<>();
		
		for(Map<String,String> map:querylist){
			DeskGroups deskGroup = new DeskGroups();
			deskGroup.setCreateDate(DateFormatUtil.dealDateFormat(map.get("CreatedDate")));
			deskGroup.setDesktopKind(Integer.parseInt(map.get("DesktopKind")));
			deskGroup.setId(map.get("Id"));
			deskGroup.setIsRemotePc(CommonUtil.dealBoolean(map.get("IsRemotePC")));
			deskGroup.setLifeCycleState(Integer.parseInt(map.get("LifecycleState")));
			deskGroup.setModifiedDate(DateFormatUtil.dealDateFormat(map.get("ModifiedDate")));
			deskGroup.setName(map.get("Name"));
			deskGroup.setSessionSupport(Integer.parseInt(map.get("SessionSupport")));
			deskList.add(deskGroup);
		}
		return deskList;
	}
	/**
	 * set machine data
	 * @param querylist
	 * @return
	 */
	public static List<Machine> setMachineData(List<Map<String, String>> querylist) {
		List<Machine>  machineList = new ArrayList<>();
		for (Map<String,String> map:querylist) {
			Machine machine = new Machine();
			machine.setId(map.get("Id"));
			machine.setSid(map.get("Sid"));
			machine.setName(map.get("Name"));
			machine.setDnsName(map.get("DnsName"));
			machine.setLifecycleState(Integer.parseInt(map.get("LifecycleState")));
			machine.setIpAddress(map.get("IPAddress"));
			machine.setHostedMachineId(map.get("HostedMachineId"));
			machine.setHostingServerName(map.get("HostingServerName"));
			machine.setHostedMachineName(map.get("HostedMachineName"));
			machine.setIsAssigned(CommonUtil.dealBoolean(map.get("IsAssigned")));
			machine.setIsInMaintenanceMode(CommonUtil.dealBoolean(map.get("IsInMaintenanceMode")));
			machine.setIsPendingUpdate(CommonUtil.dealBoolean(map.get("IsPendingUpdate")));
			machine.setAgentVersion(map.get("AgentVersion"));
			machine.setAssociatedUserFullNames(map.get("AssociatedUserFullNames"));
			machine.setAssociatedUserNames(map.get("AssociatedUserNames"));
			machine.setAssociatedUserUpns(map.get("AssociatedUserUPNs"));
			machine.setCurrentRegistrationState(Integer.parseInt(map.get("CurrentRegistrationState")));
			machine.setRegistrationStateChangeDate(DateFormatUtil.dealDateFormat(map.get("RegistrationStateChangeDate")));
			machine.setLastDeregisteredDate(DateFormatUtil.dealDateFormat(map.get("LastDeregisteredDate")));
			machine.setLastDeregisteredCode(Integer.parseInt(map.get("LastDeregisteredCode")));
			machine.setCurrentPowerState(Integer.parseInt(map.get("CurrentPowerState")));
			machine.setCurrentSessionCount(Integer.parseInt(map.get("CurrentSessionCount")));
			machine.setControllerDnsName(map.get("ControllerDnsName"));
			machine.setPoweredOnDate(DateFormatUtil.dealDateFormat(map.get("PoweredOnDate")));
			machine.setPoweredStateChangeDate(DateFormatUtil.dealDateFormat(map.get("PowerStateChangeDate")));
			machine.setFunctionalLevel(Integer.parseInt(map.get("FunctionalLevel")));
			machine.setFailureDate(DateFormatUtil.dealDateFormat(map.get("FailureDate")));
			machine.setWindowsConnectionSetting(Integer.parseInt(map.get("WindowsConnectionSetting")));
			machine.setIsPreparing(CommonUtil.dealBoolean(map.get("IsPreparing")));
			machine.setFaultState(Integer.parseInt(map.get("FaultState")));
			machine.setOsType(map.get("OSType"));
			machine.setCurrentLoadIndexId(map.get("CurrentLoadIndexId"));
			machine.setCatalogId(map.get("CatalogId"));
			machine.setDesktopGroupId(map.get("DesktopGroupId"));
			machine.setHypervisorId(map.get("HypervisorId"));
			machine.setCreatedDate(DateFormatUtil.dealDateFormat(map.get("CreatedDate")));
			machine.setModifiedDate(DateFormatUtil.dealDateFormat(map.get("ModifiedDate")));
			machineList.add(machine);
		}
		return machineList;
	}
	
	/**
	 * 将session list 中的值transfer 到sessionView
	 * @param selist
	 * @return
	 */
	public static List<SessionView> transferSessionData(List<Session> selist) {
		List<SessionView> vlist = new ArrayList<>();
		
		for(Session session:selist){
			SessionView sv = new SessionView();
			sv.setConnectionState(session.getConnectionState());
			sv.setConnectionStateChangeDate(session.getConnectionStateChangeDate());
			sv.setSessionKey(session.getSessionKey());
			sv.setStartDate(session.getStartDate());
			sv.setLogonDuration(session.getLogonDuration());
			sv.setEndDate(session.getEndDate());
			sv.setExitCode(session.getExitCode());
			sv.setFailureDate(session.getFailureDate());
			sv.setLifeCycleState(session.getLifeCycleState());
			sv.setCurrentConnectionId(session.getCurrentConnectionId());
			sv.setUserId(session.getUserId());
			sv.setMachineId(session.getMachineId());
			sv.setCreatedDate(session.getCreatedDate());
			sv.setModifiedDate(session.getModifiedDate());
			vlist.add(sv);
		}
		return vlist;
	}
}
