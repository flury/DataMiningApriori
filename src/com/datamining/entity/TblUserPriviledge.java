package com.datamining.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="userpriviledge")
public class TblUserPriviledge implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user_priviledge_id")
	private String userPriviledgeId;
	
	@Column(name="usertype")
	private Integer userType;
	
	@ManyToOne
	@JoinColumn(name="command_id")
	private TblUserCommand tblUserCommand;
	
	@Column(name="authorized")
	private Boolean authorized;
	
	public TblUserPriviledge() {
		
	}

	public String getUserPriviledgeId() {
		return userPriviledgeId;
	}

	public void setUserPriviledgeId(String userPriviledgeId) {
		this.userPriviledgeId = userPriviledgeId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public TblUserCommand getTblUserCommand() {
		return tblUserCommand;
	}

	public void setTblUserCommand(TblUserCommand tblUserCommand) {
		this.tblUserCommand = tblUserCommand;
	}

	public Boolean getAuthorized() {
		return authorized;
	}

	public void setAuthorized(Boolean authorized) {
		this.authorized = authorized;
	}

}
