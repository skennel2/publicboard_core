package org.almansa.app.core.service.repository;

import java.util.List;

import org.almansa.app.core.comment.Comment;

public interface CommentRepository extends Repository<Long, Comment> {
    List<Comment> getByWriterId(Long userId);
    List<Comment> getByPostId(Long postId);
}
