package com.datamining.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="frequent_data_confidence")
public class TblFrequentDataConfidence {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="id", unique = true, nullable = false)
	private String id;
	
	@Column(name="frequent_data_id")
	private String frequentDataId;
	
	@Column(name="candidate_a")
	private String candidateA;
	
	@Column(name="support_a")
	private Double supportA;
	
	@Column(name="candidate_b")
	private String candidateB;
	
	@Column(name="support_b")
	private Double supportB;
	
	@Column(name="execute_date")
	private Date executeDate;
	
	@Column(name="param_min_confidence")
	private Double paramMinConfidence;
	
	@Column(name="confidence")
	private Double confidence;
	
	@Column(name="execute_user")
	private String executeUser;
	
	public TblFrequentDataConfidence() {
		
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

	public String getCandidateA() {
		return candidateA;
	}

	public void setCandidateA(String candidateA) {
		this.candidateA = candidateA;
	}

	public Double getSupportA() {
		return supportA;
	}

	public void setSupportA(Double supportA) {
		this.supportA = supportA;
	}

	public String getCandidateB() {
		return candidateB;
	}

	public void setCandidateB(String candidateB) {
		this.candidateB = candidateB;
	}

	public Double getSupportB() {
		return supportB;
	}

	public void setSupportB(Double supportB) {
		this.supportB = supportB;
	}

	public Date getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(Date executeDate) {
		this.executeDate = executeDate;
	}

	public Double getParamMinConfidence() {
		return paramMinConfidence;
	}

	public void setParamMinConfidence(Double paramMinConfidence) {
		this.paramMinConfidence = paramMinConfidence;
	}

	public Double getConfidence() {
		return confidence;
	}

	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}

	public String getExecuteUser() {
		return executeUser;
	}

	public void setExecuteUser(String executeUser) {
		this.executeUser = executeUser;
	}

}
