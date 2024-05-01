package com.nour.plantes.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomPlante", types = { Plante.class })

public interface PlanteProjection {
public String getNomPlante();
}

