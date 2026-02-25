package com.yassine.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yassine.employee.entities.Employee;
import com.yassine.employee.repos.EmployeeRepository;

@Service // cici on dit que service .pour utilser les methode de cette calss on declare
			// un variable de type interface employeeService et on utilse autowired pour
			// spring injecter l'objet de cette class et on utilse les methodes
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository emp;

	@Override
	public Employee saveEmployee(Employee e) {
		return emp.save(e);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		return emp.save(e);
	}

	@Override
	public void deleteEmployee(Employee e) {
		emp.delete(e);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		emp.deleteById(id);

	}

	@Override
	public Employee getEmployee(Long id) {
		return emp.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		return emp.findAll();
	}

	@Override
	public Page<Employee> getAllEmployeesParPage(int page, int size) {
		return emp.findAll(PageRequest.of(page, size));
	}

}
