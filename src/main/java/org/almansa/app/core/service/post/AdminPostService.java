package org.almansa.app.core.service.post;

import java.util.List;

import javax.annotation.PostConstruct;

import org.almansa.app.core.cache.adminpost.AdminPostCacheStorage;
import org.almansa.app.core.member.Member;
import org.almansa.app.core.post.Post;
import org.almansa.app.core.repository.member.MemberRepository;
import org.almansa.app.core.repository.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPostService{
    private MemberRepository memberRepository;
    private PostRepository postRepository;
    private AdminPostCacheStorage adminPostCacheStorage;

    @Autowired
    public AdminPostService(MemberRepository memberRepository, PostRepository postRepository,
            AdminPostCacheStorage adminPostCacheStorage) {
        super();
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
        this.adminPostCacheStorage = adminPostCacheStorage;
    }

    @PostConstruct
    private void updateCache() {
        adminPostCacheStorage.clear();     
        List<Member> admins = memberRepository.getAdminMembers();
        
        for(Member admin : admins) {
            List<Post> list = postRepository.getByWriterId(admin.getId());
            for (Post post : list) {
                adminPostCacheStorage.store(post.getId(), post);
            }
        }       
    }
    
    public Post getById(Long id){
        return adminPostCacheStorage.get(id);
    }    
    
    public List<Post> getAll(){
        return adminPostCacheStorage.getAllPost();
    }
}
