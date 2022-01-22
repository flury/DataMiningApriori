package com.datamining.services;

import java.io.Serializable;

public interface DatabaseService {

	public Object find(Class<?> className, Serializable id);
		
	public Object find(Class<?> className, String string);

	public void delete(Object object);

	public void save(Object object);
	
	public void saveOrUpdate(Object object);

	public void update(Object object);
	
	public void commitFlushClear();

}
