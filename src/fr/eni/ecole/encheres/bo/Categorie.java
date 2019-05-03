package fr.eni.ecole.encheres.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Categorie {
	
	@Id @GeneratedValue private int idCategorie;
	@NotNull @Column(nullable = false) private String libelleCategorie;
	
	public int getIdCategorie() {
		return idCategorie;
	}
	
	public String getLibelleCategorie() {
		return libelleCategorie;
	}
	
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}
	
	public Categorie(String libelleCategorie) {
		super();
		this.setLibelleCategorie(libelleCategorie);
	}
	
	public Categorie() {
		super();
	}
	
}
