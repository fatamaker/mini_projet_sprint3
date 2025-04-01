package com.fatma.formation.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fatma.formation.entities.Formation;
import com.fatma.formation.entities.Theme;


@RepositoryRestResource(path = "rest")
public interface FormationSprintRepository extends JpaRepository<Formation, Long> {
	
	List<Formation> findByNomFormation(String nom);
	List<Formation> findByNomFormationContains(String nom);
	@Query("SELECT f FROM Formation f WHERE f.nomFormation LIKE %:nom AND f.prixFormation > :prix")
	List<Formation> findByNomPrix(@Param("nom") String nom, @Param("prix") int prix);
	
	@Query("SELECT f FROM Formation f WHERE f.theme = ?1")
	List<Formation> findByTheme (Theme theme);
	
	
	List<Formation> findByOrderByNomFormationAsc();
	
	@Query("SELECT f FROM Formation f  order by  f.nomFormation ASC, f.prixFormation DESC")
	
	List<Formation> trierFormationsNomsPrix();
	
	List<Formation> findByThemeIdTheme(Long idTheme);
}
