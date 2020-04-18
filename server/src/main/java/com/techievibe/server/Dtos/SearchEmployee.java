package com.techievibe.server.Dtos;

import java.util.Date;

import lombok.Data;

@Data
public class SearchEmployee {

	private Integer employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private Date hireDate;

	private String gender;
}
