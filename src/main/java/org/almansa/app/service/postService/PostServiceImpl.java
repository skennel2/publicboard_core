package org.almansa.app.service.postService;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.OwnerBoardInfomationImpl;
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

@Component
public class PostServiceImpl extends ServiceBase implements PostService {

    private PostRepository postRepo;
    private MemberRepository memberRepo;
    private BoardRepository boardRepo;

    final int postTextContentsMaximumLength = 300;
    final int postTextNameMaximumLength = 30;
    
    @Autowired
    public PostServiceImpl(PostRepository postRepo, MemberRepository memberRepo, BoardRepository boardRepo) {
        super();
        this.postRepo = postRepo;
        this.memberRepo = memberRepo;
        this.boardRepo = boardRepo;
    }

    @Override
    public void writeNewPost(final Long memberId, final Long boardId, final String name, final String contents) {
        final Member member = memberRepo.getById(memberId);
        final Board board = boardRepo.getById(boardId);

        verifyNotNull(member);
        verifyNotNull(board);

        OwnerBoardInfomationImpl boardInfo = new OwnerBoardInfomationImpl(board.getId());
        WriterInfomationImpl writerInfo = new WriterInfomationImpl(member.getId(), member.getLoginId());

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
    public void modifyTextPostByWriter(final Long postId, final Long modifierId, final String name,
            final String contents) {
        final Post post = postRepo.getById(postId);
        final Member modifier = memberRepo.getById(modifierId);

        verifyNotNull(name);
        verifyNotNull(contents);
        verifyNotNull(post);

        if (post.isPossibleModify(modifier.getId())) {
            post.changeName(name);
            post.write(contents);
            post.changeModifiedDate(new Date());

            postRepo.update(post);
        }
    }

    @Override
    public Post getPostByUserClick(final Long clickerId, final Long postId) {
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
    public List<Post> getWritersPosts(final Long writerId) {
        final List<Post> writersPosts = postRepo.getByWriterId(writerId);
        return writersPosts;
    }

    @Override
    public void deletePost(final Long userId, final Long postId) {
        final Post post = postRepo.getById(postId);

        if (post != null) {
            if (post.isPossibleDelete(userId)) {
                postRepo.delete(postId);
            }
        }
    }

    @Override
    public List<Post> getAll() {
        return postRepo.getAll();
    }
}