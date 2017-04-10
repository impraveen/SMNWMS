package model.dao;

import java.util.List;

import model.bean.Location;
import model.bean.Person;

public interface WarehouseDAO<T> extends BaseDAO<T> {
	
	public List<T> findByCode(String code);
	public List<T> findByName(String name);
	
	public List<T> findByLocation(Location location);
	public List<T> findByPerson(Person person);
	

}
