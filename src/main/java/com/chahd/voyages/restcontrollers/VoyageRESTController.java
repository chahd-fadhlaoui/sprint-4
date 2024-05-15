package com.chahd.voyages.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chahd.voyages.entities.Voyage;
import com.chahd.voyages.service.VoyageService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VoyageRESTController {
	@Autowired
	VoyageService voyageService;
	@RequestMapping(method = RequestMethod.GET)

	public List<Voyage> getAllVoyages() 
	{
	    return voyageService.getAllVoyages();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Voyage getVoyageById(@PathVariable("id") Long id) {
	    return voyageService.getVoyage(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public Voyage createVoyage(@RequestBody Voyage voyage) {
	    return voyageService.saveVoyage(voyage);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Voyage updateVoyage(@RequestBody Voyage voyage) {
	    return voyageService.updateVoyage(voyage);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteVoyage(@PathVariable("id") Long id) {
	    voyageService.deleteVoyageById(id);
	}
	@RequestMapping(value="/voyacl/{idCl}", method = RequestMethod.GET)
	public List<Voyage> getVoyagesByClId(@PathVariable("idCl") Long idCl) {
	    return voyageService.findByClasseIdCl(idCl);
	}



	


}
