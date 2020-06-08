package com.hxd.authorize.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.hxd.authorize.AuthorizeConfigProvider;
import com.hxd.properties.SecurityConstants;
import com.hxd.properties.SecurityProperties;
/**
 * @Order(Integer.MIN_VALUE)最小值，最早配置
 *
 */
@Component
@Order(Integer.MIN_VALUE)
public class AuthorizeConfigProviderImpl implements AuthorizeConfigProvider{

	@Autowired
	private SecurityProperties securityProperties;
	@Override
	public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		config.antMatchers(
				SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
				//SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
				securityProperties.getBrowser().getLoginPage(),
				SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
				securityProperties.getBrowser().getSignUpUrl()
				//securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".json",
				//securityProperties.getBrowser().getSession().getSessionInvalidUrl()+".html",
				).permitAll();
		
	}

}
