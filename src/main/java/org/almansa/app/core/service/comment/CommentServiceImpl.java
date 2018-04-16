package org.almansa.app.core.service.comment;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.MemberDefaultInfomation;
import org.almansa.app.core.MemberDefaultInfomationImpl;
import org.almansa.app.core.PostDefaultInfomation;
import org.almansa.app.core.PostDefaultInfomationImpl;
import org.almansa.app.core.entity.comment.Comment;
import org.almansa.app.core.entity.comment.DefaultTextComment;
import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.entity.post.Post;
import org.almansa.app.core.repository.comment.CommentRepository;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.repository.post.PostRepository;
import org.almansa.app.core.service.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl extends ServiceBase implements CommentService{
    
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
        
        verifyNotNull(member);
        verifyNotNull(post);
        
        MemberDefaultInfomation writerInfomation = new MemberDefaultInfomationImpl(member.getId(), member.getLoginId());
        PostDefaultInfomation postInfomation = new PostDefaultInfomationImpl(post.getId());
        
        Comment newComment = new DefaultTextComment(new Date(), contents, postInfomation, writerInfomation);
        
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
