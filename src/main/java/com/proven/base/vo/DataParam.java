package com.proven.base.vo;

import java.util.List;
import java.util.Map;

public class DataParam {
	private int page;
	private int row;
	private int index;
	private Map<String,String> orderMap;
	private List<String> selectList;
	private boolean isFreashAll;
	private String passTime;
	
	public DataParam(){
		this.isFreashAll=false;
	}
	public DataParam(boolean isFreashAll){
		this.isFreashAll = isFreashAll;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Map<String, String> getOrderMap() {
		return orderMap;
	}
	public void setOrderMap(Map<String, String> orderMap) {
		this.orderMap = orderMap;
	}
	public List<String> getSelectList() {
		return selectList;
	}
	public void setSelectList(List<String> selectList) {
		this.selectList = selectList;
	}
	public boolean isFreashAll() {
		return isFreashAll;
	}
	public void setFreashAll(boolean isFreashAll) {
		this.isFreashAll = isFreashAll;
	}
	public String getPassTime() {
		return passTime;
	}
	public void setPassTime(String passTime) {
		this.passTime = passTime;
	}
	
	
}
