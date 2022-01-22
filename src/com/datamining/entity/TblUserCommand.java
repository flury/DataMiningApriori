package com.datamining.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usercommand")
public class TblUserCommand implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="command_id")
	private Integer commandId;
	
	@Column(name="command")
	private String command;
	
	@Column(name="description")
	private String description;
	
	public TblUserCommand() {
		
	}

	public Integer getCommandId() {
		return commandId;
	}

	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
