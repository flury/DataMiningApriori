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
	
	@Column(name="candidate")
	private String candidate;
	
	@Column(name="antecedent_candidate")
	private String antecedentCandidate;
	
	@Column(name="antecedent_support")
	private Double antecedentSupport;
	
	@Column(name="consequent_candidate")
	private String consequentCandidate;
	
	@Column(name="consequent_support")
	private Double consequentSupport;
	
	@Column(name="execute_date")
	private Date executeDate;
	
	@Column(name="param_min_confidence")
	private Double paramMinConfidence;
	
	@Column(name="confidence")
	private Double confidence;
	
	@Column(name="description_antecedent")
	private String descriptionAntecedent;
	
	@Column(name="description_consequent")
	private String descriptionConsequent;
	
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

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public String getAntecedentCandidate() {
		return antecedentCandidate;
	}

	public void setAntecedentCandidate(String antecedentCandidate) {
		this.antecedentCandidate = antecedentCandidate;
	}

	public Double getAntecedentSupport() {
		return antecedentSupport;
	}

	public void setAntecedentSupport(Double antecedentSupport) {
		this.antecedentSupport = antecedentSupport;
	}

	public String getConsequentCandidate() {
		return consequentCandidate;
	}

	public void setConsequentCandidate(String consequentCandidate) {
		this.consequentCandidate = consequentCandidate;
	}

	public Double getConsequentSupport() {
		return consequentSupport;
	}

	public void setConsequentSupport(Double consequentSupport) {
		this.consequentSupport = consequentSupport;
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

	public String getDescriptionAntecedent() {
		return descriptionAntecedent;
	}

	public void setDescriptionAntecedent(String descriptionAntecedent) {
		this.descriptionAntecedent = descriptionAntecedent;
	}

	public String getDescriptionConsequent() {
		return descriptionConsequent;
	}

	public void setDescriptionConsequent(String descriptionConsequent) {
		this.descriptionConsequent = descriptionConsequent;
	}

	public String getExecuteUser() {
		return executeUser;
	}

	public void setExecuteUser(String executeUser) {
		this.executeUser = executeUser;
	}
	
}
