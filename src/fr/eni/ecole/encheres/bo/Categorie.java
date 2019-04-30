package fr.eni.ecole.encheres.bo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categorie {
	
	@Id @GeneratedValue private int idCategorie;
	private String libelleCategorie;
	
	public int getIdCategorie() {
		return idCategorie;
	}
	
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public String getLibelleCategorie() {
		return libelleCategorie;
	}
	
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}
	
	public Categorie(int idCategorie, String libelleCategorie) {
		super();
		this.setIdCategorie(idCategorie);
		this.setLibelleCategorie(libelleCategorie);	}
	
	public Categorie(String libelleCategorie) {
		super();
		this.setLibelleCategorie(libelleCategorie);
	}
	
	public Categorie() {
		super();
	}
	
}
