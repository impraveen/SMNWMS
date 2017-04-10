package model.dao;

import java.util.Date;
import java.util.List;

import model.bean.Person;
import model.bean.Supplier;

public interface PurchaseDAO<T> extends BaseDAO<T>{
	public List<T> findByDate(Date date);
	public List<T> findByPerson(Person person);
	public List<T> findBySupplier(Supplier supplier);
	public List<T> findByTotalCost(float totalCost);
	
	public List<T> findByRefrence(String refrence);
	

}
