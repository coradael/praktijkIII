package com.praktijk3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praktijk3.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	//add method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
