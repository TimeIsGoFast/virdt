package com.proven.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proven.quartz.GetDataServiceImpl;



public class DateFormatUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateFormatUtil.class);
     public static String toDateoString(Date date){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 		String dateTime = format.format(date);
 		return dateTime;
     }
     
     public static Date dealDateFormat(String oldDateStr){
    	 
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		 Date date;
		try {
			date = sd.parse(oldDateStr);
			String date1 = sdf.format(date);
			 return sdf.parse(date1);
		} catch (ParseException e) {
			logger.info("dealDateFormat date is null"+e);
			return null;
		}
		
 		 
		

     }
}
