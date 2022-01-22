package com.datamining.ui.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datamining.services.LogService;
import com.datamining.util.Constant;

@Controller
public class LoginController {
	
	@Autowired
	private LogService logService;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,
			ModelMap modelMap, HttpServletRequest request) {
		
		if(error != null){
			modelMap.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}
		
		return "login";
	}
	
	@RequestMapping("/logout-success")
	public String logoutSuccess(){
		logService.log(Constant.LOG_INFO, "UserLogOut", "Success");
		return "redirect:logout";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap){
		session.removeAttribute(Constant.SESS_USER_ID);
		session.removeAttribute(Constant.SESS_USER_NAME);
		session.removeAttribute(Constant.SESS_USER_TYPE_ID);
		session.removeAttribute(Constant.SESS_USER_TYPE_NAME);
		modelMap.addAttribute("msg", "You've been logged out successfully.");
		return "redirect:login";
	}
	
	private String getErrorMessage(HttpServletRequest request, String key){

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Authentication failed: no credentials provided.";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else if (exception instanceof GenericJDBCException) {
			error = exception.getMessage();
		} else if (exception instanceof AuthenticationServiceException) {
			if (exception.getCause() instanceof CannotCreateTransactionException) {
				error = "Authentication failed: Could not open connection to datasource.";
			} else if (exception.getCause() instanceof NullPointerException) {
				error = "Authentication failed: Bad Credentials.";
			}
		} else {
			error = "Invalid username and password!";
		}
		
		return error;
	}
}
