package com.fatma.formation.entities;

import java.time.LocalDate;

import com.fatma.formation.entities.Theme;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormationDTO {
    private Long idFormation;
    private String nomFormation;
    private Long prixFormation;
    private LocalDate datedebut;
    private LocalDate datefin;
    private String modeFormation;
    private Theme theme;
}
