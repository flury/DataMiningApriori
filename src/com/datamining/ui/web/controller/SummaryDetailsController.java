package com.datamining.ui.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datamining.entity.TblFrequentDataSupport;
import com.datamining.services.GenericDaoService;
import com.datamining.util.Constant;

@Controller
public class SummaryDetailsController {

	@Autowired
	private GenericDaoService genericDao;
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping("/summary-details/{frequentDataId}")
	public String index(ModelMap modelMap, @RequestParam(required=false) String messagesSuccess,
			@RequestParam(required=false) String messagesError, @PathVariable String frequentDataId) {
		
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
		params.put("frequentDataId", frequentDataId);
		List<?> listDataset = genericDao.runHQL("FROM TblFrequentDataSupport WHERE frequentDataId=:frequentDataId "
				+ "ORDER BY itemsetNumber DESC, support DESC ", params);
		modelMap.put("listDataset", listDataset);
		modelMap.put("totalData", listDataset.size());
		
		List<?> listDataConfidence = genericDao.runHQL("FROM TblFrequentDataConfidence WHERE frequentDataId=:frequentDataId "
				+ "ORDER BY confidence DESC ", params);
		modelMap.put("listDataConfidence", listDataConfidence);
		modelMap.put("totalDataConfidence", listDataConfidence.size());
		
		
		String candidate = "[5, 18]";
		String candidateFormater = candidate.replace("[", "").replace("]", "").replace(",", "");
		params.clear();
		params.put("frequentDataId", frequentDataId);
		params.put("candidate", candidateFormater);
		List<?> listDataSupport = genericDao.runHQL("FROM TblFrequentDataSupport "
				+ "WHERE frequentDataId=:frequentDataId "
				+ "AND candidate=:candidate ", params);
		if (listDataSupport.size() > 0) {
			TblFrequentDataSupport sup = (TblFrequentDataSupport) listDataSupport.get(0);
			System.out.println(candidateFormater + " candidate >>>>>>>>>>>>>>>>>> " + sup.getSupport());
		}
		
		
		return "/summary-details";
	}
}
