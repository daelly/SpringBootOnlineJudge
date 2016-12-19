package com.daelly.project.onlinejudge.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daelly.project.onlinejudge.dao.AuthGroupDao;
import com.daelly.project.onlinejudge.dao.AuthUserDao;
import com.daelly.project.onlinejudge.dao.AuthUserGroupsDao;
import com.daelly.project.onlinejudge.domain.AuthGroup;
import com.daelly.project.onlinejudge.domain.AuthUser;
import com.daelly.project.onlinejudge.domain.AuthUserGroups;

@RunWith(SpringRunner.class)
@DataJpaTest(showSql=true)
@AutoConfigureDataJpa
@AutoConfigureTestDatabase(replace=Replace.AUTO_CONFIGURED)
public class AuthUserDaoTest {
	
	@Autowired
	AuthUserDao userDao;
	
	@Autowired
	AuthGroupDao groupDao;
	
	@Autowired
	AuthUserGroupsDao userGroupDao;
	
	AuthGroup group;
	
	@Before
	public void setUp(){
		group = new AuthGroup();
		group.setName("admin");
		group = groupDao.save(group);
	}
	
	@Test
	public void test() {
		AuthUser user = new AuthUser();
		user.setUsername("daelly");
		user.setPassword("123456");
		user.setDateJoined(new Timestamp(new Date().getTime()));
		user.setEmail("940732367@qq.com");
		user.setFirstName("daelly");
		user.setLastName("lee");
		user.setLastLogin(new Timestamp(new Date().getTime()));
		user.setIsActive(true);
		user.setIsStaff(true);
		user.setIsSuperuser(true);
		Set<AuthUserGroups> authUserGroupses = new HashSet<AuthUserGroups>();
		AuthUserGroups userGroup = new AuthUserGroups();
		group.setName("admin");
		group.setAuthUserGroupses(authUserGroupses);
		userGroup.setAuthGroup(group);
		userGroup.setAuthUser(user);
		authUserGroupses.add(userGroup);
		user.setAuthUserGroupses(authUserGroupses );
		userDao.save(user);
	}

}
