package model.bean;
// Generated Mar 30, 2017 11:46:21 AM by Hibernate Tools 5.2.1.Final

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
 * SalesItem generated by hbm2java
 */
@Entity
@Table(name = "sales_item", catalog = "smndbwms")
public class SalesItem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Item item;
	private Sales sales;
	private Date date;
	private float qty;
	private String refrence;

	public SalesItem() {
	}

	public SalesItem(Item item, Sales sales, Date date, float qty, String refrence) {
		this.item = item;
		this.sales = sales;
		this.date = date;
		this.qty = qty;
		this.refrence = refrence;
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
	@JoinColumn(name = "item_id")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sales_id")
	public Sales getSales() {
		return this.sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "qty", precision = 12, scale = 0)
	public float getQty() {
		return this.qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	@Column(name = "refrence", length = 45)
	public String getRefrence() {
		return this.refrence;
	}

	public void setRefrence(String refrence) {
		this.refrence = refrence;
	}

	@Override
	public String toString() {
		return "SalesItem [id=" + id + ", " + (item != null ? "item=" + item + ", " : "")
				+ (sales != null ? "sales=" + sales + ", " : "") + (date != null ? "date=" + date + ", " : "") + "qty="
				+ qty + ", " + (refrence != null ? "refrence=" + refrence : "") + "]";
	}
	

}