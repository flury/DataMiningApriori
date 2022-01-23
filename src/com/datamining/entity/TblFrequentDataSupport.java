package com.datamining.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="frequent_data_support")
public class TblFrequentDataSupport {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="id", unique = true, nullable = false)
	private String id;
	
	@Column(name="frequent_data_id")
	private String frequentDataId;
	
	@Column(name="itemset_number")
	private Integer itemsetNumber;
	
	@Column(name="candidate")
	private String candidate;
	
	@Column(name="support")
	private Double support;
	
	@Column(name="execute_date")
	private Date executeDate;
	
	@Column(name="execute_user")
	private String executeUser;
	
	public TblFrequentDataSupport() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrequentDataId() {
		return frequentDataId;
	}

	public void setFrequentDataId(String frequentDataId) {
		this.frequentDataId = frequentDataId;
	}

	public Integer getItemsetNumber() {
		return itemsetNumber;
	}

	public void setItemsetNumber(Integer itemsetNumber) {
		this.itemsetNumber = itemsetNumber;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public Double getSupport() {
		return support;
	}

	public void setSupport(Double support) {
		this.support = support;
	}

	public Date getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(Date executeDate) {
		this.executeDate = executeDate;
	}

	public String getExecuteUser() {
		return executeUser;
	}

	public void setExecuteUser(String executeUser) {
		this.executeUser = executeUser;
	}

}
