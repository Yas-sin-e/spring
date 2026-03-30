package com.yassine.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.yassine.employee.entities.Role;
import com.yassine.employee.entities.User;
import com.yassine.employee.service.UserService;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class EmployeesApplication {

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}

//	@PostConstruct
//	void init_users() {
//		// 1. Ajouter les rôles
//		userService.addRole(new Role(null, "ADMIN"));
//		userService.addRole(new Role(null, "AGENT"));
//		userService.addRole(new Role(null, "USER"));
//
//		// 2. Ajouter les users (Le mot de passe "123" sera encodé automatiquement par UserService)
//		userService.saveUser(new User(null, "admin", "123", true, null));
//		userService.saveUser(new User(null, "yassine", "123", true, null));
//		userService.saveUser(new User(null, "user1", "123", true, null));
//
//		// 3. Ajouter les rôles aux users
//		userService.addRoleToUser("admin", "ADMIN");
//
//		userService.addRoleToUser("yassine", "USER");
//		userService.addRoleToUser("yassine", "AGENT");
//
//		userService.addRoleToUser("user1", "USER");
//	}
}