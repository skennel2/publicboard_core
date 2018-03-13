package org.almansa.app.core.service.comment;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.OwnerPostInfomation;
import org.almansa.app.core.OwnerPostInfomationImpl;
import org.almansa.app.core.WriterInfomation;
import org.almansa.app.core.WriterInfomationImpl;
import org.almansa.app.core.comment.Comment;
import org.almansa.app.core.comment.DefaultTextComment;
import org.almansa.app.core.member.Member;
import org.almansa.app.core.post.Post;
import org.almansa.app.core.repository.comment.CommentRepository;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.repository.post.PostRepository;
import org.almansa.app.core.service.ServiceBase;

public class CommentServiceImpl extends ServiceBase{
    
    private MemberRepository memberRepo;
    private PostRepository postRepo;
    private CommentRepository commentRepo;
    
    private final int maximumContentsLength = 300;
    
    public void writeComment(Long postId, Long userId, String contents) {
        Member member = memberRepo.getById(userId);
        Post post = postRepo.getById(postId);
        
        verifyNotNull(member);
        verifyNotNull(post);
        
        WriterInfomation writerInfomation = new WriterInfomationImpl(member.getId(), member.getLoginId());
        OwnerPostInfomation postInfomation = new OwnerPostInfomationImpl(post.getId());
        
        Comment newComment = new DefaultTextComment(new Date(), contents, postInfomation, writerInfomation, maximumContentsLength);
        
        commentRepo.update(newComment);
    }
    
    public List<Comment> getPostsComments(Long postId){
        return commentRepo.getByPostId(postId);
    }

}
