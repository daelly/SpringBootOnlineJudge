package org.daelly.project.onlinejudge.configuration;

import javax.sql.DataSource;

import org.daelly.project.onlinejudge.auth.CustomPasswordEncoder;
import org.daelly.project.onlinejudge.auth.SpringDataUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public OpenEntityManagerInViewFilter openEntityManagerInViewFilter(){
		return new OpenEntityManagerInViewFilter();
	}
	
	@Autowired
	SpringResourceTemplateResolver templateResolver;
	
	/**
	 * 这个bean配置很重要，要使用thymeleaf+spring security
	 * 必须添加这个方言 new SpringSecurityDialect()
	 * 支持SpringEL
	 * 这两个属性都不支持在外围配置，所以我们定义一个bean替换默认的SpringTemplateEngine bean
	 * @return
	 */
	@Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setEnableSpringELCompiler(true); // Compiled SpringEL should speed up executions
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }
	
	@Bean
	public SpringDataUserDetailsService springDataUserDetailsService(){
		return new SpringDataUserDetailsService();
	}
	
	@Bean
	public CustomPasswordEncoder customPasswordEncoder(){
		return new CustomPasswordEncoder();
	}
	
	@Override  
    public void configure(WebSecurity web) throws Exception {  
        // 设置不拦截规则  
        web.ignoring().antMatchers("/lib/**", "/custom/**", "/test/*");  
  
    } 
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/register", "/home","/").permitAll()
                .anyRequest().authenticated()
            .and()
            	.formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
            	.logout()
            	.logoutSuccessUrl("/")
                .permitAll()
            .and()
            	.rememberMe();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.userDetailsService(springDataUserDetailsService())
        	.passwordEncoder(customPasswordEncoder());
        
    }
}
