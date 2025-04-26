package com.fatma.formation.service;

import com.fatma.formation.entities.Role;
import com.fatma.formation.entities.User;

public interface UserService {
void deleteAllusers();
void deleteAllRoles();
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}
