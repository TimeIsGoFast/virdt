package com.proven.base.vo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VirdtContext {
	
	public static final VirdtContext instance = new VirdtContext();
	private static volatile Map<String,Object> properties = new ConcurrentHashMap<>();
	private VirdtContext(){
		
	}
	public static VirdtContext getInstance(){
		return instance;
	}
	
	public void setProperty(String key,Object value){
		properties.put(key, value);
	}
	
	public Object getProperty(String key){
		return properties.get(key);
	}
}
