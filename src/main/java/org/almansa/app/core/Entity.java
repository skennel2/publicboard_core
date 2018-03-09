package org.almansa.app.core;

public interface Entity<TId> {
    TId getId();

    void setId(TId id);
}