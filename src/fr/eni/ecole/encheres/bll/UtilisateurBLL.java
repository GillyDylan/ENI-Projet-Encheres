package fr.eni.ecole.encheres.bll;

import java.security.Key;

import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;

public class UtilisateurBLL implements BLL<Utilisateur>{

	private String key = "SmogogoCestLePlusBeauSiSiJeVousJureCestVraimentLePlusBeauCestPasNegociable";
	
	@Override
	public Utilisateur get(int...idUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectById(idUtilisateur[0]).get(0);
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
	public void set(Utilisateur utilisateur) throws BLLException, DALException {
		// TODO Auto-generated method stub
		utilisateur.setMotDePasseUtilisateur(encrypt(utilisateur.getMotDePasseUtilisateur()));

		if(utilisateur.getTelephoneUtilisateur().trim().matches("(0|\\\\+33|0033)[1-9][0-9]{8}")) {
			throw new BLLException("Téléphone invalide");
		}
		if(utilisateur.geteMailUtilisateur().trim().matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\r\n@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")) {
			throw new BLLException("E-Mail invalide");
		}
		if(utilisateur.getCodePostalUtilisateur() < 1000 || utilisateur.getCodePostalUtilisateur() > 99999) {
			throw new BLLException("Code postal invalide");
		}
		if(DAOFactory.getDAO(new Utilisateur()).selectById(utilisateur.getIdUtilisateur()).size() == 0 ) {
			if(!utilisateur.getPseudonymeUtilisateur().trim().matches("^[a-zA-Z0-9_]*$")) {
				throw new BLLException("Le pseudonyme doit contenir uniquement des caractères alphanumériques");
			}
			if(DAOFactory.getDAO(new Utilisateur()).selectByString(utilisateur.getPseudonymeUtilisateur()).size() != 0) {
				throw new BLLException("Ce pseudonyme est déjà utilisé");
			}
			if(DAOFactory.getDAO(new Utilisateur()).selectByString(utilisateur.geteMailUtilisateur()).size() != 0) {
				throw new BLLException("Cet E-Mail est déjà utilisé");
			}
			DAOFactory.getDAO(new Utilisateur()).insert(utilisateur);
		}else {
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
			Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE,clef);
		return new String(cipher.doFinal(password.getBytes()));
		}
			catch (Exception e)
		{
				return null;
		}
	}
	
	private String decrypt(String password){
		try
		{
			Key clef = new SecretKeySpec(key.getBytes("ISO-8859-2"),"Blowfish");
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
