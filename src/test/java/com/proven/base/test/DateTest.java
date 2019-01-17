package com.proven.base.test;

import java.util.Date;

import org.junit.Test;

import com.proven.utils.DateFormatUtil;

public class DateTest {
	@Test
	public void testDateFormatter(){
		String time = "2018-11-07T07:32:41.963";
		try {
			Date date = DateFormatUtil.dealDateFormat(time);
			
			System.out.println(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
