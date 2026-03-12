package com.yassine.employee.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.employee.entities.Grade;
public interface GradeRepository extends JpaRepository<Grade, Long>{
}
