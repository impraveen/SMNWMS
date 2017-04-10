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
import model.bean.Purchase;
import model.bean.PurchasingItem;
import model.dao.PurchasingItemDAO;

public class PurchasingItemDAOImpl implements PurchasingItemDAO<PurchasingItem>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(PurchasingItem.class);

	@Override
	public void insert(PurchasingItem entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(PurchasingItem entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(PurchasingItem entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public PurchasingItem findById(int id) {
		return (PurchasingItem) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<PurchasingItem> findAll() {
		return criteria.list();
	}

	@Override
	public List<PurchasingItem> findByCostPrice(float costPrice) {
		return criteria.add(Restrictions.eq("costPrice", costPrice)).list();
	}

	@Override
	public List<PurchasingItem> findByDate(Date date) {
		return criteria.add(Restrictions.eq("date", date)).list();
	}

	@Override
	public List<PurchasingItem> findByPurchse(Purchase purchase) {
		return criteria.add(Restrictions.eq("purchase.id", purchase.getId())).list();
	}

	@Override
	public List<PurchasingItem> findByQty(float qty) {
		return criteria.add(Restrictions.eq("qty", qty)).list();
	}

	@Override
	public List<PurchasingItem> findByRefrence(String refrence) {
		return  criteria.add(Restrictions.like("refrence", refrence, MatchMode.ANYWHERE)).list();
	}

	@Override
	public PurchasingItem findByItem(Item item) {
		return (PurchasingItem) criteria.add(Restrictions.eq("item.id", item.getId())).uniqueResult();
	}

}
