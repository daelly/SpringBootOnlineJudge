package org.daelly.project.onlinejudge.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.daelly.project.onlinejudge.dao.AuthPermissionDao;
import org.daelly.project.onlinejudge.dao.AuthUserDao;
import org.daelly.project.onlinejudge.domain.AuthPermission;
import org.daelly.project.onlinejudge.domain.AuthUser;
import org.daelly.project.onlinejudge.domain.AuthUserUserPermissions;
import org.daelly.project.onlinejudge.utils.PassWordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {
	
	@Autowired
	AuthUserDao userDao;
	
	@Autowired
	AuthPermissionDao permissionDao;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "auth/login";
	}
	
	@RequestMapping("/username")
	@ResponseBody
	public int checkUsername(String username){
		List<AuthUser> users = userDao.findByUsername(username);
		return users.size();
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
		//TODO:
		AuthPermission permission = permissionDao.findOne(25);
		AuthUserUserPermissions userPermission = new AuthUserUserPermissions(user, permission);
		Set<AuthUserUserPermissions> authUserUserPermissionses = new HashSet<AuthUserUserPermissions>();
		authUserUserPermissionses.add(userPermission);
		user.setAuthUserUserPermissionses(authUserUserPermissionses );
		userDao.save(user);
		return "redirect:/login?username="+usernamesignup;
	}
	
	@RequestMapping({"/","/home"})
	public String home(){
		return "home";
	}
}
