/**
 * 
 */
package com.proven.system.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proven.base.vo.Result;
import com.proven.constans.Constans;
import com.proven.system.model.User;
import com.proven.system.service.UserService;
import com.proven.utils.SpringUtil;

/**
 * @author Lay
 *
 */
@Controller
public class SystemController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/renderLogin")
	public String renderLogin(){
		return "login";
	}
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	@RequestMapping("/403")
	public String render403(){
		return "403";
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public Result login(UsernamePasswordToken token, HttpSession session,HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		Result result = new Result();
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			subject.getSession().setAttribute("USER", (String)subject.getPrincipal());
			result.setSuccess(true);
		} catch (UnknownAccountException e) {
			result.setSuccess(false);
			result.setMsg("帐号不存在");
		}catch(LockedAccountException e){
			result.setSuccess(false);
			result.setMsg("帐号被锁定");
		}catch(AuthenticationException e){
			result.setSuccess(false);
			result.setMsg("帐号密码错误");
		}
		return result;
	}
	
	@RequestMapping("/logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "/login";
	}
	
	@RequestMapping("/index")
	public String index(Model model){
		String uid = (String)SecurityUtils.getSubject().getPrincipal();
		User user = userService.getUserByUid(uid);
		SpringUtil.setSession(Constans.CURRENT_USER, user);
		model.addAttribute("user",user);
	
		return "system/index";
	
	}
}
