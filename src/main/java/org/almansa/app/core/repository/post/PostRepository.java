package org.almansa.app.core.repository.post;

import java.util.List;

import org.almansa.app.core.post.Post;
import org.almansa.app.core.repository.Repository;
import org.hibernate.Criteria;

public interface PostRepository extends Repository<Long, Post> {
    List<Post> getByWriterId(long writerId);
}
