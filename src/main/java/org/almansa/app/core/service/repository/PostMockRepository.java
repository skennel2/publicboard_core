package org.almansa.app.core.service.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.almansa.app.core.post.Post;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

@Component
public class PostMockRepository implements PostRepository {

    private TreeMap<Long, Post> postMap = new TreeMap<Long, Post>();
    
    @Override
    public Post getById(Long id) {
        return postMap.get(id);
    }

    @Override
    public List<Post> getAll() {
        
        
        List<Post> resultList = new ArrayList<Post>();

        for (Post post : postMap.values()) {
            resultList.add(post);
        }

        return resultList;
    }

    @Override
    public void delete(Long id) {
        postMap.remove(id);
    }

    @Override
    public void update(Post target) {
        if (target.getId() == null || !postMap.containsKey(target.getId())) {
            long newId = generateNewId();
            target.setId(newId);
            postMap.put(newId, target);
        } else {
            Post postWillUpdate = postMap.get(target.getId());
            postWillUpdate.changeName(target.getName());
            postWillUpdate.write(target.getContents());
            postWillUpdate.changeModifiedDate(new Date());
        }
    }

    @Override
    public List<Post> getByWriterId(long writerId) {
        List<Post> resultList = new ArrayList<Post>();

        for (Post post : postMap.values()) {
            if (post.getWriterInfomation().getWriterId() == writerId) {
                resultList.add(post);
            }
        }

        return resultList;
    }

    private long generateNewId() {

        long maxId = 0;

        for (Post post : postMap.values()) {
            if (post.getId() > maxId) {
                maxId = post.getId();
            }
        }
        return maxId + 1;
    }

    @Override
    public List<Post> getByCriteria(Criteria criteria) {
        // TODO Auto-generated method stub
        return null;
    }
}