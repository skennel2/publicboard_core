package org.almansa.app.core.repository.post;

import java.util.List;

import org.almansa.app.core.entity.post.Post;
import org.almansa.app.core.repository.Repository;

public interface PostRepository extends Repository<Long, Post> {
    List<Post> getByWriterId(long writerId);
}
