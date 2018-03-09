package org.almansa.app.service.postService;

import java.util.List;

import org.almansa.app.core.post.Post;

public interface PostService {

    void writeNewPost(Long memberId, Long boardId, String name, String contents);

    void modifyTextPostByWriter(Long postId, Long modifierId, String name, String contents);

    Post getById(long postId);

    Post getPostByUserClick(Long clickerId, Long postId);

    List<Post> getWritersPosts(Long writerId);

    void deletePost(Long userId, Long postId);
}