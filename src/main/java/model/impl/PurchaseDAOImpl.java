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
import model.bean.Person;
import model.bean.PersonType;
import model.bean.Purchase;
import model.bean.Supplier;
import model.dao.PurchaseDAO;

public class PurchaseDAOImpl implements PurchaseDAO<Purchase>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Purchase.class);

	@Override
	public void insert(Purchase entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Purchase entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Purchase entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Purchase findById(int id) {
		return (Purchase) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Purchase> findAll() {
		return criteria.list();
	}

	@Override
	public List<Purchase> findByDate(Date date) {
		return criteria.add(Restrictions.eq("date", date)).list();
	}

	@Override
	public List<Purchase> findByPerson(Person person) {
		return criteria.add(Restrictions.eq("person.id", person.getId())).list();
	}

	@Override
	public List<Purchase> findBySupplier(Supplier supplier) {
		return criteria.add(Restrictions.eq("supplier.id", supplier.getId())).list();
	}

	@Override
	public List<Purchase> findByTotalCost(float totalCost) {
		return criteria.add(Restrictions.eq("totalCost", totalCost)).list();
	}

	@Override
	public List<Purchase> findByRefrence(String refrence) {
		return  criteria.add(Restrictions.like("refrence", refrence, MatchMode.ANYWHERE)).list();
	}

}
