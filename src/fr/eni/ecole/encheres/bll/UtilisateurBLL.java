package fr.eni.ecole.encheres.bll;

import java.security.Key;

import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class UtilisateurBLL implements BLL<Utilisateur>{

	private String key = "SmogogoCestVraimentLePlusBeauEtCestPasNegociable";
	
	@Override
	public Utilisateur get(int idUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectById(idUtilisateur).get(0);
	}
	
	@Override
	public Utilisateur get(String chaine)throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectByString(chaine).get(0);
	}

	@Override
	public List<Utilisateur> get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectAll();
	}
	
	@Override
	public List<Utilisateur> get(int...ids) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectById(ids[0]);
	}

	@Override
	public void set(Utilisateur utilisateur) throws BLLException, DALException {
		// TODO Auto-generated method stub
		if(utilisateur.getPseudonymeUtilisateur().trim() == null || 
				utilisateur.geteMailUtilisateur().trim() == null ||
				utilisateur.getCodePostalUtilisateur() == 0 ||
				utilisateur.getNomUtilisateur().trim() == null ||
				utilisateur.getPrenomUtilisateur().trim() == null ||
				utilisateur.getRueUtilisateur().trim() == null ||
				utilisateur.getVilleUtilisateur().trim() == null) {
			throw new BLLException(5000,"Tous les paramètres obligatoires ne sont pas fournis");
		}
		utilisateur.setMotDePasseUtilisateur(encrypt(utilisateur.getMotDePasseUtilisateur()));
		if(!utilisateur.getTelephoneUtilisateur().trim().matches("(0|\\+33|0033)[1-9][0-9]{8}")) {
			throw new BLLException(5001,"Téléphone invalide");
		}
		if(!utilisateur.geteMailUtilisateur().trim().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
			throw new BLLException(5002,"E-Mail invalide");
		}
		if(utilisateur.getCodePostalUtilisateur() < 1000 || utilisateur.getCodePostalUtilisateur() > 99999) {
			throw new BLLException(5003,"Code postal invalide");
		}
		List<Utilisateur> utilisateurs = DAOFactory.getDAO(new Utilisateur()).selectById(utilisateur.getIdUtilisateur());
		if(utilisateurs.size() == 0 ) {
			if(utilisateur.getPseudonymeUtilisateur().trim().length() < 3) {
				throw new BLLException(5010,"Le pseudonyme doit être de 3 caractères minimum");
			}
			if(!utilisateur.getPseudonymeUtilisateur().trim().matches("^[a-zA-Z0-9_]*$")) {
				throw new BLLException(5011,"Le pseudonyme doit contenir uniquement des caractères alphanumériques");
			}
			if(DAOFactory.getDAO(new Utilisateur()).selectByString(utilisateur.getPseudonymeUtilisateur()).size() != 0) {
				throw new BLLException(5012,"Ce pseudonyme est déjà utilisé");
			}
			if(DAOFactory.getDAO(new Utilisateur()).selectByString(utilisateur.geteMailUtilisateur()).size() != 0) {
				throw new BLLException(5013,"Cet E-Mail est déjà utilisé");
			}
			DAOFactory.getDAO(new Utilisateur()).insert(utilisateur);
		}
		else {
			Utilisateur oldUtilisateur = utilisateurs.get(0);
			if(oldUtilisateur.getPseudonymeUtilisateur()!=utilisateur.getPseudonymeUtilisateur()) {
				throw new BLLException(5020,"Le pseudonyme d'un utilisateur déjà créé ne peut être modifié");
			}
			if(oldUtilisateur.geteMailUtilisateur()!=utilisateur.geteMailUtilisateur()) {
				throw new BLLException(5021,"L'E-Mail d'un utilisateur déjà créé ne peut être modifié");
			}
			DAOFactory.getDAO(new Utilisateur()).update(utilisateur);
		}
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		DAOFactory.getDAO(new Utilisateur()).delete(id);
	}
	
	public boolean checkMotDePasse(Utilisateur utilisateur, String motDePasse) {
		if(motDePasse.equals(decrypt(utilisateur.getMotDePasseUtilisateur()))) {
			return true;
		}else {
			return false;
		}
	}

	private String encrypt(String password){
		try
		{
			Key clef = new SecretKeySpec(this.key.getBytes("ISO-8859-2"),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE,clef);
		return new String(cipher.doFinal(password.getBytes()));
		}
			catch (Exception e)
		{
				System.out.println(e.getMessage());
				return null;
		}
	}
	
	private String decrypt(String password){
		try
		{
			Key clef = new SecretKeySpec(this.key.getBytes("ISO-8859-2"),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE,clef);
			return new String(cipher.doFinal(password.getBytes()));
		}
			catch (Exception e)
		{
				return null;
		}
	}




}
