package com.proven.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.proven.constans.Constans;



public class DateFormatUtil {
	public static final long HOUR = 3600*1000;
	public static final long DAY = 3600*1000*24;
	public static final long MONTH = 36000*1000*24*30;
	public static final long YEAR = 3600*1000*24*30*365;
	
	private static final Logger logger = Logger.getLogger(DateFormatUtil.class);
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
	public static String getCurrentTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 		String dateTime = format.format(date);
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
	
	/**
	 * 增加8个小时
	 * @param date
	 * @return
	 */
	public static Date addEightHour(Date date){
		return new Date(date.getTime()+8*HOUR);
	}
	
	/**
	 * get date that differ time
	 */
	public static String getDifferTime(String passTime){
		
		//analysis passTime
		String unit = passTime.substring(passTime.length()-1);
		String value = passTime.substring(0, passTime.length()-1);
		logger.info("unit="+unit+",value="+value);
		Date date = new Date();
		if(Constans.DAY.equalsIgnoreCase(unit)){
			return getStringDate(Calendar.DATE,Integer.parseInt(value),date);
		}else if(Constans.MONTH.equalsIgnoreCase(unit)){
			return getStringDate(Calendar.MONTH,Integer.parseInt(value),date);
		}else if(Constans.HOUR.equalsIgnoreCase(unit)){
			return getStringDate(Calendar.HOUR,Integer.parseInt(value),date);
		}else if(Constans.YEAR.equalsIgnoreCase(unit)){
			return getStringDate(Calendar.YEAR,Integer.parseInt(value),date);
		}
		return null;
	}
	
	public static String getStringDate(int dateType,int value,Date date){
		 SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Calendar c = Calendar.getInstance();
		 c.setTime(date);
         c.add(dateType, value*(-1));
         Date d = c.getTime();
         return format.format(d);
	      
	}
	//将string date 转换成Date date
	public static Date parseDate(String date) throws ParseException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.parse(date);
	}

	//通过date 判断是否为当前日期
	public static boolean isCurrentDay(String date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = new Date();
		String dateCom = format.format(date2);
		if(dateCom.equals(date)){
			return true;
		}
		return false;
	}
	//计算所用的时间 分钟
	public static Integer calculatorTime(String timeDiff) {
		Integer time = 0;
		//TODO 这里有一个bug,当timeDiff 为null 的时候不应该设置24小时
		if(StringUtils.isEmpty(timeDiff)){
			time = 60*24;
		}else{
			String[] timeArr = timeDiff.split(":");
			Integer hours = Integer.parseInt(timeArr[0]);
			Integer min = Integer.parseInt(timeArr[1]);
			time = hours*60+min;
		}
		return time;
	}
	
	
	
}
