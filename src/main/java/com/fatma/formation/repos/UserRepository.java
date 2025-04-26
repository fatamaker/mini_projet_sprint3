package com.fatma.formation.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatma.formation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
