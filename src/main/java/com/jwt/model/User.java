/**
 * Hibernat persistance class maps to table User. 
 * 
 * @autor Leakhena Ellene SUON 
 * @version 1.0
 * @since 15-08-2017
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
@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = -3465813074586302847L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int usr_id;
	
	@Column
	private String usr_username;
	
	@Column
	private String usr_password;
	
	@Column
	private String usr_role;

	/** 
	 * Getter method to retrieve usr_id form table user.
	 * @return int usr_id 
	 */
	public int getUsr_id() {
		return usr_id;
	}
	/** 
	 * Setter method to set value to usr_id field of user table.
	 * @param      usr_id map to usr_id  field of user table.
	 * @return Nothing.
	 */
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}

	/**
	 * Getter method to retrieve usr_username from table user.
	 * @return string usr_username
	 */
	public String getUsr_username() {
		return usr_username;
	}

	/**
	 * Setter method to set value to usr_username field of user table.
	 * @param usr_username
	 * @return Nothing.
	 */
	public void setUsr_username(String usr_username) {
		this.usr_username = usr_username;
	}

	/**
	 * Getter method to retrieve usr_password from table user.
	 * @return int usr_username
	 */
	public String getUsr_password() {
		return usr_password;
	}
	
	/**
	 * Setter method to set value usr_password from table user.
	 * @param usr_password
	 * @return Nothing.
	 */
	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}
	
	/**
	 * Getter method to retrieve usr_role from table user.
	 * @return int usr_role
	 */
	public String getUsr_role() {
		return usr_role;
	}
	
	/**
	 * Setter method to set value usr_role from table user.
	 * @param usr_role
	 * @return Nothing.
	 */
	public void setUsr_role(String usr_role) {
		this.usr_role = usr_role;
	}
}
