package org.almansa.app.core.service.repository;

import java.util.List;

import org.almansa.app.core.Entity;

public interface Repository<TId, T extends Entity<TId>> {
    T getById(TId id);

    List<T> getAll();

    void delete(TId id);

    void update(T target);
}