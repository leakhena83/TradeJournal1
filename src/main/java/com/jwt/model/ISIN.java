/**
 * Hibernat persistance class maps to table ISIN. 

 * 
 * @autor Leakhena Ellene SUON 
 * @version 1.0
 * @since 22-09-2017
 * 
 */
package com.jwt.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ISIN")
public class ISIN implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@Column(name = "isn_isin" , unique=true ,columnDefinition="VARCHAR(45)")
	private String isn_isin;
	
	@Column
	private String isn_securityname;

	@Column
	private String isn_currency;

	public String getIsn_isin() {
		return isn_isin;
	}

	
	public void setIsn_isin(String isn_isin) {
		this.isn_isin = isn_isin;
	}

	public String getIsn_securityname() {
		return isn_securityname;
	}

	public void setIsn_securityname(String isn_securityname) {
		this.isn_securityname = isn_securityname;
	}

	public String getIsn_currency() {
		return isn_currency;
	}

	public void setIsn_currency(String isn_currency) {
		this.isn_currency = isn_currency;
	}
	
}