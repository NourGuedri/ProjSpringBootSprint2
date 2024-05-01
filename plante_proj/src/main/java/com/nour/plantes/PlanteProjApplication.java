package com.nour.plantes;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.nour.plantes.entities.Plante;
import com.nour.plantes.service.PlanteService;
@SpringBootApplication
//pour tester implements CommandLineRunner 👇🏿👇🏿👇🏿
public class PlanteProjApplication implements CommandLineRunner{
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
	SpringApplication.run(PlanteProjApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Plante.class);
	}
//@Override
//public void run(String... args) throws Exception {
//    planteService.savePlante(new Plante("Tulipe", "Jaune", new Date()));
//    planteService.savePlante(new Plante("Orchidée", "Violet", new Date()));
//    planteService.savePlante(new Plante("Lys", "Blanc", new Date()));
//    planteService.savePlante(new Plante("Dahlia", "Rose", new Date()));
//    planteService.savePlante(new Plante("Iris", "Bleu", new Date()));
//    planteService.savePlante(new Plante("Pivoine", "Rouge", new Date()));
//    planteService.savePlante(new Plante("Bégonia", "Orange", new Date()));
//    planteService.savePlante(new Plante("Amaryllis", "Rouge", new Date()));
//    planteService.savePlante(new Plante("Azalée", "Rose", new Date()));
//}
}