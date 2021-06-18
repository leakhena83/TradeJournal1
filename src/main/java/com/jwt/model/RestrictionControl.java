/**
 * Hibernat persistance class maps to table Registration Control System. 
 * 
 * @autor Leakhena Ellene SUON 
 * @version 1.0
 * @since 10-10-2017
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
@Table(name = "Registration_Control_System")
public class RestrictionControl implements Serializable {
	private static final long serialVersionUID = -3465813074586302847L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rcs_id;
	@Column
	private String rcs_oderentryname;
	@Column
	private float rcs_actual;
	@Column
	private float rcs_min;
	@Column
	private float rcs_neutral;
	@Column
	private float rcs_max;
	@Column
	private float rcs_vsneutral;
	@Column
	private float rcs_vsmin;
	@Column
	private float rcs_vsmax;
	@Column
	private java.util.Date rcs_date;
	@Column
	private String rcs_message;
	
	private String date;
	
	//Getter and Setter Method 
	public int getRcs_id() {
		return rcs_id;
	}
	public void setRcs_id(int rcs_id) {
		this.rcs_id = rcs_id;
	}
	public String getRcs_oderentryname() {
		return rcs_oderentryname;
	}
	public void setRcs_oderentryname(String rcs_oderentryname) {
		this.rcs_oderentryname = rcs_oderentryname;
	}
	public float getRcs_actual() {
		return rcs_actual;
	}
	public void setRcs_actual(float rcs_actual) {
		this.rcs_actual = rcs_actual;
	}
	public float getRcs_min() {
		return rcs_min;
	}
	public void setRcs_min(float rcs_min) {
		this.rcs_min = rcs_min;
	}
	public float getRcs_neutral() {
		return rcs_neutral;
	}
	public void setRcs_neutral(float rcs_neutral) {
		this.rcs_neutral = rcs_neutral;
	}
	public float getRcs_max() {
		return rcs_max;
	}
	public void setRcs_max(float rcs_max) {
		this.rcs_max = rcs_max;
	}
	public float getRcs_vsneutral() {
		return rcs_vsneutral;
	}
	public void setRcs_vsneutral(float rcs_vsneutral) {
		this.rcs_vsneutral = rcs_vsneutral;
	}
	public float getRcs_vsmin() {
		return rcs_vsmin;
	}
	public void setRcs_vsmin(float rcs_vsmin) {
		this.rcs_vsmin = rcs_vsmin;
	}
	public float getRcs_vsmax() {
		return rcs_vsmax;
	}
	public void setRcs_vsmax(float rcs_vsmax) {
		this.rcs_vsmax = rcs_vsmax;
	}
	public java.util.Date getRcs_date() {
		return rcs_date;
	}
	public void setRcs_date(java.util.Date rcs_date) {
		this.rcs_date = rcs_date;
	}
	public String getRcs_message() {
		return rcs_message;
	}
	public void setRcs_message(String rcs_message) {
		this.rcs_message = rcs_message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}