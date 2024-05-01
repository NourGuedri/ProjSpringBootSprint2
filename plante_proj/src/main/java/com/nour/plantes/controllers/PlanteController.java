package com.nour.plantes.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.nour.plantes.entities.Plante;
import com.nour.plantes.service.PlanteService;

@Controller
public class PlanteController {
	@Autowired
	PlanteService planteService;

	@RequestMapping("/ListePlantes")
	public String listePlantes(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		Page<Plante> pls = planteService.getAllPlantesParPage(page, size);
		modelMap.addAttribute("plantes", pls);
		 modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listePlantes";

	}

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createPlante";
	}

	@RequestMapping("/savePlante")
	public String savePlante(@ModelAttribute("plante") Plante plante, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateRendezVous = dateformat.parse(String.valueOf(date));
		plante.setDateRendezVous(dateRendezVous);

		Plante savePlante = planteService.savePlante(plante);
		String msg = "plante enregistré avec Id " + savePlante.getIdPlante();
		modelMap.addAttribute("msg", msg);
		return "createPlante";
	}

	@RequestMapping("/supprimerPlante")
	public String supprimerPlante(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size) {
		planteService.deletePlanteById(id);
		Page<Plante> pls = planteService.getAllPlantesParPage(page,
				size);
				modelMap.addAttribute("plantes", pls);
				modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);

		return "listePlantes";
	}

	@RequestMapping("/modifierPlante")
	public String editerPlante(@RequestParam("id") Long id, ModelMap modelMap) {
		Plante p = planteService.getPlante(id);
		modelMap.addAttribute("plante", p);
		return "editerPlante";
	}

	@RequestMapping("/updatePlante")
	public String updatePlante(@ModelAttribute("plante") Plante plante, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateRendezVous = dateformat.parse(String.valueOf(date));
		plante.setDateRendezVous(dateRendezVous);

		planteService.updatePlante(plante);
		List<Plante> pls = planteService.getAllPlantes();
		modelMap.addAttribute("plantes", pls);
		return "listePlantes";
	}
}