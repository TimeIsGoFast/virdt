package com.proven.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proven.business.model.SessionView;
import com.proven.business.service.SessionViewService;
import com.proven.quartz.GetDataService;

@Controller
@RequestMapping("/session")
public class SessionController {
	@Autowired
	private GetDataService getDataService;
	
	@Autowired
	private SessionViewService sessionViewService;
	@RequestMapping("/render")
	public String render(Model model){
		List<SessionView> slist = sessionViewService.selectAll();
		model.addAttribute("list", slist);
		return "business/session/session";
	}
	
	@RequestMapping("/refresh")
	@ResponseBody
	public void refresh(){
		getDataService.getUserData(null);
	}
	

}
