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
import model.bean.Item;
import model.bean.Person;
import model.bean.Purchase;
import model.bean.StockMove;
import model.bean.Supplier;
import model.dao.SuppliersDAO;

public class SuppliersDAOImpl implements SuppliersDAO<Supplier>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Supplier.class);

	@Override
	public void insert(Supplier entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Supplier entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Supplier entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Supplier findById(int id) {
		return (Supplier) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Supplier> findAll() {
		return criteria.list();
		
	}

	@Override
	public List<Supplier> findByAddress(Address address) {
		return criteria.add(Restrictions.eq("address.id",address.getId())).list();
		
	}

	@Override
	public List<Supplier> findByItem(Item item) {
		return criteria.add(Restrictions.eq("item.id",item.getId())).list();
	}

	@Override
	public List<Supplier> findByPerson(Person person) {
		return criteria.add(Restrictions.eq("person.id",person.getId())).list();
	}

	@Override
	public List<Supplier> findByPurchases(Purchase purchase) {
		return criteria.add(Restrictions.eq("purchase.id",purchase.getId())).list();
	}

	@Override
	public List<Supplier> findByName(String name) {
		return criteria.add(Restrictions.like("name",name, MatchMode.ANYWHERE)).list();
	}

}
