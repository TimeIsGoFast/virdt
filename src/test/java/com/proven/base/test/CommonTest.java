package com.proven.base.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class CommonTest {

	@Test
	public void testCode(){
		Map<String,Integer> map = new HashMap<>();
		map.put("aaa",1);
		map.put("bbb", 2);
		map.put("ccc", 3);
		Iterator<String> it =  map.keySet().iterator();
		StringBuilder categore = new StringBuilder();
		StringBuilder datas = new StringBuilder();
		boolean isStart = true;
		while(it.hasNext()){
			String mapKey = it.next();
			if(isStart){
				categore.append(mapKey);
				datas.append(map.get(mapKey));
				isStart = false;
			}else{
				categore.append(","+mapKey);
				datas.append(","+map.get(mapKey));
			}
			
		}
		
		System.out.println(categore.toString());
		System.out.println(datas.toString());
	}
}
