package model.dao;

import java.util.List;

import model.bean.Address;
import model.bean.Contract;
import model.bean.Country;
import model.bean.PersonType;

public interface PersonDAO<T> extends BaseDAO<T>{
	public List<T> findByFirstName(String firstName);
	public List<T> findBySecondName(String secondName);
	public List<T> findByThirdName(String thirdName);
	public List<T> findByLastName(String lastName);
	public List<T> findByAddress(Address address);
	public List<T> findByCountry(Country country);
	public List<T> findByPerson(PersonType personType);
	
	
	public List<T> findByNationalId(int nationalId);
	public List<T> findByEmail(String email);
	public List<T> findByMobileNumber(int mobileNumber);
	public List<T> findByLandNumber(int landNumber);
	public T findByContract(Contract contract);
	
	
	

}
