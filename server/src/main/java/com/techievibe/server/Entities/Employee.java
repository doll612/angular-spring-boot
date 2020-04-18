package com.techievibe.server.Entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {

	@Column(name = "EMPLOYEE_ID")
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "DEPARTMENT")
	private String department;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "SALARY")
	private BigDecimal salary;

	@Column(name = "REGION_ID")
	private String regionId;

	@Temporal(TemporalType.DATE)
	@Column(name = "HIRE_DATE")
	private Date hireDate;

}
