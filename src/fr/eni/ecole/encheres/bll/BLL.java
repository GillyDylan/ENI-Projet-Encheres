package fr.eni.ecole.encheres.bll;

import java.util.List;

import fr.eni.ecole.encheres.dal.DALException;

public interface BLL<T> {
	 T get(int...ids) throws DALException;
	 T get(String s) throws DALException;
	 
	 List<T> getList(int...ids) throws DALException;
	 List<T> getList(String s) throws DALException;
	 List<T> getList() throws DALException;
	 
     void set(T t) throws BLLException, DALException;
     //void delete(int id) throws DALException;
}
