package model.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Customer;
import model.bean.Person;
import model.bean.PurchasingItem;
import model.bean.Sales;
import model.dao.SalesDAO;

public class SalesDAOImpl implements SalesDAO<Sales>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Sales.class);

	@Override
	public void insert(Sales entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Sales entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Sales entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Sales findById(int id) {
		return (Sales) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Sales> findAll() {
		return criteria.list();
	}

	@Override
	public List<Sales> findByCustomer(Customer customer) {
		return criteria.add(Restrictions.eq("customer.id", customer.getId())).list();
	}

	@Override
	public List<Sales> findByDate(Date date) {
		return criteria.add(Restrictions.eq("date", date)).list();
	}

	@Override
	public List<Sales> findByPerson(Person person) {
		return criteria.add(Restrictions.eq("person.id", person.getId())).list();
	}

	@Override
	public List<Sales> findByTotalPrice(float totalPrice) {
		return criteria.add(Restrictions.eq("totalPrice", totalPrice)).list();
	}

	@Override
	public List<Sales> findByRefrence(String refrence) {
		return  criteria.add(Restrictions.like("refrence", refrence, MatchMode.ANYWHERE)).list();
	}

}
