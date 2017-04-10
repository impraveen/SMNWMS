package model.dao;

import java.util.Date;
import java.util.List;

import model.bean.Item;
import model.bean.Sales;

public interface SalesItemDAO<T> extends BaseDAO<T>{
	
	public List<T> findByDate(Date date);
	public List<T> findByItem(Item item);
	public List<T> findByQty(float qty);
	public List<T> findBySales(Sales sales);
	
	public List<T> findByRefrence(String refrence);

}
