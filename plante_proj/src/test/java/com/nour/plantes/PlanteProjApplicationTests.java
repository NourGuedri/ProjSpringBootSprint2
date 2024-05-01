package com.nour.plantes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.nour.plantes.repos.PlanteRepository;
import com.nour.plantes.service.PlanteService;
import com.nour.plantes.entities.Plante;
import com.nour.plantes.entities.Type;


@SpringBootTest
class PlanteProjApplicationTests {

	@Autowired
	private PlanteRepository planteRepository;
	@Autowired
	private PlanteService planteService;
	@Test
	public void testCreatePlante() {
	Plante pl = new Plante("Cactus","Jaune",new Date());
	planteRepository.save(pl);
	}
	@Test
	public void testFindPlante()
	{
		Plante pl = planteRepository.findById(1L).get();
	System.out.println(pl);
	}
	@Test
	public void testUpdatePlante()
	{
	Plante pl = planteRepository.findById(1L).get();
	pl.setCouleur("Blanche");
	planteRepository.save(pl);
	}
	@Test
	public void testDeletePlante()
	{
		planteRepository.deleteById(1L);;
		}

		@Test
		public void testListerTousPlantes()
		{
		List<Plante> pls = planteRepository.findAll();
		for (Plante pl : pls)
		{
		System.out.println(pl);
		}
		}
		
		@Test
		public void testFindByNomContains()
		{
		Page<Plante> pls = planteService.getAllPlantesParPage(0,2);
		System.out.println(pls.getSize());
		System.out.println(pls.getTotalElements());
		System.out.println(pls.getTotalPages());
		pls.getContent().forEach(p -> {System.out.println(p.toString());
		 });
		/*ou bien
		for (Plante p : pls)
		{
		System.out.println(p);
		} */
		}
		
		@Test
		 public void testFindByNomPlante()
		 {
		 List<Plante> pls = planteRepository.findByNomPlante("Cactus");
		 for (Plante p : pls)
		 {
		 System.out.println(p);
		 }
		 }
		
		@Test
		public void testFindByNomPlanteContains ()
		{
		List<Plante> pls=planteRepository.findByNomPlanteContains("p");
		for (Plante p : pls)
		{
		System.out.println(p);
		} }

		@Test
		public void testfindByCouleur()
		{
		List<Plante> pls = planteRepository.findByCouleur("Tulipe","J");
		for (Plante p : pls)
		{
		System.out.println(p);
		}
		}

		@Test
		public void testfindByType()
		{
			Type t = new Type();
		t.setIdType(1L);
		List<Plante> pls = planteRepository.findByType(t);
		for (Plante p : pls)
		{
		System.out.println(p);
		}
		}

		@Test
		public void findByTypeIdCat()
		{
		List<Plante> pls = planteRepository.findByTypeIdType(1L);
		for (Plante p : pls)
		{
		System.out.println(p);
		}
		 }
		
		@Test
		public void testfindByOrderByNomPlanteAsc()
		{
		List<Plante> pls = planteRepository.findByOrderByNomPlanteAsc();
		for (Plante p : pls)
		{
		System.out.println(p);
		}
		}
		
		@Test
		public void trierPlantesNomsCouleurs()
		{
		List<Plante> pls = planteRepository.trierPlantesNomsCouleurs();
		for (Plante p : pls)
		{
		System.out.println(p);
		}
		}
}
