package com.fatma.formation.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.fatma.formation.entities.Formation;
import com.fatma.formation.entities.Theme;


public interface FormationSprintService {
	Formation saveFormation(Formation f);
	Formation updateFormation(Formation f);
	void supprimerFormation(Formation f);
	void supprimerFormationById(Long id);
	Formation getFormation(Long id);
	List<Formation> getAllFormations();
	Page<Formation> getAllFormationsParPage(int page, int size);
	
	List<Formation> findByNomFormation(String nom);
	List<Formation> findByNomFormationContains(String nom); 
	List<Formation> findByNomPrix(String nom,int prix);
	List<Formation> findByTheme (Theme theme);
	List<Formation> findByThemeIdTheme(long l);
	List<Formation> findByOrderByNomFormationAsc();
	List<Formation> trierFormationsNomsPrix();
	List<Formation> getFormationsByThemeId(Long idTheme);

}
