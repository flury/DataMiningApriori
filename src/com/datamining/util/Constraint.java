package com.datamining.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class Constraint {

	private String whereClause;
	private String orderbyClause;
	private Map<String, Object> parameters;
	
	public Constraint() {
		whereClause = null;
		parameters = new HashMap<String, Object>();
	}
	
	public String getWhereClause() {
		return whereClause;
	}
	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}
	
	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	public String getOrderbyClause() {
		return orderbyClause;
	}

	public void setOrderbyClause(String orderbyClause) {
		this.orderbyClause = orderbyClause;
	}

	public static Constraint precheckConstraint(Constraint constraint) {
		
		if(constraint == null) {
			constraint = new Constraint();
		}
		
		if(StringUtils.isNotBlank(constraint.getWhereClause())) {
			constraint.setWhereClause(constraint.getWhereClause() + " and ");
		} else {
			constraint.setWhereClause("");
		}
		
		/*if(StringUtils.isNotBlank(constraint.getOrderbyClause())) {
			constraint.setOrderbyClause(constraint.getOrderbyClause() + " ");
		} else {
			constraint.setOrderbyClause("");
		}*/
		
		return constraint;
	}
}
