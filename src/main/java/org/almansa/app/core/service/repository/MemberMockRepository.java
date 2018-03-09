package org.almansa.app.core.service.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.almansa.app.core.member.Member;
import org.almansa.app.core.member.SimpleMember;
import org.springframework.stereotype.Component;

@Component
public class MemberMockRepository implements MemberRepository {

    private Map<Long, Member> memberMap = new HashMap<Long, Member>();

    public MemberMockRepository() {
        Member member1 = new SimpleMember((long) 1, "skennel", "1234");
        Member member2 = new SimpleMember((long) 2, "gaeko14", "1234");
        Member member3 = new SimpleMember((long) 3, "hashswan", "1234");
        Member member4 = new SimpleMember((long) 4, "billstax", "1234");
        Member member5 = new SimpleMember((long) 5, "swings", "1234");

        memberMap.put((long) 1, member1);
        memberMap.put((long) 2, member2);
        memberMap.put((long) 3, member3);
        memberMap.put((long) 4, member4);
        memberMap.put((long) 5, member5);
    }

    @Override
    public Member getById(Long id) {
        return memberMap.get(id);
    }

    @Override
    public List<Member> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Member member) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Member getByLoginId(String loginId) {
        // TODO Auto-generated method stub
        return null;
    }
}