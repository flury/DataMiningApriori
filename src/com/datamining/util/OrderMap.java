package com.datamining.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrderMap implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, String> map;
	private List<String> orderList;
    
    public OrderMap() {
    	map = new HashMap<String, String>();
    	orderList = new ArrayList<String>();
	}

	public void put(String propertyName, String order) {
    	if (!map.containsKey(propertyName)) {
    		orderList.remove(propertyName);
    	}
    	map.put(propertyName, order);
    	orderList.add(propertyName);
    }
    
    @Override
    public String toString() {
    	StringBuffer stringBuffer = new StringBuffer();
    	
    	for(Iterator<String> iterator=orderList.iterator(); iterator.hasNext();) {
    		String propertyName = (String) iterator.next();
    		
    		stringBuffer.append(propertyName);
    		stringBuffer.append(" ");
    		stringBuffer.append(map.get(propertyName));
    		
    		if (iterator.hasNext()) {
    			stringBuffer.append(", ");
    		}
    	}
    	
    	return stringBuffer.toString();
    }
    
    public Map<String, String> getMap() {
		return map;
	}

	public List<String> getOrderList() {
		return orderList;
	}
}
