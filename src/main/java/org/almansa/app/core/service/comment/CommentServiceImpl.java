package org.almansa.app.core.service.comment;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.entity.comment.Comment;
import org.almansa.app.core.entity.comment.DefaultTextComment;
import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.entity.post.Post;
import org.almansa.app.core.exception.EntityNotFoundException;
import org.almansa.app.core.repository.comment.CommentRepository;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.repository.post.PostRepository;
import org.almansa.app.core.util.Entities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {

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
	@Transactional(readOnly = true)
	public List<Comment> getPostsComments(Long postId) {
		return commentRepo.getByPostId(postId);
	}

	@Override
	@Transactional
	public void writeComment(Long postId, Long userId, String contents) throws EntityNotFoundException {
		Member member = memberRepo.getById(userId);
		Post post = postRepo.getById(postId);

		Entities.assertEntityFound(member, "member can't found");
		Entities.assertEntityFound(post, "post can't found");

		Comment newComment = new DefaultTextComment(new Date(), contents, post.getId(), member.getId());
		commentRepo.update(newComment);
	}

	@Override
	@Transactional
	public void deletePost(Long commentId, Long userId) throws EntityNotFoundException {
		Comment comment = commentRepo.getById(commentId);

		Entities.assertEntityFound(comment, "comment can't found");

		if (comment.isPossibleToDelete(userId)) {
			commentRepo.delete(commentId);
		}
	}
}
