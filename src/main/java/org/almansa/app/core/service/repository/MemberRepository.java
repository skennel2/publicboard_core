package org.almansa.app.core.service.repository;

import org.almansa.app.core.member.Member;
import org.almansa.app.core.post.Post;

public interface MemberRepository {
	Member getById(long memberId);
}
	