package com.fatma.formation;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;


import com.fatma.formation.entities.Formation;
import com.fatma.formation.entities.Theme;
import com.fatma.formation.repos.FormationSprintRepository;
import com.fatma.formation.service.FormationSprintService;



@SpringBootTest
class FormationSprintApplicationTests {

	@Autowired
	private FormationSprintRepository formationRepository;
	private  FormationSprintService formationService;

	
	/*
	 * @Test public void testDeleteFormation() {
	 * formationRepository.deleteById(1L);; }
	 * 
	 * 
	 * 
	 * 
	 * @Test public void testFindFormation() { Formation f=
	 * formationRepository.findById(1L).get(); System.out.println(f); }
	 * 
	 * @Test public void testListerTousF() { List<Formation> form =
	 * formationRepository.findAll(); for (Formation f : form) {
	 * System.out.println(f); } }
	 * 
	 * 
	 * @Test public void testCreateFormation() { Formation formation = new
	 * Formation( "Formation java ", 1200, LocalDate.of(2025,01,12),
	 * LocalDate.of(2025, 02, 11), "en ligne" );
	 * 
	 * formationRepository.save(formation); }
	 * 
	 * 
	 * @Test public void testUpdateFormation() { Formation f =
	 * formationRepository.findById(1L).get(); f.setPrixFormation(2000);
	 * formationRepository.save(f);
	 * 
	 * }
	 * 
	 * @Test public void testFindByNomProduitContains() { Page<Formation> prods =
	 * formationService.getAllFormationsParPage(0, 2);
	 * System.out.println(prods.getSize());
	 * System.out.println(prods.getTotalElements());
	 * System.out.println(prods.getTotalPages()); prods.getContent().forEach(p -> {
	 * System.out.println(p.toString()); }); }
	 * 
	 * 
	 * 
	 * @Test public void findByNomFormation (){ List<Formation> prods =
	 * formationRepository.findByNomFormation("Formation UX"); for (Formation f :
	 * prods) { System.out.println(f); } }
	 * 
	 * 
	 * @Test public void testFindByNomFormationContains (){ List<Formation> prods =
	 * formationRepository.findByNomFormationContains("Formation"); for (Formation f
	 * : prods) { System.out.println(f); } }
	 * 
	 * @Test public void testfindByNomPrix() { List<Formation> prods =
	 * formationRepository.findByNomPrix("Formation UX UI Design", 1000); for
	 * (Formation f : prods) { System.out.println(f); } }
	 * 
	 * @Test public void testfindByTheme () { Theme cat = new Theme ();
	 * cat.setIdTheme(1L); List<Formation> prods =
	 * formationRepository.findByTheme(cat); for (Formation f : prods) {
	 * System.out.println(f); } }
	 */
	 
	 @Test
	 public void findByThemeIdTheme()
	 {
	 List<Formation> prods = formationRepository.findByThemeIdTheme(2L);
	 for (Formation f : prods)
	 {
	 System.out.println(f);
	 }
	  }
	
	
		
	 @Test
	 public void testfindByOrderByNomFormationAsc()
	 {
	 List<Formation> prods =formationRepository.findByOrderByNomFormationAsc();
	 for (Formation f : prods)
	 {
	 System.out.println(f);
	 }
	 }
	 
	 @Test
	 public void testTrierFormationsNomsPrix()
	 {
	 List<Formation> prods = formationRepository.trierFormationsNomsPrix();
	 for (Formation p : prods)
	 {
	 System.out.println(p);
	 }
	 }
	
	 
	 


}
