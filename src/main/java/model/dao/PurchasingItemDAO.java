package model.dao;

import java.util.Date;
import java.util.List;

import model.bean.Item;
import model.bean.Purchase;

public interface PurchasingItemDAO<T> extends BaseDAO<T>{
	
	public List<T> findByCostPrice(float costPrice);
	public List<T> findByDate(Date date);
	public List<T> findByPurchse(Purchase purchase);
	public List<T> findByQty(float qty);
	
	public List<T> findByRefrence(String refrence);
	public T findByItem(Item item);
	
	

}
