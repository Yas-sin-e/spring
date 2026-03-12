package com.yassine.employee.service;

import java.util.List;

import com.yassine.employee.entities.Grade;
import com.yassine.employee.repos.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yassine.employee.entities.Employee;
import com.yassine.employee.repos.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	GradeRepository gradeRepository;
	@Autowired
	EmployeeRepository employeeRepository; // Nom plus explicite

	@Override public Employee saveEmployee(Employee e) { return employeeRepository.save(e); }
	@Override public Employee updateEmployee(Employee e) { return employeeRepository.save(e); }
	@Override public void deleteEmployee(Employee e) { employeeRepository.delete(e); }
	@Override public void deleteEmployeeById(Long id) { employeeRepository.deleteById(id); }
	@Override public Employee getEmployee(Long id) { return employeeRepository.findById(id).orElse(null); }
	@Override public List<Employee> getAllEmployees() { return employeeRepository.findAll(); }
	@Override public Page<Employee> getAllEmployeesParPage(int page, int size) {
		return employeeRepository.findAll(PageRequest.of(page, size));
	}

	@Override public List<Employee> findByNomEmp(String nom) { return employeeRepository.findByNomEmp(nom); }
	@Override public List<Employee> findByNomEmpContains(String nom) { return employeeRepository.findByNomEmpContains(nom); }
	@Override public List<Employee> findByNomSalaire(String nom, Double salaire) { return employeeRepository.findByNomSalaire(nom, salaire); }
	@Override public List<Employee> findByGrade(Grade grade) { return employeeRepository.findByGrade(grade); }

	// Correction ici aussi
	@Override public List<Employee> findByGradeIdGrad(Long id) { return employeeRepository.findByGradeIdGrad(id); }

	@Override public List<Employee> findByOrderByNomEmpAsc() { return employeeRepository.findByOrderByNomEmpAsc(); }
	@Override public List<Employee> trierEmployeesNomsSalaire() { return employeeRepository.trierEmployeesNomsSalaire(); }
	@Override
	public List<Grade> getAllGrades() {
		return gradeRepository.findAll();
	}
}