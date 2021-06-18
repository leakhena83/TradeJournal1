/**
 * Hibernat persistance class maps to table Custodian_Bank_Data. 
 * 
 * @autor Leakhena Ellene SUON 
 * @version 1.0
 * @since 26-10-2017
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
@Table(name = "Custodian_Bank_Data")
public class CustodianBank implements Serializable {
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cbd_id;

	@Column
	private String cbd_isin;

	@Column
	private double cbd_amount;
	
	@Temporal(TemporalType.DATE)
	@Column
	private java.util.Date cbd_tradDate;
	
	@Temporal(TemporalType.DATE)
	@Column
	private java.util.Date cbd_valueDate;
	
	@Column
	private String cbd_clientID ;
	
	@Column
	private String cbd_message;
	
	
	//Generate Getetr and Setter Method
	public int getCbd_id() {
		return cbd_id;
	}

	public String getCbd_isin() {
		return cbd_isin;
	}

	public void setCbd_isin(String cbd_isin) {
		this.cbd_isin = cbd_isin;
	}
	
	public void setCbd_id(int cbd_id) {
		this.cbd_id = cbd_id;
	}

	public double getCbd_amount() {
		return cbd_amount;
	}

	public void setCbd_amount(double cbd_amount) {
		this.cbd_amount = cbd_amount;
	}

	public String getCbd_clientID() {
		return cbd_clientID;
	}

	public void setCbd_clientID(String cbd_clientID) {
		this.cbd_clientID = cbd_clientID;
	}

	public String getCbd_message() {
		return cbd_message;
	}

	public void setCbd_message(String cbd_message) {
		this.cbd_message = cbd_message;
	}
	
	public java.util.Date getCbd_tradDate() {
		return cbd_tradDate;
	}

	public void setCbd_tradDate(java.util.Date cbd_tradDate) {
		this.cbd_tradDate = cbd_tradDate;
	}

	public java.util.Date getCbd_valueDate() {
		return cbd_valueDate;
	}

	public void setCbd_valueDate(java.util.Date cbd_valueDate) {
		this.cbd_valueDate = cbd_valueDate;
	}
	
}