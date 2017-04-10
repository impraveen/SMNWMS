package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.ContractType;
import model.bean.Country;
import model.dao.CountryDAO;

public class CountryDAOImpl implements CountryDAO<Country>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Country.class);

	@Override
	public void insert(Country entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Country entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Country entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Country findById(int id) {
		return (Country) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Country> findAll() {
		return criteria.list();
	}

	@Override
	public List<Country> findByName(String name) {
		return criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE)).list(); 
	}

	@Override
	public List<Country> findByCode(String code) {
		return criteria.add(Restrictions.like("code", code, MatchMode.ANYWHERE)).list();
	}

}
