package org.almansa.app.service.postService;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.OwnerBoardInfomation;
import org.almansa.app.core.WriterInfomation;
import org.almansa.app.core.board.Board;
import org.almansa.app.core.member.Member;
import org.almansa.app.core.post.DefaultTextPost;
import org.almansa.app.core.post.Post;
import org.almansa.app.service.boardService.BoardRepository;
import org.almansa.app.service.memberService.MemberRepository;

public class PostService{
	
	private PostRepository postRepo;
	private MemberRepository memberRepo;
	private BoardRepository boardRepo;
	
    final int postTextContentsMaximumLength = 300;
    final int postTextNameMaximumLength = 30;
	
	public void writeNewPost(long memberId, long boardId, String name, String contents) {
		final Member member = memberRepo.getById(memberId);			
		final Board board = boardRepo.getById(boardId);
		
		verifyMember(member);
		verifyBoard(board);	
		
		Post post = new DefaultTextPost(
				name, 
				new Date(), 
				new Date(), 
				contents, 
				ownerBoardInfomation(board.getId()), 
				writerInfomation(member.getId(), member.loginId()), 
				postTextContentsMaximumLength, 
				postTextNameMaximumLength);
		
		postRepo.update(post);			
	}
	
	private void verifyMember(Member member) {
		if(member == null) {
			throw new RuntimeException();
		}
	}
	
	private void verifyBoard(Board board) {
		if(board == null) {
			throw new RuntimeException();
		}
	}	
	
	private OwnerBoardInfomation ownerBoardInfomation(final long boardId) {
		
		OwnerBoardInfomation ownerBoardInfomation = new OwnerBoardInfomation() {
			
			@Override
			public long getOwnerBoardKey() {
				return boardId;
			}
		};
		
		return ownerBoardInfomation;
	}
	
	private WriterInfomation writerInfomation(final long writerId, final String writerLoginId) {
		WriterInfomation writerInfomation = new WriterInfomation() {
			
			@Override
			public String getWriterLoginId() {
				return writerLoginId;
			}
			
			@Override
			public long getWriterId() {
				return writerId;
			}
		};
		
		return writerInfomation;
	}
}