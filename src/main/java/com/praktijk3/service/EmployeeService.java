package com.praktijk3.service;

import java.util.List;



import com.praktijk3.model.Employee;


public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);

}
