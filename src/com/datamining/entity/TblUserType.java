package com.datamining.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usertype")
public class TblUserType implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user_type_id")
	private Integer userTypeId;
	
	@Column(name="user_type_name")
	private String userTypeName;
	
	public TblUserType() {
		
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

}
