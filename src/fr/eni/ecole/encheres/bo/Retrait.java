package fr.eni.ecole.encheres.bo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Retrait {
	
	@OneToOne @Id private Article article;
	private String rueRetrait;
	private int codePostalRetrait;
	private String villeRetrait;
	

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
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
	
	public Retrait(Article article, String rueRetrait, int codePostalRetrait, String villeRetrait) {
		super();
		this.setArticle(article);
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
