package model.bean;
// Generated Mar 29, 2017 7:51:05 AM by Hibernate Tools 5.2.1.Final

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Unit generated by hbm2java
 */
@Entity
@Table(name = "unit", catalog = "smndbwms")
public class Unit implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private float miniUnit;
	private String miniUnitName;
	private List<Item> items = new ArrayList<Item>();

	public Unit() {
	}

	public Unit(int id) {
		this.id = id;
	}

	public Unit(int id, String name, float miniUnit, String miniUnitName, List<Item> items) {
		this.id = id;
		this.name = name;
		this.miniUnit = miniUnit;
		this.miniUnitName = miniUnitName;
		this.items = items;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "mini_unit", precision = 12, scale = 0)
	public float getMiniUnit() {
		return this.miniUnit;
	}

	public void setMiniUnit(float miniUnit) {
		this.miniUnit = miniUnit;
	}

	@Column(name = "mini_unit_name", length = 45)
	public String getMiniUnitName() {
		return this.miniUnitName;
	}

	public void setMiniUnitName(String miniUnitName) {
		this.miniUnitName = miniUnitName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "unit")
	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Unit [id=" + id + ", " + (name != null ? "name=" + name + ", " : "") + "miniUnit=" + miniUnit + ", "
				+ (miniUnitName != null ? "miniUnitName=" + miniUnitName + ", " : "")
				+ (items != null ? "items=" + items : "") + "]";
	}
	

}