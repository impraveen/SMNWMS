package model.dao;

import java.util.List;

import model.bean.City;
import model.bean.Country;

public interface AddressDAO<T> extends BaseDAO<T> {
	
	public List<T> findByDetails(String details);
	public List<T> findByCity(City city);
	public List<T> findByCountry(Country country);
	
}
