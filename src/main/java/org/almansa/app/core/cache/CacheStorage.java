package org.almansa.app.core.cache;

public interface CacheStorage<TKey, TObj> {
    void store(TKey key, TObj obj);
    TObj get(TKey key);
    void remove(TKey key);
    void clear();
}