package model.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.Contract;
import model.bean.ContractType;
import model.dao.ContractTypeDAO;

public class ContractTypeDAOImpl implements ContractTypeDAO<ContractType>{

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(ContractType.class);
	
	@Override
	public void insert(ContractType entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(ContractType entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(ContractType entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public ContractType findById(int id) {
		return (ContractType) criteria.add(Restrictions.eq("id", id)).list();
	}

	@Override
	public List<ContractType> findAll() {
		return criteria.list();
	}

	@Override
	public List<ContractType> findByTitle(String titel) {
		return criteria.add(Restrictions.like("title", titel, MatchMode.ANYWHERE)).list();
	}
	

}
