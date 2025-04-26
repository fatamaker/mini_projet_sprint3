package com.fatma.formation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.fatma.formation.entities.Formation;
import com.fatma.formation.entities.FormationDTO;
import com.fatma.formation.service.FormationSprintService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller

public class FormationSprintController {

    @Autowired
    FormationSprintService formationService;
    
    @Autowired
    FormationSprintService themeService;
  
  
    @RequestMapping("/listeFormations")
    public String listeFormations(ModelMap modelMap,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Formation> formations = formationService.getAllFormationsParPage(page, size);
        modelMap.addAttribute("formations", formations);
        modelMap.addAttribute("pages", new int[formations.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeFormations";
    }

  
    @RequestMapping("/showCreate")
    public String showCreateFormation(ModelMap modelMap) {
        modelMap.addAttribute("formation", new Formation());
        modelMap.addAttribute("themes", themeService.getAllThemes());
       
        return "createFormation";
    }
    

    @RequestMapping("/saveFormation")
    public String saveFormation(@Valid Formation formation,
            BindingResult bindingResult,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size,
            ModelMap modelMap) {
    	
    	
    	int currentPage;
        boolean isNew = (formation.getIdFormation() == null);

        if (bindingResult.hasErrors()) {
        	 modelMap.addAttribute("themes", themeService.getAllThemes());
        	 modelMap.addAttribute("page", page);
             modelMap.addAttribute("size", size);
            return "createFormation";
        }

        FormationDTO savedFormation = formationService.saveFormation(formation);
       
        if (isNew) {
            Page<Formation> formations = formationService.getAllFormationsParPage(page, size);
            currentPage = formations.getTotalPages() - 1;
        } else {
            currentPage = page;
        }

        return "redirect:/listeFormations?page=" + currentPage + "&size=" + size;
    }
    


   
    @RequestMapping("/supprimerFormation")
    public String supprimerFormation(@RequestParam("id") Long id,
                                     ModelMap modelMap,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "2") int size) {
        formationService.supprimerFormationById(id);
        Page<Formation> formations = formationService.getAllFormationsParPage(page, size);
        modelMap.addAttribute("formations", formations);
        modelMap.addAttribute("pages", new int[formations.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeFormations";
    }

    
    @GetMapping("/modifierFormation")
    public String editerFormation(@RequestParam("id") Long id,
    		@RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "2") int size,
            ModelMap modelMap) {
        FormationDTO formation = formationService.getFormation(id);
        modelMap.addAttribute("themes", themeService.getAllThemes());
        modelMap.addAttribute("formation", formation);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "editerFormation";
    }

   
    @PostMapping("/update")
    public String updateFormation(
            @ModelAttribute("formation") Formation formation,
            @RequestParam("datedebut") String datedebut,
            @RequestParam("datefin") String datefin,
            ModelMap modelMap) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formation.setDatedebut(LocalDate.parse(datedebut, formatter));
        formation.setDatefin(LocalDate.parse(datefin, formatter));

        formationService.updateFormation(formation);
        modelMap.addAttribute("formations", formationService.getAllFormations());
        return "listeFormations";
    }
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
