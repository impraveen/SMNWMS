package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Country;
import model.bean.Customer;
import model.bean.Person;
import model.dao.CustomerDAO;

public class CustomerDAOImpl implements CustomerDAO<Customer>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Customer.class);

	@Override
	public void insert(Customer entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Customer entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Customer entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Customer findById(int id) {
		return (Customer) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Customer> findAll() {
		return criteria.list();
	}

	@Override
	public List<Customer> findByName(String name) {
		return  criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE)).list();
	}

	@Override
	public Customer findByPerson(Person person) {
		return (Customer) criteria.add(Restrictions.eq("person.id", person.getId())).uniqueResult();
	}

	@Override
	public List<Customer> findByIsCompany(String comp) {
		return criteria.add(Restrictions.like("comp", comp, MatchMode.ANYWHERE)).list();
	}

	@Override
	public List<Customer> findByEmail(String email) {
		return  criteria.add(Restrictions.like("email", email, MatchMode.ANYWHERE)).list();
	}

	@Override
	public Customer findByMobileNumber(int mobileNumber) {
		return  (Customer)criteria.add(Restrictions.eq("mobileNumber", mobileNumber)).uniqueResult();
	}

	@Override
	public Customer finddByLandNumber(int landMobile) {
		return (Customer) criteria.add(Restrictions.eq("landNumber", landMobile)).uniqueResult();
	}

}
