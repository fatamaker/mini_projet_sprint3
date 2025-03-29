package com.fatma.formation.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fatma.formation.entities.Formation;


public interface FormationSprintService {
	Formation saveFormation(Formation f);
	Formation updateFormation(Formation f);
	void supprimerFormation(Formation f);
	void supprimerFormationById(Long id);
	Formation getFormation(Long id);
	List<Formation> getAllFormations();
	Page<Formation> getAllFormationsParPage(int page, int size);

}
