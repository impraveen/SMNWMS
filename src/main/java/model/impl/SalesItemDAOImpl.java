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
import model.bean.Item;
import model.bean.Sales;
import model.bean.SalesItem;
import model.dao.SalesItemDAO;

public class SalesItemDAOImpl implements SalesItemDAO<SalesItem>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(SalesItem.class);

	@Override
	public void insert(SalesItem entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(SalesItem entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(SalesItem entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public SalesItem findById(int id) {
		return (SalesItem) criteria.add(Restrictions.eq("id", id)).uniqueResult();
		
	}

	@Override
	public List<SalesItem> findAll() {
		return criteria.list();
		
	}

	@Override
	public List<SalesItem> findByDate(Date date) {
		return criteria.add(Restrictions.eq("date", date)).list();
		
	}

	@Override
	public List<SalesItem> findByItem(Item item) {
		return criteria.add(Restrictions.eq("item.id", item.getId())).list();
	}

	@Override
	public List<SalesItem> findByQty(float qty) {
		return criteria.add(Restrictions.eq("qty", qty)).list();
	}

	@Override
	public List<SalesItem> findBySales(Sales sales) {
		return criteria.add(Restrictions.eq("sales.id", sales.getId())).list();
	}

	@Override
	public List<SalesItem> findByRefrence(String refrence) {
		return  criteria.add(Restrictions.like("refrece", refrence, MatchMode.ANYWHERE)).list();
	}

}
