package org.almansa.app.core.service.comment;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.entity.comment.Comment;
import org.almansa.app.core.entity.comment.DefaultTextComment;
import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.entity.post.Post;
import org.almansa.app.core.repository.comment.CommentRepository;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.repository.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CommentServiceImpl implements CommentService{
    
    private MemberRepository memberRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;   
    
    @Autowired
    public CommentServiceImpl(MemberRepository memberRepo, PostRepository postRepo, CommentRepository commentRepo) {
        super();
        this.memberRepo = memberRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    @Override
    public List<Comment> getPostsComments(Long postId){
        return commentRepo.getByPostId(postId);
    }
            
    @Override
    public void writeComment(Long postId, Long userId, String contents) {
        Member member = memberRepo.getById(userId);
        Post post = postRepo.getById(postId);
        
        Assert.notNull(member, "member can't be null");
        Assert.notNull(post, "post can't be null");
        
        Comment newComment = new DefaultTextComment(new Date(), contents, post.getId(), member.getId());
        commentRepo.update(newComment);
    }
    
    @Override
    public void deletePost(Long commentId, Long userId){
        Comment comment = commentRepo.getById(commentId);
        
        if(comment != null && comment.isPossibleToDelete(userId)) {            
            commentRepo.delete(commentId);            
        }
    }
}
