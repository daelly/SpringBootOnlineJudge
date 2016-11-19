package org.daelly.project.onlinejudge.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.daelly.project.onlinejudge.utils.PassWordUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {
	
	private final Log logger = LogFactory.getLog(getClass());

	@Override
	public String encode(CharSequence rawPassword) {
		String result = null;
		try {
			result = PassWordUtils.generatePasswordHash(rawPassword.toString());
		} catch (Exception e) {
			logger.error("密码加密出错了！");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		boolean result = false;
		try {
			result = PassWordUtils.validatePassword(rawPassword.toString(), encodedPassword);
		} catch (Exception e) {
			logger.error("密码校验失败");
			e.printStackTrace();
		}
		return result;
	}

}
