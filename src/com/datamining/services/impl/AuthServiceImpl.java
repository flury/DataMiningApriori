package com.datamining.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datamining.entity.TblUser;
import com.datamining.entity.TblUserPriviledge;
import com.datamining.services.LogService;
import com.datamining.services.UserService;
import com.datamining.util.Constant;

@Service @Transactional
public class AuthServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private LogService logService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) {
		
		try {
			
			TblUser details = userService.findByUserName(userName);
			
			session.setAttribute(Constant.SESS_USER_ID, details.getUserId());
			session.setAttribute(Constant.SESS_USER_NAME, details.getUserName());
			session.setAttribute(Constant.SESS_USER_TYPE_ID, details.getTblUserType().getUserTypeId());
			session.setAttribute(Constant.SESS_USER_TYPE_NAME, details.getTblUserType().getUserTypeName());
			
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			SimpleGrantedAuthority globalAuthority = new SimpleGrantedAuthority("BILLING_INDEX");
			
			// Validate if Valid User Type Id
			if (details.getTblUserType().getUserTypeId() > 0) {
				
				// Read Mapping Authorization from Database
				List<?> listUserPriviledge = userService.findByUserPriviledge(details);
				if (listUserPriviledge.size() > 0) {
					for (int i = 0; i < listUserPriviledge.size(); i++) {
						TblUserPriviledge userPriviledge = (TblUserPriviledge) listUserPriviledge.get(i);
						String grantedAuthority = userPriviledge.getTblUserCommand().getCommand();
						
						if (userPriviledge.getAuthorized()) {
							SimpleGrantedAuthority readAuthority = new SimpleGrantedAuthority(grantedAuthority);
							authorities.add(readAuthority);
						}
					}
				} else {
					authorities.add(globalAuthority);
				}
				
			// Validate if Unknown User Type Id
			} else {
				authorities.add(globalAuthority);
			}
			
			UserDetails user = new User(details.getUserName(), details.getPassword(), 
					true, true, true, true, authorities);
			
			logService.log(Constant.LOG_INFO, "UserLogin", "Success: " + details.getUserName());
			
			return user;
			
		} catch (UsernameNotFoundException userEx) {
			throw new UsernameNotFoundException("Username not found:" + userName);
		}
		
	}

}
