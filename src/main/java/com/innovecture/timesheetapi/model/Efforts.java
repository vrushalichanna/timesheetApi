package com.innovecture.timesheetapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="efforts")
public class Efforts implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long effortsId;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private int hours;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Task task;
	
	public Efforts() {
		
	}

	public Long getEffortsId() {
		return effortsId;
	}

	public void setEffortsId(Long effortsId) {
		this.effortsId = effortsId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}
