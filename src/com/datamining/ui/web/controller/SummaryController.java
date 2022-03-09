package com.datamining.ui.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datamining.services.GenericDaoService;
import com.datamining.util.Constant;

@Controller
public class SummaryController {

	@Autowired
	private GenericDaoService genericDao;
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping("/summary")
	public String index(ModelMap modelMap, @RequestParam(required=false) String messagesSuccess,
			@RequestParam(required=false) String messagesError) {
		
		String userName = (String) session.getAttribute(Constant.SESS_USER_NAME);
		if(userName == null){
			return "redirect:/login";
		}
		
		if (messagesSuccess != null) {
			modelMap.put("messagesSuccess", messagesSuccess);
		}
		
		if (messagesError != null) {
			modelMap.put("messagesError", messagesError);
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<?> listDataset = genericDao.runHQL("FROM TblFrequentDataSupport GROUP BY frequentDataId ORDER BY executeDate DESC ", params);
		modelMap.put("listDataset", listDataset);
		modelMap.put("totalData", listDataset.size());
		
		return "/summary";
	}
}
