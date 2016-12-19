package com.daelly.project.onlinejudge.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daelly.project.onlinejudge.utils.Constants;
import com.daelly.project.onlinejudge.dao.AuthPermissionDao;
import com.daelly.project.onlinejudge.dao.AuthUserDao;
import com.daelly.project.onlinejudge.domain.AuthPermission;
import com.daelly.project.onlinejudge.domain.AuthUser;
import com.daelly.project.onlinejudge.domain.AuthUserUserPermissions;

@Service
@Transactional
public class AuthUserService {

	@Autowired
	AuthUserDao userDao;
	
	@Autowired
	AuthPermissionDao permissionDao;
	
	public void register(AuthUser user) {
		List<AuthUser> existedUsers = userDao.findByUsername(user.getUsername());
		if(existedUsers != null && existedUsers.size() > 0) {
			throw new RuntimeException("用户名已被注册！！");
		}
		AuthPermission permission = permissionDao.findOne(Constants.GENERAL_PER_ID);
		if(permission==null) {
			throw new RuntimeException("无效的权限！！");
		}
		AuthUserUserPermissions userPermission = new AuthUserUserPermissions(user, permission);
		Set<AuthUserUserPermissions> authUserUserPermissionses = new HashSet<AuthUserUserPermissions>();
		authUserUserPermissionses.add(userPermission);
		user.setAuthUserUserPermissionses(authUserUserPermissionses );
		userDao.save(user);
	}
}
