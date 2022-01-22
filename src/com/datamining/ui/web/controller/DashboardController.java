package com.datamining.ui.web.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datamining.util.Constant;

@Controller
public class DashboardController {

	@Autowired
	private HttpSession session;
	
	@RequestMapping("/dashboard.pl")
	public String index(ModelMap modelMap) throws SQLException {
		
		String userId = (String) session.getAttribute(Constant.SESS_USER_ID);
		
		if (userId == null) {
			return "/login";
		}
		
		return "/dashboard.pl";
	}
	
}
