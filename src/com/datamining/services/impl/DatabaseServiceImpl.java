package com.datamining.services.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datamining.services.DatabaseService;

@Transactional
@Service("databaseService")
public class DatabaseServiceImpl implements DatabaseService {

	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public Object find(Class<?> className, Serializable id) {
		return sessionFactory.getCurrentSession().get(className, id);
	}

	@Override
	public Object find(Class<?> className, String string) {
		return sessionFactory.getCurrentSession().get(className, string);
	}

	@Override
	public void delete(Object object) {
		sessionFactory.getCurrentSession().delete(object);
	}

	@Override
	public void save(Object object) {
		sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public void update(Object object) {
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public void saveOrUpdate(Object object) {
		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}

	@Override
	public void commitFlushClear() {
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}
}
