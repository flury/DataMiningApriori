package com.datamining.ui.web.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datamining.services.GenericDaoService;

@Controller
public class IndexController {

	@Autowired
	private GenericDaoService genericDao;
	
	@RequestMapping("/index")
	public String index(ModelMap modelMap) throws SQLException {
		return "/index";
	}
	
}
