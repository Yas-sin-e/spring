package com.yassine.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.employee.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}