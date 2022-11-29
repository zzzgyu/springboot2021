package com.allweing.config;

import org.apache.catalina.Realm;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @auther: zzzgyu
 */

public class UserRealm extends AuthorizingRealm {
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo( PrincipalCollection principalCollection ) {
		System.out.println("doGetAuthorizationInfo");
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo( AuthenticationToken authenticationToken ) throws AuthenticationException {
		System.out.println("doGetAuthenticationInfo");

		String username = "root";
		String password = "123456";

		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		if (!token.getUsername().equals(username)) {
			return null;
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("", password, "");
		return simpleAuthenticationInfo;
	}
}
