package com.chahd.voyages;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.chahd.voyages.entities.Classe;
import com.chahd.voyages.entities.Voyage;
import com.chahd.voyages.repos.VoyageRepository;
import com.chahd.voyages.service.VoyageService;

@SpringBootTest
class VoyagesApplicationTests {
	@Autowired
	private VoyageRepository voyageRepository;
	@Autowired

	private VoyageService voyageService;
	@Test
	public void testCreateVoyage() {
	Voyage voya = new Voyage("istanbul",2800.500,new Date());
	voyageRepository.save(voya);
	}
	 @Test
	 public void testFindVoyage()
	 {
		 Voyage v = voyageRepository.findById(1L).get();
	 System.out.println(v);
	 }
	 
	 @Test
	 public void testUpdateVoyage()
	 {
		 Voyage v = voyageRepository.findById(1L).get();
	 v.setPrixVoyage(1000.0);
	 voyageRepository.save(v);
	 }
	 @Test
	 public void testDeleteVoyage()
	 {
		 voyageRepository.deleteById(1L);;
	 }
	 
	 @Test
	 public void testListerTousVoyages()
	 {
	 List<Voyage> voyas = voyageRepository.findAll();
	 for (Voyage v : voyas)
	 {
	 System.out.println(v);
	 }
	 }
	 @Test
	 public void testFindByNomProduitContains() {
	     Page<Voyage> voyages = voyageService.getAllVoyagesParPage(0, 2);
	     System.out.println(voyages.getSize());
	     System.out.println(voyages.getTotalElements());
	     System.out.println(voyages.getTotalPages());
	     voyages.getContent().forEach(v -> {
	         System.out.println(v.toString());
	     });
	     /*ou bien
	     for (Voyage v : voyages) {
	         System.out.println(v);
	     } */
	 }
	 @Test
	 public void testFindVoyageByNom()
	 {
		List < Voyage> voyas = voyageRepository.findByNomVoyage("istanbul");
		 for (Voyage v : voyas) 
	         System.out.println(v);
	     
	 }
	 @Test
	 public void testFindVoyageByNomContains()
	 {
		List < Voyage> voyas = voyageRepository.findByNomVoyageContains("p");
		 for (Voyage v : voyas) 
	         System.out.println(v);
	     
	 }
	 @Test
	 public void testfindByNomPrix() {
	     List<Voyage> voyages = voyageRepository.findByNomPrix("istanbul", 1000.0);
	     for (Voyage v : voyages) {
	         System.out.println(v);
	     }
	 }


	 @Test
	 public void testFindByClasse() {
	     Classe classe = new Classe();
	     classe.setIdCl(1L);
	     List<Voyage> voyages = voyageRepository.findByClasse(classe);
	     for (Voyage v : voyages) {
	         System.out.println(v);
	     }
	 }
	 
	 @Test
	 public void findByClasseIdClasse() {
	     List<Voyage> voyages = voyageRepository.findByClasseIdCl(1L);
	     for (Voyage v : voyages) {
	         System.out.println(v);
	     }
	 }
	 
	 @Test
	 public void testFindByOrderByNomVoyageAsc() {
	     List<Voyage> voyages = voyageRepository.findByOrderByNomVoyageAsc();
	     for (Voyage v : voyages) {
	         System.out.println(v);
	     }
	 }

	 @Test
	 public void testTrierVoyagesNomsPrix() {
	     List<Voyage> voyages = voyageRepository.trierVoyagesNomsPrix();
	     for (Voyage v : voyages) {
	         System.out.println(v);
	     }
	 }



}
