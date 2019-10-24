package com.innovecture.timesheetapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="task")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taksId;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Projects projects;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="task")
	private List<Efforts> efforts;
	
	@Column(length = 1000)
	private String taskDetails;
	
	@JoinColumn(name="timeSheetId")
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Timesheet timeSheet;

	public Long getTaksId() {
		return taksId;
	}

	public void setTaksId(Long taksId) {
		this.taksId = taksId;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	public List<Efforts> getEfforts() {
		return efforts;
	}

	public void setEfforts(List<Efforts> efforts) {
		this.efforts = efforts;
	}

//	public Timesheet getTimeSheet() {
//		return timeSheet;
//	}
//
//	public void setTimeSheet(Timesheet timeSheet) {
//		this.timeSheet = timeSheet;
//	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}
	
}
