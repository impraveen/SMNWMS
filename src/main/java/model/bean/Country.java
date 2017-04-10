package model.bean;
// Generated Mar 29, 2017 7:51:05 AM by Hibernate Tools 5.2.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", catalog = "smndbwms")
public class Country implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String code;
	private List<Person> persons = new ArrayList<Person>();
	private List<City> cities = new ArrayList<City>();
	private List<Address> addresses = new ArrayList<Address>();

	public Country() {
	}

	public Country(String name, String code, List<Person> persons, List<City> cities, List<Address> addresses) {
		this.name = name;
		this.code = code;
		this.persons = persons;
		this.cities = cities;
		this.addresses = addresses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

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

	@Column(name = "code", length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (code != null ? "code=" + code + ", " : "") + (persons != null ? "persons=" + persons + ", " : "")
				+ (cities != null ? "cities=" + cities + ", " : "")
				+ (addresses != null ? "addresses=" + addresses : "") + "]";
	}
	

}
