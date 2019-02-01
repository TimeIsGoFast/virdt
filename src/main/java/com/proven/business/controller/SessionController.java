package com.proven.business.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proven.business.model.DeskUser;
import com.proven.business.model.SessionView;
import com.proven.business.service.DeskUserService;
import com.proven.business.service.MachineService;
import com.proven.business.service.SessionViewService;
import com.proven.quartz.GetDataService;
import com.proven.system.model.User;
import com.proven.utils.DateFormatUtil;
import com.proven.utils.SpringUtil;
import com.proven.utils.VirdtUtils;

@Controller
@RequestMapping("/session")
public class SessionController {
	@Autowired
	private GetDataService getDataService;
	
	@Autowired
	private SessionViewService sessionViewService;
	
	@Autowired
	private DeskUserService deskUserService;
	
	@Autowired
	private MachineService machineService;
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
		List<SessionView> newSessionViewList = new ArrayList<>();
		//获取当前的用户信息，用来filter该用户下面的交付组使用情况
		User currentUser = SpringUtil.getCurrentUser();		
		DeskUser duser = deskUserService.selectByKey(currentUser.getDeskUserId());
		String upn = duser.getUpn();
		List<String> groupsIdList = machineService.selectByUpn(upn);
		for (String str : groupsIdList) {
			if(!StringUtils.isEmpty(str)){
				List<SessionView> sessionList = list.stream()
						.filter(sessionView->str.equals(sessionView.getDesktopGroupId()))
						.collect(Collectors.toList());
				VirdtUtils.transferSessionViewBean(sessionList,newSessionViewList);
			}
			
		}
		//list.stream().filter(sessionView->sessionView.get)
		model.addAttribute("list", newSessionViewList);
		return "business/session/session";
	}
	
	

}
