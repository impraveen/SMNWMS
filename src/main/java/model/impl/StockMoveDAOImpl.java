package model.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Person;
import model.bean.SalesItem;
import model.bean.StockMove;
import model.bean.StockMoveType;
import model.dao.StockMoveDAO;

public class StockMoveDAOImpl implements StockMoveDAO<StockMove>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(StockMove.class);

	@Override
	public void insert(StockMove entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(StockMove entity) {
		session.update(entity);
		transaction.commit();
	}

	@Override
	public void delete(StockMove entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public StockMove findById(int id) {
		return (StockMove) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<StockMove> findAll() {
		return criteria.list();
	}

	@Override
	public List<StockMove> findByDate(Date date) {
		return criteria.add(Restrictions.eq("date", date)).list();
	}

	@Override
	public List<StockMove> findByPerson(Person person) {
		return criteria.add(Restrictions.eq("person.id", person.getId())).list();
	}

	@Override
	public List<StockMove> findByQty(float qty) {
		return criteria.add(Restrictions.eq("qty", qty)).list();
	}

	@Override
	public List<StockMove> findByStockMoveType(StockMoveType moveType) {
		return criteria.add(Restrictions.eq("stockMove.id", moveType.getId())).list();
	}

	@Override
	public List<StockMove> findByRefrence(String refrence) {
		return  criteria.add(Restrictions.eq("refrence", refrence)).list();
	}

}
