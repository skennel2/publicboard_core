package org.almansa.app.service.postService;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.OwnerBoardInfomation;
import org.almansa.app.core.OwnerBoardInfomationImpl;
import org.almansa.app.core.WriterInfomation;
import org.almansa.app.core.WriterInfomationImpl;
import org.almansa.app.core.board.Board;
import org.almansa.app.core.member.Member;
import org.almansa.app.core.post.DefaultTextPost;
import org.almansa.app.core.post.Post;
import org.almansa.app.core.service.ServiceBase;
import org.almansa.app.core.service.repository.BoardRepository;
import org.almansa.app.core.service.repository.MemberRepository;
import org.almansa.app.core.service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PostServiceImpl extends ServiceBase implements PostService{
	
	@Autowired
	private PostRepository postRepo;	
	@Autowired
	private MemberRepository memberRepo;	
	@Autowired
	private BoardRepository boardRepo;
	
	final int postTextContentsMaximumLength = 300;
	final int postTextNameMaximumLength = 30;
	
	@Override
	public void writeNewPost(final long memberId, final long boardId, final String name, final String contents) {
		final Member member = memberRepo.getById(memberId);			
		final Board board = boardRepo.getById(boardId);
		
		verifyNotNull(member);
		verifyNotNull(board);	
		
		OwnerBoardInfomationImpl boardInfo = new OwnerBoardInfomationImpl(board.getId());
		WriterInfomationImpl writerInfo = new WriterInfomationImpl(member.getId(), member.loginId());
		
		Post post = new DefaultTextPost(
				name, 
				new Date(), 
				new Date(), 
				contents, 
				boardInfo, 
				writerInfo, 
				postTextContentsMaximumLength, 
				postTextNameMaximumLength,
				0);
		
		postRepo.update(post);			
	}
    
	@Override
	public void modifyTextPostByWriter(final long postId, final long modifierId, final String name, final String contents){
    	final Post post = postRepo.getById(postId);
    	final Member modifier = memberRepo.getById(modifierId);		
    	
    	verifyNotNull(name);
    	verifyNotNull(contents);
    	verifyNotNull(post);
    	
    	if(post.isPossibleModify(modifier.getId())) {	    	
	    	post.changeName(name);
	    	post.write(contents);
	    	post.changeModifiedDate(new Date());
	    	
	    	postRepo.update(post);    	
    	}
	}    
    
	@Override
	public Post getPostByUserClick(final long clickerId, final long postId) {
		final Post post = postRepo.getById(postId);
		
		post.increaseClickCount(clickerId);
		postRepo.update(post);
		
		return post;
	}
	
	@Override
	public Post getById(long postId) {
		return postRepo.getById(postId);
	}
	
	@Override
	public List<Post> getWritersPosts(final long writerId){
		final List<Post> writersPosts = postRepo.getByWriterId(writerId);
		return writersPosts;
	}
	
	@Override
	public void deletePost(final long userId, final long postId) {
		final Post post = postRepo.getById(postId);
		
		if(post != null) {
			if(post.isPossibleDelete(userId)) {
				postRepo.delete(postId);
			}
		}
	}
}