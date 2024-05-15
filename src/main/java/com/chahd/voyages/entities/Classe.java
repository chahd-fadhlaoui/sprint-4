package com.chahd.voyages.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idCl;
	private String nomCl;
	private String descriptionCl;
	
	@OneToMany (mappedBy = "classe")
	@JsonIgnore

	private List<Voyage> voyages;

	
	public Long getIdCl() {
		return idCl;
	}
	public void setIdCl(Long idCl) {
		this.idCl = idCl;
	}
	public String getNomCl() {
		return nomCl;
	}
	public void setNomCl(String nomCl) {
		this.nomCl = nomCl;
	}
	public String getDescriptionCl() {
		return descriptionCl;
	}
	public void setDescriptionCl(String descriptionCl) {
		this.descriptionCl = descriptionCl;
	}
	public List<Voyage> getVoyages() {
		return voyages;
	}
	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}
	
	

}
