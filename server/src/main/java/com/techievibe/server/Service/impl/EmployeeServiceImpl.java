package com.techievibe.server.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mysql.cj.log.Log;
import com.techievibe.server.Dtos.SearchEmployee;
import com.techievibe.server.Entities.Employee;
import com.techievibe.server.Pojos.DataList;
import com.techievibe.server.Service.EmployeeService;
import com.techievibe.server.repositories.EmployeeRepository;
import com.techievibe.server.searchSpec.SearchCriteria;
import com.techievibe.server.searchSpec.SearchOperator;
import com.techievibe.server.searchSpec.SearchSpecification;

import lombok.Data;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public DataList<Employee> filterEmployeesList(SearchEmployee searchParams) {
		DataList<Employee> dataList = new DataList(new ArrayList<Employee>(), 0);
		SearchSpecification<Employee> empSpec = new SearchSpecification();
		if (searchParams != null) {
			if (searchParams.getEmail() != null && !searchParams.getEmail().isEmpty()) {
				LOG.info("email id : " + searchParams.getEmail());
				empSpec.add(new SearchCriteria("email", searchParams.getEmail(), SearchOperator.EQUAL));
			}
			if (searchParams.getEmployeeId() != null) {
				LOG.info("employeeId : " + searchParams.getEmployeeId());
				empSpec.add(new SearchCriteria("id", searchParams.getEmployeeId(), SearchOperator.EQUAL));
			}
			if (searchParams.getFirstName() != null && !searchParams.getFirstName().isEmpty()) {
				LOG.info("firstName : " + searchParams.getFirstName());
				empSpec.add(new SearchCriteria("firstName", searchParams.getFirstName(), SearchOperator.EQUAL));
			}
			if (searchParams.getLastName() != null && !searchParams.getLastName().isEmpty()) {
				LOG.info("lastName : " + searchParams.getLastName());
				empSpec.add(new SearchCriteria("lastName", searchParams.getLastName(), SearchOperator.EQUAL));
			}
			if (searchParams.getGender() != null && !searchParams.getGender().isEmpty()) {
				LOG.info("gender : " + searchParams.getGender());
				empSpec.add(new SearchCriteria("gender", searchParams.getGender(), SearchOperator.EQUAL));
			}
			if (searchParams.getHireDate() != null) {
				LOG.info("hireDate : " + searchParams.getHireDate());
				empSpec.add(new SearchCriteria("hireDate", searchParams.getHireDate(), SearchOperator.EQUAL));
			}
		}

		String[] properties = { "hireDate" };

		Page<Employee> msTitleRatingList = employeeRepository.findAll(empSpec,
				PageRequest.of(0, 10, Sort.by(Direction.DESC, properties)));
		LOG.info("msTitleRatingList size : " + msTitleRatingList.getTotalElements());
		msTitleRatingList.forEach(i -> {
			LOG.info("Employee : " + i.toString());
		});
		dataList.setList(msTitleRatingList.toList());
		dataList.setCount(msTitleRatingList.getTotalElements());
		return dataList;
	}
}
