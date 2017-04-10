package model.dao;

import java.util.Date;
import java.util.List;

import model.bean.Customer;
import model.bean.Person;

public interface SalesDAO<T> extends BaseDAO<T>{
	
	public List<T> findByCustomer(Customer customer);
	public List<T> findByDate(Date date);
	public List<T> findByPerson(Person person);
	public List<T> findByTotalPrice(float totalPrice);
	
	public List<T> findByRefrence(String refrence);
}
