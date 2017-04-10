package model.dao;

import java.util.List;

public interface ContractTypeDAO<T> extends BaseDAO<T> {
	 
	public List<T> findByTitle(String titel);

}
