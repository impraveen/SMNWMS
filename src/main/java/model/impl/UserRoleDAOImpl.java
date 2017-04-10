package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.User;
import model.bean.UserRole;
import model.dao.UserRoleDAO;

public class UserRoleDAOImpl implements UserRoleDAO<UserRole>{
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(UserRole.class);

	@Override
	public void insert(UserRole entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(UserRole entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(UserRole entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public UserRole findById(int id) {
		return (UserRole) criteria.add(Restrictions.eq("id",id)).uniqueResult();
	}

	@Override
	public List<UserRole> findAll() {
		return criteria.list();
	}

	@Override
	public List<UserRole> findByTitle(String titel) {
		return criteria.add(Restrictions.like("titel", titel, MatchMode.ANYWHERE)).list();
	}

}
