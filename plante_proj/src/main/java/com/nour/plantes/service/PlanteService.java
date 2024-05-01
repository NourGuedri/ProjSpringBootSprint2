package com.nour.plantes.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nour.plantes.entities.Plante;
import com.nour.plantes.entities.Type;

public interface PlanteService {
	Plante savePlante(Plante p);
	Plante updatePlante(Plante p);
	void deletePlante(Plante p);
	 void deletePlanteById(Long id);
	 Plante getPlante(Long id);
	List<Plante> getAllPlantes();
	
	Page<Plante> getAllPlantesParPage(int page, int size);

	List<Plante> findByNomPlante(String nom);
	List<Plante> findByNomPlanteContains(String nom);
	List<Plante> findByCouleur(String nom, String couleur);
	List<Plante> findByType (Type type);
	List<Plante> findByTypeIdType(Long id);
	List<Plante> findByOrderByNomPlanteAsc();
	List<Plante> trierPlantesNomsCouleur();
}
