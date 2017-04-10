package model.dao;

import java.util.List;

import model.bean.City;

public interface LocationDAO<T> extends BaseDAO<T>{
	public List<T> finByName(String name);
	public List<T> findByCity(City city);

}
