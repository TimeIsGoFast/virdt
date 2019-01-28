package com.proven.business.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proven.business.model.SessionView;
import com.proven.business.service.SessionViewService;
import com.proven.quartz.GetDataService;
import com.proven.system.model.User;
import com.proven.utils.DateFormatUtil;
import com.proven.utils.SpringUtil;

@Controller
@RequestMapping("/session")
public class SessionController {
	@Autowired
	private GetDataService getDataService;
	
	@Autowired
	private SessionViewService sessionViewService;
	/**
	 * get session index page
	 * @param model
	 * @return
	 */
	@RequestMapping("/render")
	public String render(Model model){
		List<SessionView> slist = sessionViewService.selectAllOrderByEndDate();
		//if end date is null,means the status is running,so set different time
		slist.stream().filter(session->("".equals(session.getEndDate())||session.getEndDate()==null)
				&&(!"".equals(session.getFailureDate())||session.getFailureDate()!=null))
		.forEach(se->se.setTimeDiff(DateFormatUtil.getTimeDiff(se.getStartDate(), new Date())));

		model.addAttribute("list", slist);
		return "business/session/session";
	}
	
	@RequestMapping("/refresh")
	@ResponseBody
	public void refresh(){
		getDataService.getUserData(null);
	}
	
	/**
	 * get current status
	 */
	@RequestMapping("/current")
	public String getCurrentStatus(Model model){
		List<SessionView> list = getDataService.getCurrentStatus();
		//获取当前的用户信息，用来filter该用户下面的交付组使用情况
		//TODO
		//TODOUser currentUser = SpringUtil.getCurrentUser();	
		model.addAttribute("list", list);
		return "business/session/session";
	}
	

}
