package com.proven.base.vo;

public class BarData {
	private String categore;
	private String data;
	
	public BarData(){
		
	}
	public BarData(String categore,String data){
		this.data=  data;
		this.categore = categore;
	}
	public String getCategore() {
		return categore;
	}
	public void setCategore(String categore) {
		this.categore = categore;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
