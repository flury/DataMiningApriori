package com.datamining.services.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datamining.entity.TblActivityLog;
import com.datamining.services.DatabaseService;
import com.datamining.services.LogService;
import com.datamining.util.Constant;

@Transactional
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private DatabaseService databaseService;
	
	@Override
	public void log(String type, String command, String message) {
		
		TblActivityLog logger = new TblActivityLog();
		
		logger.setLogTime(new Date());
		logger.setLogType(type);
		logger.setUserName((String)session.getAttribute(Constant.SESS_USER_NAME));
		logger.setCommand(command);
		logger.setLogMessage(message);
		logger.setIpAddress(request.getRemoteAddr());
		
		databaseService.save(logger);
	}
	
}
