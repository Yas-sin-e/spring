package com.yassine.employee.repos;

import com.yassine.employee.entities.Employee;
import com.yassine.employee.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNomEmp(String nom);
    List<Employee> findByNomEmpContains(String nom);

    @Query("select e from Employee e where e.nomEmp like %:nom and e.salaire > :salaire")
    List<Employee> findByNomSalaire(@Param("nom") String nom, @Param("salaire") Double salaire);

    @Query("select e from Employee e where e.grade = ?1")
    List<Employee> findByGrade(Grade grade);

    // Correction ici : IdGrad avec majuscules
    List<Employee> findByGradeIdGrad(Long id);

    List<Employee> findByOrderByNomEmpAsc();

    @Query("select e from Employee e order by e.nomEmp ASC, e.salaire DESC")
    List<Employee> trierEmployeesNomsSalaire();
}