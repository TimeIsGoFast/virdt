package com.proven.quartz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.core4j.Enumerable;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.core.OEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.vo.DataParam;
import com.proven.business.model.DeskGroups;
import com.proven.business.model.DeskUser;
import com.proven.business.model.Machine;
import com.proven.business.model.Session;
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
	
	private static final Logger logger = LoggerFactory.getLogger(GetDataServiceImpl.class);
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

	@Override
	public int getSessionData(DataParam param){
		ODataConsumer consumer = ODataConsumer.create(SERVICE_URL);
		String entitySetName = "Sessions";
		StringBuilder strbui = new StringBuilder("StartDate ge DateTime");
		strbui.append(DateFormatUtil.getCurrentTime());
		Enumerable<OEntity> qList;
		if(param.isFreashAll()){
			qList = consumer.getEntities(entitySetName).orderBy("StartDate desc").execute();
		}else{
			qList = consumer.getEntities(entitySetName).filter(strbui.toString()).orderBy("StartDate desc").execute();    
		}
	    List<Map<String,String>> list = getDataMap(qList);
	    try{
	    	List<Session> selist = SetDataUtils.setSessionData(list);
	    	for (Session session : selist) {
	    		sessionService.save(session);
			}
	    	
	    }catch(Exception e){
	    	logger.error("getSessionData error:"+e.getMessage());
	    	return 0;
	    }
	    return 1;
	
	}

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
	
		
}
