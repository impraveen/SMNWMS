package model.dao;

import java.util.Date;
import java.util.List;

import model.bean.ContractType;
import model.bean.Job;
import model.bean.Person;

public interface ContractDAO<T> extends BaseDAO<T> {
	
	public List<T> findByContractType(ContractType contractType);
	public List<T> findByjob(Job job);
	public List<T> findByStartDate(Date startDate);
	public List<T> findByEndDate(Date endDate);
	public List<T> findBySalary(float salary);
	public T findByPerson(Person person);

}
