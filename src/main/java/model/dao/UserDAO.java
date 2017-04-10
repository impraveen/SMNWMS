package model.dao;

import java.util.List;

import model.bean.Person;
import model.bean.UserRole;

public interface UserDAO<T> extends BaseDAO<T>{
	public T findByPerson(Person person);
	public T findByUsername(String username);
	public List<T> findByRole(UserRole role);

}
