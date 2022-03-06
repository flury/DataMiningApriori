package com.datamining.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="master_itemset")
public class TblMasterItemset {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="label")
	private String label;
	
	@Column(name="description")
	private String description;
	
	public TblMasterItemset() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
