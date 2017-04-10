package model.dao;

import java.util.Date;
import java.util.List;

import model.bean.Person;
import model.bean.StockMoveType;

public interface StockMoveDAO<T> extends BaseDAO<T>{
	
	public List<T> findByDate(Date date);
	public List<T> findByPerson(Person person);
	public List<T> findByQty(float qty);
	public List<T> findByStockMoveType(StockMoveType moveType);
	
	public List<T> findByRefrence(String refrence);

}
