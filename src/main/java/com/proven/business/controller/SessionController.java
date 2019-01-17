package com.proven.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proven.base.vo.DataParam;
import com.proven.quartz.GetDataService;

@Controller
@RequestMapping("/session")
public class SessionController {
	@Autowired
	private GetDataService getDataService;
	
	@RequestMapping("/render")
	public String render(){
		return "business/session/session";
	}
	
	@RequestMapping("/refresh")
	@ResponseBody
	public void refresh(){
		getDataService.getSessionData(null);
	}
	

}
