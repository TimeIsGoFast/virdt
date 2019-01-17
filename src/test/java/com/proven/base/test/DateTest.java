package com.proven.base.test;

import java.util.Date;

import org.junit.Test;

import com.proven.utils.DateFormatUtil;

public class DateTest {
	@Test
	public void testDateFormatter(){
		String time = "2019-01-09T09:00:56.000";
		try {
			Date date = DateFormatUtil.dealDateFormat(time);
			
			System.out.println(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
