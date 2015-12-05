package com.neu.cloud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salaries")
public class Salary {

	@Id
	@Column(name="emp_no", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.TABLE)
	private int empid;
	
	@Column(name="salary")
	private int salary;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="to_date")
	private Date toDate;
}
