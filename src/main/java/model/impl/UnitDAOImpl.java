package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Supplier;
import model.bean.Unit;
import model.dao.UnitDAO;

public class UnitDAOImpl implements UnitDAO<Unit>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Unit.class);

	@Override
	public void insert(Unit entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Unit entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Unit entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Unit findById(int id) {
		return (Unit) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Unit> findAll() {
		return criteria.list();
	}

	@Override
	public List<Unit> findByName(String name) {
		return criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE)).list();
	}

	@Override
	public List<Unit> findByMiniUnit(float miniUnit) {
		return criteria.add(Restrictions.eq("miniUnit", miniUnit)).list();
	}

	@Override
	public List<Unit> findByMiniUnitName(String miniUnitName) {
		return criteria.add(Restrictions.like("miniUnitName", miniUnitName, MatchMode.ANYWHERE)).list();
	}

}
