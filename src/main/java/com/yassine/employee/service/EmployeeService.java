package com.yassine.employee.service;

import java.util.List;
import com.yassine.employee.entities.Grade;
import org.springframework.data.domain.Page;
import com.yassine.employee.entities.Employee;

public interface EmployeeService {
	// Méthodes CRUD de base
	Employee saveEmployee(Employee e);
	Employee updateEmployee(Employee e);
	void deleteEmployee(Employee e);
	void deleteEmployeeById(Long id);
	Employee getEmployee(Long id);
	List<Employee> getAllEmployees();
	Page<Employee> getAllEmployeesParPage(int page, int size);
	List<Grade> getAllGrades();


	List<Employee> findByNomEmp(String nom);
	List<Employee> findByNomEmpContains(String nom);
	List<Employee> findByNomSalaire(String nom, Double salaire);
	List<Employee> findByGrade(Grade grade);

	// Correction ici : IdGrad pour correspondre à l'entité Grade
	List<Employee> findByGradeIdGrad(Long id);

	List<Employee> findByOrderByNomEmpAsc();
	List<Employee> trierEmployeesNomsSalaire();
}