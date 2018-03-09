package org.almansa.app.core.service.repository;

import java.util.List;

import org.almansa.app.core.post.Post;

public interface PostRepository extends Repository<Long, Post> {
    List<Post> getByWriterId(long writerId);
}
