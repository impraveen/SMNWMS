package model.dao;

import java.util.List;

public interface StockMoveTypeDAO<T> extends BaseDAO<T>{
	public List<T> findByName(String name);

}
