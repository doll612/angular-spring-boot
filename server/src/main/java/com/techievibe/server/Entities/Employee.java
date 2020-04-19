package com.techievibe.server.Entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.techievibe.server.common.CustomerDateAndTimeDeserialize;
import com.techievibe.server.common.CustomerDateAndTimeSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
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

	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@JsonSerialize(using = CustomerDateAndTimeSerialize.class)
	@Temporal(TemporalType.DATE)
	@Column(name = "HIRE_DATE")
	private Date hireDate;

}
