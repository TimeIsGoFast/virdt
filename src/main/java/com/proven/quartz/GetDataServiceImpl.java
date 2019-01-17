package com.proven.quartz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.core4j.Enumerable;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.core.OEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proven.base.vo.DataParam;
import com.proven.business.model.Session;

@Service
@Transactional
public class GetDataServiceImpl extends AbstractGetData{
	@Override
	public void getUserData(DataParam param) {
		String serviceUrl = "http://192.168.20.9/Citrix/Monitor/OData/v1/Data";
		ODataConsumer consumer = ODataConsumer.create(serviceUrl);
		String entitySetName = "Users";
		Enumerable<OEntity> qList = consumer.getEntities(entitySetName).execute();
	    List<Map<String,String>> list = getDataMap(qList);
		
	}

	@Override
	public void getSessionData(DataParam param) {
		String serviceUrl = "http://192.168.20.9/Citrix/Monitor/OData/v1/Data";
		ODataConsumer consumer = ODataConsumer.create(serviceUrl);
		String entitySetName = "Sessions";
		Enumerable<OEntity> qList = consumer.getEntities(entitySetName).execute();
	    List<Map<String,String>> list = getDataMap(qList);
	    List<Session> sessionList = new ArrayList<>();
		for(Map<String,String> map:list){
			Session se = new Session();
			se.setConnectionState(map.get("ConnectionState"));
			
		}
	}
	
		
}
