package com.techievibe.server.Service;

import com.techievibe.server.Dtos.SearchEmployee;
import com.techievibe.server.Entities.Employee;
import com.techievibe.server.Pojos.DataList;

public interface EmployeeService {

	/**
	 * 
	 * @param searchParams
	 * @return
	 */
	DataList<Employee> filterEmployeesList(SearchEmployee searchParams);

}
