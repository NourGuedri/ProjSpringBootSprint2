package com.nour.plantes.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nour.plantes.entities.Plante;
import com.nour.plantes.entities.Type;
import com.nour.plantes.repos.PlanteRepository;
@Service
public class PlanteServiceImpl implements PlanteService {
@Autowired
PlanteRepository planteRepository;
@Override
public Plante savePlante(Plante p) {
return planteRepository.save(p);
}
@Override
public Plante updatePlante(Plante p) {
return planteRepository.save(p);
}
@Override
public void deletePlante(Plante p) {
planteRepository.delete(p);
}
 @Override
public void deletePlanteById(Long id) {
planteRepository.deleteById(id);
}
@Override
public Plante getPlante(Long id) {
return planteRepository.findById(id).get();
}
@Override
public List<Plante> getAllPlantes() {
return planteRepository.findAll();
}
@Override
public Page<Plante> getAllPlantesParPage(int page, int size) {
	return planteRepository.findAll(PageRequest.of(page, size));
}
@Override
public List<Plante> findByNomPlante(String nom) {

	return planteRepository.findByNomPlante(nom);
}
@Override
public List<Plante> findByNomPlanteContains(String nom) {

	return planteRepository.findByNomPlanteContains(nom);
}
@Override
public List<Plante> findByCouleur(String nom, String couleur) {

	return planteRepository.findByCouleur(nom, couleur);
}
@Override
public List<Plante> findByType(Type type) {

	return planteRepository.findByType(type);
}
@Override
public List<Plante> findByTypeIdType(Long id) {

	return planteRepository.findByTypeIdType(id);
}
@Override
public List<Plante> findByOrderByNomPlanteAsc() {

	return planteRepository.findByOrderByNomPlanteAsc();
}
@Override
public List<Plante> trierPlantesNomsCouleur() {

	return planteRepository.trierPlantesNomsCouleurs();
}
}