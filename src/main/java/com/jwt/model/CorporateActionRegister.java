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

@Entity
@Table(name = "Corporate_Action_Register")
public class CorporateActionRegister implements Serializable {
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int car_id;
	
	

	@Column
	private String car_payment_devidend;
	
	@Column
	private double car_payment_coupon;
	
	@Column
	private double car_maturity_bound ;
	
	@Column
	private double car_call_bound ;
	
	@Column
	private double car_exercise_option;
	
	@Column
	private double car_expiry_option ;
	
	@Column
	private double car_stock_split ;
	
	@Column
	private double car_return_capital ;
	
	@Column
	private double car_increase_capital ;
	
	@Column
	private String car_delisting ;
	
	@Column
	private double car_new_listing ;
	
	// Generate Getter and Setter 
	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getCar_payment_devidend() {
		return car_payment_devidend;
	}

	public void setCar_payment_devidend(String car_payment_devidend) {
		this.car_payment_devidend = car_payment_devidend;
	}

	public double getCar_payment_coupon() {
		return car_payment_coupon;
	}

	public void setCar_payment_coupon(double car_payment_coupon) {
		this.car_payment_coupon = car_payment_coupon;
	}

	public double getCar_maturity_bound() {
		return car_maturity_bound;
	}

	public void setCar_maturity_bound(double car_maturity_bound) {
		this.car_maturity_bound = car_maturity_bound;
	}

	public double getCar_call_bound() {
		return car_call_bound;
	}

	public void setCar_call_bound(double car_call_bound) {
		this.car_call_bound = car_call_bound;
	}

	public double getCar_exercise_option() {
		return car_exercise_option;
	}

	public void setCar_exercise_option(double car_exercise_option) {
		this.car_exercise_option = car_exercise_option;
	}

	public double getCar_expiry_option() {
		return car_expiry_option;
	}

	public void setCar_expiry_option(double car_expiry_option) {
		this.car_expiry_option = car_expiry_option;
	}

	public double getCar_stock_split() {
		return car_stock_split;
	}

	public void setCar_stock_split(double car_stock_split) {
		this.car_stock_split = car_stock_split;
	}

	public double getCar_return_capital() {
		return car_return_capital;
	}

	public void setCar_return_capital(double car_return_capital) {
		this.car_return_capital = car_return_capital;
	}

	public double getCar_increase_capital() {
		return car_increase_capital;
	}

	public void setCar_increase_capital(double car_increase_capital) {
		this.car_increase_capital = car_increase_capital;
	}

	public String getCar_delisting() {
		return car_delisting;
	}

	public void setCar_delisting(String car_delisting) {
		this.car_delisting = car_delisting;
	}

	public double getCar_new_listing() {
		return car_new_listing;
	}

	public void setCar_new_listing(double car_new_listing) {
		this.car_new_listing = car_new_listing;
	}
}