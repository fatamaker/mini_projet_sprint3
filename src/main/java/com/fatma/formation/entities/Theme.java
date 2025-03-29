package com.fatma.formation.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Theme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTheme ;
	private String nomTheme  ;
	
	@JsonIgnore
		@OneToMany(mappedBy = "theme")
		private List<Formation> formations;
	
	  public Long getIdTheme() {
	        return idTheme;
	    }

	    public void setIdTheme(Long idTheme) {
	        this.idTheme = idTheme;
	    }
	public String getNomTheme() {
		return nomTheme;
	}
	public void setNomTheme(String nomTheme) {
		this.nomTheme = nomTheme;
	}
	public List<Formation> getFormations() {
		return formations;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	

}
