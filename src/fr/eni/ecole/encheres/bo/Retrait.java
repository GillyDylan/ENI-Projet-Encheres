package fr.eni.ecole.encheres.bo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Retrait{
	
	@Id private int idRetrait;
	private String adresseRetrait;
	private int codePostalRetrait;
	private String villeRetrait;
	

	public int getIdRetrait() {
		return idRetrait;
	}
	public void setIdRetrait(int idRetrait) {
		this.idRetrait = idRetrait;
	}
	public String getAdresseRetrait() {
		return adresseRetrait;
	}
	public void setAdresseRetrait(String rueRetrait) {
		this.adresseRetrait = rueRetrait;
	}
	public int getCodePostalRetrait() {
		return codePostalRetrait;
	}
	public void setCodePostalRetrait(int codePostalRetrait) {
		this.codePostalRetrait = codePostalRetrait;
	}
	public String getVilleRetrait() {
		return villeRetrait;
	}
	public void setVilleRetrait(String villeRetrait) {
		this.villeRetrait = villeRetrait;
	}
	
	public Retrait( String adresseRetrait, int codePostalRetrait, String villeRetrait) {
		super();
		this.setAdresseRetrait(adresseRetrait);
		this.setCodePostalRetrait(codePostalRetrait);
		this.setVilleRetrait(villeRetrait);
	}

	
	public Retrait() {
		super();
	}
	
	

}
