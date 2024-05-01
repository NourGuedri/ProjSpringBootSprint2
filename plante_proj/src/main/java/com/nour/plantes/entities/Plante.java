package com.nour.plantes.entities;


import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Plante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlante;
	private String nomPlante;
	private String couleur;
	private Date dateRendezVous ;
	@ManyToOne
	private Type type;
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Plante() {
	super();
	}
	public Plante(String nomPlante, String couleur, Date dateRendezVous) {
	super();
	this.nomPlante = nomPlante;
	this.couleur = couleur;
	this.dateRendezVous = dateRendezVous;
	}
	
	public Long getIdPlante() {
		return idPlante;
		}
		public void setIdPlante(Long idPlante) {
		this.idPlante = idPlante;
		}
		public String getNomPlante() {
		return nomPlante;
		}
		public void setNomPlante(String nomPlante) {
		this.nomPlante = nomPlante;
		}
		public String getCouleur() {
		return couleur;
		}
		public void setCouleur(String couleur) {
		this.couleur = couleur;
		}
	public Date getDateRendezVous() {
	return dateRendezVous;
	}
	public void setDateRendezVous(Date dateRendezVous) {
	this.dateRendezVous = dateRendezVous;
	}
	@Override
	public String toString() {
	return "Plante [idPlante=" + idPlante + ", nomPlante=" +nomPlante + ", couleur=" + couleur
	+ ", dateRendezVous=" + dateRendezVous + "]";
	}
	}