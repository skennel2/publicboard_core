package org.almansa.app.service.commentService;

import java.util.Date;

import org.almansa.app.core.OwnerPostInfomation;
import org.almansa.app.core.OwnerPostInfomationImpl;
import org.almansa.app.core.WriterInfomation;
import org.almansa.app.core.WriterInfomationImpl;
import org.almansa.app.core.comment.Comment;
import org.almansa.app.core.comment.DefaultTextComment;
import org.almansa.app.core.member.Member;
import org.almansa.app.core.post.Post;
import org.almansa.app.core.service.ServiceBase;
import org.almansa.app.core.service.repository.MemberRepository;
import org.almansa.app.core.service.repository.PostRepository;
import org.almansa.app.service.memberService.MemberService;
import org.almansa.app.service.memberService.MemberServiceImpl;

public class CommentServiceImpl extends ServiceBase{
    
    private MemberRepository memberRepo;
    private PostRepository postRepo;
    
    private final int maximumContentsLength = 300;
    
    public void writeComment(Long postId, Long userId, String contents) {
        Member member = memberRepo.getById(userId);
        Post post = postRepo.getById(postId);
        
        WriterInfomation writerInfomation = new WriterInfomationImpl(member.getId(), member.getLoginId());
       // OwnerPostInfomation postInfomation = new OwnerPostInfomationImpl(post.getId());
        
        //Comment newComment = new DefaultTextComment(new Date(), contents, postInfomation, writerInfomation, maximumContentsLength);
        
    }
}
