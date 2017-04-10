package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Item;
import model.bean.Job;
import model.dao.JobDAO;

public class JobDAOImpl implements JobDAO<Job>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Job.class);

	@Override
	public void insert(Job entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Job entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Job entity) {
		session.delete(entity);
		transaction.commit();
		
		
	}

	@Override
	public Job findById(int id) {
		return (Job) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Job> findAll() {
		return criteria.list();
		
	}

	@Override
	public List<Job> findByTitle(String name) {
		return  criteria.add(Restrictions.like("name", name)).list();
	}

}
