package com.techievibe.server.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.techievibe.server.Entities.Employee;

@Repository
public interface EmployeeRepository
		extends JpaSpecificationExecutor<Employee>, PagingAndSortingRepository<Employee, Integer> {

	List<Employee> findAllByHireDate(Date hireDate);

}
