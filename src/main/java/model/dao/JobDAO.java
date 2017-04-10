package model.dao;

import java.util.List;

public interface JobDAO<T> extends BaseDAO<T>{
	public List<T> findByTitle(String name);
	

}
