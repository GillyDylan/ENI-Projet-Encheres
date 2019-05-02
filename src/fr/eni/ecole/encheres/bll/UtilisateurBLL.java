package fr.eni.ecole.encheres.bll;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;
import fr.eni.ecole.encheres.dal.DAOFactory;
import fr.eni.ecole.encheres.dal.hibernate.UtilisateurDAOHibernate;

public class UtilisateurBLL implements BLL<Utilisateur>{

	@Override
	public Utilisateur get(int...idUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return (Utilisateur) DAOFactory.getDAO(new Utilisateur()).selectById(idUtilisateur[0]).get(0);
	}
	
	@Override
	public Utilisateur get(String chaine)throws DALException {
		// TODO Auto-generated method stub
		return (Utilisateur) DAOFactory.getDAO(new Utilisateur()).selectByString(chaine).get(0);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> get() throws DALException {
		// TODO Auto-generated method stub
		return DAOFactory.getDAO(new Utilisateur()).selectAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void set(Utilisateur utilisateur) throws BLLException, DALException {
		// TODO Auto-generated method stub
		System.out.println(utilisateur.getMotDePasseUtilisateur());
		try {
			byte[] salt = getSalt();
			utilisateur.setMotDePasseUtilisateur(get_SHA_512_SecurePassword(utilisateur.getMotDePasseUtilisateur(), salt));
			System.out.println(utilisateur.getMotDePasseUtilisateur());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(utilisateur.getTelephoneUtilisateur() < 10000000l || utilisateur.getTelephoneUtilisateur() > 9999999999l) {
			throw new BLLException("Téléphone invalide");
		}
		if(utilisateur.getCodePostalUtilisateur() < 1000 || utilisateur.getCodePostalUtilisateur() > 99999) {
			throw new BLLException("Code postal invalide");
		}
		if(((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectById(utilisateur.getIdUtilisateur())!=null) {
			if(!utilisateur.getPseudonymeUtilisateur().equals("^[a-zA-Z0-9_]*$")) {
				throw new BLLException("Le pseudonyme doit contenir uniquement des caractères alphanumériques");
			}
			if(((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectByString(utilisateur.getPseudonymeUtilisateur())!=null) {
				throw new BLLException("Ce pseudonyme est déjà utilisé");
			}
			if(((UtilisateurDAOHibernate) DAOFactory.getDAO(new Utilisateur())).selectByString(utilisateur.getPseudonymeUtilisateur())!=null) {
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
	
	

    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
    
    private static String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt)
    {
    	String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }


}
