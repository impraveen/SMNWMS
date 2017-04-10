package model.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Customer;
import model.bean.InventoryCheck;
import model.bean.Item;
import model.bean.Person;
import model.dao.InventoryCheckDAO;

public class InventoryCheckDAOImpl implements InventoryCheckDAO<InventoryCheck>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(InventoryCheck.class);

	@Override
	public void insert(InventoryCheck entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(InventoryCheck entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(InventoryCheck entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public InventoryCheck findById(int id) {
		return (InventoryCheck) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<InventoryCheck> findAll() {
		return criteria.list();
	}

	@Override
	public List<InventoryCheck> findByActualQty(float actualQty) {
		return criteria.add(Restrictions.eq("actualQty", actualQty)).list();
	}

	@Override
	public List<InventoryCheck> findByCurrentQTY(float currentQty) {
		return criteria.add(Restrictions.eq("currentQty", currentQty)).list();
	}

	@Override
	public List<InventoryCheck> findByDate(Date date) {
		return criteria.add(Restrictions.eq("date", date)).list();
	}

	@Override
	public List<InventoryCheck> findByDiffQty(float diffQty) {
		return criteria.add(Restrictions.eq("diffQty", diffQty)).list();
	}

	@Override
	public List<InventoryCheck> findByItem(Item item) {
		return criteria.add(Restrictions.eq("item.id", item.getId())).list();
	}

	@Override
	public List<InventoryCheck> findByLastQty(float lastQty) {
		return criteria.add(Restrictions.eq("lastQty", lastQty)).list();
	}

	@Override
	public List<InventoryCheck> findByPerson(Person person) {
		return criteria.add(Restrictions.eq("person.id", person.getId())).list();
	}

}
