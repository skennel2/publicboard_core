package org.almansa.app.service.postService;

import java.util.List;

import org.almansa.app.core.Repository;
import org.almansa.app.core.post.Post;

public interface PostRepository extends Repository<Long, Post> {
	List<Post> getByWriterId(long writerId);
}
