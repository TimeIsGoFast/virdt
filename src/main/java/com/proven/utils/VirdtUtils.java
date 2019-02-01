package com.proven.utils;

import java.util.List;

import com.proven.business.model.SessionView;

/**
 * 存放一些项目中可能会通用的一些方法
 * @author chenyn
 *
 */
public class VirdtUtils {
	
	//转换sessionView List,将sessionviewList 统一的转换到一个SessionViewList中
	public static void transferSessionViewBean(List<SessionView> oldList,List<SessionView> newList){
		for(SessionView sessionView:oldList){
			newList.add(sessionView);
		}
	}
	
}
