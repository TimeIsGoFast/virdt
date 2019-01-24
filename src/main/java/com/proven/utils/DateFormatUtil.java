package com.proven.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;



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
			if(StringUtils.isEmpty(oldDateStr)){
				logger.info("this date is null!");
				return null; 
		    }
			date = sd.parse(oldDateStr);
			String date1 = sdf.format(date);
			 return sdf.parse(date1);
		} catch (ParseException e) {
			logger.error("dealDateFormat date is null"+e);
			return null;
		}
		
 		 
		

     }
     
     /**
      * getCurrentTime,the format is "yyyy-MM-dd'T'HH:mm:ss.SSS"
      * StartDate ge DateTime'2018-11-07T07:32:41.963'
      * @return String
      */
	public static String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 		String dateTime = format.format(new Date());
		return "'"+dateTime+"T00:00:00.000'";
	}
	
	public static String getTimeDiff(Date date1,Date date2){
		if(date1==null||date2==null){
			return null;
		}
		long between = date2.getTime() - date1.getTime();
		long hour = between / (60 * 60 * 1000);
		long min = ((between / (60 * 1000)) - hour * 60);

		return hour+":"+min;
	}

}
