package Persistencia.Interfaces;

import java.util.List;

public interface DAO<T> {

	List<T> readAll();
	void insert(T t);
	void delete(T t);
	void update(T t);
	
}
