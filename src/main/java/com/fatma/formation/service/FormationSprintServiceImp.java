package com.fatma.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fatma.formation.entities.Formation;
import com.fatma.formation.repos.FormationSprintRepository;

@Service
public class FormationSprintServiceImp implements FormationSprintService {

	@Autowired
	FormationSprintRepository formationRepository;
	

	@Override
	public Formation saveFormation(Formation f) {
		return formationRepository.save(f);
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
	public Formation  getFormation(Long id) {
		return formationRepository.findById(id).get();
	}

	@Override
	public List<Formation> getAllFormations() {
		return formationRepository.findAll();
	}
	
	@Override
    public Page<Formation> getAllFormationsParPage(int page, int size) {
        return formationRepository.findAll(PageRequest.of(page, size));
    }

}
