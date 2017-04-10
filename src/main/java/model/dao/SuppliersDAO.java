package model.dao;

import java.util.List;

import model.bean.Address;
import model.bean.Item;
import model.bean.Person;
import model.bean.Purchase;

public interface SuppliersDAO<T> extends BaseDAO<T>{
	
	public List<T> findByAddress(Address address);
	public List<T> findByItem(Item item);
	public List<T> findByPerson(Person person);
	public List<T> findByPurchases(Purchase purchase);
	
	public List<T> findByName(String name);

}
