package com.yassine.employee.service;

import com.yassine.employee.entities.Role;
import com.yassine.employee.entities.User;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
}