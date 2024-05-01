package com.nour.plantes.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nour.plantes.entities.Plante;
import com.nour.plantes.service.PlanteService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class PlanteRESTController {
@Autowired
PlanteService planteService;
@RequestMapping(method = RequestMethod.GET)
public List<Plante> getAllPlantes() {
return planteService.getAllPlantes();
}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Plante getPlanteById(@PathVariable("id") Long id) {
return planteService.getPlante(id);
 }

@RequestMapping(method = RequestMethod.POST)
public Plante createPlante(@RequestBody Plante plante) {
return planteService.savePlante(plante);
}

@RequestMapping(method = RequestMethod.PUT)
public Plante updatePlante(@RequestBody Plante plante) {
return planteService.updatePlante(plante);
}

@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deletePlante(@PathVariable("id") Long id)
{
planteService.deletePlanteById(id);
}

@RequestMapping(value="/plantstype/{idType}",method = RequestMethod.GET)
public List<Plante> getPlantesByTypeId(@PathVariable("idType") Long idType) {
return planteService.findByTypeIdType(idType);
}





}
