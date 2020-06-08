package com.hxd.authorize.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.hxd.authorize.AuthorizeConfigManager;
import com.hxd.authorize.AuthorizeConfigProvider;
@Component
public class AuthorizeConfigManagerImpl implements AuthorizeConfigManager{

	@Autowired
	private Set<AuthorizeConfigProvider> authorizeConfigProviders;
	@Override
	public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
			authorizeConfigProvider.config(config);
		}
//		config.anyRequest().authenticated();
	}

}
