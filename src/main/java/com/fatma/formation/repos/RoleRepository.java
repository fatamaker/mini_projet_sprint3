package com.fatma.formation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatma.formation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
