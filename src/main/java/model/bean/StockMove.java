package model.bean;
// Generated Mar 29, 2017 7:51:05 AM by Hibernate Tools 5.2.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StockMove generated by hbm2java
 */
@Entity
@Table(name = "stock_move", catalog = "smndbwms")
public class StockMove implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Person person;
	private StockMoveType stockMoveType;
	private Date date;
	private int refrence;
	private int qty;

	public StockMove() {
	}

	public StockMove(Person person, StockMoveType stockMoveType, Date date, int refrence, int qty) {
		this.person = person;
		this.stockMoveType = stockMoveType;
		this.date = date;
		this.refrence = refrence;
		this.qty = qty;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "move_by_id")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	public StockMoveType getStockMoveType() {
		return this.stockMoveType;
	}

	public void setStockMoveType(StockMoveType stockMoveType) {
		this.stockMoveType = stockMoveType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "refrence")
	public int getRefrence() {
		return this.refrence;
	}

	public void setRefrence(int refrence) {
		this.refrence = refrence;
	}

	@Column(name = "qty")
	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "StockMove [id=" + id + ", " + (person != null ? "person=" + person + ", " : "")
				+ (stockMoveType != null ? "stockMoveType=" + stockMoveType + ", " : "")
				+ (date != null ? "date=" + date + ", " : "") + "refrence=" + refrence + ", qty=" + qty + "]";
	}
	

}
