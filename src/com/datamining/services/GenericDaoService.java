package com.datamining.services;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.datamining.util.Constraint;
import com.datamining.util.OrderMap;
import com.datamining.util.SearchResult;

public interface GenericDaoService {

	public List<?> runHQL(String hql, Map<String, Object> parameters);
	
	public List<?> runHQL(String hql, Map<String, Object> parameters,int maxResults);
	
	public Object runHQLUniqueResult(String hql, Map<String, Object> parameters);
	
	public Object runHQLUniqueResult(String hql, Map<String, Object> parameters,boolean isCacheQuery);
	
	public int executeUpdateHQL(String hql, Map<String, Object> parameters);
	
	public List<?> runSQLQuery(String sql, Map<String, Object> parameters, Map<String, Type> mapScalar);
	
	public SearchResult searchHQL(String selectClause, String fromClause, Constraint constraint, 
			OrderMap orderMap, boolean isUsingPaging, int offset, int pageSize, boolean isCacheQuery);
	
	public SearchResult searchHQL(String selectClause, String fromClause, Constraint constraint, 
			OrderMap orderMap, boolean isUsingPaging, int offset, int pageSize);
	
}
