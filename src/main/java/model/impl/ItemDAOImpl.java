package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.InventoryCheck;
import model.bean.Item;
import model.bean.Supplier;
import model.bean.Unit;
import model.bean.Warehouse;
import model.dao.ItemDAO;

public class ItemDAOImpl implements ItemDAO<Item>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Item.class);

	@Override
	public void insert(Item entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Item entity) {
		session.update(entity);
		transaction.commit();
	}

	@Override
	public void delete(Item entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Item findById(int id) {
		return (Item) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Item> findAll() {
		return criteria.list();
	}

	@Override
	public List<Item> findByCode(String code) {
		return  criteria.add(Restrictions.like("code", code, MatchMode.ANYWHERE)).list();
	}

	@Override
	public Item findByGenCode(String genCode) {
		return (Item) criteria.add(Restrictions.eq("genCode", genCode)).uniqueResult();
	}

	@Override
	public List<Item> findByName(String name) {
		return criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE)).list();
	}

	@Override
	public List<Item> findByProperties(String properties) {
		return criteria.add(Restrictions.like("properties", properties)).list();
	}

	@Override
	public List<Item> findByQty(float qty) {
		return criteria.add(Restrictions.eq("qty", qty)).list();
	}

	@Override
	public List<Item> findBySalePrice(float salePrice) {
		return criteria.add(Restrictions.eq("salePrice", salePrice)).list();
	}

	@Override
	public List<Item> findBySize(float size) {
		return criteria.add(Restrictions.eq("size", size)).list();
	}

	@Override
	public List<Item> findBySupplier(Supplier supplier) {
		return criteria.add(Restrictions.eq("supplier.id", supplier.getId())).list();	
		}

	@Override
	public List<Item> findByUnit(Unit unit) {
		return criteria.add(Restrictions.eq("unit.id", unit.getId())).list();	
		}

	@Override
	public List<Item> findByWarehouse(Warehouse warehouse) {
		return criteria.add(Restrictions.eq("warehouse.id", warehouse.getId())).list();	
		}

}
