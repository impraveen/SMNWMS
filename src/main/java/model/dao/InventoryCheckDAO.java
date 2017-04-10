package model.dao;

import java.util.Date;
import java.util.List;

import model.bean.Item;
import model.bean.Person;

public interface InventoryCheckDAO<T> extends BaseDAO<T>{
	public List<T> findByActualQty(float actualQty);
	public List<T> findByCurrentQTY(float currentQty);
	public List<T> findByDate(Date date);
	public List<T> findByDiffQty(float diffQty);
	public List<T> findByItem(Item item);
	public List<T> findByLastQty(float lastQty);
	public List<T> findByPerson(Person person);
	

}
