package org.almansa.app.core.cache.adminpost;

import java.util.List;

import org.almansa.app.core.cache.CacheStorage;
import org.almansa.app.core.post.Post;

public interface AdminPostCacheStorage extends CacheStorage<Long, Post>{
    public List<Post> getAllPost();

    void store(Long key, Post obj);
}