package com.yassine.employee.repos;

import com.yassine.employee.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.employee.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByNomEmp(String nomEmp);
    List<Employee> findByNomEmpContains(String nom);
    // 10. JPQL : Nom contient texte ET salaire supérieur à...
    @Query("select e from Employee e where e.nomEmp like %:nom and e.salaire > :salaire")
    List<Employee> findByNomSalaire(@Param("nom") String nom, @Param("salaire") Double salaire);

    // 12. Recherche en passant l'objet Grade en paramètre
    @Query("select e from Employee e where e.grade = ?1")
    List<Employee> findByGrade(Grade grade);

    // 14. Recherche par l'ID du Grade
    List<Employee> findByGradeIdGrad(Long id);

    // 16. Trier par nom croissant
    List<Employee> findByOrderByNomEmpAsc();

    // 18. Trier par nom (ASC) et salaire (DESC)
    @Query("select e from Employee e order by e.nomEmp ASC, e.salaire DESC")
    List<Employee> trierEmployeesNomsSalaire();

}
