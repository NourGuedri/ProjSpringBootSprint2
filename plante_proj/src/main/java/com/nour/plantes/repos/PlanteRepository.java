package com.nour.plantes.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nour.plantes.entities.Plante;
import com.nour.plantes.entities.Type;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path ="rest")
public interface PlanteRepository extends JpaRepository<Plante, Long> {
	 List<Plante> findByNomPlante(String nom);
	 List<Plante> findByNomPlanteContains(String nom);
//	 @Query("select p from Plante p where p.nomPlante like %?1 and p.couleur > ?2")
//	 List<Plante> findByCouleur (String nom, String couleur);
	 
	 @Query("select p from Plante p where p.nomPlante like %:nom and p.couleur > :couleur")
	 List<Plante> findByCouleur (@Param("nom") String nom,@Param("couleur") String couleur);

	 @Query("select p from Plante p where p.type = ?1")
	 List<Plante> findByType (Type type);

	 List<Plante> findByTypeIdType(Long id);
	 
	 List<Plante> findByOrderByNomPlanteAsc();
	 
	 @Query("select p from Plante p order by p.nomPlante ASC, p.couleur DESC")
	 List<Plante> trierPlantesNomsCouleurs ();



}
