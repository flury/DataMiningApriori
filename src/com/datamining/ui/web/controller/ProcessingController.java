package com.datamining.ui.web.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datamining.entity.EducationItem;
import com.datamining.services.GenericDaoService;
import com.datamining.util.Constant;

import de.mrapp.apriori.Apriori;
import de.mrapp.apriori.Transaction;

@Controller
public class ProcessingController {

	@Autowired
	private GenericDaoService genericDao;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/datamining-processing")
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
		
		return "/datamining-processing";
	}
	
	@RequestMapping("/execute-datamining-apriori.pl")
	public String executeDataMiningApriori(ModelMap modelMap,
			@RequestParam(required=false) double minSupport,
			@RequestParam(required=false) double minConfidence,
			@RequestParam(required=false) Integer totalRecords) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<?> listDataset = genericDao.runHQL("FROM TblDataset ORDER BY id ASC ", params, totalRecords);
		if (listDataset.size() > 0) {
			System.out.println("[info] Total Records Selected: " + listDataset.size());
			
			//Vector<String> frequentCandidates = new Vector<String>();
			
			String inputFile = ""; //file transaction
			FileInputStream file_in; //file input stream
			BufferedReader data_in; //data input stream
			
			try {
				file_in = new FileInputStream(inputFile);
				data_in = new BufferedReader(new InputStreamReader(file_in));
				
			} catch (IOException e) {
				// TODO: handle exception
			}
			// Generating all association rules with a minimum confidence
//			Apriori<EducationItem> apriori = new Apriori.Builder<EducationItem>(minSupport).generateRules(minConfidence).create();
//			Iterable<Transaction<EducationItem>> iterable = () -> new DataIterator(inputFile);
//			Output<NamedItem> output = apriori.execute(iterable);
//			RuleSet<NamedItem> ruleSet = output.getRuleSet();
		}
		
		
		
		return "redirect:/datamining-processing";
	}
	
}
