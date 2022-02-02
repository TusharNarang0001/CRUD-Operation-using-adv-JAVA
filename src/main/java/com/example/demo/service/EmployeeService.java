package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	// Get All Employees
	List<Employee> getAllEmployee();

	// Save Employees to database
	void saveEmployee(Employee employee);

	// Update Employee
	Employee getEmpoyeeById(long id);

	// Delete Employee method
	void deleteEmployeeById(long id);

}
