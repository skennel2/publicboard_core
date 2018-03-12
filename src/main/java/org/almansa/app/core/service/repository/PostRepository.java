package org.almansa.app.core.service.repository;

import java.util.List;

import org.almansa.app.core.post.Post;
import org.hibernate.Criteria;

public interface PostRepository extends Repository<Long, Post> {
    List<Post> getByWriterId(long writerId);
    List<Post> getByCriteria(Criteria criteria);
}
