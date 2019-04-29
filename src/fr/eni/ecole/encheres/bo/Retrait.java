package fr.eni.ecole.encheres.bo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Retrait {
	
	@Id private int idRetrait;
	private String rueRetrait;
	private int codePostalRetrait;
	private String villeRetrait;
	
	public int getIdRetrait() {
		return idRetrait;
	}
	public void setIdRetrait(int idRetrait) {
		this.idRetrait = idRetrait;
	}
	public String getRueRetrait() {
		return rueRetrait;
	}
	public void setRueRetrait(String rueRetrait) {
		this.rueRetrait = rueRetrait;
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
	
	public Retrait(int idRetrait, String rueRetrait, int codePostalRetrait, String villeRetrait) {
		super();
		this.setIdRetrait(idRetrait);
		this.setRueRetrait(rueRetrait);
		this.setCodePostalRetrait(codePostalRetrait);
		this.setVilleRetrait(villeRetrait);
	}
	
	public Retrait(String rueRetrait, int codePostalRetrait, String villeRetrait) {
		super();
		this.setRueRetrait(rueRetrait);
		this.setCodePostalRetrait(codePostalRetrait);
		this.setVilleRetrait(villeRetrait);
	}
	
	public Retrait() {
		super();
	}
	
	

}
