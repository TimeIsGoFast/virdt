package com.proven.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proven.business.model.DeskUser;
import com.proven.business.service.DeskUserService;

@Controller
@RequestMapping("/deskUser")
public class DeskUserController {
	@Autowired
	private DeskUserService deskUserService;

	@RequestMapping("/render")
	public String render(Model model){
		List<DeskUser> list = deskUserService.selectAll();
		model.addAttribute("list", list);
		return "business/deskuser/user";
	}
}
