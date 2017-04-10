package model.dao;

import java.util.List;

import model.bean.Person;

public interface CustomerDAO<T> extends BaseDAO<T>{
	
	public List<T> findByName(String name);
	public T findByPerson(Person person);
	public List<T> findByIsCompany(String comp);
	public List<T> findByEmail(String email);
	public T findByMobileNumber(int mobileNumber);
	public T finddByLandNumber(int landMobile);
	
	

}
