package com.fatma.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatma.formation.entities.Formation;
import com.fatma.formation.entities.FormationDTO;
import com.fatma.formation.service.FormationSprintService;

import org.springframework.web.bind.annotation.RequestMethod;





@RestController
@RequestMapping("/api")
@CrossOrigin("*") 
public class FormationRestController {
	
	@Autowired
	FormationSprintService formationService;
	
	@GetMapping
	public List<FormationDTO> getAllFormations() {
		return formationService.getAllFormations();
	}
	
	@GetMapping("/{id}")
    public FormationDTO getFormationtById(@PathVariable("id") Long id) {
        return formationService.getFormation(id);
    }
	
	@GetMapping("/thm/{idTheme}")
	public ResponseEntity<List<Formation>> getFormationsByThemeId(@PathVariable("idTheme") Long idTheme) {
	    List<Formation> formations = formationService.getFormationsByThemeId(idTheme);
	    return formations.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(formations);
	}
	
	@PostMapping
	public FormationDTO createFormation(@RequestBody Formation formation) {
	    return formationService.saveFormation(formation);
	}
		
	@PutMapping
	public Formation updateFormation(@RequestBody Formation formation) {
	    return formationService.updateFormation(formation);
	}
	
	@DeleteMapping("/{id}")
	public void deleteFormation(@PathVariable Long id) {
	    formationService.supprimerFormationById(id);
	}
	
	@RequestMapping(value="/formthem/{idTheme}",method = RequestMethod.GET)
	public List<Formation> getFormationByIdTheme(@PathVariable Long idTheme) {
	    return formationService.findByThemeIdTheme(idTheme);
	}

	@RequestMapping(value="/formsByName/{nom}",method = RequestMethod.GET) 
	public List<Formation> findByNomFormationContains(@PathVariable("nom") String nom) { 
	return formationService.findByNomFormationContains(nom);
	}


}
