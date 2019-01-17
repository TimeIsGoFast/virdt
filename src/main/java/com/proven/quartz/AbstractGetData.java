package com.proven.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.core4j.Enumerable;
import org.odata4j.core.OEntity;

public abstract class AbstractGetData implements GetDataService{
	
	public static final Logger loger = Logger.getLogger(AbstractGetData.class);
	public static List<Map<String,String>> getDataMap(Enumerable<OEntity> qList) {
		List<Map<String,String>> list = new ArrayList<>();
		try {
			for (OEntity oEntity : qList) {
				int count = oEntity.getProperties().size();
				Map<String,String> map = new HashMap<>();
				for(int i=0;i<count;i++){
					map.put(oEntity.getProperties().get(i).getName(), oEntity.getProperties().get(i).getName());
				}
			}
		} catch (Exception e) {
			loger.error("getDataMap error "+e);
		}
	

		return list;
	}
}
