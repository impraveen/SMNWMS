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
 * ContractType generated by hbm2java
 */
@Entity
@Table(name = "contract_type", catalog = "smndbwms")
public class ContractType implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private List<Contract> contracts = new ArrayList<Contract>();

	public ContractType() {
	}

	public ContractType(String title, List<Contract> contracts) {
		this.title = title;
		this.contracts = contracts;
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

	@Column(name = "title", length = 70)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contractType")
	public List<Contract> getContracts() {
		return this.contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	public String toString() {
		return "ContractType [id=" + id + ", " + (title != null ? "title=" + title + ", " : "")
				+ (contracts != null ? "contracts=" + contracts : "") + "]";
	}
	

}
