package org.almansa.app.core.service.comment;

import java.util.List;

import org.almansa.app.core.comment.Comment;

public interface CommentService {

    List<Comment> getPostsComments(Long postId);

    void writeComment(Long postId, Long userId, String contents);

    void deletePost(Long commentId, Long userId);

}