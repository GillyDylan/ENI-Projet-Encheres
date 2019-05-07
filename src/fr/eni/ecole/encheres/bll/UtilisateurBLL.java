package fr.eni.ecole.encheres.bll;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import fr.eni.ecole.encheres.bo.Article;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class UtilisateurBLL implements BLL<Utilisateur>{

	private String key = "SmogogoCestVraimentLePlusBeauEtCestPasNegociable";
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie l'Utilisateur ayant pour identifiant idUtilisateur.
	* @throws DALException 
	*/
	@Override
	public Utilisateur get(int...idUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectById(idUtilisateur[0]).get(0);
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie l'utilisateur contenant la chaine entrée.
	* @throws DALException 
	*/
	@Override
	public Utilisateur get(String chaine)throws DALException {
		// TODO Auto-generated method stub
		return BLLManager.getBLL(new Utilisateur()).getList(chaine).get(0);
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste des utilisateurs ayant les identifiants entrés
	* en paramètre.
	* @throws DALException 
	*/
	@Override
	public List<Utilisateur> getList(int...idUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectById(idUtilisateur);
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste des utilisateurs contenant dans leurs 
	* champs la chaine entrée en paramètre.
	* @throws DALException 
	*/
	@Override
	public List<Utilisateur> getList(String chaine) throws DALException {
			// TODO Auto-generated method stub
			List<Utilisateur> utilisateurs = BLLManager.getBLL(new Utilisateur()).getList();
			List<Utilisateur> utilisateursTrouves = new ArrayList<>();
			for(Utilisateur utilisateur : utilisateurs) {
				String nom = utilisateur.getNomUtilisateur();
				String prenom = utilisateur.getPrenomUtilisateur();
				String eMail = utilisateur.geteMailUtilisateur();
				String pseudo = utilisateur.getPseudonymeUtilisateur();
				String adresse = utilisateur.getRueUtilisateur();
				String ville = utilisateur.getVilleUtilisateur();
				//Remplace les majuscules en minuscules
				nom = nom.toLowerCase();
				prenom = prenom.toLowerCase();
				eMail = eMail.toLowerCase();
				pseudo = pseudo.toLowerCase();
				adresse = adresse.toLowerCase();
				ville = ville.toLowerCase();
				chaine = chaine.toLowerCase();
				//Retirer ponctuations et espaces/tab
				nom = nom.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
				prenom = prenom.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
				eMail = eMail.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
				pseudo = pseudo.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
				adresse = adresse.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
				ville = ville.replaceAll("[\\p{Punct}\\p{Blank}]", ""); 
				chaine = chaine.replaceAll("[\\p{Punct}\\p{Blank}]", "");
				//Retirer les accents
				nom = BLLManager.normalize(nom);
				prenom = BLLManager.normalize(prenom);
				eMail = BLLManager.normalize(eMail);
				pseudo = BLLManager.normalize(pseudo);
				adresse = BLLManager.normalize(adresse); 
				ville = BLLManager.normalize(ville); 
				chaine = BLLManager.normalize(chaine);
								
				if(ville.contains(chaine) ||
						adresse.contains(chaine) || 
						nom.contains(chaine) ||
						prenom.contains(chaine) ||
						eMail.contains(chaine) || 
						pseudo.contains(chaine)){
					utilisateursTrouves.add(utilisateur);
				}
			}
			return utilisateursTrouves;
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie la liste de tous les utilisateurs
	* @throws DALException 
	*/
	@Override
	public List<Utilisateur> getList() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectAll();
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Ajoute l'utilisateur
	* @throws DALException, BLLException 
	*/
	@Override
	public void set(Utilisateur utilisateur) throws BLLException, DALException {
		// TODO Auto-generated method stub
		List<Utilisateur> tousLesUtilisateurs = BLLManager.getBLL(new Utilisateur()).getList();
		if(utilisateur.getPseudonymeUtilisateur().trim() == null || 
				utilisateur.geteMailUtilisateur().trim() == null ||
				utilisateur.getCodePostalUtilisateur() == 0 ||
				utilisateur.getNomUtilisateur().trim() == null ||
				utilisateur.getPrenomUtilisateur().trim() == null ||
				utilisateur.getRueUtilisateur().trim() == null ||
				utilisateur.getVilleUtilisateur().trim() == null ||
				utilisateur.getMotDePasseUtilisateur().trim() == null ||
				utilisateur.getPseudonymeUtilisateur().trim() == "" || 
				utilisateur.geteMailUtilisateur().trim() == "" ||
				utilisateur.getNomUtilisateur().trim() == "" ||
				utilisateur.getPrenomUtilisateur().trim() == "" ||
				utilisateur.getRueUtilisateur().trim() == "" ||
				utilisateur.getVilleUtilisateur().trim() == "" ||
				utilisateur.getMotDePasseUtilisateur().trim() == "") {
			throw new BLLException(5000,"Tous les paramètres obligatoires ne sont pas fournis");
		}
		System.out.println(utilisateur.getMotDePasseUtilisateur());
		utilisateur.setMotDePasseUtilisateur(encrypt(utilisateur.getMotDePasseUtilisateur()));
		System.out.println(utilisateur.getMotDePasseUtilisateur());
		
		if(!utilisateur.getTelephoneUtilisateur().trim().matches("(0|\\+33|0033)[1-9][0-9]{8}")) {
			throw new BLLException(5001,"Téléphone invalide");
		}
		if(!utilisateur.geteMailUtilisateur().trim().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
			throw new BLLException(5002,"E-Mail invalide");
		}
		if(utilisateur.getCodePostalUtilisateur() < 1000 || utilisateur.getCodePostalUtilisateur() > 99999) {
			throw new BLLException(5003,"Code postal invalide");
		}
		List<Utilisateur> utilisateurs = BLLManager.getBLL(new Utilisateur()).getList(utilisateur.getIdUtilisateur());
		if(utilisateurs.size() == 0 ) {
			if(utilisateur.getPseudonymeUtilisateur().trim().length() < 3) {
				throw new BLLException(5010,"Le pseudonyme doit être de 3 caractères minimum");
			}
			if(!utilisateur.getPseudonymeUtilisateur().trim().matches("^[a-zA-Z0-9_]*$")) {
				throw new BLLException(5011,"Le pseudonyme doit contenir uniquement des caractères alphanumériques");
			}
			for(Utilisateur u : tousLesUtilisateurs)
			{
				if(u.getPseudonymeUtilisateur().equals(utilisateur.getPseudonymeUtilisateur())) {
					throw new BLLException(5012,"Ce pseudonyme est déjà utilisé");
				}
				if(u.geteMailUtilisateur().equals(utilisateur.geteMailUtilisateur())) {
					throw new BLLException(5013,"Cet E-Mail est déjà utilisé");
				}
			}
			DAOFactory.getDAO(new Utilisateur()).insert(utilisateur);
		}
		else {
			Utilisateur oldUtilisateur = utilisateurs.get(0);
			if(oldUtilisateur.getPseudonymeUtilisateur() != utilisateur.getPseudonymeUtilisateur()) {
				throw new BLLException(5020,"Le pseudonyme d'un utilisateur déjà créé ne peut être modifié");
			}
			if(oldUtilisateur.geteMailUtilisateur() != utilisateur.geteMailUtilisateur()) {
				throw new BLLException(5021,"L'E-Mail d'un utilisateur déjà créé ne peut être modifié");
			}
			DAOFactory.getDAO(new Utilisateur()).update(utilisateur);
		}
	}

	
	/**
	* @author ${Dylan Gilly}
	*
	* Supprime l'utilisateur en passant ses champs a null
	* @throws DALException, BLLException 
	*/
	@Override
	public void delete(Utilisateur utilisateur) throws DALException, BLLException {
		// TODO Auto-generated method stub
		if(utilisateur.getCreditUtilisateur() < 0) {
			throw new BLLException(5030, "Impossible de supprimer un utilisateur avec une dette");
		}
		List<Enchere> encheres = BLLManager.getBLL(new Enchere()).getList();
		Collections.reverse(encheres);
		List<Article> articles = BLLManager.getBLL(new Article()).getList();
		for(Article article : articles) {
			if(article.getUtilisateurAchetant().getIdUtilisateur() == utilisateur.getIdUtilisateur()) {
				//Si l'uilitsateur à supprimer a des enchères gagnantes
				for(Enchere enchere : encheres) {
					if(enchere.getArticle().getIdArticle() == article.getIdArticle()) {
						if(enchere.getUtilisateur().getIdUtilisateur() != utilisateur.getIdUtilisateur()) {
							//On update l'article avec la précédente meilleure enchère
							article.setUtilisateurAchetant(enchere.getUtilisateur());
						} 
					}
				}	
			}
		}
		utilisateur.setActif(false);
		utilisateur.setCodePostalUtilisateur(99999);
		utilisateur.setCreditUtilisateur(0);
		utilisateur.seteMailUtilisateur(null);
		utilisateur.setMotDePasseUtilisateur(null);
		utilisateur.setNomUtilisateur("supprimé");
		utilisateur.setPrenomUtilisateur("Compte");
		utilisateur.setPseudonymeUtilisateur(null);
		utilisateur.setRueUtilisateur(null);
		utilisateur.setTelephoneUtilisateur(null);
		utilisateur.setVilleUtilisateur(null);
	}
	
	
	/**
	* @author ${Dylan Gilly}
	*
	* Renvoie true si le mot de passe correspond,
	* sinon false.
	 * @throws DALException 
	*/
	public boolean checkMotDePasse(String login, String motDePasse) throws DALException {
		boolean check = false;
		List<Utilisateur> utilisateurs = this.getList();
		for(Utilisateur utilisateur : utilisateurs) {
			if(utilisateur.getPseudonymeUtilisateur().contentEquals(login)){
				if(motDePasse.equals(decrypt(utilisateur.getMotDePasseUtilisateur()))) {
					check = true;
					return check;
				}
			}
		}
		return check;
	}


	private String encrypt(String password){
		try{
			Key clef = new SecretKeySpec(this.key.getBytes("UTF-8"),"AES");
			Cipher cipher=Cipher.getInstance("AES");
			System.out.println(clef);
			cipher.init(Cipher.ENCRYPT_MODE,clef);
			return new String(cipher.doFinal(password.getBytes()));
		}
			catch (Exception e){
				e.printStackTrace();
				System.out.println(e.getMessage());
				return null;
		}
	}
	
	
	private String decrypt(String password){
		try{
			Key clef = new SecretKeySpec(this.key.getBytes("UTF-8"),"AES");
			Cipher cipher=Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE,clef);
			return new String(cipher.doFinal(password.getBytes()));
		}
			catch (Exception e){
				return null;
		}
	}




}
