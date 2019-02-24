package com.proven.base.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.proven.utils.CommonUtil;
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
	
	@Test
	public void testGetCurrentTime(){
		System.out.println(DateFormatUtil.getCurrentTime(new Date()));
	}
	@Test
	public void testDealBoolean(){
		System.out.println(CommonUtil.dealBoolean("false"));
	}
	
	@Test
	public void testGeTimeDiff() throws InterruptedException{
		Date date1 = new Date();
		Thread.sleep(5000);
		Date date2 = new Date();
		System.out.println(DateFormatUtil.getTimeDiff(date1, date2));
		
	}
	
	//test getDifferTime
	@Test
	public void testGetDifferTime(){
		System.out.println(DateFormatUtil.getDifferTime("2d"));
		
	}
	
	//test param date
	@Test
	public void testParamDate() throws ParseException{
		String date = "2019-02-24 00:00:00";
		System.out.println(DateFormatUtil.parseDate(date));
	}
	
	@Test
	public void testGetStringDate() throws ParseException{
		String date = "2019-02-23 00:00:00";
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(DateFormatUtil.getStringDate(Calendar.DATE, -1,format.parse(date)));
		
	}
	
	//测试calculatorTime
	@Test
	public void testCalculatorTime(){
		System.out.println(DateFormatUtil.calculatorTime(null));
	}
}
