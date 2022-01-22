package com.datamining.services;

import java.util.List;

import com.datamining.entity.TblUser;

public interface UserService {

	public TblUser findByUserName(String userName);
	
	public List<?> findByUserPriviledge(TblUser tblUser);
	
}
