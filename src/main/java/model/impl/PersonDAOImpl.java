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
import model.bean.Contract;
import model.bean.Country;
import model.bean.Job;
import model.bean.Person;
import model.bean.PersonType;
import model.dao.PersonDAO;

public class PersonDAOImpl implements PersonDAO<Person>{
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();
	Criteria criteria = session.createCriteria(Person.class);

	@Override
	public void insert(Person entity) {
		session.save(entity);
		transaction.commit();
		
	}

	@Override
	public void update(Person entity) {
		session.update(entity);
		transaction.commit();
		
	}

	@Override
	public void delete(Person entity) {
		session.delete(entity);
		transaction.commit();
		
	}

	@Override
	public Person findById(int id) {
		
		return (Person) criteria.add(Restrictions.eq("id",id)).uniqueResult();
	}

	@Override
	public List<Person> findAll() {
		
		return criteria.list();
	}

	@Override
	public List<Person> findByFirstName(String firstName) {
		
		return criteria.add(Restrictions.like("firstName", firstName, MatchMode.ANYWHERE)).list();
	}

	@Override
	public List<Person> findBySecondName(String secondName) {
		
		return criteria.add(Restrictions.like("secondName", secondName, MatchMode.ANYWHERE)).list();
		}

	@Override
	public List<Person> findByThirdName(String thirdName) {
		
		return criteria.add(Restrictions.like("thirdName", thirdName, MatchMode.ANYWHERE)).list();
		}

	@Override
	public List<Person> findByLastName(String lastName) {
		
		return criteria.add(Restrictions.like("lastName", lastName, MatchMode.ANYWHERE)).list();
		}

	@Override
	public List<Person> findByAddress(Address address) {
		
		return criteria.add(Restrictions.eq("address.id", address.getId())).list();	
		}

	@Override
	public List<Person> findByCountry(Country country) {
		
		return criteria.add(Restrictions.eq("country.id", country.getId())).list();	
		}

	@Override
	public List<Person> findByPerson(PersonType personType) {
		
		return criteria.add(Restrictions.eq("personType.id", personType.getId())).list();
		}

	@Override
	public List<Person> findByNationalId(int nationalId) {
		
		return criteria.add(Restrictions.eq("nationalId",nationalId )).list();
	}

	@Override
	public List<Person> findByEmail(String email) {
		
		return  criteria.add(Restrictions.eq("email",email)).list();
	}

	@Override
	public List<Person> findByMobileNumber(int mobileNumber) {
		
		return criteria.add(Restrictions.eq("mobileNumber",mobileNumber)).list();
	}

	@Override
	public List<Person> findByLandNumber(int landNumber) {
		
		return  criteria.add(Restrictions.eq("landNumber",landNumber)).list();
	}

	@Override
	public Person findByContract(Contract contract) {
		
		return (Person) criteria.add(Restrictions.eq("contract.id",contract.getId())).uniqueResult();
	}

}
