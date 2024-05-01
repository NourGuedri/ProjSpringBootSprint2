package com.nour.plantes.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Type {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idType;
private String nomType;
private String descriptionType;

@OneToMany(mappedBy = "type")
@JsonIgnore
private List<Plante> plantes;
public Type(String nomType, String descriptionType, List<Plante> plantes) 
{
super();
this.nomType = nomType;
this.descriptionType = descriptionType;
this.plantes = plantes;
}
public Long getIdType() {
return idType;
}
public void setIdType(Long idType) {
this.idType = idType;
}
public String getNomType() {
return nomType;
}
public void setNomType(String nomType) {
this.nomType = nomType;
}
public String getDescriptionType() {
return descriptionType;
}
public void setDescriptionType(String descriptionType) {
this.descriptionType = descriptionType;
}
public List<Plante> getPlantes() {
return plantes;
}
public void setPlantes(List<Plante> plantes) {
this.plantes = plantes;
}
}
