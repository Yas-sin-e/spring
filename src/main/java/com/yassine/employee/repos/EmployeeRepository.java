package com.yassine.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.employee.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// JpaRepository contient déjà toutes les méthodes : save, findAll, delete, etc.
}
