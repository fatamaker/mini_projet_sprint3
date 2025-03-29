package com.fatma.formation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatma.formation.entities.Formation;

public interface FormationSprintRepository extends JpaRepository<Formation, Long> {

}
