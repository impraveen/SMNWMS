package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Address;
import model.bean.City;
import model.dao.CityDAO;

public class CityDAOImpl implements CityDAO<City> {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(City.class);

	@Override
	public void insert(City entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(City entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(City entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public City findById(int id) {
		return (City) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<City> findAll() {
		return criteria.list();
	}

	@Override
	public List<City> findByCode(String code) {
		return criteria.add(Restrictions.like("code", code, MatchMode.ANYWHERE)).list();
	}

	@Override
	public List<City> findByName(String name) {
		return  criteria.add(Restrictions.like("name", name,MatchMode.ANYWHERE)).list();
	}
	

}
