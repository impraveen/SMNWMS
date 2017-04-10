package model.dao;

import java.util.List;

import model.bean.Supplier;
import model.bean.Unit;
import model.bean.Warehouse;

public interface ItemDAO<T> extends BaseDAO<T>{
	public List<T> findByCode(String code);
	public T findByGenCode(String genCode);
	public List<T> findByName(String name);
	public List<T> findByProperties(String properties);
	public List<T> findByQty(float qty);
	public List<T> findBySalePrice(float salePrice);
	public List<T> findBySize(float size);
	public List<T> findBySupplier(Supplier supplier);
	public List<T> findByUnit(Unit unit);
	public List<T> findByWarehouse(Warehouse warehouse);
}
