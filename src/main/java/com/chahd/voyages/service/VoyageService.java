package com.chahd.voyages.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.chahd.voyages.entities.Classe;
import com.chahd.voyages.entities.Voyage;

public interface VoyageService {
	Voyage saveVoyage(Voyage v);
	Voyage updateVoyage(Voyage v);
	void deleteVoyage(Voyage v);
	 void deleteVoyageById(Long id);
	 Voyage getVoyage(Long id);
	List<Voyage> getAllVoyages();
	Page<Voyage> getAllVoyagesParPage(int page, int size);
	List<Voyage> findByNomVoyage(String nom);
    List<Voyage> findByNomVoyageContains(String nom);
    List<Voyage> findByNomPrix(String nom, Double prix);
    List<Voyage> findByClasse(Classe classe);
    List<Voyage> findByClasseIdCl(Long id);
    List<Voyage> findByOrderByNomVoyageAsc();
    List<Voyage> trierVoyagesNomsPrix();
    List<Classe> getAllClasses();


}
