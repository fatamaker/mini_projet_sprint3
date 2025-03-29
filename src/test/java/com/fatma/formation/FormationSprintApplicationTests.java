package com.fatma.formation;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.fatma.formation.entities.Formation;
import com.fatma.formation.repos.FormationSprintRepository;
import com.fatma.formation.service.FormationSprintService;



@SpringBootTest
class FormationSprintApplicationTests {

	@Autowired
	private  FormationSprintService formationService;
	private FormationSprintRepository formationRepository;
	
	
	
	@Test
	 public void testDeleteFormation()
	 {
		 formationRepository.deleteById(1L);;
	 }
	 

	 
	
	 @Test
	 public void testFindFormation()
	 {
		 Formation f= formationRepository.findById(1L).get();
	     System.out.println(f);
	 }
	 
	  @Test
	 public void testListerTousF()
	 {
	 List<Formation> form =  formationRepository.findAll();
	 for (Formation f : form)
	 {
	 System.out.println(f);
	 }
	 }
	 
	 
	  @Test
		public void testCreateFormation() {
			 Formation formation = new Formation(
			            "Formation java ",
			            1200,
			            LocalDate.of(2025,01,12),
			            LocalDate.of(2025, 02, 11),
			            "en ligne"
			        );
			        
			        formationRepository.save(formation);
		}
	 
	
	 @Test
	 public void testUpdateFormation()
	 {
	 Formation f = formationRepository.findById(1L).get();
	 f.setPrixFormation(2000);
	 formationRepository.save(f);
	 
	 }
	 
	 @Test
	    public void testFindByNomProduitContains() {
	        Page<Formation> prods = formationService.getAllFormationsParPage(0, 2);
	        System.out.println(prods.getSize());
	        System.out.println(prods.getTotalElements());
	        System.out.println(prods.getTotalPages());
	        prods.getContent().forEach(p -> {
	            System.out.println(p.toString());
	        });
	    }
	
	
		
	
	
	 
	 


}
