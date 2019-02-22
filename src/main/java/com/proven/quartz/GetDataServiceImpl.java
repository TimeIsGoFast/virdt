package com.proven.quartz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.core4j.Enumerable;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.core.OEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.proven.base.vo.DataParam;
import com.proven.business.model.DeskGroups;
import com.proven.business.model.DeskUser;
import com.proven.business.model.Machine;
import com.proven.business.model.Session;
import com.proven.business.model.SessionView;
import com.proven.business.service.DeskGroupsService;
import com.proven.business.service.DeskUserService;
import com.proven.business.service.MachineService;
import com.proven.business.service.SessionService;
import com.proven.utils.DateFormatUtil;
import com.proven.utils.SetDataUtils;

@Service
@Transactional
public class GetDataServiceImpl extends AbstractGetData{
	public static final String SERVICE_URL = "http://192.168.20.9/Citrix/Monitor/OData/v1/Data";
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private DeskUserService deskUserService;
	
	@Autowired
	private DeskGroupsService deskGroupsService;
	
	@Autowired
	private MachineService machineService;
	
	private static final Logger logger = Logger.getLogger(GetDataServiceImpl.class);
	/**
	 * 获取用户的信息并存储到数据库中
	 */
	@Override
	public int getUserData(DataParam param) {
		ODataConsumer consumer = ODataConsumer.create(SERVICE_URL);
		String entitySetName = "Users";
		Enumerable<OEntity> qList = consumer.getEntities(entitySetName).execute();
	    List<Map<String,String>> list = getDataMap(qList);
	    List<Integer> idList = deskUserService.getIds();
	    try{
	    	List<DeskUser> userlist = SetDataUtils.setDeskUserData(list);
	    	for (DeskUser user : userlist) {
	    		if(!idList.contains(user.getId())){
	    			deskUserService.save(user);
	    		}else{
	    			deskUserService.update(user);
	    		}
	    		
			}
	    	
	    }catch(Exception e){
	    	logger.error("getUserData error:"+e.getMessage());
	    	return 0;
	    }
	    return 1;
		
	}

	/**
	 * 获取session的数据并且存到数据库中
	 */
	@Override
	public int getSessionData(DataParam param){
		ODataConsumer consumer = ODataConsumer.create(SERVICE_URL);
		String entitySetName = "Sessions";
		StringBuilder strbui = new StringBuilder("StartDate ge DateTime");
		//得到passtime 所对应的时间date
		if(StringUtils.isEmpty(param.getPassTime())){
			param.setPassTime("1y");
		}
		String date = DateFormatUtil.getDifferTime(param.getPassTime());
		//调用api 得到新的数据插入到数据苦衷	
	    try{
	    	strbui.append(DateFormatUtil.getCurrentTime(DateFormatUtil.parseDate(date)));
			Enumerable<OEntity> qList;
			qList = consumer.getEntities(entitySetName).filter(strbui.toString()).orderBy("StartDate desc").execute();    
		    List<Map<String,String>> list = getDataMap(qList);
	    	//通过这个date去数据库中删除date 之后的数据
		    sessionService.deleteByLastDate(date);
	    	List<Session> selist = SetDataUtils.setSessionData(list);
	    	for (Session session : selist) {
	    		session.setTimeDiff(DateFormatUtil.getTimeDiff(session.getStartDate(),session.getEndDate()) );
	    		sessionService.save(session);
			}
	    	
	    }catch(Exception e){
	    	logger.error("getSessionData error:"+e.getMessage());
	    	return 0;
	    }
	    return 1;
	
	}
	/**
	 * 更新session 的数据
	 * 
	 */
	@Override
	public int updateSessionData() {
		List<String> list = sessionService.getEndDateIsnull();
		ODataConsumer consumer = ODataConsumer.create(SERVICE_URL);
		String entitySetName = "Sessions";
		List<Map<String,String>> querylist = new ArrayList<>();
		List<Session> selist = new ArrayList<>();
		Enumerable<OEntity> qList = null;
		try {
			for (String string : list) {
				qList =  consumer.getEntities(entitySetName).filter("SessionKey eq GUID'"+string+"'").execute();

				if(qList!=null){
					querylist = getDataMap(qList);
					selist = SetDataUtils.setSessionData(querylist);
					for (Session session : selist) {
						sessionService.deleteBySessionKey(session.getSessionKey());
			    		sessionService.update(session);
					}
				}
			}
		} catch (Exception e) {
			logger.error("getSessionData error:"+e.getMessage());
	    	return 0;
		}
	
		return 1;
	}
	/**set desktopGroups
	 * getDesktopGroups
	 */
	@Override
	public int getDesktopGroups(DataParam param) {
		 
		ODataConsumer consumer = ODataConsumer.create(SERVICE_URL);
		String entitySetName = "DesktopGroups";
		List<Map<String,String>> querylist = new ArrayList<>();
		List<DeskGroups> dlist = deskGroupsService.selectAll();
		try {
			Enumerable<OEntity> qList  =  consumer.getEntities(entitySetName).execute();
			querylist = getDataMap(qList);
			List<DeskGroups> selist  = SetDataUtils.setDeskGroupData(querylist);
			if(dlist.isEmpty()){
				for (DeskGroups deskGroups : selist) {
					deskGroupsService.save(deskGroups);
				}
			}else{
				for (DeskGroups deskGroups : selist) {
					DeskGroups li = dlist.stream().filter(t->t.getId().equals(deskGroups.getId()))
							.collect(Collectors.toList()).get(0);
					if(li==null){
						deskGroupsService.save(deskGroups);
					}else{
						deskGroupsService.update(deskGroups);
					}
				}
			}
			
		} catch (Exception e) {
			logger.error("getSessionData error:"+e.getMessage());
	    	return 0;
		}
		return 1;
	}
	/**
	 * get machine data
	 */
	@Override
	public int getMachineData(DataParam param) {
		ODataConsumer consumer = ODataConsumer.create(SERVICE_URL);
		String entitySetName = "Machines";
		List<Map<String,String>> querylist = new ArrayList<>();
		try {
			List<String> ids = machineService.getAllIds();
			Enumerable<OEntity> qList  =  consumer.getEntities(entitySetName).execute();
			querylist = getDataMap(qList);
			List<Machine> melist  = SetDataUtils.setMachineData(querylist);
			for (Machine machine : melist) {
				if(ids.contains(machine.getId())){
					machineService.update(machine);
				}else{
					machineService.save(machine);
				}				
			}
		} catch (Exception e) {
			logger.error("getSessionData error:"+e.getMessage());
	    	return 0;
		}
		
		return 1;
	}
	/**
	 * 得到实时的session 数据
	 */
	@Override
	public List<SessionView> getCurrentStatus() {
		//EndDate eq null
		ODataConsumer consumer = ODataConsumer.create(SERVICE_URL);	
		String entitySetName = "Sessions";
		List<SessionView> list = new ArrayList<>();
		try{
			Enumerable<OEntity> qList = consumer.getEntities(entitySetName).filter("EndDate eq null").orderBy("StartDate desc").execute(); 
			List<Map<String,String>> querylist = getDataMap(qList);
			List<Session>  selist = SetDataUtils.setSessionData(querylist);
			//将start date 增加8个小时
			selist.stream().forEach(Session->Session.setStartDate(DateFormatUtil.addEightHour(Session.getStartDate())));
			//将session的值set到sessionView中
			list = SetDataUtils.transferSessionData(selist);
			//将user name,machine name,computer name 设置到list中
			List<Integer> countList = new ArrayList<>();
			int count=0;
			for(SessionView sview : list){
				if(!StringUtils.isEmpty(sview.getFailureDate())){
					countList.add(count);
					continue;
				}
				DeskUser user = deskUserService.selectByKey(sview.getUserId());
				Machine machine = machineService.selectByKey(sview.getMachineId());
				DeskGroups deskgroups = deskGroupsService.selectByKey(machine.getDesktopGroupId());
				//这里有个bug,以后修改，当user,machine,deskGroups 为null,现在直接把这条数据给清除掉了，按理应该先去更新一下user,machine,deskgroups的数据。
				if(user==null||machine==null){
					countList.add(count);
					continue;
				}else{
					sview.setUserName(user.getUserName());
					sview.setFullName(user.getFullName());
					sview.setMachineName(machine.getName());
					sview.setDesktopGroupId(machine.getDesktopGroupId());
				}
				
				if(deskgroups==null){
					countList.add(count);
					continue;
				}else{
					sview.setComputerName(deskgroups.getName());
				}
				sview.setTimeDiff(DateFormatUtil.getTimeDiff(sview.getStartDate(), new Date()));
				count++;
			}
			
			
		}catch(Exception e){
			logger.error("getCurrentStatus error:"+e.getMessage());
		}
		return list;
	}
	
		
}
