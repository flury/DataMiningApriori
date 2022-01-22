package com.datamining.util;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


@SuppressWarnings("deprecation")
public class SpringSecurityUtil {

	public static String getUsername() {
		if(getAuthentication() == null) {
			return null;
		}
		
		Object principal = getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails)principal).getUsername();
		} else {
			return principal.toString();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Collection<GrantedAuthority> getAuthorities() {
		if(getAuthentication() == null) {
			return null;
		}
		return (Collection<GrantedAuthority>) getAuthentication().getAuthorities();
	}
	
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public static boolean isAuthenticated() {
		if(getAuthentication() == null) {
			return false;
		}
		Collection<GrantedAuthority> authorities = getAuthorities();
		if(authorities.size() == 1 && 
				StringUtils.equals(authorities.iterator().next().getAuthority(), "ROLE_ANONYMOUS")) {
			return false;
		}
		return true;
	}
	
	public static String encodePassword(String password) {
		PasswordEncoder encoder = new Md5PasswordEncoder();
		
		return encoder.encodePassword(password, null);
	}

    public static boolean haveAuthority(String role) {
    	if(getAuthentication() == null) {
			return false;
		}
    	
    	Collection<GrantedAuthority> authorities = getAuthorities();
        for(Iterator<GrantedAuthority> iterator=authorities.iterator();iterator.hasNext();) {
        	GrantedAuthority authority = iterator.next();
        	if(StringUtils.equals(authority.getAuthority(), role)) {
                return true;
            }
        }
        return false;
    }
}
