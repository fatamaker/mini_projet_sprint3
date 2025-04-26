package com.fatma.formation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fatma.formation.entities.Formation;
import com.fatma.formation.entities.FormationDTO;
import com.fatma.formation.entities.Theme;
import com.fatma.formation.repos.FormationSprintRepository;
import com.fatma.formation.repos.FormationThemeRepository;

@Service
public class FormationSprintServiceImp implements FormationSprintService {

	@Autowired
	FormationSprintRepository formationRepository;
	
	@Autowired
	FormationThemeRepository themeRepository;
	

	@Override
	public FormationDTO saveFormation(Formation f) {
		return convertEntityToDto( formationRepository.save(f));
	}

	@Override
	public Formation updateFormation(Formation f) {
		return formationRepository.save(f);
	}

	@Override
	public void supprimerFormation(Formation f) {
		 formationRepository.delete(f);
		
	}

	@Override
	public void supprimerFormationById(Long id) {
		formationRepository.deleteById(id);
		
	}

	@Override
	public FormationDTO  getFormation(Long id) {
		return convertEntityToDto(formationRepository.findById(id).get());
	}

	@Override
	public List<FormationDTO> getAllFormations() {
//		return formationRepository.findAll();
		
		return formationRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());

	}
	
	@Override
    public Page<Formation> getAllFormationsParPage(int page, int size) {
        return formationRepository.findAll(PageRequest.of(page, size));
    }
	
	@Override
	public List<Formation> findByNomFormation(String nom) {
		return formationRepository.findByNomFormation(nom);
	}

	@Override
	public List<Formation> findByNomFormationContains(String nom) {
		return formationRepository.findByNomFormationContains(nom);
	}

	@Override
	public List<Formation> findByNomPrix(String nom, int prix) {
		return formationRepository.findByNomPrix(nom,prix);	}

	@Override
	public List<Formation> findByTheme(Theme theme) {
		return formationRepository.findByTheme(theme);
	}

	@Override
	public List<Formation> findByThemeIdTheme(long l) {
		return formationRepository.findByThemeIdTheme(l);
	}

	@Override
	public List<Formation> findByOrderByNomFormationAsc() {
		
		return formationRepository.findByOrderByNomFormationAsc();
	}

	@Override
	public List<Formation> trierFormationsNomsPrix() {
		return formationRepository.trierFormationsNomsPrix();
	}

	public List<Formation> getFormationsByThemeId(Long idTheme) {
        return formationRepository.findByThemeIdTheme(idTheme);
    }
	
	@Override
	public List<Theme> getAllThemes() {
	return themeRepository.findAll();
	}
	
	@Override
	public FormationDTO convertEntityToDto(Formation formation) {
		/*
		 * FormationDTO formationDTO = new FormationDTO();
		 * formationDTO.setIdFormation(formation.getIdFormation());
		 * formationDTO.setNomFormation(formation.getNomFormation());
		 * formationDTO.setPrixFormation(formation.getPrixFormation());
		 * formationDTO.setDatedebut(formation.getDatedebut());
		 * formationDTO.setDatefin(formation.getDatefin());
		 * formationDTO.setModeFormation(formation.getModeFormation());
		 * formationDTO.setTheme(formation.getTheme()); return formationDTO;
		 */
	    
	    return FormationDTO.builder()
	            .idFormation(formation.getIdFormation())
	            .nomFormation(formation.getNomFormation())
	            .prixFormation(formation.getPrixFormation())
	            .datedebut(formation.getDatedebut())
	            .datefin(formation.getDatefin())
	            .modeFormation(formation.getModeFormation())
	            .theme(formation.getTheme())
	            .build();
	}


	

}
