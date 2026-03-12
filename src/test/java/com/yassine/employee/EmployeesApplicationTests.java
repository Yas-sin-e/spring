package com.yassine.employee;

import java.time.LocalDate;
import java.util.List;

import com.yassine.employee.entities.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.yassine.employee.entities.Employee;
import com.yassine.employee.repos.EmployeeRepository;
import com.yassine.employee.service.EmployeeService;

@SpringBootTest
class EmployeesApplicationTests {

	@Autowired
	private EmployeeRepository emp;
	@Autowired
	private EmployeeService emps;

	// le principe d'injection de dependances: avec authowired on peut dit a spring
	// de cree pour moi une objet qui implment l'interface employeerepository
	// ici le speing data jpa qui cree l'instance de linterface.
	// au demarage de l'application
	@Test
	public void testajout() {
		Employee e = new Employee("Mouhamed", LocalDate.of(1967, 9, 10), 2500.0);
		Employee e1 = new Employee("Rayen", LocalDate.of(2004, 1, 7), 2500.0);
		emp.save(e1);
		emp.save(e);
		System.out.println("Employé enregistré avec succès !");
		// ici on utilise get car la methode findbyid retourne un objet spécial
		// appelé Optional<Employee> pour que le peut retouner des null et n'est
		// bloquer

	}
	@Test
	public void testFindByNomEmployee()
	{
		List<Employee>  emps = emp.findByNomEmp("yassine");
		for (Employee e : emps)
		{
			System.out.println(e);
		}

	}
	@Test
	public void testFindByNomEmployeAsc()
	{
		List<Employee>  emps = emp.findByOrderByNomEmpAsc();
		for (Employee e : emps)
		{
			System.out.println(e);
		}

	}
	@Test
	public void trierEmployeeBYSalaire()
	{
		List<Employee>  emps = emp.trierEmployeesNomsSalaire();
		for (Employee e : emps)
		{
			System.out.println(e);
		}

	}
	@Test
	public void testFindByNomEmployee_Contains()
	{
		List<Employee>  emps = emp.findByNomEmpContains("yas");
		for (Employee e : emps)
		{
			System.out.println(e);
		}

	}
	@Test
	public void testFindBySalaire()
	{
		List<Employee>  emps = emp.findByNomSalaire("Rayen",2500.0);
		for (Employee e : emps)
		{
			System.out.println(e);
		}

	}
	@Test
	public void testFindByGradeidGrad()
	{
		List<Employee>  emps = emp.findByGradeIdGrad(1L);
		for (Employee e : emps)
		{
			System.out.println(e);
		}

	}
	@Test
	public void testfindByGrade()
	{
		Grade gra=new Grade();
		gra.setIdGrad(1l);
		List<Employee>  emps = emp.findByGrade(gra);
		for (Employee e : emps)
		{
			System.out.println(e);
		}

	}




	@Test
	public void modificationEmp() {
		Employee em = emp.findById(11L).get();
		em.setSalaire(3000.0);
		emp.save(em);
		System.out.println("l'employe nom est " + em.getNomEmp());

	}

	@Test
	public void chercherEmp() {
		Employee em = emp.findById(11L).get(); // ici on utilise get car la methode findbyid retourne un objet spécial
												// appelé Optional<Employee> pour que le peut retouner des null et n'est
												// bloquer

		System.out.println("l'employe nom est " + em.getNomEmp());
	}

	@Test
	public void listerEmp() {
		List<Employee> emps = emp.findAll();
		emps.forEach(e -> System.out.println(e.toString()));

	}

	@Test
	public void deleteEmp() {
		emp.deleteById(12L);
	}

	@Test
	public void testFindByNomEmployeeContains() {
		Page<Employee> emp = emps.getAllEmployeesParPage(0, 2);
		System.out.println(emp.getSize());
		System.out.println(emp.getTotalElements());
		System.out.println(emp.getTotalPages());
		emp.getContent().forEach(e -> {
			System.out.println(e.toString());
		});
	}
}


