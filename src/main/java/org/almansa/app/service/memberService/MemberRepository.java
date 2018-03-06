package org.almansa.app.service.memberService;

import org.almansa.app.core.member.Member;

public interface MemberRepository {

	Member getById(long memberId);

}
	