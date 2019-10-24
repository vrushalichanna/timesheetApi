package com.innovecture.timesheetapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="timesheet")
public class Timesheet implements Serializable {

	
	private static final long serialVersionUID = -3966686498825129967L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long timesheetId;
	private boolean status;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy ="timeSheet")
	private List<Task> tasks;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private User user;
	
	public Timesheet() {
		
	}

	public Long getTimesheetId() {
		return timesheetId;
	}

	public void setTimesheetId(Long timesheetId) {
		this.timesheetId = timesheetId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
