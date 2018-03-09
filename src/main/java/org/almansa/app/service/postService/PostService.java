package org.almansa.app.service.postService;

import java.util.List;

import org.almansa.app.core.post.Post;

public interface PostService {

    void writeNewPost(long memberId, long boardId, String name, String contents);

    void modifyTextPostByWriter(long postId, long modifierId, String name, String contents);

    Post getById(long postId);

    Post getPostByUserClick(long clickerId, long postId);

    List<Post> getWritersPosts(long writerId);

    void deletePost(long userId, long postId);
}