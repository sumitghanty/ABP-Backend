package com.mazars.in.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

public class CompanyDAOImpl implements CompanyDAO{
	
	private static final Logger logger = LogManager.getLogger(CompanyDAOImpl.class);
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
