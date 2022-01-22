package com.datamining.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class TblUser implements Serializable {

	public static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="user_id", unique = true, nullable = false)
	private String userId;
	
	@ManyToOne
	@JoinColumn(name="usertype")
	private TblUserType tblUserType;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="wrong_password")
	private Integer wrongPassword;
	
	@Column(name="is_account_lock")
	private Boolean isAccountLock;
	
	@Column(name="status_user")
	private Boolean statusUser;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String genderUser;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="change_password")
	private Date changePassword;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login")
	private Date lastLogin;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email_user")
	private String emailUser;
	
	@Column(name="update_user")
	private String updateUser;
	
	@Column(name="update_date")
	private Date updateDate;
	
	@Column(name="create_user")
	private String createUser;
	
	@Column(name="create_date")
	private Date createDate;
	
	public TblUser() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public TblUserType getTblUserType() {
		return tblUserType;
	}

	public void setTblUserType(TblUserType tblUserType) {
		this.tblUserType = tblUserType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getWrongPassword() {
		return wrongPassword;
	}

	public void setWrongPassword(Integer wrongPassword) {
		this.wrongPassword = wrongPassword;
	}

	public Boolean getIsAccountLock() {
		return isAccountLock;
	}

	public void setIsAccountLock(Boolean isAccountLock) {
		this.isAccountLock = isAccountLock;
	}

	public Boolean getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(Boolean statusUser) {
		this.statusUser = statusUser;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGenderUser() {
		return genderUser;
	}

	public void setGenderUser(String genderUser) {
		this.genderUser = genderUser;
	}

	public Date getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(Date changePassword) {
		this.changePassword = changePassword;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
