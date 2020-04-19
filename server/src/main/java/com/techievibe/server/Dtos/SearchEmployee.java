package com.techievibe.server.Dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.techievibe.server.common.CustomerDateAndTimeDeserialize;
import com.techievibe.server.common.CustomerDateAndTimeSerialize;

import lombok.Data;

@Data
public class SearchEmployee {

	private Integer employeeId;

	private String firstName;

	private String lastName;

	private String email;

	@JsonDeserialize(using = CustomerDateAndTimeDeserialize.class)
	@JsonSerialize(using = CustomerDateAndTimeSerialize.class)
	private Date hireDate;

	private String gender;

	private Integer pageNumber = 0;

	private Integer pageSize = 10;

	private String[] sortParam;
}
