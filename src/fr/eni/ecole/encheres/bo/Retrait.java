package fr.eni.ecole.encheres.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Retrait{
	
	@Id @GeneratedValue private int idRetrait;
	@NotNull @Column(nullable = false) private String adresseRetrait;
	@NotNull @Column(nullable = false) private int codePostalRetrait;
	@NotNull @Column(nullable = false) private String villeRetrait;
	

	public int getIdRetrait() {
		return idRetrait;
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
