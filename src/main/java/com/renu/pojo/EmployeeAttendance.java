package com.renu.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class EmployeeAttendance {

	@Column
	private long id;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date date;
	@Column
	private String status;
	@Column
	private String name;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column
	private int serialno;

	public EmployeeAttendance() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeAttendance(long id, Date date, String status, int serialno) {
		super();
		this.id = id;
		this.date = date;
		this.status = status;
		this.serialno = serialno;
	}

	public int getSerialno() {
		return serialno;
	}

	public void setSerialno(int serialno) {
		this.serialno = serialno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getstatus() {
		return status;
	}

	public void setstatus(String status) {
		this.status = status;
	}

}
