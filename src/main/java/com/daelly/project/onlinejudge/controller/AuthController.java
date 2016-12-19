package com.daelly.project.onlinejudge.controller;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daelly.project.onlinejudge.domain.AuthUser;
import com.daelly.project.onlinejudge.service.AuthUserService;
import com.daelly.project.onlinejudge.utils.PassWordUtils;

@Controller
public class AuthController {
	
	@Autowired
	AuthUserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "auth/login";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(){
		return "auth/register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(String usernamesignup,String emailsignup,String passwordsignup) throws Exception{
		AuthUser user = new AuthUser();
		user.setUsername(usernamesignup);
		user.setEmail(emailsignup);
		user.setPassword(PassWordUtils.generatePasswordHash(passwordsignup));
		long time = new Date().getTime();
		user.setDateJoined(new Timestamp(time));
		user.setFirstName(usernamesignup);
		user.setLastName("default");
		user.setIsActive(true);
		user.setIsStaff(false);
		user.setIsSuperuser(false);
		user.setLastLogin(new Timestamp(time));
		userService.register(user);
		return "redirect:/login?username="+usernamesignup;
	}
	
	@RequestMapping({"/","/home"})
	public String home(){
		return "home";
	}
}
