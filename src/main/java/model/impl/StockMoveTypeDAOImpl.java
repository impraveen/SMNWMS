package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.StockMove;
import model.bean.StockMoveType;
import model.dao.StockMoveTypeDAO;

public class StockMoveTypeDAOImpl implements StockMoveTypeDAO<StockMoveType>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(StockMoveType.class);

	@Override
	public void insert(StockMoveType entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(StockMoveType entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(StockMoveType entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public StockMoveType findById(int id) {
		return (StockMoveType) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<StockMoveType> findAll() {
		return criteria.list();
		
	}

	@Override
	public List<StockMoveType> findByName(String name) {
		return criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE)).list();
	}

}
