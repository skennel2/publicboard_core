package org.almansa.app.core.cache.adminpost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.entity.post.Post;
import org.springframework.stereotype.Component;

@Component
public class AdminPostCacheStorageImpl implements AdminPostCacheStorage{

    private Map<Long, Post> map = new HashMap<Long, Post>();
    
    @Override
    public void store(Long key, Post obj) {
        map.put(key, obj);
    }

    @Override
    public Post get(Long key) {
        return map.get(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Post> getAllPost() {
        return (List<Post>) map.values();
    }

    @Override
    public void remove(Long key) {
        map.remove(key);
    }    
}
