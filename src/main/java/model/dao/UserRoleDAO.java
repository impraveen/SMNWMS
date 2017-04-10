package model.dao;

import java.util.List;

public interface UserRoleDAO<T> extends BaseDAO<T>{
	public List<T> findByTitle(String titel);

}
