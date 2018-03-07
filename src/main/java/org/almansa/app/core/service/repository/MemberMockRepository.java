package org.almansa.app.core.service.repository;

import java.util.HashMap;
import java.util.Map;

import org.almansa.app.core.member.Member;
import org.almansa.app.core.member.SimpleMember;
import org.springframework.stereotype.Component;

@Component
public class MemberMockRepository implements MemberRepository{

	private Map<Long, Member> memberMap = new HashMap<Long, Member>();
	
	public MemberMockRepository() {
		Member member1 = new SimpleMember(1, "skennel");
		Member member2 = new SimpleMember(2, "gaeko14");
		Member member3 = new SimpleMember(3, "hashswan");
		Member member4 = new SimpleMember(4, "billstax");
		Member member5 = new SimpleMember(5, "swings");
		
		memberMap.put((long) 1, member1);
		memberMap.put((long) 2, member2);
		memberMap.put((long) 3, member3);
		memberMap.put((long) 4, member4);
		memberMap.put((long) 5, member5);
	}
	
	@Override
	public Member getById(long memberId) {		
		return memberMap.get(memberId);
	}
	
}