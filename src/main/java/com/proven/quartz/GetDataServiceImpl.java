package com.proven.quartz;

import java.util.List;
import java.util.Map;

import org.core4j.Enumerable;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.core.OEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.vo.DataParam;
import com.proven.business.model.Session;
import com.proven.business.service.SessionService;
import com.proven.utils.SetDataUtils;

@Service
@Transactional
public class GetDataServiceImpl extends AbstractGetData{
	@Autowired
	private SessionService sessionService;
	
	private static final Logger logger = LoggerFactory.getLogger(GetDataServiceImpl.class);
	@Override
	public void getUserData(DataParam param) {
		String serviceUrl = "http://192.168.20.9/Citrix/Monitor/OData/v1/Data";
		ODataConsumer consumer = ODataConsumer.create(serviceUrl);
		String entitySetName = "Users";
		Enumerable<OEntity> qList = consumer.getEntities(entitySetName).execute();
	    List<Map<String,String>> list = getDataMap(qList);
	    
	    
		
	}

	@Override
	public void getSessionData(DataParam param){
		String serviceUrl = "http://192.168.20.9/Citrix/Monitor/OData/v1/Data";
		ODataConsumer consumer = ODataConsumer.create(serviceUrl);
		String entitySetName = "Sessions";
		Enumerable<OEntity> qList = consumer.getEntities(entitySetName).execute();
	    List<Map<String,String>> list = getDataMap(qList);
	    try{
	    	List<Session> selist = SetDataUtils.setSessionData(list);
	    	for (Session session : selist) {
	    		sessionService.save(session);
			}
	    	
	    }catch(Exception e){
	    	logger.error("getSessionData error:"+e);
	    }
	
	}
	
		
}
