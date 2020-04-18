package com.techievibe.server.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techievibe.server.Dtos.SearchEmployee;
import com.techievibe.server.Entities.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@PostMapping("/filter")
	public List<Employee> filterEmployeeList(SearchEmployee searchParams) {
		List<Employee> list = new ArrayList<Employee>();
		return list;
	}
}
