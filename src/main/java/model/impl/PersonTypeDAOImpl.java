package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Person;
import model.bean.PersonType;
import model.dao.PersonTypeDAO;

public class PersonTypeDAOImpl implements PersonTypeDAO<PersonType>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(PersonType.class);

	@Override
	public void insert(PersonType entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(PersonType entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(PersonType entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public PersonType findById(int id) {
		
		return (PersonType) criteria.add(Restrictions.eq("id", id));
	}

	@Override
	public List<PersonType> findAll() {
		
		return criteria.list();
	}

	@Override
	public List<PersonType> findByTitle(String title) {
		return criteria.add(Restrictions.like("titel", title, MatchMode.ANYWHERE)).list();
	}

}
