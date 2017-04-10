package model.dao;

import java.util.List;

public interface PersonTypeDAO<T> extends BaseDAO<T>{
	public List<T> findByTitle(String title);

}
