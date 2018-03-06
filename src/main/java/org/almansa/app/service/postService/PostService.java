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
import org.almansa.app.service.boardService.BoardRepository;
import org.almansa.app.service.memberService.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService extends ServiceBase{
	
	private PostRepository postRepo;
	private MemberRepository memberRepo;
	private BoardRepository boardRepo;
	
    final int postTextContentsMaximumLength = 300;
    final int postTextNameMaximumLength = 30;
	
    @Transactional
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
		
	@Transactional
	public Post getPostByUserClick(final long clickerId, final long postId) {
		final Post post = postRepo.getById(postId);
		
		post.increaseClickCount(clickerId);
		postRepo.update(post);
		
		return post;
	}
	
	@Transactional
	public List<Post> getWritersPosts(final long writerId){
		final List<Post> writersPosts = postRepo.getByWriterId(writerId);
		
		return writersPosts;
	}
}