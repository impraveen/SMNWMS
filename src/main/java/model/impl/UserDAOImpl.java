package model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Person;
import model.bean.User;
import model.bean.UserRole;
import model.dao.UserDAO;

public class UserDAOImpl implements UserDAO<User>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(User.class);
	
	@Override
	public void insert(User entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(User entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(User entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public User findById(int id) {
		return (User) criteria.add(Restrictions.eq("id",id)).uniqueResult();
	}

	@Override
	public List<User> findAll() {
		return criteria.list();
		
	}

	@Override
	public User findByPerson(Person person) {
		return (User) criteria.add(Restrictions.eq("person.id", person.getId())).uniqueResult();
	}

	@Override
	public User findByUsername(String username) {
		return (User) criteria.add(Restrictions.eq("username", username)).uniqueResult();
	}

	@Override
	public List<User> findByRole(UserRole role) {
		return criteria.add(Restrictions.eq("role.id", role.getId())).list();
	}

}
