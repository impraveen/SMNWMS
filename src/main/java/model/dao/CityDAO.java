package model.dao;

import java.util.List;

public interface CityDAO<T> extends BaseDAO<T> {
	
	public List<T> findByCode(String code);
	public List<T> findByName(String name);

}
