package org.almansa.app.core;

import java.util.List;

public interface Repository<TId, T extends Entity<TId>>{
	T getById(TId id);
	List<T> getAll();
	void delete(TId id);
	void update(T target);
}