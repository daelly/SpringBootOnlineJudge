package com.daelly.project.onlinejudge.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class EhcacheCacheConfig {

	/**
	 * ehcache的主要管理器
	 * @param bean
	 * @return
	 */
	@Bean
	public CacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
		return new EhCacheCacheManager(bean.getObject());
	}
	
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
		bean.setConfigLocation(new ClassPathResource("conf/ehcache.xml"));
		bean.setShared(true);
		return bean;
	}
}
