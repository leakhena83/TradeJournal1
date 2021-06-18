/**
 * Hibernat persistance class maps to table Order Entry. 

 * 
 * @autor Leakhena Ellene SUON 
 * @version 1.0
 * @since 17-11-2017
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
@Table(name = "Statistic_Client_Data")
public class StatisticClientData implements Serializable {
	
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scd_id;
	
	@Column(nullable = false)
	private int usr_id;
	
	@Column
	private String scd_firstname;

	@Column
	private String scd_lastname;

	@Temporal(TemporalType.DATE)
	@Column
	private java.util.Date scd_birthday;

	@Column
	private String scd_nationality;
	
	@Column
	private String scd_country_domicile ;
	
	@Column
	private String scd_address;
	
	@Column
	private String scd_business_phone ;
	
	@Column
	private String scd_mobilephone ;
	
	@Column
	private String scd_homephone ;
	
	@Column
	private String scd_email ;
	
	@Column
	private String scd_accountnumber ;
	
	@Column
	private String scd_custodianbank ;
	
	@Column
	private String scd_others ;
	
	//Getter and Setter Method
	
	public int getScd_id() {
		return scd_id;
	}

	public void setScd_id(int scd_id) {
		this.scd_id = scd_id;
	}

	public int getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}

	public String getScd_firstname() {
		return scd_firstname;
	}

	public void setScd_firstname(String scd_firstname) {
		this.scd_firstname = scd_firstname;
	}

	public String getScd_lastname() {
		return scd_lastname;
	}

	public void setScd_lastname(String scd_lastname) {
		this.scd_lastname = scd_lastname;
	}

	public java.util.Date getScd_birthday() {
		return scd_birthday;
	}

	public void setScd_birthday(java.util.Date scd_birthday) {
		this.scd_birthday = scd_birthday;
	}

	public String getScd_nationality() {
		return scd_nationality;
	}

	public void setScd_nationality(String scd_nationality) {
		this.scd_nationality = scd_nationality;
	}

	public String getScd_country_domicile() {
		return scd_country_domicile;
	}

	public void setScd_country_domicile(String scd_country_domicile) {
		this.scd_country_domicile = scd_country_domicile;
	}

	public String getScd_address() {
		return scd_address;
	}

	public void setScd_address(String scd_address) {
		this.scd_address = scd_address;
	}

	public String getScd_business_phone() {
		return scd_business_phone;
	}

	public void setScd_business_phone(String scd_business_phone) {
		this.scd_business_phone = scd_business_phone;
	}

	public String getScd_mobilephone() {
		return scd_mobilephone;
	}

	public void setScd_mobilephone(String scd_mobilephone) {
		this.scd_mobilephone = scd_mobilephone;
	}

	public String getScd_homephone() {
		return scd_homephone;
	}

	public void setScd_homephone(String scd_homephone) {
		this.scd_homephone = scd_homephone;
	}

	public String getScd_email() {
		return scd_email;
	}

	public void setScd_email(String scd_email) {
		this.scd_email = scd_email;
	}

	public String getScd_accountnumber() {
		return scd_accountnumber;
	}

	public void setScd_accountnumber(String scd_accountnumber) {
		this.scd_accountnumber = scd_accountnumber;
	}

	public String getScd_custodianbank() {
		return scd_custodianbank;
	}

	public void setScd_custodianbank(String scd_custodianbank) {
		this.scd_custodianbank = scd_custodianbank;
	}

	public String getScd_others() {
		return scd_others;
	}

	public void setScd_others(String scd_others) {
		this.scd_others = scd_others;
	}
	
}