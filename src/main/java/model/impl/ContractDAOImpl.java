package model.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import model.HibernateUtil;
import model.bean.City;
import model.bean.Contract;
import model.bean.ContractType;
import model.bean.Job;
import model.bean.Person;
import model.dao.ContractDAO;

public class ContractDAOImpl implements ContractDAO<Contract> {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Contract.class);

	@Override
	public void insert(Contract entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Contract entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Contract entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Contract findById(int id) {
		return (Contract) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Contract> findAll() {
		return criteria.list();
	}

	@Override
	public List<Contract> findByContractType(ContractType contractType) {
		return criteria.add(Restrictions.eq("contractType.id", contractType.getId())).list();
	}

	@Override
	public List<Contract> findByjob(Job job) {
		return criteria.add(Restrictions.eq("job.id", job.getId())).list();
	}

	@Override
	public List<Contract> findByStartDate(Date startDate) {
		return criteria.add(Restrictions.eq("startDate", startDate)).list();
	}

	@Override
	public List<Contract> findByEndDate(Date endDate) {
		return criteria.add(Restrictions.eq("endDate", endDate)).list();
	}

	@Override
	public List<Contract> findBySalary(float salary) {
		return criteria.add(Restrictions.eq("salary", salary)).list();
	}

	@Override
	public Contract findByPerson(Person person) {
		return (Contract) criteria.add(Restrictions.eq("person.id", person.getId())).uniqueResult();
	}

}
