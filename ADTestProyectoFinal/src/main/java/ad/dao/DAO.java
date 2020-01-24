package ad.dao;

import java.util.List;

import ad.Customer;

public interface DAO<T,K> {
	
	void insert(T t);
	
	void update(T t);
	
	void remove(T t);
	
	List<T> getT();
	
	T getById(K id);
	
}
