package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.dal.DALException;

public interface BLL<T> {
	 T get(int...ids) throws DALException;
	 Object get(String s) throws DALException;
     List<T> get() throws DALException;
     void set(T t) throws BLLException, DALException;
     void delete(int id) throws DALException;
}
