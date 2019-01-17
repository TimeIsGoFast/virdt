package com.proven.utils;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DateFormatUtil {
     public static String toDateoString(Date date){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
 		String dateTime = format.format(date);
 		return dateTime;
     }
     
     public static Date dealDateFormat(String oldDateStr) throws Exception{
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		 Date date=sd.parse(oldDateStr);
		 String date1 = sdf.format(date);
 		 
		 return sdf.parse(date1);

     }
}
