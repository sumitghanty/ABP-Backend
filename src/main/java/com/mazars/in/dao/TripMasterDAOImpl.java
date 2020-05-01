package  com.mazars.in.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mazars.in.model.mastermodel.TripMaster;


public class TripMasterDAOImpl implements TripMasterDAO {
	private static final Logger logger = LogManager.getLogger(TripMasterDAOImpl.class);
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public void save(TripMaster p) {
		try
		{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
		}
		catch(Exception e)
		{
			logger.error("catch block of save method of  PersonDAOImpl");
		}
	}
	public void update(TripMaster p) {
		try
		{
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(p);
		tx.commit();
		session.close();
		}
		catch(Exception e)
		{
			logger.error("catch block of save method of  PersonDAOImpl");
		}
	}
	
	

	@SuppressWarnings("unchecked")
	public List<TripMaster> list() {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from Person where id = :id");
		
		query.setParameter("id", 10);
		List<TripMaster> personList = query.list();
		session.close();
		return personList;
	}

}
