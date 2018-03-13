package org.almansa.app.core.repository.member;

import org.almansa.app.core.member.Member;
import org.almansa.app.core.repository.Repository;

public interface MemberRepository extends Repository<Long, Member>{
    Member getByLoginId(String loginId);
}
