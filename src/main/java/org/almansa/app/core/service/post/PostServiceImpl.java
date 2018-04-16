package org.almansa.app.core.service.post;

import java.util.Date;
import java.util.List;

import org.almansa.app.core.MemberDefaultInfomationImpl;
import org.almansa.app.core.OwnerBoardInfomationImpl;
import org.almansa.app.core.entity.board.Board;
import org.almansa.app.core.entity.member.Member;
import org.almansa.app.core.entity.post.DefaultTextPost;
import org.almansa.app.core.entity.post.Post;
import org.almansa.app.core.repository.board.BoardRepository;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.repository.post.PostRepository;
import org.almansa.app.core.service.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends ServiceBase implements PostService {

    private PostRepository postRepo;
    private MemberRepository memberRepo;
    private BoardRepository boardRepo;

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
        MemberDefaultInfomationImpl writerInfo = new MemberDefaultInfomationImpl(member.getId(), member.getLoginId());

        Post post = new DefaultTextPost(
                name, 
                new Date(), 
                new Date(), 
                contents, 
                boardInfo, 
                writerInfo,
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
    public List<Post> getAll() {
        return postRepo.getAll();
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
}