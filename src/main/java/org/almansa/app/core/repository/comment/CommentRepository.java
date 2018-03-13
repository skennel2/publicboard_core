package org.almansa.app.core.repository.comment;

import java.util.List;

import org.almansa.app.core.comment.Comment;
import org.almansa.app.core.repository.Repository;

public interface CommentRepository extends Repository<Long, Comment> {
    List<Comment> getByWriterId(Long userId);
    List<Comment> getByPostId(Long postId);
}
