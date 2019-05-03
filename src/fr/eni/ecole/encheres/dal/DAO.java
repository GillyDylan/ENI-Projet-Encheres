package fr.eni.ecole.encheres.dal;


import java.util.List;

public interface DAO<T> {
		List<T> selectById(int...id) throws DALException;
        List<T> selectAll() throws DALException;
        List<T> selectByString(String string) throws DALException;
        void insert(T t) throws DALException;
        void update(T t) throws DALException;
        void delete(T t) throws DALException;
}

