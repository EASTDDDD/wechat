package com.hxd.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.hxd.authorize.AuthorizeConfigProvider;
/**
 * @Order(Integer.MAX_VALUE)最大值，最后配置
 *
 */
@Component
@Order(Integer.MAX_VALUE)
public class DemoAuthorizeConfigProvider implements AuthorizeConfigProvider{

	@Override
	public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		config.antMatchers("/user").hasRole("ADMIN");
		//对应imooc-security-authorize的RbacServiceImpl里面的方法
//		config.anyRequest().access("@rbacService.hasPermission(request,authentication)");
	}

}
