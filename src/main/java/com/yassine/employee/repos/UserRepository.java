package com.yassine.employee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.employee.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}