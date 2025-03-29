package com.fatma.formation.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "formationSprint")  
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFormation;

    private String nomFormation;
    private long prixFormation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datedebut;

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

    public long getIdFormation() {
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

    public long getPrixFormation() {
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
