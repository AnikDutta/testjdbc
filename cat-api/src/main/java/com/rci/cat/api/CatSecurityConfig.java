package com.rci.cat.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelAuthorizationException;
import org.apache.camel.Exchange;
import org.apache.camel.component.spring.security.SpringSecurityAccessPolicy;
import org.apache.camel.component.spring.security.SpringSecurityAuthorizationPolicy;
import org.apache.camel.spi.AuthorizationPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.authentication.AuthenticationManager;

import com.google.common.base.Joiner;

@Configuration
public class CatSecurityConfig {

	private final static Logger LOG = LoggerFactory.getLogger(CatSecurityConfig.class);

	@Autowired
	private Environment environment;

	@Autowired
	AuthenticationManager authenticationManager;

	@Bean("authorizationPolicy")
	public AuthorizationPolicy authorizationPolicy() {
		SpringSecurityAuthorizationPolicy policy = new SpringSecurityAuthorizationPolicy() {
			@Override
			protected void beforeProcess(Exchange exchange) throws Exception {
				if (environment.getProperty("security.enabled", Boolean.class)) {
					String roles = "role_user";
					if (roles.isEmpty())
						throw new CamelAuthorizationException("no roles found in cache for service key", exchange);
					List<ConfigAttribute> attributes = getSpringSecurityAccessPolicy().getConfigAttributes();
					attributes.clear();
					attributes.addAll(SecurityConfig.createListFromCommaDelimitedString(roles));
					super.beforeProcess(exchange);
				} else {
					LOG.warn("skipping executing authorization policy for service key as security.enabled is false");
				}
			}
		};
		policy.setAuthenticationManager(authenticationManager);
		policy.setAccessDecisionManager(getAccessDecisionManager());
		policy.setAlwaysReauthenticate(false);
		policy.setSpringSecurityAccessPolicy(new SpringSecurityAccessPolicy(""));
		return policy;
	}

	@Bean
	public AccessDecisionManager getAccessDecisionManager() {
		List<AccessDecisionVoter<?>> decisionVoters = new ArrayList<>();
		decisionVoters.add(getRoleHierarchyVoter());
		return new AffirmativeBased(decisionVoters);
	}

	@Bean
	public RoleHierarchyVoter getRoleHierarchyVoter() {
		RoleHierarchyVoter voter = new RoleHierarchyVoter(getRoleHierarchy());
		voter.setRolePrefix("");
		return voter;
	}

	@Bean
	public RoleHierarchy getRoleHierarchy() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		String hierarchy = Joiner.on(' ').join("role_admin > role_user", "role_user > role_unauthenticated");
		roleHierarchy.setHierarchy(hierarchy);
		return roleHierarchy;
	}
}