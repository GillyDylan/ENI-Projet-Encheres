package fr.eni.ecole.encheres.bo;

public class ArticleRecherche {
	private String filtre;
	private Categorie categorie;
	private boolean achat;
	private boolean param1;
	private boolean param2;
	private boolean param3;
	
	public String getFiltre() {
		return filtre;
	}
	public void setFiltre(String filtre) {
		this.filtre = filtre;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public boolean isAchat() {
		return achat;
	}
	public void setAchat(boolean achatVente) {
		this.achat = achatVente;
	}
	public boolean isParam1() {
		return param1;
	}
	public void setParam1(boolean param1) {
		this.param1 = param1;
	}
	public boolean isParam2() {
		return param2;
	}
	public void setParam2(boolean param2) {
		this.param2 = param2;
	}
	public boolean isParam3() {
		return param3;
	}
	public void setParam3(boolean param3) {
		this.param3 = param3;
	}
	
	public ArticleRecherche(String filtre, Categorie categorie, boolean achat, boolean param1, boolean param2,
			boolean param3) {
		super();
		this.filtre = filtre;
		this.categorie = categorie;
		this.achat = achat;
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
	}
	
	public ArticleRecherche() {
		super();
	}
}
