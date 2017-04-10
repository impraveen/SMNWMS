package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Location;
import model.bean.Person;
import model.bean.UserRole;
import model.bean.Warehouse;
import model.dao.WarehouseDAO;

public class WarehouseDAOImpl implements WarehouseDAO<Warehouse>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Warehouse.class);

	@Override
	public void insert(Warehouse entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Warehouse entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Warehouse entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Warehouse findById(int id) {
		return (Warehouse) criteria.add(Restrictions.eq("id",id)).uniqueResult();
	}

	@Override
	public List<Warehouse> findAll() {
		return criteria.list();
	}

	@Override
	public List<Warehouse> findByCode(String code) {
		return  criteria.add(Restrictions.like("code", code, MatchMode.ANYWHERE)).list();
	}

	@Override
	public List<Warehouse> findByName(String name) {
		return  criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE)).list();
	}

	@Override
	public List<Warehouse> findByLocation(Location location) {
		return criteria.add(Restrictions.eq("location.id", location.getId())).list();
	}

	@Override
	public List<Warehouse> findByPerson(Person person) {
		return criteria.add(Restrictions.eq("person.id", person.getId())).list();
	}

}
