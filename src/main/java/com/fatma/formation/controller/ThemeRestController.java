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

import com.fatma.formation.entities.Theme;
import com.fatma.formation.repos.FormationThemeRepository;



@RestController
@RequestMapping("/api/thm") 
@CrossOrigin("*") 
public class ThemeRestController {

    @Autowired 
    private FormationThemeRepository themeRepository;

    // Get all themes
    @GetMapping
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    // Get a theme by ID
    @GetMapping("/{id}")
    public ResponseEntity<Theme> getThemeById(@PathVariable("id") Long id) {
        return themeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new theme
    @PostMapping
    public ResponseEntity<Theme> createTheme(@RequestBody Theme theme) {
        Theme savedTheme = themeRepository.save(theme);
        return ResponseEntity.status(201).body(savedTheme);
    }

    // Update an existing theme
    @PutMapping
    public ResponseEntity<Theme> updateTheme(@RequestBody Theme theme) {
        if (theme.getIdTheme() == null || !themeRepository.existsById(theme.getIdTheme())) {
            return ResponseEntity.notFound().build();
        }
        Theme updatedTheme = themeRepository.save(theme);
        return ResponseEntity.ok(updatedTheme);
    }

    // Delete a theme by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable("id") Long id) {
        if (!themeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        themeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
