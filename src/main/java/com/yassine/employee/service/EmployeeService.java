package com.yassine.employee.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yassine.employee.entities.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee e);

	Employee updateEmployee(Employee e);

	void deleteEmployee(Employee e);

	void deleteEmployeeById(Long id);

	Employee getEmployee(Long id);

	List<Employee> getAllEmployees();

	Page<Employee> getAllEmployeesParPage(int page, int size);
}
