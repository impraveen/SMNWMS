package model.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import model.HibernateUtil;
import model.bean.Address;
import model.bean.City;
import model.bean.Country;
import model.dao.AddressDAO;

public class AddressDAOImpl implements AddressDAO<Address> {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Address.class);


	@Override
	public void insert(Address entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Address entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Address entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Address findById(int id) {
		return (Address) criteria.add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Address> findAll() {
		return criteria.list();
	}

	@Override
	public List<Address> findByCity(City city) {
		return criteria.add(Restrictions.eq("city.id", city.getId())).list();
	}

	@Override
	public List<Address> findByCountry(Country country) {
		return  criteria.add(Restrictions.eq("country.id", country.getId())).list();
	}

	@Override
	public List<Address> findByDetails(String details) {
		return  criteria.add(Restrictions.like("details", details, MatchMode.ANYWHERE)).list();
	}
	

}
