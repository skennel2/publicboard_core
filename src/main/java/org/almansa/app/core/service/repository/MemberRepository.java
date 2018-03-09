package org.almansa.app.core.service.repository;

import org.almansa.app.core.member.Member;

public interface MemberRepository extends Repository<Long, Member>{
    Member getByLoginId(String loginId);
}
