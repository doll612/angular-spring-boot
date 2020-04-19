package com.techievibe.server.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techievibe.server.Dtos.SearchEmployee;
import com.techievibe.server.Entities.Employee;
import com.techievibe.server.Pojos.DataList;
import com.techievibe.server.Service.EmployeeService;
import com.techievibe.server.repositories.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final static Logger LOG = LogManager.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/filter")
	public Map<String, Object> filterEmployeeList(@RequestBody SearchEmployee searchParams) {
		Map<String, Object> result = new HashMap<>();
		DataList<Employee> list = new DataList();
		try {
			list = employeeService.filterEmployeesList(searchParams);
		} catch (Exception e) {
			LOG.info("Exception while filter Employees : " + e);
		}
		
		result.put("empList", list.getList());
		result.put("totalEmps", list.getCount());
		return result;
	}

	@PostMapping("/getByDate")
	public List<Employee> getByDate(@RequestBody SearchEmployee searchParams) {
		List<Employee> list = new ArrayList<Employee>();
		try {
			LOG.info("getByDate searchParams.getHireDate() : " + searchParams.getHireDate());
			list = employeeRepository.findAllByHireDate(searchParams.getHireDate());
		} catch (Exception e) {
			LOG.info("Exception while filter Employee : " + e);
		}
		return list;
	}
}
