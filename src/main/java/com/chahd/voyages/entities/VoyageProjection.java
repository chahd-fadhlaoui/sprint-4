package com.chahd.voyages.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomVoya", types = { Voyage.class })

public interface VoyageProjection {
	public String getNomVoyage();


}
