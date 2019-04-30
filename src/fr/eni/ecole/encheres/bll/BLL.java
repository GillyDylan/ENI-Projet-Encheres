package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;

public interface BLL<T> {
	 Object get(int id) throws DALException;
	 Object get(String s) throws DALException;
     List<Object> get() throws DALException;
     void set(Object o) throws BLLException, DALException;
     void delete(int id) throws DALException;

}
