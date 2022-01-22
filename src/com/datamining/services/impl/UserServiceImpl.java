package com.datamining.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datamining.entity.TblUser;
import com.datamining.services.GenericDaoService;
import com.datamining.services.UserService;

@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private GenericDaoService genericDao;
	
	@Override
	public TblUser findByUserName(String userName) {
		Map< String, Object> parameters=new HashMap<String, Object>();
		parameters.put("userName", userName);
		
		TblUser tblUser =(TblUser) genericDao.runHQLUniqueResult("from TblUser where userName=:userName", parameters);
		
		return tblUser;
	}
	
	@Override
	public List<?> findByUserPriviledge(TblUser tblUser) {
		
		Map< String, Object> parameters = new HashMap<String, Object>();
		parameters.put("userType", tblUser.getTblUserType().getUserTypeId());
		
		List<?> listUserPriviledge = genericDao.runHQL("FROM TblUserPriviledge WHERE userType=:userType ", parameters);
		
		return listUserPriviledge;
	}

}
