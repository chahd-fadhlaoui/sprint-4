package com.chahd.voyages.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chahd.voyages.entities.Classe;
import com.chahd.voyages.entities.Voyage;
@RepositoryRestResource(path = "rest")

public interface VoyageRepository extends JpaRepository<Voyage, Long> {
	List<Voyage> findByNomVoyage(String nom);
	List<Voyage> findByNomVoyageContains(String nom);
	/*@Query("select v from Voyage v where v.nomVoyage like %?1 and v.prixVoyage > ?2")
	List<Voyage> findByNomPrix(String nom, Double prix);*/
	@Query("select v from Voyage v where v.nomVoyage like %:nom and v.prixVoyage > :prix")
	List<Voyage> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

	@Query("select v from Voyage v where v.classe = ?1")
	List<Voyage> findByClasse (Classe  classe );
	List<Voyage> findByClasseIdCl(Long id);
	List<Voyage> findByOrderByNomVoyageAsc();
	@Query("select v from Voyage v order by v.nomVoyage ASC, v.prixVoyage DESC")
	List<Voyage> trierVoyagesNomsPrix();




}
