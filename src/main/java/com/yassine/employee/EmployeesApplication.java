package com.yassine.employee;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yassine.employee.entities.Employee;
import com.yassine.employee.service.EmployeeService;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner {
	@Autowired
	EmployeeService emp;

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		emp.saveEmployee(new Employee("toto", LocalDate.of(2024, 9, 10), 4000.0));
		emp.saveEmployee(new Employee("momo", LocalDate.of(2020, 8, 10), 5000.0));
		emp.saveEmployee(new Employee("kiko", LocalDate.of(2002, 9, 10), 9000.0));

	}

}
