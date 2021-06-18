/**
 * Hibernat persistance class maps to table Order Entry. 

 * 
 * @autor Leakhena Ellene SUON 
 * @version 1.0
 * @since 18-08-2017
 * 
 */
package com.jwt.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Order_Entry")
public class OrderEntry implements Serializable {
	
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ode_id;
	
	@Column(nullable = true)
	private String isn_isin;
	
	@Column
	private String ode_firstname;

	@Column
	private String ode_lastname;

	@Column
	private String ode_userid;

	@Column
	private String ode_bank;
	
	@Temporal(TemporalType.DATE)
	@Column
	private java.util.Date ode_traddate;
	
	@Column
	private String ode_action ;
	
	@Column
	private double ode_amount ;
	
	@Temporal(TemporalType.DATE)
	@Column
	private java.util.Date ode_valuedate ;
	
	@Column
	private String ode_limit ;
	
	@Column
	private String ode_stoploss ;
	
	@Temporal(TemporalType.DATE)
	@Column
	private java.util.Date ode_validdate ;
	
	@Column
	private String ode_clientID ;
	
	@Column
	private String ode_clientinstruction ;
	
	@Column
	private String ode_clientdetailmedium ;
	
	@Column
	private String ode_callbacktel ;
	
	@Column
	private String ode_callbacktime ;
	
	@Column
	private String ode_mediumbank ;
	
	@Column
	private String ode_bankdetailmedium ;
	
	@Column
	private String ode_rational ;
	
	@Column
	private String ode_remark ;
	
	@Temporal(TemporalType.DATE)
	@Column
	private java.util.Date ode_dateexecution ;
	
	@Column
	private String ode_quantity;
	
	@Column
	private String ode_price;
	
	@Column
	private String ode_totalcurrency;
	
	@Column
	private String ode_checked;
	
	private String vludate;
	
	//Getter and Setter Method
	
	public int getOde_id() {
		return ode_id;
	}
	
	public void setOde_id(int ode_id) {
		this.ode_id = ode_id;
	}
	
	public String getIsn_isin() {
		return isn_isin;
	}

	public void setIsn_isin(String isn_isin) {
		this.isn_isin = isn_isin;
	}
	
	public String getOde_firstname() {
		return ode_firstname;
	}

	public void setOde_firstname(String ode_firstname) {
		this.ode_firstname = ode_firstname;
	}

	public String getOde_lastname() {
		return ode_lastname;
	}

	public void setOde_lastname(String ode_lastname) {
		this.ode_lastname = ode_lastname;
	}

	public String getOde_userid() {
		return ode_userid;
	}

	public void setOde_userid(String ode_userid) {
		this.ode_userid = ode_userid;
	}

	public String getOde_bank() {
		return ode_bank;
	}

	public void setOde_bank(String ode_bank) {
		this.ode_bank = ode_bank;
	}

	public java.util.Date getOde_traddate() {
		return ode_traddate;
	}

	public void setOde_traddate(java.util.Date ode_traddate) {
		this.ode_traddate = ode_traddate;
	}

	public String getOde_action() {
		return ode_action;
	}

	public void setOde_action(String ode_action) {
		this.ode_action = ode_action;
	}

	public double getOde_amount() {
		return ode_amount;
	}

	public void setOde_amount(double ode_amount) {
		this.ode_amount = ode_amount;
	}

	public java.util.Date getOde_valuedate() {
		return ode_valuedate;
	}

	public void setOde_valuedate(java.util.Date ode_valuedate) {
		this.ode_valuedate = ode_valuedate;
	}

	public String getOde_limit() {
		return ode_limit;
	}

	public void setOde_limit(String ode_limit) {
		this.ode_limit = ode_limit;
	}

	public String getOde_stoploss() {
		return ode_stoploss;
	}

	public void setOde_stoploss(String ode_stoploss) {
		this.ode_stoploss = ode_stoploss;
	}

	public java.util.Date getOde_validdate() {
		return ode_validdate;
	}

	public void setOde_validdate(java.util.Date ode_validdate) {
		this.ode_validdate = ode_validdate;
	}
	
	public String getOde_clientID() {
		return ode_clientID;
	}

	public void setOde_clientID(String ode_clientID) {
		this.ode_clientID = ode_clientID;
	}

	public String getOde_clientinstruction() {
		return ode_clientinstruction;
	}

	public void setOde_clientinstruction(String ode_clientinstruction) {
		this.ode_clientinstruction = ode_clientinstruction;
	}

	public String getOde_clientdetailmedium() {
		return ode_clientdetailmedium;
	}

	public void setOde_clientdetailmedium(String ode_clientdetailmedium) {
		this.ode_clientdetailmedium = ode_clientdetailmedium;
	}

	public String getOde_callbacktel() {
		return ode_callbacktel;
	}

	public void setOde_callbacktel(String ode_callbacktel) {
		this.ode_callbacktel = ode_callbacktel;
	}

	public String getOde_callbacktime() {
		return ode_callbacktime;
	}

	public void setOde_callbacktime(String ode_callbacktime) {
		this.ode_callbacktime = ode_callbacktime;
	}

	public String getOde_mediumbank() {
		return ode_mediumbank;
	}

	public void setOde_mediumbank(String ode_mediumbank) {
		this.ode_mediumbank = ode_mediumbank;
	}

	public String getOde_bankdetailmedium() {
		return ode_bankdetailmedium;
	}

	public void setOde_bankdetailmedium(String ode_bankdetailmedium) {
		this.ode_bankdetailmedium = ode_bankdetailmedium;
	}

	public String getOde_rational() {
		return ode_rational;
	}

	public void setOde_rational(String ode_rational) {
		this.ode_rational = ode_rational;
	}

	public String getOde_remark() {
		return ode_remark;
	}

	public void setOde_remark(String ode_remark) {
		this.ode_remark = ode_remark;
	}

	public java.util.Date getOde_dateexecution() {
		return ode_dateexecution;
	}

	public void setOde_dateexecution(java.util.Date date) {
		this.ode_dateexecution = date;
	}

	public String getOde_quantity() {
		return ode_quantity;
	}

	public void setOde_quantity(String ode_quantity) {
		this.ode_quantity = ode_quantity;
	}

	public String getOde_price() {
		return ode_price;
	}

	public void setOde_price(String ode_price) {
		this.ode_price = ode_price;
	}

	public String getOde_totalcurrency() {
		return ode_totalcurrency;
	}

	public void setOde_totalcurrency(String ode_totalcurrency) {
		this.ode_totalcurrency = ode_totalcurrency;
	}

	public String getOde_checked() {
		return ode_checked;
	}

	public void setOde_checked(String ode_checked) {
		this.ode_checked = ode_checked;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getVludate() {
		return vludate;
	}

	public void setVludate(String vludate) {
		this.vludate = vludate;
	}
	
}