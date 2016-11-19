package org.daelly.project.onlinejudge.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daelly.project.onlinejudge.dao.AuthUserDao;
import org.daelly.project.onlinejudge.domain.AuthPermission;
import org.daelly.project.onlinejudge.domain.AuthUser;
import org.daelly.project.onlinejudge.domain.AuthUserUserPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SpringDataUserDetailsService implements UserDetailsService {
	
	private final Log logger = LogFactory.getLog(getClass());
	
	protected final MessageSourceAccessor messages = SpringSecurityMessageSource
			.getAccessor();
		
	@Autowired
	AuthUserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<AuthUser> users = userDao.findByUsername(username);
		if (users.size() == 0) {
			this.logger.debug("Query returned no results for user '" + username + "'");
			
			throw new UsernameNotFoundException(
					this.messages.getMessage("SpringDataUserDetailsService.notFound",
							new Object[] { username }, "Username {0} not found"));
		}
		AuthUser authUser = users.get(0);
		String password = authUser.getPassword();
		
		List<GrantedAuthority> authrities = new ArrayList<GrantedAuthority>();
		Set<AuthUserUserPermissions> permissions = authUser.getAuthUserUserPermissionses();
		for (AuthUserUserPermissions permission : permissions) {
			AuthPermission authPermission = permission.getAuthPermission();
			GrantedAuthority authority = new SimpleGrantedAuthority(authPermission.getName());
			authrities.add(authority);
		}
		if (authrities.size() == 0) {
			this.logger.debug("User '" + username
					+ "' has no authorities and will be treated as 'not found'");

			throw new UsernameNotFoundException(this.messages.getMessage(
					"JdbcDaoImpl.noAuthority", new Object[] { username },
					"User {0} has no GrantedAuthority"));
		}
		UserDetails user = new User(username, password, true, true, true, true,authrities);
		return user;
	}

}
