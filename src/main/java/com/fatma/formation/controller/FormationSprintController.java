package com.fatma.formation.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.fatma.formation.entities.Formation;
import com.fatma.formation.service.FormationSprintService;

@Controller

public class FormationSprintController {

    @Autowired
    FormationSprintService formationService;

  
  
    @RequestMapping("/ListeFormations")
    public String listeFormations(ModelMap modelMap,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Formation> formations = formationService.getAllFormationsParPage(page, size);
        modelMap.addAttribute("formations", formations);
        modelMap.addAttribute("pages", new int[formations.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeFormations";
    }

  
    @GetMapping("/create")
    public String showCreateFormation(ModelMap modelMap) {
        modelMap.addAttribute("formation", new Formation());
        return "createFormation";
    }

  
    @PostMapping("/save")
    public String saveFormation(
            @ModelAttribute("formation") Formation formation,
            @RequestParam("datedebut") String datedebut,
            @RequestParam("datefin") String datefin,
            ModelMap modelMap) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formation.setDatedebut(LocalDate.parse(datedebut, formatter));
        formation.setDatefin(LocalDate.parse(datefin, formatter));

        Formation savedFormation = formationService.saveFormation(formation);
        modelMap.addAttribute("msg", "Formation enregistrée avec Id " + savedFormation.getIdFormation());
        return "createFormation";
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

    
    @GetMapping("/edit")
    public String editerFormation(@RequestParam("id") Long id, ModelMap modelMap) {
        Formation formation = formationService.getFormation(id);
        modelMap.addAttribute("formation", formation);
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
}
