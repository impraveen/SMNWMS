package model.dao;

import java.util.List;

public interface BaseDAO<T> {
		
	public void insert(T entity);
	public void update(T entity);
	public void delete(T entity);
	public T findById(int id);
	public List<T> findAll();
	
}
