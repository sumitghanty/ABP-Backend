package com.mazars.in.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mazars.in.model.mastermodel.Instance;

public class InstanceDAOImpl implements InstanceDAO {

	
	private static final Logger logger = LogManager.getLogger(InstanceDAOImpl.class);
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	
	
	@Override
	public void save(Instance instance) {
		try
		{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(instance);
		tx.commit();
		session.close();
		}
		catch(Exception e)
		{
			logger.error("catch block of save method of  Instance dao");
		}
	
		
		
	}

	@Override
	public void update(Instance instance) {

		try
		{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(instance);
		tx.commit();
		session.close();
		}
		catch(Exception e)
		{
			logger.error("catch block of save method of Instance dao");
		}
	
		
	}

	@Override
	public List<Instance> list() {

		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Instance where id = :id");
		
		query.setParameter("id", 10);
		List<Instance> instanceList = query.list();
		session.close();
		return instanceList;
	
	}

}
