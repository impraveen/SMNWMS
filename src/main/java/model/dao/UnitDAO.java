package model.dao;

import java.util.List;

public interface UnitDAO<T> extends BaseDAO<T>{
	public List<T> findByName(String name);
	public List<T> findByMiniUnit(float miniUnit);
	public List<T> findByMiniUnitName(String miniUnitName);
	

}
