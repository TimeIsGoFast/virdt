package com.proven.utils;

public class CommonUtil {
	public static int dealBoolean(String bool){
		
		if(bool==null){
			return 0;
		}
		if(bool.equals("false")){
			return 0;
		}else if(bool.equals("true")){
			return 1;
		}else{
			return 0;
		}
		
	}
}
