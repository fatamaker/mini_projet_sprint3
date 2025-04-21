package com.fatma.formation.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "formationSprint")  
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormation;

    
    @NotNull
    @Size (min = 4,max = 15)
    
    @Column(name = "nom_formation", length = 255)
    private String nomFormation;
    
    
    @Min(value = 10)
    @Max(value = 10000)
    private Long prixFormation;

    
    @Temporal(TemporalType.DATE)
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datedebut;
    
    
    @Temporal(TemporalType.DATE)
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datefin;

    private String modeFormation;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    public Formation() {}

    public Formation(String nomFormation, long prixFormation, LocalDate date, LocalDate date2, String modeFormation) {
        this.nomFormation = nomFormation;
        this.prixFormation = prixFormation;
        this.datedebut = date;
        this.datefin = date2;
        this.modeFormation = modeFormation;
    }

    public Long getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(long idFormation) {
        this.idFormation = idFormation;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public Long getPrixFormation() {
        return prixFormation;
    }

    public void setPrixFormation(long prixFormation) {
        this.prixFormation = prixFormation;
    }

    public LocalDate getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public String getModeFormation() {
        return modeFormation;
    }

    public void setModeFormation(String modeFormation) {
        this.modeFormation = modeFormation;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Formation [idFormation=" + idFormation + ", nomFormation=" + nomFormation + ", prixFormation="
                + prixFormation + ", datedebut=" + datedebut + ", datefin=" + datefin + ", modeFormation="
                + modeFormation + "]";
    }
}
