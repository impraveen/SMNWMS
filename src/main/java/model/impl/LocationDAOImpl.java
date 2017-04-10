package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.City;
import model.bean.Job;
import model.bean.Location;
import model.dao.LocationDAO;

public class LocationDAOImpl implements LocationDAO<Location>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Location.class);

	@Override
	public void insert(Location entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Location entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Location entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Location findById(int id) {
		return (Location) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Location> findAll() {
		return criteria.list();
	}

	@Override
	public List<Location> finByName(String name) {
		return  criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE)).list();
	}

	@Override
	public List<Location> findByCity(City city) {
		return criteria.add(Restrictions.eq("city.id", city.getId())).list();
	}



}
