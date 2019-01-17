package com.proven.base.test;

import org.junit.Test;

import com.proven.base.vo.DataParam;
import com.proven.quartz.GetDataServiceImpl;

public class ODataTest {
	@Test
	public void TestGetUserData(){
		GetDataServiceImpl getdataService = new GetDataServiceImpl();
		getdataService.getUserData(new DataParam());
		
	}
}
