package org.almansa.app.core.service.post;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.entity.board.Board;
import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.entity.post.DefaultTextPost;
import org.almansa.app.core.entity.post.Post;
import org.almansa.app.core.repository.board.BoardRepository;
import org.almansa.app.core.repository.comment.CommentRepository;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.repository.post.PostRepository;
import org.almansa.app.core.util.Entities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepo;
	private MemberRepository memberRepo;
	private BoardRepository boardRepo;
	private CommentRepository commentRepo;
	
	//@Resource(name="redisTemplate")
	//private ValueOperations<String, Object> redis;

	@Autowired
	public PostServiceImpl(PostRepository postRepo, MemberRepository memberRepo, BoardRepository boardRepo,
			CommentRepository commentRepo) {
		super();
		this.postRepo = postRepo;
		this.memberRepo = memberRepo;
		this.boardRepo = boardRepo;
		this.commentRepo = commentRepo;
	}

	@Override
	@Transactional
	public void writeNewPost(final Long memberId, final Long boardId, final String name, final String contents) {
		final Member member = memberRepo.getById(memberId);
		final Board board = boardRepo.getById(boardId);

		Entities.assertEntityFound(member, "member can't found");
		Entities.assertEntityFound(board, "board can't found");

		Post post = new DefaultTextPost(name, new Date(), new Date(), contents, board.getId(), member.getId(), member.getLoginId(), 0);

		postRepo.update(post);
	}

	@Override
	@Transactional
	public void modifyTextPostByWriter(final Long postId, final Long modifierId, final String name,
			final String contents) {
		Assert.notNull(name, "name can't be null");
		Assert.notNull(contents, "contents can't be null");

		final Post post = postRepo.getById(postId);
		final Member modifier = memberRepo.getById(modifierId);

		Entities.assertEntityFound(post, "post can't found");
		Entities.assertEntityFound(modifier, "modifier can't found");

		if (post.isPossibleModify(modifier.getId())) {
			post.changeName(name);
			post.write(contents);
			post.changeModifiedDate(new Date());

			postRepo.update(post);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Post getPostByUserClick(final Long clickerId, final Long postId) {
		final Post post = postRepo.getById(postId);

		post.increaseClickCount(clickerId);
		postRepo.update(post);

		return post;
	}

	@Override
	@Transactional(readOnly = true)
	public Post getById(long postId) {
		return postRepo.getById(postId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Post> getWritersPosts(final Long writerId) {
		final List<Post> writersPosts = postRepo.getByWriterId(writerId);
		return writersPosts;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Post> getAll() {
		return postRepo.getAll();
	}

	@Override
	@Transactional
	public void deletePost(final Long userId, final Long postId) throws PostModifyException {
		final Post post = postRepo.getById(postId);

		Entities.assertEntityFound(post, "post can't found");

		if (!post.isPossibleDelete(userId)) {
			throw new PostModifyException("삭제 권한이 없습니다.");
		}
		
		if(commentRepo.getByPostId(postId).size() != 0) {
			throw new PostModifyException("댓글이 존재하면 삭제할 수 없습니다.");
		}
		
		postRepo.delete(postId);
	}
}