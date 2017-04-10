package model.dao;

import java.util.List;

public interface CountryDAO<T> extends BaseDAO<T>{
	public List<T> findByName(String name);
	public List<T> findByCode(String code);

}
